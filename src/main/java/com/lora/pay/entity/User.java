package com.lora.pay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableField("is_admin") // 指定数据库字段名
    private Integer isAdmin; // 使用Integer类型对应数据库int
    private String userLabel;




}    