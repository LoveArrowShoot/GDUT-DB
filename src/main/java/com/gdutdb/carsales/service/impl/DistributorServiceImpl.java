package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Distributor;
import com.gdutdb.carsales.service.DistributorService;
import com.gdutdb.carsales.mapper.DistributorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class DistributorServiceImpl extends ServiceImpl<DistributorMapper, Distributor>
    implements DistributorService{

    @Resource
    DistributorMapper distributorMapper;

    @Override
    public CommonResult deleteByDistributorId(Integer distributorId) {
        return distributorMapper.deleteByDistributorId(distributorId) > 0 ? CommonResult.successResult() : CommonResult.failResult("删除失败");
    }
}




