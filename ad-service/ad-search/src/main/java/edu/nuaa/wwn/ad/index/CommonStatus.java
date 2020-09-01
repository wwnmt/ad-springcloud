package edu.nuaa.wwn.ad.index;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-09-01
 * Time: 10:32
 */
@Getter
public enum CommonStatus {

    VALID((byte)1, "有效状态"),
    INVALID((byte)0, "无效状态");

    private final Byte status;
    private final String desc;


    CommonStatus(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
