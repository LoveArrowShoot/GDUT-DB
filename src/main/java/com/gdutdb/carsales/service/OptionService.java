package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Option;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface OptionService extends IService<Option> {
    CommonResult deleteByOptionId(Integer optionId);
}
