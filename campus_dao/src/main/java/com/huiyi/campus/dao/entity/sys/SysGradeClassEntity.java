package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@TableName("sys_grade_class")
public class SysGradeClassEntity implements Serializable {
    private String id;

    private String className;

    private String gradeParentId;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private static final long serialVersionUID = 1L;


}