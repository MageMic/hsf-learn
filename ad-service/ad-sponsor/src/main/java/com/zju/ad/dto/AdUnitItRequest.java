package com.zju.ad.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 22:16 2019/9/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitItRequest {

    private List<UnitIt> unitIts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitIt {

        @ApiModelProperty(name = "unitId", value = "单元id")
        private Long unitId;
        @ApiModelProperty(name = "itTag", value = "兴趣标签")
        private String itTag;
    }
}
