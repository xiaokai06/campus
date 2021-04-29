package com.huiyi.campus.dao.vo.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: yzg
 * @time: 2021-04-26 13:53
 * @description:
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@ApiModel("用户返回实体类")
public class SysUserVo {

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

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("角色ID")
    private Integer roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("最后登录时间")
    private String lastVisit;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("学校ID")
    private Integer schoolId;

    @ApiModelProperty("学校名称")
    private String schoolName;

    @ApiModelProperty("机构ID")
    private Integer organId;

    @ApiModelProperty("机构名称")
    private String organName;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

}
