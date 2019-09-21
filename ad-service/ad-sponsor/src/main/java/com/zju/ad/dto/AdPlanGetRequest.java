package com.zju.ad.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 21:20 2019/9/21
 */
@Data
public class AdPlanGetRequest {

    @ApiModelProperty(name = "userId", value = "用户id")
    private Long userId;

    @ApiModelProperty(name = "ids", value = "用户id列表")
    private List<Long> ids;

    public boolean validate() {

        return userId != null && !CollectionUtils.isEmpty(ids);
    }
}
