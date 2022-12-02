package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.poja.Option;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity com.gdutdb.carsales.po.poja.Option
 */
public interface OptionMapper extends BaseMapper<Option> {
    Integer deleteByOptionId(Integer optionId);
}




