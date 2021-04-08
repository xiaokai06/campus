package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("sys_grade_class")
public class SysGradeClassEntity implements Serializable {
    private String id;

    private String gradeName;

    private Integer gradeId;

    private String className;

    private String parentId;

    private Integer schoolId;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    private String remark6;

    private static final long serialVersionUID = 1L;


}