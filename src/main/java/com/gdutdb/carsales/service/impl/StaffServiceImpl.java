package com.gdutdb.carsales.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdutdb.carsales.mapper.StaffMapper;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Staff;
import com.gdutdb.carsales.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

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
    public CommonResult login(String username, String password) {
        Staff staff = staffMapper.queryAllByStaffName(username);
        if (Objects.isNull(staff)){
            return CommonResult.failResult("用户不存在");
        }
        if (!staff.getStaffPassword().equals(password)){
            return CommonResult.failResult("用户名或密码错误");
        }
        return CommonResult.successResult();
    }

    @Override
    public CommonResult register(Staff staff) {
        Staff staff1 = staffMapper.queryAllByStaffName(staff.getStaffName());
        if (Objects.nonNull(staff1)) {
            return CommonResult.failResult("用户名已存在");
        }
        staffMapper.insert(staff);
        return CommonResult.successResult();
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




