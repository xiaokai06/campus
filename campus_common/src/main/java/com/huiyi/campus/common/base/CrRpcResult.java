package com.huiyi.campus.common.base;


import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * web通用返回数据
 * @author lucky
 * @param <T>
 */
public class CrRpcResult<T> {
    private String code;

    private String msg;
    /** 总记录数 */
    private long total;

    private List<T> data;

    public CrRpcResult()
    {
    }

    public CrRpcResult(String code, Long total, String msg) {
        this.code = code;
        this.msg = msg;
        this.total = total;
    }

    public CrRpcResult(String code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public static CrRpcResult success(PageInfo pageInfo) {
        CrRpcResult crRpcResult = new CrRpcResult();
        crRpcResult.setCode(CommonEnum.SUCCESS.getResultCode());
        crRpcResult.setMsg(CommonEnum.SUCCESS.getResultMsg());
        crRpcResult.setTotal(pageInfo.getTotal());
        crRpcResult.setData(pageInfo.getList());
        return crRpcResult;
    }

}
