package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@TableName("t_s_typegroup")
public class TsTypeGroupEntity implements Serializable {

    private Integer id;

    private String typegroupcode;

    private String typegroupname;

    private String typecode;

    private String typename;

    private String typegroupid;


    private static final long serialVersionUID = 1L;

}