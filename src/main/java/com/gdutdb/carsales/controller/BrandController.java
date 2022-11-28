package com.gdutdb.carsales.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdutdb.carsales.po.poja.Brand;
import com.gdutdb.carsales.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/brand")
public class BrandController {
    @Resource
    private BrandService brandService;

    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Brand brand) {
        // 新增或者更新
        return brandService.save(brand);
    }

    // 查询所有数据
    @GetMapping
    public List<Brand> findAll() {
        return brandService.list();
    }

    // TODO 伪删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return brandService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return brandService.removeByIds(ids);
    }


    // 分页查询 - mybatis-plus的方式
    @GetMapping("/page")
    public IPage<Brand> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String name) {
        IPage<Brand> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("brand_name", name);
        }
        queryWrapper.orderByDesc("brand_id");
        return brandService.page(page, queryWrapper);
    }
}
