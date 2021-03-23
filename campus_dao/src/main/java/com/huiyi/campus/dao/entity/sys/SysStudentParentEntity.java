package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
@TableName("sys_student_parent")
public class SysStudentParentEntity implements Serializable {
    private Integer id;

    private Integer studentId;

    private Integer parentId;

    private static final long serialVersionUID = 1L;

}