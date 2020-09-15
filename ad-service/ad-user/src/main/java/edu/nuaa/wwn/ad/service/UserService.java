package edu.nuaa.wwn.ad.service;


import edu.nuaa.wwn.ad.vo.UserInfoModel;
import edu.nuaa.wwn.ad.vo.UserModel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 15:09
 */
public interface UserService {

    int login(String username, String password);

    boolean register(UserModel userModel);

    UserInfoModel getUserInfoModel(int uuid);

    UserInfoModel updateUserInfoModel(UserInfoModel userInfoModel);

}
