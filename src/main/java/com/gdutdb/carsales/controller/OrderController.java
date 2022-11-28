package com.gdutdb.carsales.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdutdb.carsales.po.poja.Order;
import com.gdutdb.carsales.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    //TODO 职工只能看见自己所处理的订单

    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Order order) {
        // 新增或者更新
        return orderService.save(order);
    }

    // 查询所有数据
    @GetMapping
    public List<Order> findAll() {
        //TODO 查看该订单所属的销售人员的姓名
        return orderService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return orderService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return orderService.removeByIds(ids);
    }

    // 分页查询 - mybatis-plus的方式
    @GetMapping("/page")
    public IPage<Order> findPage(@RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize,
                                     @RequestParam(defaultValue = "") String name)
    {
        IPage<Order> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("staff_name", name);
        }

        queryWrapper.orderByDesc("order_id");
        return orderService.page(page, queryWrapper);
    }

}
