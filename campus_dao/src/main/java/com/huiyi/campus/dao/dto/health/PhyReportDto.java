package com.huiyi.campus.dao.dto.health;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: yzg
 * @time: 2021-05-24 17:49
 * @description:
 */
@Getter
@Setter
public class PhyReportDto {

    @ApiModelProperty("学生姓名")
    private String studentName;

    @ApiModelProperty("班级名称")
    private String className;

    @ApiModelProperty("异常项目")
    private String exceptionItem;

    private Integer pageNum;

    private Integer pageSize;

}
