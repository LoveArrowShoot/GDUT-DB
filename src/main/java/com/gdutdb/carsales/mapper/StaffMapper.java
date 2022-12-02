package com.gdutdb.carsales.mapper;

import com.gdutdb.carsales.po.dto.StaffDetail;
import com.gdutdb.carsales.po.poja.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.gdutdb.carsales.po.poja.Staff
 */
public interface StaffMapper extends BaseMapper<Staff> {
    List<StaffDetail> queryAllByEnable();
    List<StaffDetail> queryByDistributorId(Integer distributorId);
    Integer deleteByStaffId(Integer staffId);
}




