package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.poja.Car;
import com.gdutdb.carsales.service.CarService;
import com.gdutdb.carsales.mapper.CarMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car>
    implements CarService{

}




