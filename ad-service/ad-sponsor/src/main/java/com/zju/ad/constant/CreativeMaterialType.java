package com.zju.ad.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: zjumic
 * @Date: created at 20:21 2019/9/21
 */
@Getter
@AllArgsConstructor
public enum CreativeMaterialType {

    JPG((byte)1, "jpg"),
    BMP((byte)2, "bmp"),

    MP4((byte)3, "mp4"),
    AVI((byte)4, "avi"),

    TXT((byte)5, "txt");

    private Byte type;
    private String desc;
}
