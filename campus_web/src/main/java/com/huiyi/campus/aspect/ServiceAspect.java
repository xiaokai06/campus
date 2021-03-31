package com.huiyi.campus.aspect;

import com.huiyi.campus.common.annotaion.OperLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author yzg
 * @date 2020/11/21 0021
 * @description: 切面
 */
@Component
@Aspect
public class ServiceAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

    private String methodName;

    private long startTime;

    /**
     * 拦截web层service方法
     */
    @Pointcut("execution(* com.huiyi.campus.web.*.*(..))")
    public void servicePointCut() {
    }

    @Before("servicePointCut()")
    public void doServiceBefore(JoinPoint joinPoint) {
        methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        startTime = System.currentTimeMillis();
    }

    @After("servicePointCut()")
    public void doServiceAfter() {
        long time = System.currentTimeMillis() - startTime;
        logger.info("执行 " + methodName + " 耗时为：" + time + "ms");
    }

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.huiyi.campus.common.annotaion.OperLog)")
    public void operLogPointCut() {
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint 切入点
     */
    @AfterReturning(value = "operLogPointCut()")
    public void saveOperLog(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.getRequestAttributes())).getRequest();
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();

            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            if (opLog != null) {
                String operModule = opLog.operModule();
                String operType = opLog.operType();
                String operDesc = opLog.operDesc();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

