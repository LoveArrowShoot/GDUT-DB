package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.poja.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Brand
 */
public interface BrandMapper extends BaseMapper<Brand> {
    List<Brand> queryAllByEnable();

    int deleteByBrandId(Integer brandId);
}




