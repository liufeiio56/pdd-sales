package com.lora.pay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lora.pay.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByUsername(String username);
}    