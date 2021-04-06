package com.huiyi.campus.common.utils.area;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-06 16:03
 * @Version V1.0
 */
@Data
@AllArgsConstructor
public class Area {
    // 区域码
    private String code;

    // 区域名称
    private String name;

    // 父级
    private String parent;


}
