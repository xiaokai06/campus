package com.huiyi.campus.dao.entity.phy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yzg
 * @time: 2021-05-17 10:26
 * @description: 性别年龄参考值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("性别年龄参考值")
public class PhySexAgeRef {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("项目ID")
    private Integer phyProjectId;

    @ApiModelProperty("性别（1:男，2:女，all：未知）")
    private String sex;

    @ApiModelProperty("最小年龄")
    private String minAge;

    @ApiModelProperty("最大年龄")
    private String maxAge;

    @ApiModelProperty("最小值")
    private String refL;

    @ApiModelProperty("最大值")
    private String refH;

    @ApiModelProperty("参考值范围")
    private String refText;

}
