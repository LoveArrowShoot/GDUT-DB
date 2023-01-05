package com.gdutdb.carsales.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Order;
import com.gdutdb.carsales.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

//    @PostMapping
//    public boolean save(@RequestBody Order order) {
//        // 新增或者更新
//        return orderService.save(order);
//    }

    // 新增和修改
    @PostMapping("/sale")
    public CommonResult saleCar(@RequestBody Order order) {
        // 新增或者更新
        return orderService.saleCar(order);
    }
    // 查询所有数据
    @GetMapping
    public CommonResult findAll() {
        return orderService.queryAll();
    }

    @GetMapping("/staff/{staffId}")
    public CommonResult queryByStaffId(@PathVariable Integer staffId) {
        return orderService.queryByStaffId(staffId);
    }

    @GetMapping("/car/{carVin}")
    public CommonResult queryByCarVin(@PathVariable Integer carVin) {
        return orderService.queryByCarVin(carVin);
    }

    @GetMapping("/distributor/{distributorId}")
    public CommonResult queryByDistributorId(@PathVariable Integer distributorId) {
        return orderService.queryByDistributorId(distributorId);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return orderService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return orderService.removeByIds(ids);
    }

    @PutMapping()
    public CommonResult update(@RequestBody Order order){
        return orderService.updateById(order) ? CommonResult.successResult() : CommonResult.failResult("更新失败");
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
