package com.zju.ad.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: zjumic
 * @Date: created at 0:03 2019/9/21
 */
@Getter
@AllArgsConstructor
public enum CommonStatus {

    VALID((byte)1, "有效状态"),
    INVALID((byte)2, "无效状态");

    private Byte status;
    private String desc;
}
