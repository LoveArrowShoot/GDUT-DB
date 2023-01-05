package com.gdutdb.carsales.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;


/**
 * Xdb相关接口日志打印
 * @author 欧家骏
 */
@Slf4j
public class SysLogger {

    /**
     * Aop日志打印
     * @param proceedingJoinPoint 环绕切点
     * @return 返回
     * @throws Throwable 异常
     */
    public static Object doAopLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 获取方法请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();


        // 获取 @WebLog 注解的描述信息
        StringBuilder sb = new StringBuilder();
        // 打印请求相关参数
        sb.append("========================================== Start ==========================================").append("\n");
        // 执行Target方法
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        sb.append(result.toString()).append("\n");
        // 方法结束分割
        sb.append("=========================================== End ===========================================").append("\n");
        log.info(sb.toString());
        return result;
    }
}
