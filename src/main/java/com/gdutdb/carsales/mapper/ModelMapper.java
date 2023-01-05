package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.dto.ModelDetail;
import com.gdutdb.carsales.po.poja.Model;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdutdb.carsales.po.poja.Option;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Model
 */
public interface ModelMapper extends BaseMapper<Model> {
    Integer deleteByModelId(Integer modelId);
    Integer deleteOptionByModelId(Integer modelId);
    List<ModelDetail> queryAll();
    ModelDetail queryByModelId(Integer modelId);
    Model queryByCarvVin(Integer carVin);
    List<Option> queryOptionOfModel(Integer modelId);
}




