package com.gdutdb.carsales.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdutdb.carsales.po.poja.Model;
import com.gdutdb.carsales.po.poja.Staff;
import com.gdutdb.carsales.service.StaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    //TODO 登陆功能

    //TODO 经销商只能看见并修改属于自己的职工

    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Staff staff) {
        // 新增或者更新
        return staffService.save(staff);
    }

    // 查询所有数据
    @GetMapping
    public List<Staff> findAll() {
        //TODO 展示该员工所属的经销商姓名
        return staffService.list();
    }

    // TODO 伪删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return staffService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return staffService.removeByIds(ids);
    }

    // 分页查询 - mybatis-plus的方式
    @GetMapping("/page")
    public IPage<Staff> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String name)
    {
        //TODO 展示该员工所属的经销商姓名
        IPage<Staff> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("staff_name", name);
        }

        queryWrapper.orderByDesc("staff_id");
        return staffService.page(page, queryWrapper);
    }
}
