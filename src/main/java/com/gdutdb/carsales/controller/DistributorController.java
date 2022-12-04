package com.gdutdb.carsales.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Distributor;
import com.gdutdb.carsales.service.DistributorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/distributor")
public class DistributorController {
    @Resource
    private DistributorService distributorService;

    @GetMapping("/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password){
        return distributorService.login(username, password);
    }

    @PostMapping("/register")
    public CommonResult register(@RequestBody Distributor distributor){
        return distributorService.register(distributor);
    }

    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Distributor distributor) {
        // 新增或者更新
        return distributorService.save(distributor);
    }

    // 查询所有数据
    @GetMapping
    public CommonResult findAll() {
        return distributorService.queryAllByEnable();
    }


    //删除
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        return distributorService.deleteByDistributorId(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return distributorService.removeByIds(ids);
    }


    // 分页查询 - mybatis-plus的方式
    @GetMapping("/page")
    public CommonResult findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam(defaultValue = "") String name,
                                       @RequestParam(defaultValue = "") String address
    ) {
        IPage<Distributor> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Distributor> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("distributor_name", name);
        }
        if (!"".equals(address)) {
            queryWrapper.like("distributor_address", address);
        }
        queryWrapper.orderByDesc("distributor_id");
        return CommonResult.successResult(distributorService.page(page, queryWrapper));
    }
}
