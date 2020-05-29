package com.zju.ad.controller;

import com.alibaba.fastjson.JSON;
import com.zju.ad.dto.CreateUserRequestDTO;
import com.zju.ad.exception.AdException;
import com.zju.ad.service.UserService;
import com.zju.ad.vo.CreateUserResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zjumic
 * @Date: created at 22:16 2019/9/25
 */
@RestController
@Api(tags = "用户操作")
@Slf4j
public class UserOPController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/user")
    @ApiOperation(value = "创建用户")
    public CreateUserResponseVO createUser(@RequestBody CreateUserRequestDTO request) throws AdException {
        log.info("ad-sponsor: createUser -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }
}
