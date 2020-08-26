package edu.nuaa.wwn.ad.constant;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-26
 * Time: 18:23
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态");

    private final int status;
    private final String desc;

    CommonStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
