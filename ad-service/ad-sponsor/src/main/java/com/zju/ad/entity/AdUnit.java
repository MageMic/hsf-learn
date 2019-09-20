package com.zju.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName
public class AdUnit {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "planId", value = "计划id")
    @TableField(value = "plan_id")
    @NotNull
    private Long planId;

    @ApiModelProperty(name = "unitName", value = "单元名称")
    @TableField(value = "unit_name")
    @NotNull
    private String unitName;

    @ApiModelProperty(name = "unitStatus", value = "单元状态")
    @TableField(value = "unit_status")
    @NotNull
    private Byte unitStatus;

    @ApiModelProperty(name = "positionType", value = "单元状态")
    @TableField(value = "position_type")
    @NotNull
    private Byte positionType;

    @ApiModelProperty(name = "budget", value = "预算")
    @TableField(value = "budget")
    @NotNull
    private Long budget;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @TableField(value = "create_time")
    @NotNull
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @TableField(value = "update_Time")
    @NotNull
    private Date updateTime;
}