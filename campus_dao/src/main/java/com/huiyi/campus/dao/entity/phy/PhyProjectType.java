package com.huiyi.campus.dao.entity.phy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yzg
 * @time: 2021-05-17 10:25
 * @description: 项目归类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("项目归类")
public class PhyProjectType {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("项目归类名")
    private String phyName;

    @ApiModelProperty("项目归类编码")
    private String phyCode;

}
