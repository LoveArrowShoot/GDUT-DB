package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.dto.CarDetail;
import com.gdutdb.carsales.po.poja.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdutdb.carsales.po.poja.Option;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Car
 */
public interface CarMapper extends BaseMapper<Car> {
    int insertOption(@Param("carVin") Integer carVin,@Param("optionId") Integer optionId);
    List<CarDetail> queryAllByEnable();
    List<CarDetail> queryByModelId(Integer modelId);
    List<Option> queryOptionOfCar(Integer carVin);
    List<CarDetail> queryByDistributorId(Integer distributorId);
    List<CarDetail> queryByDistributorIdAndBrandId(Integer distributorId, Integer brandId);
    Integer deleteByCarVin(Integer carVin);
    Integer deleteCarOption(Integer carVin);
}




