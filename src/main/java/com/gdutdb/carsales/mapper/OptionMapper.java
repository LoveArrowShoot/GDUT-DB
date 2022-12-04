package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.poja.Option;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Option
 */
public interface OptionMapper extends BaseMapper<Option> {
    List<Option> queryAllByEnable();
    Integer deleteByOptionId(Integer optionId);
}




