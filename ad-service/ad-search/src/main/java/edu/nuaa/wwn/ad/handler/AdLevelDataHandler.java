package edu.nuaa.wwn.ad.handler;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.constant.OpType;
import edu.nuaa.wwn.ad.dump.table.AdPlanTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitDistrictTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitItTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitKeywordTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitTable;
import edu.nuaa.wwn.ad.dump.table.CreativeTable;
import edu.nuaa.wwn.ad.dump.table.CreativeUnitTable;
import edu.nuaa.wwn.ad.index.DataTable;
import edu.nuaa.wwn.ad.index.IndexAware;
import edu.nuaa.wwn.ad.index.adplan.AdPlanIndex;
import edu.nuaa.wwn.ad.index.adplan.AdPlanObject;
import edu.nuaa.wwn.ad.index.adunit.AdUnitIndex;
import edu.nuaa.wwn.ad.index.adunit.AdUnitObject;
import edu.nuaa.wwn.ad.index.creative.CreativeIndex;
import edu.nuaa.wwn.ad.index.creative.CreativeObject;
import edu.nuaa.wwn.ad.index.creativeunit.CreativeUnitIndex;
import edu.nuaa.wwn.ad.index.creativeunit.CreativeUnitObject;
import edu.nuaa.wwn.ad.index.district.UnitDistrictIndex;
import edu.nuaa.wwn.ad.index.keyword.UnitKeywordIndex;
import edu.nuaa.wwn.ad.index.keyword.UnitKeywordObject;
import edu.nuaa.wwn.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 索引存在层级依赖关系划分，加载全量索引（增量索引的特殊实现）
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 16:20
 */
@Slf4j
public class AdLevelDataHandler {

    public static void handleLevel2(AdPlanTable planTable, OpType type) {
        AdPlanObject planObject = new AdPlanObject(
                planTable.getId(),
                planTable.getUserId(),
                planTable.getPlanStatus(),
                planTable.getStartDate(),
                planTable.getEndDate()
        );
        handleBinlogEvent(
                DataTable.of(AdPlanIndex.class),
                planObject.getPlanId(),
                planObject,
                type
        );
    }

    public static void handleLevel2(CreativeTable creativeTable, OpType type) {
        CreativeObject creativeObject = new CreativeObject(
                creativeTable.getAdId(),
                creativeTable.getName(),
                creativeTable.getType(),
                creativeTable.getMaterialType(),
                creativeTable.getHeight(),
                creativeTable.getWidth(),
                creativeTable.getAuditStatus(),
                creativeTable.getUrl()
        );
        handleBinlogEvent(
                DataTable.of(CreativeIndex.class),
                creativeObject.getAdId(),
                creativeObject,
                type
        );
    }

    public static void handleLevel3(AdUnitTable unitTable, OpType type) {
        AdPlanObject adPlanObject = DataTable.of(
                AdPlanIndex.class
        ).get(unitTable.getPlanId());
        if (null == adPlanObject) {
            log.error("handleLevel3 found AdPlanObject error: {}", unitTable.getPlanId());
            return;
        }
        AdUnitObject unitObject = new AdUnitObject(
                unitTable.getUnitId(),
                unitTable.getUnitStatus(),
                unitTable.getPositionType(),
                unitTable.getPlanId(),
                adPlanObject
        );

        handleBinlogEvent(
                DataTable.of(AdUnitIndex.class),
                unitObject.getUnitId(),
                unitObject,
                type
        );
    }

    public static void handleLevel3(CreativeUnitTable creativeUnitTable, OpType type) {

        if (type == OpType.UPDATE) {
            log.error("CreativeUnitIndex not support update");
            return;
        }

        AdUnitObject unitObject = DataTable.of(
                AdUnitIndex.class
        ).get(creativeUnitTable.getUnitId());
        CreativeObject creativeObject = DataTable.of(
                CreativeIndex.class
        ).get(creativeUnitTable.getAdId());

        if (null == unitObject || null == creativeObject) {
            log.error("AdCreativeUnitTable index error: {}",
                      JSON.toJSONString(creativeUnitTable));
            return;
        }

        CreativeUnitObject creativeUnitObject = new CreativeUnitObject(
                creativeUnitTable.getAdId(),
                creativeUnitTable.getUnitId()
        );

        handleBinlogEvent(
                DataTable.of(
                        CreativeUnitIndex.class
                ),
                CommonUtils.stringConcat(
                        creativeUnitObject.getAdId().toString(),
                        creativeUnitObject.getUnitId().toString()
                ),
                creativeUnitObject,
                type
        );
    }

    public static void handleLevel4(AdUnitDistrictTable unitDistrictTable, OpType type) {

        if (type == OpType.UPDATE) {
            log.error("UnitKeyword not support update");
            return;
        }

        AdUnitObject adUnitObject = DataTable.of(
                AdUnitIndex.class
        ).get(Long.valueOf(unitDistrictTable.getUnitId()));
        if (null == adUnitObject) {
            log.error("handleLevel4 found AdUnitObject error: {}", unitDistrictTable.getUnitId());
            return;
        }

        String key = CommonUtils.stringConcat(
                unitDistrictTable.getProvince(),
                unitDistrictTable.getCity()
        );
        Set<Long> value = new HashSet<Long>(
                Collections.singleton(Long.valueOf(unitDistrictTable.getUnitId()))
        );
        handleBinlogEvent(
                DataTable.of(
                        UnitDistrictIndex.class
                ),
                key,
                value,
                type
        );
    }

    public static void handleLevel4(AdUnitItTable unitItTable, OpType type) {

        if (type == OpType.UPDATE) {
            log.error("UnitKeyword not support update");
            return;
        }

        AdUnitObject adUnitObject = DataTable.of(
                AdUnitIndex.class
        ).get(Long.valueOf(unitItTable.getUnitId()));
        if (null == adUnitObject) {
            log.error("handleLevel4 found AdUnitObject error: {}", unitItTable.getUnitId());
            return;
        }

        Set<Long> value = new HashSet<Long>(
                Collections.singleton(Long.valueOf(unitItTable.getUnitId()))
        );
        handleBinlogEvent(
                DataTable.of(
                        UnitDistrictIndex.class
                ),
                unitItTable.getItTag(),
                value,
                type
        );
    }

    public static void handleLevel4(AdUnitKeywordTable unitKeywordTable, OpType type) {

        if (type == OpType.UPDATE) {
            log.error("UnitKeyword not support update");
            return;
        }

        AdUnitObject adUnitObject = DataTable.of(
                AdUnitIndex.class
        ).get(Long.valueOf(unitKeywordTable.getUnitId()));
        if (null == adUnitObject) {
            log.error("handleLevel4 found AdUnitObject error: {}", unitKeywordTable.getUnitId());
            return;
        }
        UnitKeywordObject unitKeywordObject = new UnitKeywordObject(
                unitKeywordTable.getUnitId(),
                unitKeywordTable.getKeyword()
        );
        Set<Long> value = new HashSet<>(
                Collections.singleton(Long.valueOf(unitKeywordObject.getUnitId()))
        );
        handleBinlogEvent(
                DataTable.of(UnitKeywordIndex.class),
                unitKeywordObject.getKeyword(),
                value,
                type
        );
    }

    private static <K, V> void handleBinlogEvent(IndexAware<K, V> index,
                                                 K key, V value,
                                                 OpType type) {
        switch (type) {
            case ADD:
                index.add(key, value);
                break;
            case UPDATE:
                index.update(key, value);
                break;
            case DELETE:
                index.delete(key, value);
                break;
            default:
                break;
        }
    }
}
