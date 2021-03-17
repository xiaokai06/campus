package com.huiyi.campus.common.base;

import java.util.List;

/**
 * @author: yzg
 * @time: 2020/11/18 14:37
 * @description: 批量更新
 */
public class BatchUpdate<T> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
