package com.gdutdb.carsales.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdutdb.carsales.po.poja.Model;
import com.gdutdb.carsales.service.ModelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/model")
public class ModelController {
    @Resource
    private ModelService modelService;

    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Model model) {
        return modelService.save(model);
    }

    //TODO 查看,修改该模型可选的选项并且在model_option表中修改


    // 查询所有数据
    @GetMapping
    public List<Model> findAll() {
        //TODO 展示该模型所对应的品牌
        return modelService.list();
    }

    // TODO 伪删除

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return modelService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return modelService.removeByIds(ids);
    }


    // 分页查询 - mybatis-plus的方式
    @GetMapping("/page")
    public IPage<Model> findPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(defaultValue = "") String name)
    {
        //TODO 展示该模型所对应的品牌
        IPage<Model> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Model> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("model_name", name);
        }

        queryWrapper.orderByDesc("model_id");
        return modelService.page(page, queryWrapper);
    }
}
