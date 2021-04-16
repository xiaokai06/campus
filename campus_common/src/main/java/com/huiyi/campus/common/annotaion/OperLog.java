package com.huiyi.campus.common.annotaion;

import java.lang.annotation.*;

/**
 * @author lucky
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperLog {

    boolean required() default true;

    String operModule() default "";

    String operType() default "";

    String operDesc() default "";

}
