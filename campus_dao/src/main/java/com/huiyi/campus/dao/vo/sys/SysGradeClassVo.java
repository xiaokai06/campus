package com.huiyi.campus.dao.vo.sys;

import com.huiyi.campus.dao.entity.sys.SysGradeClassEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-21 15:17
 * @Version V1.0
 */
@Getter
@Setter
public class SysGradeClassVo {

    private String id;

    private String gradeName;

    private String schoolId;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private List<SysGradeClassEntity> sysGradeClassEntityList;
}
