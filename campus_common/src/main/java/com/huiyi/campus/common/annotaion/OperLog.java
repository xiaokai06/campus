package com.huiyi.campus.common.annotaion;

import java.lang.annotation.*;

/**
 * @author lucky
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperLog {

    String operModule() default "";

    String operType() default "";

    String operDesc() default "";

}
