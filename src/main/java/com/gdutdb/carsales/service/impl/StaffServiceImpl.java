package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Staff;
import com.gdutdb.carsales.service.StaffService;
import com.gdutdb.carsales.mapper.StaffMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff>
    implements StaffService{
    @Resource
    StaffMapper staffMapper;

    @Override
    public CommonResult queryAll() {
        return CommonResult.successResult(staffMapper.queryAllByEnable());
    }

    @Override
    public CommonResult queryByDistributorId(Integer distributorId) {
        return CommonResult.successResult(staffMapper.queryByDistributorId(distributorId));
    }

    @Override
    public CommonResult deleteByStaffId(Integer staffId) {
        return staffMapper.deleteByStaffId(staffId) > 0 ? CommonResult.successResult() : CommonResult.failResult("删除失败");
    }
}




