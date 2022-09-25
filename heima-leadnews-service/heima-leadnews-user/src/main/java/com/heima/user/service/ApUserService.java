package com.heima.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.user.dtos.LoginDto;
import com.heima.model.common.user.pojos.ApUser;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : JiShiMing
 * @Date 2022/9/22 11:00
 */
public interface ApUserService extends IService<ApUser> {


    /**
     * app端登录功能
     *
     * @param loginDto 登录dto
     * @return {@link ResponseResult}
     */
    public ResponseResult login(LoginDto loginDto);
}
