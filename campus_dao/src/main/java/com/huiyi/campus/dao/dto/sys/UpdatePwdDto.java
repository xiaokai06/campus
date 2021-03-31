package com.huiyi.campus.dao.dto.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: yzg
 * @time: 2021-03-31 18:32
 * @description:
 */
@Setter
@Getter
public class UpdatePwdDto {

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("旧密码")
    private String oldPwd;

    @ApiModelProperty("新密码")
    private String newPwd;

    @ApiModelProperty("确认密码")
    private String confirmPwd;

}
