package com.heima.model.common.user.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录dto
 * Created by IntelliJ IDEA.
 *
 * @author JiShiMing
 * @Date 2022/9/22 10:56
 */
@Data
public class LoginDto {
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
