package com.zju.ad.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zju.ad.constant.CommonStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@ApiModel
@Data
@TableName(value = "ad_user")
public class AdUser {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "username", value = "用户名")
    @TableField(value = "username", insertStrategy = FieldStrategy.NOT_NULL)
    private String username;

    @ApiModelProperty(name = "token", value = "token")
    @TableField(value = "token", insertStrategy = FieldStrategy.NOT_NULL)
    private String token;

    @ApiModelProperty(name = "userStatus", value = "用户状态")
    @TableField(value = "user_status", insertStrategy = FieldStrategy.NOT_NULL)
    private Byte userStatus;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "create_time", insertStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "update_Time", insertStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;

    public AdUser(String username, String token) {
        this.username = username;
        this.token = token;
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}