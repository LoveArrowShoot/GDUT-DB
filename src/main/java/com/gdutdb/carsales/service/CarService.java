package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Car;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface CarService extends IService<Car> {
    CommonResult queryAll();
    CommonResult queryByModelId(Integer modelId);
    CommonResult queryOptionOfCar(Integer carVin);
    CommonResult queryByDistributorId(Integer distributorId);
    CommonResult queryByDistributorIdAndBrandId(Integer distributorId, Integer brandId);
    CommonResult deleteByCarVin(Integer carVin);
}
