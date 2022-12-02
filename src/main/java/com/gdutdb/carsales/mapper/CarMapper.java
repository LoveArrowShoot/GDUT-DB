package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.dto.CarDetail;
import com.gdutdb.carsales.po.poja.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdutdb.carsales.po.poja.Option;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Car
 */
public interface CarMapper extends BaseMapper<Car> {
    List<CarDetail> queryAllByEnable();
    List<CarDetail> queryByModelId(Integer modelId);
    List<Option> queryOptionOfCar(Integer carVin);
    Integer deleteByCarVin(Integer carVin);
}




