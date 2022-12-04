package com.gdutdb.carsales.service;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface StaffService extends IService<Staff> {
    CommonResult queryAll();
    CommonResult login(String username, String password);
    CommonResult queryByDistributorId(Integer distributorId);
    CommonResult deleteByStaffId(Integer staffId);
}
