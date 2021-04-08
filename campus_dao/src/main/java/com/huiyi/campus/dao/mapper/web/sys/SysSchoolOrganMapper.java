package com.huiyi.campus.dao.mapper.web.sys;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-08 10:26
 * @description: 学校机构
 */
public interface SysSchoolOrganMapper {

    List<Integer> selectSchoolByOrganId(Integer id);

}
