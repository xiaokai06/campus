package com.huiyi.campus.dao.vo.health;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-14 10:35
 * @Version V1.0
 */
@Getter
@Setter
public class StudentHealthInfoPhyDateVo {
    @ApiModelProperty("体检日期")
    private String phyDate;
}
