package com.heima.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.common.user.dtos.LoginDto;
import com.heima.model.common.user.pojos.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;
import com.heima.utils.common.AppJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : JiShiMing
 * @Date 2022/9/22 11:00
 */
@Service
@Transactional
@Slf4j
public class ApUserServiceImpl extends ServiceImpl<ApUserMapper, ApUser> implements ApUserService {

    /**
     * app端登录功能-实现
     *
     * @param loginDto 登录dto
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult login(LoginDto loginDto) {
        // 1.正常登录,用户名和密码
        if (StringUtils.isNotBlank(loginDto.getPhone()) && StringUtils.isNotBlank(loginDto.getPassword())) {
            // 1.1 根据手机号查询用户信息
            ApUser apUser = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone, loginDto.getPhone()));
            if (apUser == null) {
                return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST, "用户消息不存在");
            }
            // 1.2 比对密码
            String salt = apUser.getSalt();
            String password = loginDto.getPassword();
            String pswd = DigestUtils.md5DigestAsHex((password + salt).getBytes());
            if (!pswd.equals(apUser.getPassword())) {
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
            // 1.3 返回数据
            String token = AppJwtUtil.getToken(apUser.getId().longValue());
            HashMap<String, Object> map = new HashMap<>();
            map.put("token", token);
            apUser.setSalt("");
            apUser.setPassword("");
            map.put("user", apUser);

            return ResponseResult.okResult(map);
        } else {
            // 2.游客登录
            HashMap<String, Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0L));
            return ResponseResult.okResult(map);
        }
    }
}
