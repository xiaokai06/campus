package com.huiyi.campus.dao.vo.common;

import com.huiyi.campus.dao.entity.sys.TsTypeEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 参数类型字典返回Vo
 * @date: 2021-04-08 12:34
 * @Version V1.0
 */
@Getter
@Setter
public class TsTypeGroupVo {
    private Integer id;

    private String typegroupcode;

    private String typegroupname;

    private List<TsTypeEntity> typeList;
}
