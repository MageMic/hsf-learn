package com.zju.ad.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author: zjumic
 * @Date: created at 20:29 2019/9/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDTO {

    @NotNull(message = "用户名不可为空")
    @ApiModelProperty(name = "username", value = "用户名", dataType = "String", required = true)
    private String username;

}
