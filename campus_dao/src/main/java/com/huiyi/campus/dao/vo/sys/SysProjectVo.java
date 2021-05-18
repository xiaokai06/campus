package com.huiyi.campus.dao.vo.sys;

import com.huiyi.campus.dao.entity.phy.PhySexAgeRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-05-17 10:45
 * @description: 项目字典返回实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("项目字典返回实体类")
public class SysProjectVo {

    private Integer id;

    @ApiModelProperty("项目归类名")
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

    private List<PhySexAgeRef> list;

}
