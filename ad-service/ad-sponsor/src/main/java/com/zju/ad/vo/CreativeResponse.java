package com.zju.ad.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zjumic
 * @Date: created at 23:43 2019/9/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeResponse {

    @ApiModelProperty(name = "id", value = "id")
    private Long id;
    @ApiModelProperty(name = "name", value = "创意名称")
    private String name;
}
