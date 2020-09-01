package edu.nuaa.wwn.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 17:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdSlot {

    //广告位编码
    private String adSlotCode;
    //流量类型
    private Integer positionType;
    //广告位宽和高
    private Integer width;
    private Integer height;

    //物料类型 视频，图片
    private List<Integer> type;
    //最低出价
    private Integer minCpm;
}
