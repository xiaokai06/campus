package com.huiyi.campus.dao.vo.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author: yzg
 * @time: 2021-03-31 10:19
 * @description: token返回
 */
@Setter
@Getter
@ApiModel("token返回")
public class TokenVo {

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("学校ID数组")
    private Set<Integer> idList;

}
