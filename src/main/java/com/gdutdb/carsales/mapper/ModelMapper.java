package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.dto.ModelDetail;
import com.gdutdb.carsales.po.poja.Model;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Model
 */
public interface ModelMapper extends BaseMapper<Model> {
    Integer deleteByModelId(Integer modelId);
    List<ModelDetail> queryAll();
    ModelDetail queryByModelId(Integer modelId);
}




