package com.huiyi.campus.dao.dto.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 公共请求参数
 * @date: 2021-04-25 10:45
 * @Version V1.0
 */
@Getter
@Setter
public class CommonDto {
    @ApiModelProperty("相片路径名")
    private String fileName;
    @ApiModelProperty("学生id")
    private String studentId;
}
