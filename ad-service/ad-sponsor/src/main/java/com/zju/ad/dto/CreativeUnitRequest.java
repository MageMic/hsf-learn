package com.zju.ad.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 23:49 2019/9/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeUnitRequest {

    private List<CreativeUnitItem> unitItems;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreativeUnitItem {

        @ApiModelProperty(name = "creativeId", value = "创意id")
        private Long creativeId;
        @ApiModelProperty(name = "unitId", value = "单元id")
        private Long unitId;
    }
}
