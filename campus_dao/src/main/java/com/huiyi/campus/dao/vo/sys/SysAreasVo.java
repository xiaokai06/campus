package com.huiyi.campus.dao.vo.sys;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-06 17:28
 * @Version V1.0
 */
@Getter
@Setter
public class SysAreasVo {
    private Integer id;

    private String name;

    private Integer pid;

    private List<SysAreasVo> areasList;
}
