package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.poja.Distributor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Distributor
 */
public interface DistributorMapper extends BaseMapper<Distributor> {

    Integer saveDistributor(Distributor distributor);

    List<Distributor> queryAllByEnable();

    Distributor queryAllByDistributorUsername(String distributorName);

    Integer deleteByDistributorId(Integer distributorId);
}




