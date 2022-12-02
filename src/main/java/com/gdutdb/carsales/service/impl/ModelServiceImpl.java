package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Model;
import com.gdutdb.carsales.po.poja.ModelOption;
import com.gdutdb.carsales.po.poja.Option;
import com.gdutdb.carsales.service.ModelOptionService;
import com.gdutdb.carsales.service.ModelService;
import com.gdutdb.carsales.mapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model>
    implements ModelService{

    @Resource
    ModelMapper modelMapper;

    @Resource
    ModelOptionService modelOptionService;

    @Override
    public CommonResult queryAll() {
        return CommonResult.successResult(modelMapper.queryAll());
    }

    @Override
    public CommonResult queryByModelId(Integer modelId) {
        return CommonResult.successResult(modelMapper.queryByModelId(modelId));
    }

    @Override
    public CommonResult queryOptionOfModel(Integer modelId) {
        return CommonResult.successResult(modelMapper.queryOptionOfModel(modelId));
    }

    @Override
    public CommonResult deleteByModelId(Integer modelId) {
        return modelMapper.deleteByModelId(modelId) > 0 ? CommonResult.successResult() : CommonResult.failResult("删除失败");
    }

    @Override
    @Transactional
    public CommonResult updateModelOption(Integer modelId, List<Integer> optionIds) {
        //todo select forUpdate
        modelMapper.deleteOptionByModelId(modelId);
        for (Integer optionId : optionIds) {
           if(modelOptionService.save(new ModelOption(modelId, optionId))) {
               TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
               return CommonResult.failResult("更新失败");
           }
        }
        return CommonResult.successResult();
    }
}




