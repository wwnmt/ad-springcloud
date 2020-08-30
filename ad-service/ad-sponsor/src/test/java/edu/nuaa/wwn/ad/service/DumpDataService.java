package edu.nuaa.wwn.ad.service;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.Application;
import edu.nuaa.wwn.ad.constant.CommonStatus;
import edu.nuaa.wwn.ad.dao.CreativePOMapper;
import edu.nuaa.wwn.ad.dao.CreativeUnitPOMapper;
import edu.nuaa.wwn.ad.dao.PlanPOMapper;
import edu.nuaa.wwn.ad.dao.UnitDistrictPOMapper;
import edu.nuaa.wwn.ad.dao.UnitItPOMapper;
import edu.nuaa.wwn.ad.dao.UnitKeywordPOMapper;
import edu.nuaa.wwn.ad.dao.UnitPOMapper;
import edu.nuaa.wwn.ad.dump.DConstant;
import edu.nuaa.wwn.ad.dump.table.AdPlanTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitDistrictTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitItTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitKeywordTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitTable;
import edu.nuaa.wwn.ad.dump.table.CreativeTable;
import edu.nuaa.wwn.ad.dump.table.CreativeUnitTable;
import edu.nuaa.wwn.ad.entity.CreativePO;
import edu.nuaa.wwn.ad.entity.CreativeUnitPO;
import edu.nuaa.wwn.ad.entity.PlanPO;
import edu.nuaa.wwn.ad.entity.UnitDistrictPO;
import edu.nuaa.wwn.ad.entity.UnitItPO;
import edu.nuaa.wwn.ad.entity.UnitKeywordPO;
import edu.nuaa.wwn.ad.entity.UnitPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 14:16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DumpDataService {

    @Autowired
    private PlanPOMapper planPOMapper;
    @Autowired
    private UnitPOMapper unitPOMapper;
    @Autowired
    private UnitKeywordPOMapper unitKeywordPOMapper;
    @Autowired
    private UnitItPOMapper unitItPOMapper;
    @Autowired
    private UnitDistrictPOMapper unitDistrictPOMapper;
    @Autowired
    private CreativePOMapper creativePOMapper;
    @Autowired
    private CreativeUnitPOMapper creativeUnitPOMapper;

    @Test
    public void dumpAdTableData() {
        dumpAdPlanTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                              DConstant.AD_PLAN)
        );
        dumpAdUnitTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                              DConstant.AD_UNIT)
        );
        dumpCreativeTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                              DConstant.AD_CREATIVE)
        );
        dumpCreativeUnitTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                              DConstant.AD_CREATIVE_UNIT)
        );
        dumpUnitKeywordTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                              DConstant.AD_UNIT_KEYWORD)
        );
        dumpUnitItTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                              DConstant.AD_UNIT_IT)
        );
        dumpUnitDistrictTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                              DConstant.AD_UNIT_DISTRICT)
        );
    }

    private void dumpAdPlanTable(String filename) {
        List<PlanPO> planPOList = planPOMapper.findAllByStatus(
                CommonStatus.VALID.getStatus()
        );
        if (CollectionUtils.isEmpty(planPOList)) {
            return;
        }
        List<AdPlanTable> planTables = new ArrayList<>();
        planPOList.forEach(planPO -> planTables.add(
                new AdPlanTable(
                        planPO.getId(),
                        planPO.getUserId(),
                        planPO.getPlanStatus(),
                        planPO.getStartDate(),
                        planPO.getEndDate()
                )
        ));

        Path path = Paths.get(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdPlanTable planTable : planTables) {
                writer.write(JSON.toJSONString(planTable));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpAdPlanTable error");
        }
    }

    private void dumpAdUnitTable(String fileName) {
        List<UnitPO> unitPOList = unitPOMapper.findAllByStatus(
                CommonStatus.VALID.getStatus()
        );
        if (CollectionUtils.isEmpty(unitPOList)) {
            return;
        }
        List<AdUnitTable> unitTables = new ArrayList<>();
        unitPOList.forEach(unitPO -> unitTables.add(
                new AdUnitTable(
                        unitPO.getId(),
                        unitPO.getUnitStatus(),
                        unitPO.getPositionType(),
                        unitPO.getPlanId()
                )
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitTable planTable : unitTables) {
                writer.write(JSON.toJSONString(planTable));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpAdUnitTable error");
        }
    }

    private void dumpCreativeTable(String fileName) {
        List<CreativePO> creativePOList = creativePOMapper.findAll();
        if (CollectionUtils.isEmpty(creativePOList)) {
            return;
        }
        List<CreativeTable> creativeTables = new ArrayList<>();
        creativePOList.forEach(creativePO -> creativeTables.add(
                new CreativeTable(
                        creativePO.getId(),
                        creativePO.getName(),
                        creativePO.getType(),
                        creativePO.getMaterialType(),
                        creativePO.getHeight(),
                        creativePO.getWidth(),
                        creativePO.getAuditStatus(),
                        creativePO.getUrl()
                )
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (CreativeTable planTable : creativeTables) {
                writer.write(JSON.toJSONString(planTable));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpCreativeTable error");
        }
    }

    private void dumpCreativeUnitTable(String fileName) {
        List<CreativeUnitPO> creativeUnitPOList = creativeUnitPOMapper.findAll();
        if (CollectionUtils.isEmpty(creativeUnitPOList)) {
            return;
        }
        List<CreativeUnitTable> creativeUnitTables = new ArrayList<>();
        creativeUnitPOList.forEach(creativeUnitPO -> creativeUnitTables.add(
                new CreativeUnitTable(
                        creativeUnitPO.getUnitId(),
                        creativeUnitPO.getId()
                )
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (CreativeUnitTable planTable : creativeUnitTables) {
                writer.write(JSON.toJSONString(planTable));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpCreativeUnitTable error");
        }
    }

    private void dumpUnitKeywordTable(String fileName) {
        List<UnitKeywordPO> unitKeywordPOList = unitKeywordPOMapper.findAll();
        if (CollectionUtils.isEmpty(unitKeywordPOList)) {
            return;
        }
        List<AdUnitKeywordTable> unitKeywordTables = new ArrayList<>();
        unitKeywordPOList.forEach(unitKeywordPO -> unitKeywordTables.add(
                new AdUnitKeywordTable(
                        unitKeywordPO.getUnitId(),
                        unitKeywordPO.getKeyword()
                )
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitKeywordTable planTable : unitKeywordTables) {
                writer.write(JSON.toJSONString(planTable));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpUnitKeywordTable error");
        }
    }

    private void dumpUnitItTable(String fileName) {
        List<UnitItPO> unitItPOList = unitItPOMapper.findAll();
        if (CollectionUtils.isEmpty(unitItPOList)) {
            return;
        }
        List<AdUnitItTable> unitItTables = new ArrayList<>();
        unitItPOList.forEach(unitItPO -> unitItTables.add(
                new AdUnitItTable(
                        unitItPO.getUnitId(),
                        unitItPO.getItTag()
                )
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitItTable planTable : unitItTables) {
                writer.write(JSON.toJSONString(planTable));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpUnitKeywordTable error");
        }
    }

    private void dumpUnitDistrictTable(String fileName) {
        List<UnitDistrictPO> unitDistrictPOList = unitDistrictPOMapper.findAll();
        if (CollectionUtils.isEmpty(unitDistrictPOList)) {
            return;
        }
        List<AdUnitDistrictTable> unitDistrictTables = new ArrayList<>();
        unitDistrictPOList.forEach(unitDistrictPO -> unitDistrictTables.add(
                new AdUnitDistrictTable(
                        unitDistrictPO.getUnitId(),
                        unitDistrictPO.getProvince(),
                        unitDistrictPO.getCity()
                )
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitDistrictTable planTable : unitDistrictTables) {
                writer.write(JSON.toJSONString(planTable));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpUnitKeywordTable error");
        }
    }
}
