package com.zju.ad.controller;

import com.alibaba.fastjson.JSON;
import com.zju.ad.annotation.IgnoreResponseAdvice;
import com.zju.ad.client.SponsorClient;
import com.zju.ad.client.vo.AdPlan;
import com.zju.ad.client.vo.AdPlanGetRequest;
import com.zju.ad.dto.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "ribbon获取AdPlan")
public class SearchController {

    private final RestTemplate restTemplate;
    @Autowired
    private SponsorClient sponsorClient;

    @Autowired
    public SearchController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @IgnoreResponseAdvice
    @PostMapping("/getAdPlans")
    @ApiOperation(value = "获取adPlans")
    public CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlans -> {}",
                JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }

    @SuppressWarnings("all")
    @IgnoreResponseAdvice
    @PostMapping("/getAdPlansByRibbon")
    @ApiOperation(value = "获取adPlanByRibbon")
    public CommonResponse<List<AdPlan>> getAdPlansByRibbon(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlansByRibbon -> {}",
                JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureka-client-ad-sponsor/ad=sponsor/get/adPlan", request, CommonResponse.class
        ).getBody();
    }
}
