package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Distributor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface DistributorService extends IService<Distributor> {
    /**
     * 伪删除
     * @param distributorId 供应商id
     * @return 统一返回
     */
    CommonResult deleteByDistributorId(Integer distributorId);
}
