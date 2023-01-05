package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Model;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdutdb.carsales.po.poja.Option;

import java.util.List;

/**
 *
 */
public interface ModelService extends IService<Model> {
    CommonResult queryAll();
    CommonResult queryByModelId(Integer modelId);
    CommonResult queryOptionOfModel(Integer modelId);
    CommonResult queryByCarvVin(Integer carVin);
    CommonResult deleteByModelId(Integer modelId);
    CommonResult updateModelOption(Integer modelId, List<Integer> optionIds);
}
