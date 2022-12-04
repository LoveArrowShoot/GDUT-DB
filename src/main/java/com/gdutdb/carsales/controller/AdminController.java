package com.gdutdb.carsales.controller;

import com.gdutdb.carsales.po.dto.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password){
        if (username.equals("admin") && password.equals("admin")){
            return CommonResult.successResult();
        }
        return CommonResult.failResult("登录失败");
    }
}
