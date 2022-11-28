package com.gdutdb.carsales.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdutdb.carsales.po.poja.Option;
import com.gdutdb.carsales.service.OptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/option")
public class OptionController {
    @Resource
    private OptionService optionService;

    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Option option) {
        // TODO 新增或修改选项的时候，需要处理model_option,car_option两张表
        return optionService.save(option);

    }

    // 查询所有数据
    @GetMapping
    public List<Option> findAll() {
        return optionService.list();
    }

    // TODO 伪删除

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return optionService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return optionService.removeByIds(ids);
    }


    // 分页查询 - mybatis-plus的方式
    @GetMapping("/page")
    public IPage<Option> findPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(defaultValue = "") String name)
    {
        IPage<Option> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Option> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("option_name", name);
        }

        queryWrapper.orderByDesc("option_id");
        return optionService.page(page, queryWrapper);
    }
}
