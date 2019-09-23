package com.zju.ad.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zjumic
 * @Date: created at 23:49 2019/9/23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitResponse {

    @ApiModelProperty(name = "planId", value = "计划id")
    private Long planId;

    @ApiModelProperty(name = "unitName", value = "单元名称")
    private String unitName;
}
