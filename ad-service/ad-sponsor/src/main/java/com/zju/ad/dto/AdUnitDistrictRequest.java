package com.zju.ad.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 22:18 2019/9/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitDistrictRequest {

    private List<UnitDistrict> unitDistricts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitDistrict {

        @ApiModelProperty(name = "unitId", value = "单元id")
        private Long unitId;
        @ApiModelProperty(name = "province", value = "省")
        private String province;
        @ApiModelProperty(name = "city", value = "市")
        private String city;
    }
}
