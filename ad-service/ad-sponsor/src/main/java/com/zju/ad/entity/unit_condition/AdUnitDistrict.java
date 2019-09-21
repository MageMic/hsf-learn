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
@TableName(value = "ad_unit_district")
public class AdUnitDistrict {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "unitId", value = "单元id")
    @TableField(value = "unit_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long unitId;

    @ApiModelProperty(name = "province", value = "省")
    @TableField(value = "province", insertStrategy = FieldStrategy.NOT_NULL)
    private String province;

    @ApiModelProperty(name = "city", value = "市")
    @TableField(value = "city", insertStrategy = FieldStrategy.NOT_NULL)
    private String city;

    public AdUnitDistrict(Long unitId, String province, String city) {
        this.unitId = unitId;
        this.province = province;
        this.city = city;
    }
}