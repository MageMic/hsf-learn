package com.zju.ad.entity.unit_condition;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "creative_unit")
public class CreativeUnit {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "creativeId", value = "创意id")
    @TableField(value = "creative_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long creativeId;

    @ApiModelProperty(name = "unitId", value = "单元id")
    @TableField(value = "unit_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long unitId;

    public CreativeUnit(Long creativeId, Long unitId) {

        this.creativeId = creativeId;
        this.unitId = unitId;
    }
}