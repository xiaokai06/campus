package com.huiyi.campus.dao.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

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

    @ApiModelProperty("菜单类型（1:目录，2:菜单，3:按钮）")
    private Integer menuType;

    @ApiModelProperty("父级ID")
    private Integer parentId;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("菜单等级")
    private Integer menuLevel;

    @ApiModelProperty("排序")
    private String sort;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("是否隐藏（0：false，1：true）")
    private Integer hiddenFlag;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("组件路径")
    private String component;

    @ApiModelProperty("路径名称")
    private String pathName;

    private List<SysMenuEntity> list;

}




