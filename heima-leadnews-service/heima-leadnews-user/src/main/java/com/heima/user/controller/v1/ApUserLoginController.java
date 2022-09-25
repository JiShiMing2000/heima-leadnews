package com.heima.user.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.user.dtos.LoginDto;
import com.heima.user.service.ApUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : JiShiMing
 * @Date 2022/9/22 10:54
 */

@RestController
@RequestMapping("api/v1/login")
@Api(value = "app端用户登录", tags = "app端用户登录")
public class ApUserLoginController {

    @Autowired
    private ApUserService apUserService;

    @PostMapping("login_auth")
    @ApiOperation("用户登录")
    public ResponseResult login(@RequestBody LoginDto loginDto) {

        return apUserService.login(loginDto);
    }
}
