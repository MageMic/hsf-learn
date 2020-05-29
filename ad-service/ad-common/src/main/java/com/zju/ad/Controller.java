package com.zju.ad;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zjumic
 * @Date: created at 23:41 2019/9/25
 */
@RestController
@Api
public class Controller {

    @GetMapping("/test")
    @ApiOperation(value = "123")
    public String test() {
        return "test";
    }
}
