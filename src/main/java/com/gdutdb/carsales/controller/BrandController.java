package com.gdutdb.carsales.controller;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @author ojj
 */
@Controller
public class BrandController {

    @Resource
    BrandService brandService;

    @GetMapping
    public CommonResult getBrandPage(IPaga){
        brandService.page()
        return
    }
}
