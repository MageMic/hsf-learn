package com.zju.ad.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zjumic
 * @Date: created at 21:19 2019/9/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanResponse {

    @ApiModelProperty(name = "id", value = "主键")
    private Long id;

    @ApiModelProperty(name = "planName", value = "计划名称")
    private String planName;
}
