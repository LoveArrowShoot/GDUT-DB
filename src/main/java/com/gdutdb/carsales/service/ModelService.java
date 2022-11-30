package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Model;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface ModelService extends IService<Model> {
    CommonResult queryAll();
    CommonResult queryByModelId(Integer modelId);
    CommonResult deleteByModelId(Integer modelId);
}
