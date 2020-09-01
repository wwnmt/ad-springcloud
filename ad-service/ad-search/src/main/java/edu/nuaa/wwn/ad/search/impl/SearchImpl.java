package edu.nuaa.wwn.ad.search.impl;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.nuaa.wwn.ad.index.CommonStatus;
import edu.nuaa.wwn.ad.index.DataTable;
import edu.nuaa.wwn.ad.index.adunit.AdUnitIndex;
import edu.nuaa.wwn.ad.index.adunit.AdUnitObject;
import edu.nuaa.wwn.ad.index.creative.CreativeIndex;
import edu.nuaa.wwn.ad.index.creative.CreativeObject;
import edu.nuaa.wwn.ad.index.creativeunit.CreativeUnitIndex;
import edu.nuaa.wwn.ad.index.district.UnitDistrictIndex;
import edu.nuaa.wwn.ad.index.interest.UnitIdIndex;
import edu.nuaa.wwn.ad.index.keyword.UnitKeywordIndex;
import edu.nuaa.wwn.ad.search.ISearch;
import edu.nuaa.wwn.ad.search.vo.SearchRequest;
import edu.nuaa.wwn.ad.search.vo.SearchResponse;
import edu.nuaa.wwn.ad.search.vo.feature.DistrictFeature;
import edu.nuaa.wwn.ad.search.vo.feature.FeatureRelation;
import edu.nuaa.wwn.ad.search.vo.feature.ItFeature;
import edu.nuaa.wwn.ad.search.vo.feature.KeywordFeature;
import edu.nuaa.wwn.ad.search.vo.media.AdSlot;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 20:10
 */
@Slf4j
@Service
public class SearchImpl implements ISearch {

    public SearchResponse fallback(SearchRequest request, Throwable throwable) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public SearchResponse fetchAds(SearchRequest request) {
        //请求广告位信息
        List<AdSlot> adSlots = request.getRequestInfo().getAdSlots();
        //3个feature
        KeywordFeature keywordFeature = request.getFeatureInfo().getKeywordFeature();
        DistrictFeature districtFeature = request.getFeatureInfo().getDistrictFeature();
        ItFeature itFeature = request.getFeatureInfo().getItFeature();

        FeatureRelation relation = request.getFeatureInfo().getRelation();

        //构造响应
        SearchResponse response = new SearchResponse();
        Map<String, List<SearchResponse.Creative>> adSlot2Ads =
                response.getAdSlot2Ads();

        for (AdSlot adSlot : adSlots) {
            Set<Long> targetUnitIdSet;
            //根据流量类型获取初始AdUnit
            Set<Long> adUnitIdSet = DataTable.of(
                    AdUnitIndex.class
            ).match(adSlot.getPositionType());

            if (relation == FeatureRelation.AND) {
                filterKeywordFeature(adUnitIdSet, keywordFeature);
                filterDistrictFeature(adUnitIdSet, districtFeature);
                filterItFeature(adUnitIdSet, itFeature);

                targetUnitIdSet = adUnitIdSet;
            } else {
                targetUnitIdSet = getOrRelationUnitIds(
                        adUnitIdSet,
                        keywordFeature,
                        districtFeature,
                        itFeature);
            }
            //通过unitId获取unit对象
            List<AdUnitObject> unitObjects =
                    DataTable.of(AdUnitIndex.class).fetch(targetUnitIdSet);
            //过滤状态不符合要求的推广单元
            filterAdUnitAndPlanStatus(unitObjects, CommonStatus.VALID);
            List<Long> adIds = DataTable.of(CreativeUnitIndex.class)
                    .selectAds(unitObjects);
            List<CreativeObject> creatives = DataTable.of(CreativeIndex.class)
                    .fetch(adIds);

            //通过AdSlot实现对creatives过滤
            filterCreativeByAdSlot(creatives,
                                   adSlot.getWidth(),
                                   adSlot.getHeight(),
                                   adSlot.getType());
            adSlot2Ads.put(
                    adSlot.getAdSlotCode(), buildCreativeResponse(creatives)
            );
        }
        log.info("fetchAds: {}-{}",
                 JSON.toJSONString(request),
                 JSON.toJSONString(response));
        return response;
    }

