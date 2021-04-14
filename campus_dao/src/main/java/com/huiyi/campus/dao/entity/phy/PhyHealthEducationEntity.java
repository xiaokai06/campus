package com.huiyi.campus.dao.entity.phy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: yzg
 * @time: 2021-04-14 14:24
 * @description: 健康宣教
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@ApiModel("健康宣教")
public class PhyHealthEducationEntity {

    @ApiModelProperty("id")
    public Integer id;

    @ApiModelProperty("标题")
    public String title;

    @ApiModelProperty("内容")
    public String content;

    @ApiModelProperty("操作人")
    public String operUser;

    @ApiModelProperty("图片路径")
    public String imageUrl;

    @ApiModelProperty("学校ID")
    public Integer schoolId;

    @ApiModelProperty("学校名称")
    public String schoolName;

    @ApiModelProperty("创建时间")
    public String createTime;

    @ApiModelProperty("是否设置为头条（0:否，1:是）")
    public Integer headFlag;

}
