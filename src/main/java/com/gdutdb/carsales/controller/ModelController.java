package com.gdutdb.carsales.controller;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Model;
import com.gdutdb.carsales.service.ModelService;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Resource
    private ModelService modelService;

    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Model model) {
        return modelService.save(model);
    }

    // 查询所有数据
    @GetMapping
    public CommonResult findAll() {
        return modelService.queryAll();
    }

    // 查询模型
    @GetMapping("/{id}")
    public CommonResult findByModelId(@PathVariable Integer id) {
        return CommonResult.successResult(modelService.queryByModelId(id));
    }

    // 查询模型的所有选项
    @GetMapping("/{id}/option")
    public CommonResult queryOptionOfModel(@PathVariable Integer id){
        return modelService.queryOptionOfModel(id);
    }

    // 更新模型的选项
    @PutMapping("{modelId}/option")
    public CommonResult updateModelOption(@PathVariable Integer modelId, @RequestBody Integer[] ids){
        return modelService.updateModelOption(modelId, new ArrayList<Integer>(Arrays.asList(ids)));
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        return modelService.deleteByModelId(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return modelService.removeByIds(ids);
    }

    @PutMapping("/update")
    public CommonResult update(@RequestBody Model model) {
        return modelService.updateById(model) ? CommonResult.successResult() : CommonResult.failResult();
    }

//    // 分页查询 - mybatis-plus的方式
//    @GetMapping("/page")
//    public CommonResult findPage(@RequestParam Integer pageNum,
//                                  @RequestParam Integer pageSize,
//                                  @RequestParam(defaultValue = "") String name)
//    {
//        //TODO 展示该模型所对应的品牌
//        IPage<Model> page = new Page<>(pageNum, pageSize);
//        QueryWrapper<Model> queryWrapper = new QueryWrapper<>();
//        if (!"".equals(name)) {
//            queryWrapper.like("model_name", name);
//        }
//
//        queryWrapper.orderByDesc("model_id");
//        return CommonResult.successResult(modelService.page(page, queryWrapper));
//    }
}
