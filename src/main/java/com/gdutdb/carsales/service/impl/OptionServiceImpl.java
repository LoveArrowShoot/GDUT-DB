package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Option;
import com.gdutdb.carsales.service.OptionService;
import com.gdutdb.carsales.mapper.OptionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class OptionServiceImpl extends ServiceImpl<OptionMapper, Option>
    implements OptionService{

    @Resource
    OptionMapper optionMapper;

    @Override
    public CommonResult queryAllByEnable() {
        return CommonResult.successResult(optionMapper.queryAllByEnable());
    }

    @Override
    public CommonResult deleteByOptionId(Integer optionId) {
        return optionMapper.deleteByOptionId(optionId) > 0 ? CommonResult.successResult() : CommonResult.failResult();
    }
}




