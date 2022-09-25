package com.heima.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.wemedia.pojos.WmUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * wm用户映射器
 *
 * @author JiShiMing
 * @date 2022/09/25
 */
@Mapper
public interface WmUserMapper extends BaseMapper<WmUser> {
}