package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Inventory;
import com.gdutdb.carsales.service.InventoryService;
import com.gdutdb.carsales.mapper.InventoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory>
    implements InventoryService{

    @Resource
    InventoryMapper inventoryMapper;

    @Override
    public CommonResult queryAll() {
        return CommonResult.successResult(inventoryMapper.queryAll());
    }

    @Override
    public CommonResult queryByDistributorId(Integer distributeId) {
        return CommonResult.successResult(inventoryMapper.queryByDistributorId(distributeId));
    }

    @Override
    public CommonResult deleteByInventoryId(Integer inventoryId) {
        return inventoryMapper.deleteByInventoryId(inventoryId) > 0 ? CommonResult.successResult() : CommonResult.failResult();
    }

    @Override
    public CommonResult updateCount(Integer inventoryId, Integer count) {
        return inventoryMapper.updateCount(inventoryId, count) > 0 ? CommonResult.successResult() : CommonResult.failResult();
    }
}




