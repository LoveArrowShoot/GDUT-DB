package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.mapper.InventoryMapper;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.dto.InventoryDetail;
import com.gdutdb.carsales.po.poja.Car;
import com.gdutdb.carsales.po.poja.CarOption;
import com.gdutdb.carsales.po.poja.Inventory;
import com.gdutdb.carsales.service.CarService;
import com.gdutdb.carsales.mapper.CarMapper;
import com.gdutdb.carsales.service.InventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car>
    implements CarService{
    @Resource
    CarMapper carMapper;

    @Resource
    InventoryMapper inventoryMapper;

    @Resource
    InventoryService inventoryService;

    @Override
    @Transactional
    public CommonResult updateCarOption(Integer carVin, List<Integer> ids) {
        if(carMapper.deleteCarOption(carVin) < 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return CommonResult.failResult("更新失败");
        }
        for (Integer oid:ids) {
            if(carMapper.insertOption(carVin, oid) <= 0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return CommonResult.failResult("更新失败");
            }
        }
        return CommonResult.successResult();
    }

    @Override
    @Transactional
    public CommonResult addCar(Car car) {

        InventoryDetail inventory = inventoryMapper.queryByDistributorId(car.getCarDistributorId());
        if (Objects.isNull(inventory)){
            inventoryService.save(new Inventory(null, car.getCarModelId(), car.getCarDistributorId(),0));
            inventory = inventoryMapper.queryByDistributorId(car.getCarDistributorId());
        }

        if(inventoryMapper.changeCount(
                inventory.getInventoryId(),
                1
        ) <= 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return CommonResult.failResult("库存变化失败");
        }

        if (!save(car)){
            CommonResult.failResult("保存车辆信息失败");
        }
        return CommonResult.successResult();
    }

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

    @Override
    public CommonResult deleteCarOption(Integer carVin) {
        return carMapper.deleteCarOption(carVin) > 0 ? CommonResult.successResult() : CommonResult.failResult("删除失败");
    }
}




