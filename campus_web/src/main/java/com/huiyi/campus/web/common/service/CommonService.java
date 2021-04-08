package com.huiyi.campus.web.common.service;

import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.dao.dto.common.SchoolDto;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-06 17:19
 * @Version V1.0
 */
public interface CommonService {
    HQJsonResult area();

    HQJsonResult selectSchoolByUserId(SchoolDto schoolDto);

    HQJsonResult selectClassBySchoolId(SchoolDto schoolDto);
}
