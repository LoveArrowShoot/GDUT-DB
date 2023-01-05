package com.gdutdb.carsales.log;

import java.lang.annotation.*;

/**
 * @author 欧家骏
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface XdbControllerLog {
    /**
     * 日志描述信息
     *
     * @return 日志描述信息
     */
    String description() default "";
}
