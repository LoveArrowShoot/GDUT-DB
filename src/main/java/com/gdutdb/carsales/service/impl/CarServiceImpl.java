package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Car;
import com.gdutdb.carsales.service.CarService;
import com.gdutdb.carsales.mapper.CarMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car>
    implements CarService{
    @Resource
    CarMapper carMapper;

    @Override
    public CommonResult queryAll() {
        return CommonResult.successResult(carMapper.queryAllByEnable());
    }

    @Override
    public CommonResult queryByModelId(Integer modelId) {
        return CommonResult.successResult(carMapper.queryByModelId(modelId));
    }

    @Override
    public CommonResult queryOptionOfCar(Integer carVin) {
        return CommonResult.successResult(carMapper.queryOptionOfCar(carVin));
    }

    @Override
    public CommonResult queryByDistributorId(Integer distributorId) {
        return CommonResult.successResult(carMapper.queryByDistributorId(distributorId));
    }

    @Override
    public CommonResult queryByDistributorIdAndBrandId(Integer distributorId, Integer brandId) {
        return CommonResult.successResult(carMapper.queryByDistributorIdAndBrandId(distributorId, brandId));
    }

    @Override
    public CommonResult deleteByCarVin(Integer carVin) {
        return carMapper.deleteByCarVin(carVin) > 0 ? CommonResult.successResult() : CommonResult.failResult("删除失败");
    }
}




