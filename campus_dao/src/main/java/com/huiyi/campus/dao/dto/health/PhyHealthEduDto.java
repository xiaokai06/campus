package com.huiyi.campus.dao.dto.health;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: yzg
 * @time: 2021-05-07 14:32
 * @description: 健康宣教
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhyHealthEduDto implements Serializable {

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

    @ApiModelProperty("机构ID")
    public Integer organId;

    @ApiModelProperty("创建时间")
    public String createTime;

    @ApiModelProperty("是否设置为头条（0:否，1:是）")
    public Integer headFlag;

    public Integer pageNum;

    public Integer pageSize;

}
