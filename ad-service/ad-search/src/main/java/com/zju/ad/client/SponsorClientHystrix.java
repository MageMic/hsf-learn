package com.zju.ad.client;

import com.zju.ad.client.vo.AdPlan;
import com.zju.ad.client.vo.AdPlanGetRequest;
import com.zju.ad.dto.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author magemic
 * @date 2020/5/30
 */
@Component
public class SponsorClientHystrix implements SponsorClient {
    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "eureka-client-ad-sponsor error");
    }
}
