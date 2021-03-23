package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Setter
@Getter
@TableName("sys_user")
public class SysUserEntity implements Serializable {
    private String uid;

    private String userName;

    private String passWord;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;


}