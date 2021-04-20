package com.huiyi.campus.dao.vo.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: yzg
 * @time: 2021-03-31 10:19
 * @description: token返回
 */
@Setter
@Getter
@ApiModel("token返回")
public class TokenVo {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("姓名")
    private String userName;

    @ApiModelProperty("性别（1:男，2:女）")
    private Byte sex;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("token")
    private String token;

}
