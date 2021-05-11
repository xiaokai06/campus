package com.huiyi.campus.dao.vo.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yzg
 * @time: 2021-05-11 16:16
 * @description: 操作日志返回实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("操作日志")
public class SysOperLogVo {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("操作人")
    private String operUser;

    @ApiModelProperty("操作模块")
    private String operModel;

    @ApiModelProperty("操作类型")
    private String operType;

    @ApiModelProperty("操作描述")
    private String operDesc;

    @ApiModelProperty("操作IP")
    private String operIp;

    @ApiModelProperty("创建时间")
    private String createTime;

}
