package edu.nuaa.wwn.ad.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 16:32
 */

@Data
public class UserInfoModel implements Serializable {

    private int uuid;

    private String username;

    private String email;

    private String phone;

    private int sex;

    private long createTime;

    private long updateTime;
}
