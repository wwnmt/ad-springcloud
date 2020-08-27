package edu.nuaa.wwn.ad.controller;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.service.UserService;
import edu.nuaa.wwn.ad.vo.CreateUserRequest;
import edu.nuaa.wwn.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 11:56
 */
@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException {

        log.info("ad-sponsor: createUser -> {}",
                 JSON.toJSONString(request));
        return userService.createUser(request);
    }
}
