package com.zju.ad.entity.unit_condition;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: zjumic
 * @Date: created at 19:51 2019/9/21
 */
@EqualsAndHashCode(callSuper = false)
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "ad_unit_keyword")
public class AdUnitKeyword {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "unitId", value = "单元id")
    @TableField(value = "unit_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long unitId;

    @ApiModelProperty(name = "keyword", value = "关键词")
    @TableField(value = "keyword", insertStrategy = FieldStrategy.NOT_NULL)
    private String keyword;

    public AdUnitKeyword(Long unitId, String keyword) {
        this.unitId = unitId;
        this.keyword = keyword;
    }
}
