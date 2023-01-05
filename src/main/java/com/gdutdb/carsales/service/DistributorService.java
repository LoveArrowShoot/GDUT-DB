package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Distributor;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
public interface DistributorService extends IService<Distributor> {

    CommonResult queryAllByEnable();

    CommonResult login(String username, String password);

    CommonResult register(Distributor distributor);
    /**
     * 伪删除
     * @param distributorId 供应商id
     * @return 统一返回
     */
    CommonResult deleteByDistributorId(Integer distributorId);
}
