package com.gdutdb.carsales.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static com.gdutdb.carsales.log.SysLogger.doAopLog;

/**
 * @author 欧家骏
 * controllerAop日志切面
 */
@Aspect
@Component
@Slf4j
public class ControllerLogAspect {

    @Pointcut("@annotation(com.gdutdb.carsales.log.XdbControllerLog)")
    public void xdbControllerLog(){}

    @Around("xdbControllerLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return doAopLog(proceedingJoinPoint);
    }

}
