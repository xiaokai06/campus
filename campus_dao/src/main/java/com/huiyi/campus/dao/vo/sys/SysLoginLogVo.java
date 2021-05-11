package com.huiyi.campus.dao.vo.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yzg
 * @time: 2021-05-11 16:16
 * @description: 登录日志返回实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("登录日志")
public class SysLoginLogVo {

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
