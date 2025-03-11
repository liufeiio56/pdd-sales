package com.lora.pay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@TableName("t_users")
@Data
@Accessors(chain = true)
public class User {
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String userName;
    private String passWord;
    private String pddUserName;
    private String isAdmin;
    private String userLabel;




}    