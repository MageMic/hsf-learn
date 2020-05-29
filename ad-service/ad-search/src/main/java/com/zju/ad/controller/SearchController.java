package com.zju.ad.controller;

import com.alibaba.fastjson.JSON;
import com.zju.ad.annotation.IgnoreResponseAdvice;
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
    public SearchController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
