package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.mapper.InventoryMapper;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Order;
import com.gdutdb.carsales.service.OrderService;
import com.gdutdb.carsales.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{
    @Resource
    OrderMapper orderMapper;

    @Resource
    InventoryMapper inventoryMapper;


    @Override
    @Transactional
    public CommonResult saleCar(Order order) {
        if(inventoryMapper.changeCount(
                inventoryMapper.queryByCarVin(order.getOrderVin()).getInventoryId(),
                -1) <= 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return CommonResult.failResult("出售失败");
        }
        if(orderMapper.insert(order) <= 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return CommonResult.failResult("出售失败");
        }
        return CommonResult.successResult();
    }

    @Override
    public CommonResult queryAll() {
        return CommonResult.successResult(orderMapper.queryAll());
    }

    @Override
    public CommonResult queryByStaffId(Integer staffId) {
        return CommonResult.successResult(orderMapper.queryByStaffId(staffId));
    }

    @Override
    public CommonResult queryByCarVin(Integer carVin) {
        return CommonResult.successResult(orderMapper.queryByCarVin(carVin));
    }

    @Override
    public CommonResult queryByDistributorId(Integer distributorId) {
        return CommonResult.successResult(orderMapper.queryByDistributorId(distributorId));
    }


}




