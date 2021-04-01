package com.huiyi.campus.dao.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yzg
 * @date 2021-03-31
 * @description:
 */
@Setter
@Getter
@ApiModel("用户管理筛选条件")
public class UserDto {

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("手机号")
    private String phone;

}
