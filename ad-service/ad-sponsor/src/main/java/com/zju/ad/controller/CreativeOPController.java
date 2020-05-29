package com.zju.ad.controller;

import com.alibaba.fastjson.JSON;
import com.zju.ad.dto.CreativeRequest;
import com.zju.ad.service.CreativeService;
import com.zju.ad.vo.CreativeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zjumic
 * @Date: created at 22:46 2019/9/25
 */
@Slf4j
@RestController
@Api(tags = "创意操作")
public class CreativeOPController {

    @Autowired
    private CreativeService creativeService;

    @PostMapping("/create/creative")
    @ApiOperation(value = "创建创意")
    public CreativeResponse createCreative(@RequestBody CreativeRequest request) {
        log.info("ad-sponsor: createCreative -> {}", JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}
