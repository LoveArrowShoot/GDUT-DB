package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Model;
import com.gdutdb.carsales.service.ModelService;
import com.gdutdb.carsales.mapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model>
    implements ModelService{

    @Resource
    ModelMapper modelMapper;

    @Override
    public CommonResult queryAll() {
        return CommonResult.successResult(modelMapper.queryAll());
    }

    @Override
    public CommonResult queryByModelId(Integer modelId) {
        return CommonResult.successResult(modelMapper.queryByModelId(modelId));
    }

    @Override
    public CommonResult deleteByModelId(Integer modelId) {
        return modelMapper.deleteByModelId(modelId) > 0 ? CommonResult.successResult() : CommonResult.failResult("删除失败");
    }
}




