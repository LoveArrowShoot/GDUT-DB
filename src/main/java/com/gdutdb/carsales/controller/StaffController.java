package com.gdutdb.carsales.controller;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Order;
import com.gdutdb.carsales.po.poja.Staff;
import com.gdutdb.carsales.service.OrderService;
import com.gdutdb.carsales.service.StaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    @Resource
    OrderService orderService;

    // 销售 即创建订单
    @PostMapping("/sale")
    public CommonResult saleCar(@RequestBody Order order) {
        return orderService.saleCar(order);
    }

    // 新增和修改
    @PostMapping
    public CommonResult save(@RequestBody Staff staff) {
        staffService.save(staff);
        // 新增或者更新
        return CommonResult.successResult();
    }

    @GetMapping("/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password){
        return staffService.login(username, password);
    }

    @PostMapping("/register")
    public CommonResult register(@RequestBody Staff staff){
        return staffService.register(staff);
    }


    // 查询所有数据
    @GetMapping
    public CommonResult findAll() {
        return staffService.queryAll();
    }

    // 查询销售商数据
    @GetMapping("/distributor/{distributorId}")
    public CommonResult findByDistributorId(@PathVariable Integer distributorId) {
        return staffService.queryByDistributorId(distributorId);
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        return staffService.deleteByStaffId(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return staffService.removeByIds(ids);
    }

    public CommonResult update(@RequestBody Staff staff){
        return staffService.updateById(staff) ? CommonResult.successResult() : CommonResult.failResult("更新失败");
    }

//    // 分页查询 - mybatis-plus的方式
//    @GetMapping("/page")
//    public IPage<Staff> findPage(@RequestParam Integer pageNum,
//                                 @RequestParam Integer pageSize,
//                                 @RequestParam(defaultValue = "") String name)
//    {
//        //TODO 展示该员工所属的经销商姓名
//        IPage<Staff> page = new Page<>(pageNum, pageSize);
//        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
//        if (!"".equals(name)) {
//            queryWrapper.like("staff_name", name);
//        }
//
//        queryWrapper.orderByDesc("staff_id");
//        return staffService.page(page, queryWrapper);
//    }
}
