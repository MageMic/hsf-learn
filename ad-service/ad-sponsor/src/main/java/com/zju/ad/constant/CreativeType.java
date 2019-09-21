package com.zju.ad.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: zjumic
 * @Date: created at 20:20 2019/9/21
 */
@Getter
@AllArgsConstructor
public enum CreativeType {

    IMAGE((byte)1, "图片"),
    VIDEO((byte)2, "视频"),
    TEXT((byte)3, "文本");

    private Byte type;
    private String desc;
}
