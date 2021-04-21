package com.huiyi.campus.dao.entity.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class SysGradeEntity implements Serializable {
    private String id;

    private String gradeName;

    private Integer schoolId;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String remark5;

    private String remark6;

    @ApiModelProperty("页码")
    private Integer page;
    @ApiModelProperty("条数")
    private Integer rows;

    private static final long serialVersionUID = 1L;


}