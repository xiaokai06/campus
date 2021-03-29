package com.huiyi.campus.common.utils.rs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.UUID;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-03-29 14:41
 * @Version V1.0
 */
public abstract class BaseJsonModel {
    private static final long serialVersionUID = -7532190300864165247L;
    private transient SerializerFeature[] features = new SerializerFeature[3];
    @JSONField
    private String requestId;

    public BaseJsonModel() {
        this.features[0] = SerializerFeature.QuoteFieldNames;
        this.features[1] = SerializerFeature.WriteMapNullValue;
        this.features[2] = SerializerFeature.WriteNullStringAsEmpty;
       /* if (this.getRequestId() == null || this.getRequestId().equals("")) {
            this.setRequestId(UUID.randomUUID().toString());
        }*/

    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, this.features);
    }

    public String toString(SerializeFilter... filters) {
        return filters == null ? JSON.toJSONString(this, this.features) : JSON.toJSONString(this, filters, this.features);
    }

/*    public String getRequestId() {
        return this.requestId;
    }*/
/*
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }*/
}
