package com.zju.ad.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zju.ad.constant.CommonStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ad_unit")
public class AdUnit {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "planId", value = "计划id")
    @TableField(value = "plan_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long planId;

    @ApiModelProperty(name = "unitName", value = "单元名称")
    @TableField(value = "unit_name", insertStrategy = FieldStrategy.NOT_NULL)
    private String unitName;

    @ApiModelProperty(name = "unitStatus", value = "单元状态")
    @TableField(value = "unit_status", insertStrategy = FieldStrategy.NOT_NULL)
    private Byte unitStatus;

    @ApiModelProperty(name = "positionType", value = "广告位类型", notes = "开屏，贴片，中贴...")
    @TableField(value = "position_type", insertStrategy = FieldStrategy.NOT_NULL)
    private Byte positionType;

    @ApiModelProperty(name = "budget", value = "预算")
    @TableField(value = "budget", insertStrategy = FieldStrategy.NOT_NULL)
    private Long budget;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "create_time", insertStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "update_Time", insertStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;

    public AdUnit(Long planId, String unitName, Byte positionType, Long budget) {
        this.planId = planId;
        this.unitName = unitName;
        this.unitStatus = CommonStatus.VALID.getStatus();
        this.positionType = positionType;
        this.budget = budget;
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}