package com.zju.ad.index.creativeunit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author magemic
 * @date 2020/6/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeUnitObject {

    private Long adId;
    private Long unitId;

    // key: adId-unitId
}
