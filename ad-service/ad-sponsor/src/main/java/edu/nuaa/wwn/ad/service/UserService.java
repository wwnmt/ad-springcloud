package edu.nuaa.wwn.ad.service;

import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.vo.CreateUserRequest;
import edu.nuaa.wwn.ad.vo.CreateUserResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-26
 * Time: 17:58
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request)
            throws AdException;
}
