package edu.nuaa.wwn.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 10:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitItRequest {

    private List<UnitIt> its;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitIt{
        private Long unitId;
        private String tag;
    }
}
