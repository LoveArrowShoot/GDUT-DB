package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.dto.OrderDetail;
import com.gdutdb.carsales.po.poja.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface OrderService extends IService<Order> {
    CommonResult deleteById(Integer orderId);
    CommonResult queryAll();
    CommonResult queryByStaffId(Integer staffId);
    CommonResult queryByCarVin(Integer carVin);
    CommonResult queryByDistributorId(Integer distributorId);
    CommonResult saleCar(Order order);
}
