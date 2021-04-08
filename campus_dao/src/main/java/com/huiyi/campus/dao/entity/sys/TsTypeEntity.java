package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("t_s_type")
public class TsTypeEntity implements Serializable {

    private Integer id;

    private String typecode;

    private String typename;

    private String typegroupid;

    private static final long serialVersionUID = 1L;

}