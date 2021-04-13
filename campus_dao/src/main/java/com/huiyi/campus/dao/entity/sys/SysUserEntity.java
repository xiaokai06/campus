package com.huiyi.campus.dao.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@ApiModel("用户实体类")
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("姓名")
    private String userName;

    @ApiModelProperty("密码")
    private String passWord;

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

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("学校ID")
    private Integer schoolId;

    @ApiModelProperty("学校名称")
    private String schoolName;

    @ApiModelProperty("机构ID")
    private Integer organId;

    @ApiModelProperty("机构名称")
    private String organName;

    @ApiModelProperty("页码")
    private Integer pageNum;

    @ApiModelProperty("页数")
    private Integer pageSize;

}