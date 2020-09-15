package edu.nuaa.wwn.ad.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 16:07
 */

@Data
public class UserModel implements Serializable {
    private String username;

    private String password;

    private String email;

    private String phone;
}
