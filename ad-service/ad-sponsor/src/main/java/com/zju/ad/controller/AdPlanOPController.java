package com.zju.ad.controller;

import com.alibaba.fastjson.JSON;
import com.zju.ad.dto.AdPlanGetRequest;
import com.zju.ad.dto.AdPlanRequest;
import com.zju.ad.dto.CreateUserRequestDTO;
import com.zju.ad.entity.AdPlan;
import com.zju.ad.exception.AdException;
import com.zju.ad.service.AdPlanService;
import com.zju.ad.vo.AdPlanResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 22:30 2019/9/25
 */
@Slf4j
@RestController("/ad-sponsor")
@Api(tags = "推广计划操作")
public class AdPlanOPController {

    @Autowired
    private AdPlanService adPlanService;

    @PostMapping("/create/adPlan")
    @ApiOperation(value = "创建计划")
    public AdPlanResponse createAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: createAdPlan -> {}", JSON.toJSONString(request));
        return adPlanService.createAdPlan(request);
    }

    @PostMapping("/get/adPlan")
    @ApiOperation(value = "获取计划列表")
    public List<AdPlan> getAdPlanByIds(@RequestBody AdPlanGetRequest request) throws AdException{
        log.info("ad-sponsor: getAdPlanByIds -> {}", JSON.toJSONString(request));
        return adPlanService.getAdPlanByIds(request);
    }

    @PutMapping("/update/adPlan")
    @ApiOperation(value = "更新计划")
    public AdPlanResponse updateAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: updateAdPlan -> {}", JSON.toJSONString(request));
        return adPlanService.updateAdPlan(request);
    }

    @DeleteMapping("/delete/adPlan")
    @ApiOperation(value = "删除计划")
    public void deleteAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: deleteAdPlan -> {}", JSON.toJSONString(request));
        adPlanService.deleteAdPlan(request);
    }

}
