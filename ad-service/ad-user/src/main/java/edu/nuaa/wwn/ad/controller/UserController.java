package edu.nuaa.wwn.ad.controller;

import edu.nuaa.wwn.ad.constant.Constants;
import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.service.UserService;
import edu.nuaa.wwn.ad.vo.UserInfoModel;
import edu.nuaa.wwn.ad.vo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 16:00
 */

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="register",method = RequestMethod.POST)
    @ResponseBody
    public String register(UserModel userModel){
        if(userModel.getUsername() == null || userModel.getUsername().trim().length()==0){
            return "用户名不能为空";
        }
        if(userModel.getPassword() == null || userModel.getPassword().trim().length()==0){
            return "密码不能为空";
        }

        boolean isSuccess = userService.register(userModel);
        if(isSuccess){
            return "注册成功";
        }else{
            return "注册失败";
        }
    }

    @RequestMapping(value="logout",method = RequestMethod.GET)
    @ResponseBody
    public String logout(UserModel userModel){
        /*
            1.前端存储jwt 7天：jwt刷新
            2.服务器端存储活动用户信息 30分钟
            3.JWT里的userId为key，查找活跃用户

            退出：
                1.前端删除jwt
                2.后端删除活跃用户缓存
         */
        return "用户退出成功";
    }

    @RequestMapping(value="getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public UserInfoModel getUserInfo() throws AdException {
        //获取当前用户
        String userId = CurrentUser.getUserId();
        if (userId != null && userId.trim().length() > 0) {
            int uuid = Integer.parseInt(userId);

            UserInfoModel userInfoModel = userService.getUserInfoModel(uuid);
            if (userInfoModel != null) {
                return userInfoModel;
            } else {
                throw new AdException(Constants.ErrorMsg.USER_NOT_EXIST_ERROR);
            }
        } else {
            throw new AdException(Constants.ErrorMsg.USER_NOT_LOGIN_ERROR);
        }
    }

    @RequestMapping(value="updateUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public String updateUserInfo(UserInfoModel userInfoModel){
        //获取当前用户
        String userId = CurrentUser.getUserId();
        if (userId != null && userId.trim().length() > 0) {
            int uuid = Integer.parseInt(userId);
            if (uuid != userInfoModel.getUuid()) {
                return "请修改个人的用户信息";
            }
            UserInfoModel newUserInfo = userService.updateUserInfoModel(userInfoModel);
            if (newUserInfo != null) {
                return "用户信息修改成功";
            } else {
                return "用户信息修改失败";
            }
        } else {
            return "用户未登录";
        }
    }
}
