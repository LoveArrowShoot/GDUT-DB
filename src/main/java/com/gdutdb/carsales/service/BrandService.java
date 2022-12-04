package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface BrandService extends IService<Brand> {

    CommonResult queryAllByEnable();
    /**
     * 伪删除
     * @param brandId 品牌id
     * @return 统一返回
     */
     CommonResult deleteById(Integer brandId);
}
