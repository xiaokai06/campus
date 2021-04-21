package com.huiyi.campus.dao.vo.sys;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-21 16:32
 * @Version V1.0
 */
@Getter
@Setter
public class SysGradeVo {
    /**
     * 父级数据
     */
    private String gradeId;
    private String gradeName;
    private String schoolId;
    private String createUser;
    private String createTime;
    private String updateUser;
    private String updateTime;
    /**
     * 子级数据
     */
    private String classId;
    private String className;
    private String gradeParentId;
    private String classCreateUser;
    private String classCreateTime;
    private String classUpdateUser;
    private String classUpdateTime;

}
