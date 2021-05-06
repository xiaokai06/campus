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
@ApiModel("学校实体类")
public class SysSchoolEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer schoolId;

    @ApiModelProperty("机构ID")
    private Integer organId;

    @ApiModelProperty("机构名称")
    private String organName;

    @ApiModelProperty("学校名称")
    private String schoolName;

    @ApiModelProperty("学校地址")
    private String schoolAddress;

    @ApiModelProperty("创建时间")
    private String createTime;

    private Integer pageNum;

    private Integer pageSize;

}