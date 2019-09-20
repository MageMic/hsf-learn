package com.zju.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class AdUser {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "username", value = "用户名")
    @TableId(value = "username")
    @NotNull
    private String username;

    @ApiModelProperty(name = "token", value = "token")
    @TableId(value = "token")
    @NotNull
    private String token;

    @ApiModelProperty(name = "userStatus", value = "用户状态")
    @TableId(value = "user_status")
    @NotNull
    private Byte userStatus;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @TableId(value = "create_time")
    @NotNull
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @TableId(value = "update_Time")
    @NotNull
    private Date updateTime;

    public AdUser(String username, String token) {
        this.username = username;
        this.token = token;
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}