package com.huiyi.campus.dao.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@ApiModel("医生实体类")
public class SysDoctorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("医生名字")
    private String doctorName;

    @ApiModelProperty("科室ID")
    private Integer deskId;

    @ApiModelProperty("科室名称")
    private String deskName;

    @ApiModelProperty("学校ID")
    private Integer schoolId;

    @ApiModelProperty("学校名称")
    private String schoolName;

    @ApiModelProperty("医生状态（0:正常，1:离职）")
    private Integer doctorState;

    @ApiModelProperty("描述")
    private String introduce;

    @ApiModelProperty("创建时间")
    private String createTime;

}