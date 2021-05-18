package com.huiyi.campus.dao.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yzg
 * @time: 2021-05-18 9:07
 * @description: 项目字典筛选条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("项目字典筛选条件")
public class PhyProjectDto {

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("项目归类ID")
    private Integer projectTypeId;

    @ApiModelProperty("页码")
    private Integer pageNum;

    @ApiModelProperty("页数")
    private Integer pageSize;

}
