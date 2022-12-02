package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Inventory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface InventoryService extends IService<Inventory> {
    CommonResult queryAll();
    CommonResult queryByDistributorId(Integer distributorId);
    CommonResult deleteByInventoryId(Integer inventoryId);
    CommonResult updateCount(Integer inventoryId, Integer count);
}
