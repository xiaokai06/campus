package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.dao.entity.sys.SysGradeClassEntity;
import com.huiyi.campus.dao.entity.sys.SysGradeEntity;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-21 14:22
 * @Version V1.0
 */
public interface SysGradeClassService {
    HQJsonResult insertGrade(SysGradeEntity sysGradeEntity);

    HQJsonResult selectGrade(SysGradeEntity sysGradeEntity, String nickName);

    HQJsonResult updateGrade(SysGradeEntity sysGradeEntity);

    HQJsonResult deleteGrade(SysGradeEntity sysGradeEntity);

    HQJsonResult insertGradeClass(SysGradeClassEntity sysGradeClassEntity);

    HQJsonResult selectGradeClass(SysGradeClassEntity sysGradeClassEntity);

    HQJsonResult updateGradeClass(SysGradeClassEntity sysGradeClassEntity);

    HQJsonResult deleteGradeClass(SysGradeClassEntity sysGradeClassEntity);

    HQJsonResult queryGradeClass(SysGradeEntity sysGradeEntity);
}
