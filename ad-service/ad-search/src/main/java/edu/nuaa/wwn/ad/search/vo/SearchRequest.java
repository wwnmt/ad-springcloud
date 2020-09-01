package edu.nuaa.wwn.ad.search.vo;

import edu.nuaa.wwn.ad.search.vo.feature.DistrictFeature;
import edu.nuaa.wwn.ad.search.vo.feature.FeatureRelation;
import edu.nuaa.wwn.ad.search.vo.feature.ItFeature;
import edu.nuaa.wwn.ad.search.vo.feature.KeywordFeature;
import edu.nuaa.wwn.ad.search.vo.media.AdSlot;
import edu.nuaa.wwn.ad.search.vo.media.App;
import edu.nuaa.wwn.ad.search.vo.media.Device;
import edu.nuaa.wwn.ad.search.vo.media.Geo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 17:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

    private String mediaId;

    private RequestInfo requestInfo;

    private FeatureInfo featureInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestInfo {

        private String requestId;

        private List<AdSlot> adSlots;

        private App app;

        private Geo geo;

        private Device device;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureInfo {

        private KeywordFeature keywordFeature;
        private DistrictFeature districtFeature;
        private ItFeature itFeature;

        private FeatureRelation relation = FeatureRelation.AND;
    }
}
