package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Distributor;
import com.gdutdb.carsales.service.DistributorService;
import com.gdutdb.carsales.mapper.DistributorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 *
 */
@Service
public class DistributorServiceImpl extends ServiceImpl<DistributorMapper, Distributor>
    implements DistributorService{

    @Resource
    DistributorMapper distributorMapper;

    @Override
    public CommonResult queryAllByEnable() {
        return CommonResult.successResult(distributorMapper.queryAllByEnable());
    }

    @Override
    public CommonResult login(String username, String password) {
        Distributor distributor = distributorMapper.queryAllByDistributorUsername(username);
        if (Objects.isNull(distributor)){
            return CommonResult.failResult("用户不存在");
        }
        if (!distributor.getDistributorPassword().equals(password)){
            return CommonResult.failResult("用户名或密码错误");
        }
        return CommonResult.successResult();
    }

    @Override
    public CommonResult deleteByDistributorId(Integer distributorId) {
        return distributorMapper.deleteByDistributorId(distributorId) > 0 ? CommonResult.successResult() : CommonResult.failResult("删除失败");
    }
}




