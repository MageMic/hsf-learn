package com.zju.ad.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 22:13 2019/9/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitKeywordRequest {

    private List<UnitKeyword> unitKeywords;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitKeyword {

        @ApiModelProperty(name = "unitId", value = "单元id")
        private Long unitId;
        @ApiModelProperty(name = "keyword", value = "关键词")
        private String keyword;
    }
}
