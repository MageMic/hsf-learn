package com.zju.ad.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: zjumic
 * @Date: created at 21:09 2019/9/21
 */
@Data
public class AdPlanRequest {

    @ApiModelProperty(name = "id", value = "id")
    private Long id;

    @ApiModelProperty(name = "userId", value = "用户id")
    private Long userId;

    @ApiModelProperty(name = "planName", value = "计划名称")
    private String planName;

    @ApiModelProperty(name = "startDate", value = "开始时间")
    private String startDate;

    @ApiModelProperty(name = "endDate", value = "结束时间")
    private String endDate;

    public boolean createValidate() {
        return userId != null
                && StringUtils.isNotBlank(planName)
                && StringUtils.isNotBlank(startDate)
                && StringUtils.isNotBlank(endDate);
    }

    public boolean updateValidate() {
        return id != null && userId != null;
    }

    public boolean deleteValidate() {
        return id != null && userId != null;
    }
}
