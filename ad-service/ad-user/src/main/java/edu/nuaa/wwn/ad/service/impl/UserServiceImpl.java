package edu.nuaa.wwn.ad.service.impl;

import edu.nuaa.wwn.ad.dao.UserPOMapper;
import edu.nuaa.wwn.ad.entity.UserPO;
import edu.nuaa.wwn.ad.service.UserService;
import edu.nuaa.wwn.ad.util.MD5Util;
import edu.nuaa.wwn.ad.vo.UserInfoModel;
import edu.nuaa.wwn.ad.vo.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 15:12
 */

@Service
public class UserServiceImpl implements UserService{

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserPOMapper userPOMapper;

    @Override
    public int login(String username, String password) {
        log.info(username + " login...");
        UserPO userDO = userPOMapper.selectByUserName(username);
        if (userDO != null && userDO.getUserId() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (md5Password.equals(userDO.getUserPwd())) {
                log.info(username + " login success");
                return userDO.getUserId();
            }
        }
        log.info(username + " login failed");
        return -1;
    }

    @Override
    public boolean register(UserModel userModel) {
        UserPO userDO = new UserPO();
        userDO.setUserName(userModel.getUsername());
        userDO.setEmail(userModel.getEmail());
        userDO.setUserPhone(userModel.getPhone());

        //数据加密 【MD5混淆加密 + 盐值 Shiro加密】
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        userDO.setUserPwd(md5Password);
        int id = userPOMapper.insert(userDO);
        if (id > 0) {
            log.info("New User: " + userModel.getUsername() + " phone: " + userModel.getPhone());
            return true;
        }
        return false;
    }

    @Override
    public UserInfoModel getUserInfoModel(int uuid) {
        //根据主键查询UserDO
        //把UserDO转换为UserInfoModel，返回
        UserPO userDO = userPOMapper.selectByPrimaryKey(uuid);
        if (userDO == null || userDO.getUserId() != uuid) {
            log.info(uuid + " not exist");
            return null;
        }
        return do2UserInfoModel(userDO);
    }

    @Override
    public UserInfoModel updateUserInfoModel(UserInfoModel userInfoModel) {
        //转换数据
        UserPO userDO = model2UserDO(userInfoModel);
        System.out.println(userInfoModel);
        //更新数据库
        int result = userPOMapper.updateByPrimaryKeySelective(userDO);
        if (result > 0) {
            //通过id读取数据库
            return getUserInfoModel(userInfoModel.getUuid());
        } else {
            return userInfoModel;
        }
    }

    private Date time2Date(long time) {
        return new Date(time);
    }

    private long date2Long(Date date) {
        return date.getTime();
    }

    private UserPO model2UserDO(UserInfoModel userInfoModel) {
        UserPO userDO = new UserPO();
        userDO.setUserPhone(userInfoModel.getPhone());
        userDO.setUserName(userInfoModel.getUsername());
        userDO.setEmail(userInfoModel.getEmail());
        userDO.setUserId(userInfoModel.getUuid());
        userDO.setUserSex(userInfoModel.getSex());

        if (userInfoModel.getUpdateTime() != 0) {
            userDO.setUpdateTime(time2Date(userInfoModel.getUpdateTime()));
        } else {
            userDO.setUpdateTime(new Date());
        }
        if (userInfoModel.getCreateTime() != 0) {
            userDO.setBeginTime(time2Date(userInfoModel.getCreateTime()));
        } else {
            userDO.setBeginTime(null);
        }
        return userDO;
    }

    private UserInfoModel do2UserInfoModel(UserPO userDO) {
        UserInfoModel userInfoModel = new UserInfoModel();

        userInfoModel.setUuid(userDO.getUserId());
        userInfoModel.setUsername(userDO.getUserName());
        userInfoModel.setSex(userDO.getUserSex());
        userInfoModel.setPhone(userDO.getUserPhone());
        userInfoModel.setEmail(userDO.getEmail());
        userInfoModel.setUpdateTime(date2Long(userDO.getUpdateTime()));
        userInfoModel.setCreateTime(date2Long(userDO.getBeginTime()));

        return userInfoModel;
    }
}
