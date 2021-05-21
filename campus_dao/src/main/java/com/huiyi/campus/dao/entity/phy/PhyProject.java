package com.huiyi.campus.dao.entity.phy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yzg
 * @time: 2021-05-17 10:14
 * @description: 项目字典
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("项目字典")
public class PhyProject {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("项目归类名称")
    private String phyName;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("项目归类ID")
    private Integer projectTypeId;

    @ApiModelProperty("项目单元")
    private String unit;

    @ApiModelProperty("项目编码")
    private String projectCode;

    @ApiModelProperty("低于参考值建议")
    private String lowAdvice;

    @ApiModelProperty("高于参考值建议")
    private String highAdvice;

    @ApiModelProperty("低于参考值风险")
    private String lowRisk;

    @ApiModelProperty("高于参考值风险")
    private String highRisk;

    @ApiModelProperty("参考低值")
    private String refLow;

    @ApiModelProperty("参考高值")
    private String refHigh;

    @ApiModelProperty("参考值范围")
    private String refValue;

    @ApiModelProperty("是否与年龄有关（1:有关，-1:无关）")
    private Integer refByAge;

    @ApiModelProperty("是否与性别有关（1:有关，-1:无关）")
    private Integer refBySex;

}
