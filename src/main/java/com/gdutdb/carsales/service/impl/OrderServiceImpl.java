package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.poja.Order;
import com.gdutdb.carsales.service.OrderService;
import com.gdutdb.carsales.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




