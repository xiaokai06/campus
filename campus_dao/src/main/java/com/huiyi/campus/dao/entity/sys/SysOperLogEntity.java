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
@ApiModel("操作日志")
public class SysOperLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("操作人")
    private String operUser;

    @ApiModelProperty("操作模块")
    private String operModel;

    @ApiModelProperty("操作类型")
    private String operType;

    @ApiModelProperty("操作描述")
    private String operDesc;

    @ApiModelProperty("操作URL")
    private String operUrl;

    @ApiModelProperty("操作方法")
    private String operMethod;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private String OperIp;

}