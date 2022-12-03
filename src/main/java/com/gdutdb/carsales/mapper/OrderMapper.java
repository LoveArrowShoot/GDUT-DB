package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.dto.OrderDetail;
import com.gdutdb.carsales.po.poja.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Order
 */
public interface OrderMapper extends BaseMapper<Order> {
    List<OrderDetail> queryAll();
    List<OrderDetail> queryByStaffId(Integer staffId);
    List<OrderDetail> queryByCarVin(Integer carVin);
    List<OrderDetail> queryByDistributorId(Integer distributorId);
}




