package com.gdutdb.carsales.po.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ojj
 * 统一返回
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {
    /**
     * 返回码
     */
    int code;
    /**
     * 结果消息
     */
    String message;
    /**
     * 结果数据
     */
    Object data;

    public CommonResult successResult(){
        return new CommonResult(codeConstants.SUCCESS, null, null);
    }

    public CommonResult successResult(String message){
        return new CommonResult(codeConstants.SUCCESS, message, null);
    }

    public CommonResult successResult(Object data){
        return new CommonResult(codeConstants.SUCCESS, null, data);
    }

    public CommonResult FailResult(){
        return new CommonResult(codeConstants.FAIL, null, null);
    }

    public CommonResult FailResult(String message){
        return new CommonResult(codeConstants.FAIL, message, null);
    }

    public static class codeConstants {
        public static final int SUCCESS = 200;
        public static final int FAIL = -1;
    }

}
