package com.gdutdb.carsales.controller;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Model;
import com.gdutdb.carsales.service.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

import static com.gdutdb.carsales.po.dto.CommonResult.failResult;
import static com.gdutdb.carsales.po.dto.CommonResult.successResult;

/**
 * @author ojj
 */
@Controller
public class ModelController {
    @Resource
    ModelService modelService;

    @PostMapping("/model/add")
    public CommonResult addModel(@RequestBody Model model){
        model.setModelId(null);
        return modelService.save(model)? successResult() : failResult();
    }

}
