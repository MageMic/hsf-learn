package com.zju.ad.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: zjumic
 * @Date: created at 23:44 2019/9/23
 */
@Data
public class AdUnitRequest {

    @ApiModelProperty(name = "planId", value = "计划id")
    private Long planId;

    @ApiModelProperty(name = "unitName", value = "单元名称")
    private String unitName;

    @ApiModelProperty(name = "positionType", value = "广告位类型", notes = "开屏，贴片，中贴...")
    private Byte positionType;

    @ApiModelProperty(name = "budget", value = "预算")
    private Long budget;

    public boolean createValidate() {
        return null != planId && !StringUtils.isNotBlank(unitName)
                && positionType != null && budget != null;
    }
}
