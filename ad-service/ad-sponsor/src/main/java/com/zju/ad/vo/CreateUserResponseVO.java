package com.zju.ad.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: zjumic
 * @Date: created at 20:31 2019/9/21
 */
@Data
public class CreateUserResponseVO {

    @ApiModelProperty(name = "id", value = "主键")
    private Long userId;

    @ApiModelProperty(name = "username", value = "用户名")
    private String username;

    @ApiModelProperty(name = "token", value = "token")
    private String token;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Date updateTime;
}
