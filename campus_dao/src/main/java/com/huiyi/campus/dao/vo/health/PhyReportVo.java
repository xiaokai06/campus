package com.huiyi.campus.dao.vo.health;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author: yzg
 * @time: 2021-05-24 17:40
 * @description:
 */
@Getter
@Setter
@ApiModel("健康体检报告")
public class PhyReportVo {

    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("学生姓名")
    private String studentName;

    @ApiModelProperty("性别(1:男，2:女，0:未知性别)")
    private Integer sex;

    @ApiModelProperty("班级名称")
    private String className;

    @ApiModelProperty("家长联系方式")
    private String parentNumber;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("异常项目")
    @Value("血压升高，体重过重")
    private String exceptionItem;

}
