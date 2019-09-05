package com.zhuofengyuan.mlszm.vote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.NONE)
    private String id;
    private String openid;
    private String name;
    private String logo;
    private String username;
    private String screenName;
    private String password;
}
