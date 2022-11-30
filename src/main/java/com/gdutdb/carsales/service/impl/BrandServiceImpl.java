package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Brand;
import com.gdutdb.carsales.service.BrandService;
import com.gdutdb.carsales.mapper.BrandMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>
    implements BrandService{

    @Resource
    BrandMapper brandMapper;

    @Override
    public CommonResult deleteById(Integer brandId) {
        return brandMapper.deleteByBrandId(brandId) > 0 ? CommonResult.successResult() : CommonResult.failResult("更新失败");
    }
}




