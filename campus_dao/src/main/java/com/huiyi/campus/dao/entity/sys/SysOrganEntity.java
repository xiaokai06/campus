package com.huiyi.campus.dao.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: yzg
 * @time: 2021-04-06 14:49
 * @description: 机构实体类
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@ApiModel("机构实体类")
public class SysOrganEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("机构名字")
    private String organName;

    @ApiModelProperty("机构代码")
    private String organCode;

    @ApiModelProperty("机构联系电话")
    private String organPhone;

    @ApiModelProperty("机构负责人")
    private String organManager;

    @ApiModelProperty("机构所在地")
    private String organAddress;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("上级机构ID")
    private Integer parentId;

    private Integer pageNum;

    private Integer pageSize;

}
