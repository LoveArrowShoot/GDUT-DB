package com.gdutdb.carsales.controller;

import com.gdutdb.carsales.log.XdbControllerLog;
import com.gdutdb.carsales.po.dto.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @XdbControllerLog
    @GetMapping("/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password){
        if (username.equals("admin") && password.equals("admin")){
            CommonResult result = CommonResult.successResult();
            log.info("success");
            return result;
        }
        return CommonResult.failResult("登录失败");
    }
}
