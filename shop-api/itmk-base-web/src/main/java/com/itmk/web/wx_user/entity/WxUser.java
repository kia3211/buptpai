package com.itmk.web.wx_user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("wx_user")
public class WxUser {
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String nickName;
    private String name;
    private String picture;
    private String phone;
    private String username;
    private String password;
    //0:启用 1：停用
    private String status;
}