    private List<SearchResponse.Creative> buildCreativeResponse(List<CreativeObject> creatives) {
        if (CollectionUtils.isEmpty(creatives))
            return Collections.emptyList();
        CreativeObject randomObject = creatives.get(
                Math.abs(new Random().nextInt()) % creatives.size()
        );
        return Collections.singletonList(
                SearchResponse.convert(randomObject)
        );
    }

    private void filterCreativeByAdSlot(List<CreativeObject> creatives,
                                        Integer width,
                                        Integer height,
                                        List<Integer> type) {
        if (CollectionUtils.isEmpty(creatives))
            return;
        CollectionUtils.filter(
                creatives,
                creative -> creative.getAuditStatus().equals(CommonStatus.VALID.getStatus())
                                && creative.getWidth().equals(width)
                                && creative.getHeight().equals(height)
                                && type.contains(Integer.valueOf(creative.getType()))
        );
    }

    private void filterAdUnitAndPlanStatus(List<AdUnitObject> unitObjects,
                                           CommonStatus status) {
        if (CollectionUtils.isEmpty(unitObjects))
            return;
        CollectionUtils.filter(
                unitObjects,
                object -> object.getUnitStatus().equals(status.getStatus())
                        && object.getAdPlanObject().getPlanStatus().equals(status.getStatus())
        );
    }

    private Set<Long> getOrRelationUnitIds(Set<Long> unitIds,
                                           KeywordFeature keywordFeature,
                                           DistrictFeature districtFeature,
                                           ItFeature itFeature) {
        if (CollectionUtils.isEmpty(unitIds))
            return Collections.emptySet();

        Set<Long> keywordUnitIdSet = new HashSet<>(unitIds);
        Set<Long> districtUnitIdSet = new HashSet<>(unitIds);
        Set<Long> itUnitIdSet = new HashSet<>(unitIds);

        filterKeywordFeature(keywordUnitIdSet, keywordFeature);
        filterDistrictFeature(districtUnitIdSet, districtFeature);
        filterItFeature(itUnitIdSet, itFeature);

        return new HashSet<>(
                CollectionUtils.union(
                        CollectionUtils.union(keywordUnitIdSet, districtUnitIdSet),
                        itUnitIdSet
                )
        );
    }

    private void filterKeywordFeature(Collection<Long> unitIds, KeywordFeature keywordFeature) {
        if (CollectionUtils.isEmpty(unitIds))
            return;
        if (CollectionUtils.isNotEmpty(keywordFeature.getKeywords())) {
            CollectionUtils.filter(
                    unitIds,
                    unitId -> DataTable.of(UnitKeywordIndex.class)
                            .match(unitId, keywordFeature.getKeywords())
            );
        }
    }

    private void filterDistrictFeature(Collection<Long> unitIds, DistrictFeature districtFeature) {
        if (CollectionUtils.isEmpty(unitIds))
            return;
        if (CollectionUtils.isNotEmpty(districtFeature.getDistricts())) {
            CollectionUtils.filter(
                    unitIds,
                    unitId -> DataTable.of(UnitDistrictIndex.class)
                            .match(unitId, districtFeature.getDistricts())
            );
        }
    }

    private void filterItFeature(Collection<Long> unitIds, ItFeature itFeature) {
        if (CollectionUtils.isEmpty(unitIds))
            return;
        if (CollectionUtils.isNotEmpty(itFeature.getIts())) {
            CollectionUtils.filter(
                    unitIds,
                    unitId -> DataTable.of(UnitIdIndex.class)
                            .match(unitId, itFeature.getIts())
            );
        }
    }
}

