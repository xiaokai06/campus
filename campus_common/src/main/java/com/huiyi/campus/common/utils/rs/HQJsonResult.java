package com.huiyi.campus.common.utils.rs;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 统一对象返回
 * @date: 2021-03-29 14:40
 * @Version V1.0
 */

public class HQJsonResult<T> extends BaseJsonModel {
    private static final long serialVersionUID = -7532190660864165247L;
    static final HQJsonResult.Success DEFAULT_SUCCESS = new HQJsonResult.Success();
    @JSONField
    private boolean success = true;
    @JSONField
    private String code = "0";
    @JSONField
    private String msg;
    @JSONField
    private String requestID;
    @JSONField
    private long total = 0;
    @JSONField
    private List<T> data = new ArrayList();

    public HQJsonResult() {
    }

    public HQJsonResult(List<T> data, String code, String msg, boolean success) {
        if (this.getRequestID() == null || this.getRequestID().equals("")) {
            this.setRequestID(UUID.randomUUID().toString());
        }

        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public HQJsonResult(List<T> data, String message, String code, String msg, boolean success) {
        if (this.getRequestID() == null || this.getRequestID().equals("")) {
            this.setRequestID(UUID.randomUUID().toString());
        }
        this.success = success;
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public HQJsonResult(MyBaseException exception) {
        if (exception != null) {
            this.success = false;
            this.code = exception.getcode();
            this.msg = exception.getmsg();
            if (this.getRequestID() == null || this.getRequestID().equals("")) {
                this.setRequestID(UUID.randomUUID().toString());
            }
        }

    }

    public HQJsonResult(List<T> data) {
        if (data != null && data.size() > 0) {
            this.data = data;
            this.total = data.size();
            if (this.getRequestID() == null || this.getRequestID().equals("")) {
                this.setRequestID(UUID.randomUUID().toString());
            }
        }

    }

    public HQJsonResult(T data) {
        if (data != null) {
            this.data.add(data);
            this.total = 1;
            if (this.getRequestID() == null || this.getRequestID().equals("")) {
                this.setRequestID(UUID.randomUUID().toString());
            }
        }

    }

    public HQJsonResult(List<T> data, Integer total) {
        if (data != null && data.size() > 0) {
            this.data = data;
            this.total = total;
            if (this.getRequestID() == null || this.getRequestID().equals("")) {
                this.setRequestID(UUID.randomUUID().toString());
            }
        }

    }

    public void addData(T data) {
        this.data.add(data);
        this.total = 1;
        if (this.getRequestID() == null || this.getRequestID().equals("")) {
            this.setRequestID(UUID.randomUUID().toString());
        }

    }

    public void addData(List<T> data) {
        this.data = data;
        this.total = data.size();
        if (this.getRequestID() == null || this.getRequestID().equals("")) {
            this.setRequestID(UUID.randomUUID().toString());
        }

    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String code) {
        this.msg = msg;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static Success getDefaultSuccess() {
        return DEFAULT_SUCCESS;
    }

    public List<T> getData() {
        return this.data;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static <T> HQJsonResult<T> success(List<T> data) {
        return DEFAULT_SUCCESS.success(data);
    }

    public static <T> HQJsonResult<T> success(T data) {
        return DEFAULT_SUCCESS.success(data);
    }

    public static <T> HQJsonResult<T> success(T data, String message) {
        return DEFAULT_SUCCESS.success(data, message);
    }

    public static <T> HQJsonResult<T> success(List<T> data, String message) {
        return DEFAULT_SUCCESS.success(data, message);
    }
    public static <T> HQJsonResult<T> success(List<T> data, String msg,String code) {
        return DEFAULT_SUCCESS.success(data, msg,code);
    }

    public static HQJsonResult<Void> success() {
        return DEFAULT_SUCCESS.success();
    }

    public static HQJsonResult<Void> withSuccessMessage(String message) {
        return DEFAULT_SUCCESS.success(message);
    }

    public static <T> HQJsonResult<T> error(String code, String errorMessage) {
        return new HQJsonResult((List)null, code, errorMessage, false);
    }

    public static <T> HQJsonResult<T> error(CodeMessage message) {
        return new HQJsonResult((List)null, message.getCodeAsString(), message.getMessage(), false);
    }

    public static void throwMsg(CodeMessage message) {
        throw new SystemException(message.getCodeAsString(), message.getMessage());
    }

    public static void throwMsg(String code, String msg) {
        throw new SystemException(code, msg);
    }

    public void ifSuccess(Consumer<List<T>> consumer) {
        if (this.success) {
            consumer.accept(this.data);
        }

    }

    public List<T> orElse(List<T> other) {
        return this.success ? this.data : other;
    }

    public T orOneData() {
        return this.success ? (this.data != null && this.data.size() > 0 ? this.data.get(0) : null) : null;
    }

    public <X extends Throwable> T oneElseThrow(Supplier<? extends X> exceptionSupplier) throws Throwable {
        if (!this.success) {
            throw (Throwable)exceptionSupplier.get();
        } else {
            return this.data != null && this.data.size() > 0 ? this.data.get(0) : null;
        }
    }

    public <X extends Throwable> T oneElseThrow() throws Throwable {
        return this.oneElseThrow(() -> {
            return new SystemException(this.getCode(), this.getMsg());
        });
    }

    public <X extends Throwable> List<T> orElseThrow(Supplier<? extends X> exceptionSupplier) throws Throwable {
        if (this.success) {
            return this.data;
        } else {
            throw (Throwable)exceptionSupplier.get();
        }
    }

    public List<T> orElseThrow() throws Throwable {
        return this.orElseThrow(() -> {
            return new SystemException(this.getCode(), this.getMsg());
        });
    }

    public List<T> orElseGet(Supplier<? extends List<T>> other) {
        return this.success ? this.data : (List)other.get();
    }

    public <U> HQJsonResult<U> flatMap(Function<? super List<T>, HQJsonResult<U>> mapper) {
        Objects.requireNonNull(mapper);
        return !this.success ? this.error() : (HQJsonResult)Objects.requireNonNull(mapper.apply(this.data));
    }

    public <U> HQJsonResult<U> map(Function<? super List<T>, ? extends List<U>> mapper) {
        Objects.requireNonNull(mapper);
        return !this.success ? this.error() : success((List)mapper.apply(this.data));
    }

    <U> HQJsonResult<U> error() {
        return error(this.code, this.msg);
    }

    public String getRequestID() {
        return this.requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    static class Success implements CodeMessage {
        Success() {
        }

        @Override
        public String getCodeAsString() {
            return "0";
        }

        @Override
        public String getMessage() {
            return "处理成功！";
        }

        <T> HQJsonResult<T> success(List<T> data) {
            return new HQJsonResult(data, this.getMessage(), this.getCodeAsString(), (String)null, true);
        }

        <T> HQJsonResult<T> success(T data) {
            List<T> value = new ArrayList();
            if (data != null) {
                value.add(data);
            }

            return new HQJsonResult(value, this.getMessage(), this.getCodeAsString(), (String)null, true);
        }

        <T> HQJsonResult<T> success(List<T> data, String message) {
            return new HQJsonResult(data, message, this.getCodeAsString(), (String)null, true);
        }

        <T> HQJsonResult<T> success(List<T> data, String msg,String code) {
            return new HQJsonResult(data, msg,code, (String)null, true);
        }
        <T> HQJsonResult<T> success(T data, String message) {
            List<T> value = new ArrayList();
            if (data != null) {
                value.add(data);
            }

            return new HQJsonResult(value, message, this.getCodeAsString(), (String)null, true);
        }

        <T> HQJsonResult<T> success() {
            return new HQJsonResult((List)null, this.getMessage(), this.getCodeAsString(), (String)null, true);
        }

        <T> HQJsonResult<T> success(String message) {
            return new HQJsonResult((List)null, message, this.getCodeAsString(), (String)null, true);
        }

    }
}