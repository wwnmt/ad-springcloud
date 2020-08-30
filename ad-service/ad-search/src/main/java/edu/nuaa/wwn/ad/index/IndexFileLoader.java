package edu.nuaa.wwn.ad.index;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.dump.DConstant;
import edu.nuaa.wwn.ad.dump.table.AdPlanTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitDistrictTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitItTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitKeywordTable;
import edu.nuaa.wwn.ad.dump.table.AdUnitTable;
import edu.nuaa.wwn.ad.dump.table.CreativeTable;
import edu.nuaa.wwn.ad.handler.AdLevelDataHandler;
import edu.nuaa.wwn.ad.mysql.constant.OpType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 17:05
 */
@Slf4j
@Component
@DependsOn("dataTable")
public class IndexFileLoader {

    @PostConstruct
    public void init() {
        //AD_PLAN
        List<String> adPlanStrings = loadDumpData(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN)
        );
        adPlanStrings.forEach(p -> AdLevelDataHandler.handleLevel2(
                JSON.parseObject(p, AdPlanTable.class), OpType.ADD
        ));
        //CREATIVE
        List<String> creativeStrings = loadDumpData(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_CREATIVE)
        );
        creativeStrings.forEach(c -> AdLevelDataHandler.handleLevel2(
                JSON.parseObject(c, CreativeTable.class), OpType.ADD
        ));
        //AD_UNIT
        List<String> adUnitStrings = loadDumpData(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT)
        );
        adUnitStrings.forEach(u -> AdLevelDataHandler.handleLevel3(
                JSON.parseObject(u, AdUnitTable.class), OpType.ADD
        ));
        //AD_UNIT_DISTRICT
        List<String> adUnitDistrictStrings = loadDumpData(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT_DISTRICT)
        );
        adUnitDistrictStrings.forEach(d -> AdLevelDataHandler.handleLevel4(
                JSON.parseObject(d, AdUnitDistrictTable.class), OpType.ADD
        ));
        //AD_UNIT_DISTRICT
        List<String> adUnitItStrings = loadDumpData(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT_IT)
        );
        adUnitItStrings.forEach(i -> AdLevelDataHandler.handleLevel4(
                JSON.parseObject(i, AdUnitItTable.class), OpType.ADD
        ));
        //AD_UNIT_DISTRICT
        List<String> adUnitKeywordStrings = loadDumpData(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT_KEYWORD)
        );
        adUnitKeywordStrings.forEach(k -> AdLevelDataHandler.handleLevel4(
                JSON.parseObject(k, AdUnitKeywordTable.class), OpType.ADD
        ));
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    private List<String> loadDumpData(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            return br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
