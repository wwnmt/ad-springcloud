package edu.nuaa.wwn.ad.service.impl;

import edu.nuaa.wwn.ad.constant.CommonStatus;
import edu.nuaa.wwn.ad.constant.Constants;
import edu.nuaa.wwn.ad.dao.UserPOMapper;
import edu.nuaa.wwn.ad.entity.UserPO;
import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.service.UserService;
import edu.nuaa.wwn.ad.util.CommonUtils;
import edu.nuaa.wwn.ad.vo.CreateUserRequest;
import edu.nuaa.wwn.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-26
 * Time: 18:03
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserPOMapper userPOMapper;

    @Autowired
    public UserServiceImpl(UserPOMapper userPOMapper) {
        this.userPOMapper = userPOMapper;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        if (request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        String username = request.getUsername();
        UserPO oldUser = userPOMapper.findByUsername(username);
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        UserPO newUser = new UserPO();
        newUser.setUsername(username);
        newUser.setToken(CommonUtils.md5(username));
        newUser.setUserStatus((byte) CommonStatus.VALID.getStatus());
        newUser.setCreateTime(new Date());
        newUser.setUpdateTime(new Date());
        userPOMapper.insert(newUser);
        return new CreateUserResponse(newUser.getId(), newUser.getUsername(),
                                      newUser.getToken(), newUser.getCreateTime(), newUser.getUpdateTime());
    }
}
