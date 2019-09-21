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
@TableName(value = "ad_unit_it")
public class AdUnitIt {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "unitId", value = "单元id")
    @TableField(value = "unit_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long unitId;

    @ApiModelProperty(name = "itTag", value = "兴趣标签")
    @TableField(value = "it_tag", insertStrategy = FieldStrategy.NOT_NULL)
    private String itTag;

    public AdUnitIt(Long unitId, String itTag) {
        this.unitId = unitId;
        this.itTag = itTag;
    }

}