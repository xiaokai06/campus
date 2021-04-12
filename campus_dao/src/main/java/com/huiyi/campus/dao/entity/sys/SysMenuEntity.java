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
@ApiModel("用户菜单")
public class SysMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(dataType = "Integer", value = "id")
    private Integer id;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("修改时间")
    private String updateTime;

    @ApiModelProperty("菜单等级")
    private Integer menuLevel;

    @ApiModelProperty("排序")
    private String sort;

    @ApiModelProperty("根路径")
    private String rootPath;

    @ApiModelProperty("子路径")
    private String path;

}




