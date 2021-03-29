package com.huiyi.campus.common.utils.rs;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-03-29 14:43
 * @Version V1.0
 */
public interface CodeMessage {
    String getCodeAsString();

    String getMessage();

    default <T> HQJsonResult<T> error() {
        return new HQJsonResult((List)null, this.getCodeAsString(), this.getMessage(), false);
    }

    default <T> HQJsonResult<T> error(Supplier<String> messageSupplier) {
        Objects.requireNonNull(messageSupplier, "messageSupplier");
        return new HQJsonResult((List)null, this.getCodeAsString(), (String)messageSupplier.get(), false);
    }

    default <T> HQJsonResult<T> error(String messageSupplier) {
        Objects.requireNonNull(messageSupplier, "messageSupplier");
        return new HQJsonResult((List)null, this.getCodeAsString(), messageSupplier, false);
    }

    default <T> HQJsonResult<T> error(CodeMessage.TemplateMessageProcessor processor) {
        Objects.requireNonNull(processor, "processor");
        return new HQJsonResult((List)null, this.getCodeAsString(), (String)processor.apply(this.getMessage()), false);
    }

    default Supplier<SystemException> supplierError() {
        return this::createError;
    }

    default Supplier<SystemException> supplierError(String message) {
        return () -> {
            return this.createError(message);
        };
    }

    default Supplier<SystemException> supplierError(Supplier<String> messageSupplier) {
        return () -> {
            return this.createError(messageSupplier);
        };
    }

    default Supplier<SystemException> supplierError(CodeMessage.TemplateMessageProcessor processor) {
        return () -> {
            return this.createError(processor);
        };
    }

    default SystemException createError() {
        return new SystemException(this.getCodeAsString(), this.getMessage());
    }

    default SystemException createError(String message) {
        return new SystemException(this.getCodeAsString(), message);
    }

    default SystemException createError(Supplier<String> messageSupplier) {
        Objects.requireNonNull(messageSupplier, "messageSupplier");
        return new SystemException(this.getCodeAsString(), (String)messageSupplier.get());
    }

    default SystemException createError(CodeMessage.TemplateMessageProcessor processor) {
        Objects.requireNonNull(processor, "processor not null");
        return new SystemException(this.getCodeAsString(), (String)processor.apply(this.getMessage()));
    }

    default void throwMsg() {
        throw new SystemException(this.getCodeAsString(), this.getMessage());
    }

    @FunctionalInterface
    public interface TemplateMessageProcessor extends Function<String, String> {
    }
}
