package com.zju.ad.controller;

import com.alibaba.fastjson.JSON;
import com.zju.ad.dto.*;
import com.zju.ad.exception.AdException;
import com.zju.ad.service.AdUnitService;
import com.zju.ad.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zjumic
 * @Date: created at 22:40 2019/9/25
 */
@Slf4j
@RestController
@Api(tags = "推广单元操作")
public class AdUnitOPController {

    @Autowired
    private AdUnitService adUnitService;


    @PostMapping("/create/adUnit")
    @ApiOperation(value = "创建推广单元")
    public AdUnitResponse createUnit(@RequestBody AdUnitRequest request) throws AdException {
        log.info("ad-sponsor: createUnit -> {}", JSON.toJSONString(request));
        return adUnitService.createAdUnit(request);
    }


    @PostMapping("/create/unitKeyword")
    @ApiOperation(value = "创建关键词")
    public AdUnitKeywordResponse createUnitKeyword(@RequestBody AdUnitKeywordRequest request) throws AdException {
        log.info("ad-sponsor: createUnitKeyword -> {}", JSON.toJSONString(request));
        return adUnitService.createUnitKeyword(request);
    }

    @PostMapping("/create/unitIt")
    @ApiOperation(value = "创建兴趣")
    public AdUnitItResponse createUnitIt(@RequestBody AdUnitItRequest request) throws AdException {
        log.info("ad-sponsor: createUnitIt -> {}", JSON.toJSONString(request));
        return adUnitService.createUnitIt(request);
    }

    @PostMapping("/create/unitDistrict")
    @ApiOperation(value = "创建推广区域")
    public AdUnitDistrictResponse createUnitDistrict(@RequestBody AdUnitDistrictRequest request) throws AdException {
        log.info("ad-sponsor: createUnitDistrict -> {}", JSON.toJSONString(request));
        return adUnitService.createUnitDistrict(request);
    }

    @PostMapping("/create/creativeUnit")
    @ApiOperation(value = "创建创意单元关联")
    public CreativeUnitResponse createCreativeUnit(@RequestBody CreativeUnitRequest request) throws AdException {
        log.info("ad-sponsor: createCreativeUnit -> {}", JSON.toJSONString(request));
        return adUnitService.createCreativeUnit(request);
    }
}
