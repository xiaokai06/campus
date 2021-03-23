package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@TableName("sys_school_doctor")
public class SysSchoolDoctorEntity implements Serializable {
    private Integer id;

    private Integer doctorId;

    private Integer schoolId;

    private static final long serialVersionUID = 1L;

}