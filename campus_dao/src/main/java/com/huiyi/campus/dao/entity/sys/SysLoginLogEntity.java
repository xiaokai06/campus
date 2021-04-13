package com.huiyi.campus.dao.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@ApiModel("登录日志管理")
public class SysLoginLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("登录用户名")
    private String loginUname;

    @ApiModelProperty("登录IP")
    private String loginIp;

    @ApiModelProperty("登录时间")
    private Date loginTime;

    @ApiModelProperty("创建时间")
    private Date createTime;

}