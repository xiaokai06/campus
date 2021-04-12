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
@ApiModel("医院管理")
public class SysHospitalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("医院名称")
    private String hospitalName;

    @ApiModelProperty("医院代码")
    private String hospitalCode;

    @ApiModelProperty("医院地址")
    private String hospitalAddress;

    @ApiModelProperty("医院电话")
    private String hospitalPhone;

    @ApiModelProperty("医院负责人")
    private String hospitalLeader;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}