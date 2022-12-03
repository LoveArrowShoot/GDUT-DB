package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.poja.Inventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Inventory
 */
public interface InventoryMapper extends BaseMapper<Inventory> {
    List<Inventory> queryAll();
    Inventory queryByCarVin(Integer carVin);
    Inventory queryByDistributorId(Integer distributeId);
    Integer deleteByInventoryId(Integer inventoryId);
    Integer updateCount(Integer inventoryId, Integer count);
    Integer changeCount(Integer inventoryId, Integer count);
}




