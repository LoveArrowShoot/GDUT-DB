package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.dto.InventoryDetail;
import com.gdutdb.carsales.po.poja.Inventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Inventory
 */
public interface InventoryMapper extends BaseMapper<Inventory> {
    List<InventoryDetail> queryAll();
    InventoryDetail queryByCarVin(Integer carVin);
    InventoryDetail queryByDistributorId(Integer distributeId);
    InventoryDetail queryByStaffId(Integer distributeId);
    Integer deleteByInventoryId(Integer inventoryId);
    Integer updateCount(@Param("inventoryId") Integer inventoryId,@Param("count") Integer count);
    Integer changeCount(@Param("inventoryId") Integer inventoryId,@Param("count") Integer count);
}




