package edu.nuaa.wwn.ad.index.keyword;

import edu.nuaa.wwn.ad.index.IndexAware;
import edu.nuaa.wwn.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created with IntelliJ IDEA.
 * Description: 倒排索引 通过keyword查询响应的推广单元unit
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 12:28
 */
@Slf4j
@Component
public class UnitKeywordIndex implements IndexAware<String, Set<Long>> {

    private static final Map<String, Set<Long>> keywordUnitMap;
    private static final Map<Long, Set<String>> unitKeywordMap;

    static {
        keywordUnitMap = new ConcurrentHashMap<>();
        unitKeywordMap = new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {
        if (StringUtils.isEmpty(key)) {
            return Collections.emptySet();
        }
        Set<Long> result = keywordUnitMap.get(key);
        if (result == null) {
            return Collections.emptySet();
        }
        return result;
    }

    @Override
    public void add(String key, Set<Long> value) {
        log.info("UnitKeywordIndex, before add: {}", keywordUnitMap);

        Set<Long> unitIdSet = CommonUtils.getOrCreate(
                key, keywordUnitMap,
                ConcurrentSkipListSet::new
        );
        unitIdSet.addAll(value);

        for (Long unitId : value) {
            Set<String> keywordSet = CommonUtils.getOrCreate(
                    unitId, unitKeywordMap,
                    ConcurrentSkipListSet::new
            );
            keywordSet.add(key);
        }

        log.info("UnitKeywordIndex, after add: {}", keywordUnitMap);
    }

    @Override
    public void update(String key, Set<Long> value) {
        log.error("keyword index can not support update");
    }

    @Override
    public void delete(String key, Set<Long> value) {
        log.info("UnitKeywordIndex, before delete: {}", keywordUnitMap);

        Set<Long> unitIds = CommonUtils.getOrCreate(
                key, keywordUnitMap,
                ConcurrentSkipListSet::new
        );
        unitIds.removeAll(value);

        for (Long unitId : value) {
            Set<String> keywordSet = CommonUtils.getOrCreate(
                    unitId, unitKeywordMap,
                    ConcurrentSkipListSet::new
            );
            keywordSet.remove(key);
        }
        log.info("UnitKeywordIndex, after delete: {}", keywordUnitMap);
    }

    public boolean match(Long unitId, List<String> keywords) {
        if (unitKeywordMap.containsKey(unitId)
                && CollectionUtils.isNotEmpty(unitKeywordMap.get(unitId))) {
            Set<String> unitKeywords = unitKeywordMap.get(unitId);
            return CollectionUtils.isSubCollection(keywords, unitKeywords);
        }
        return false;
    }
}
