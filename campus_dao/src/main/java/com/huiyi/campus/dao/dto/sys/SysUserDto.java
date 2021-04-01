package com.huiyi.campus.dao.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: yzg
 * @time: 2021-03-30 9:56
 * @description:
 */
@Setter
@Getter
@ApiModel("用户登录")
public class SysUserDto {

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("密码")
    private String pwd;

}
