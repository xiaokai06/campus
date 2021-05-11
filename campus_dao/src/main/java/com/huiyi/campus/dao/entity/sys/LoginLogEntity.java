package com.huiyi.campus.dao.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: yzg
 * @time: 2021-05-11 16:04
 * @description: 登录日志
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("登录日志")
public class LoginLogEntity implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("登录用户名")
    private String loginName;

    @ApiModelProperty("登录IP")
    private String loginIp;

    @ApiModelProperty("登录时间")
    private String loginTime;

    @ApiModelProperty("创建时间")
    private String createTime;

}
