package com.gdutdb.carsales.controller;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Model;
import com.gdutdb.carsales.service.ModelService;
import org.apache.ibatis.annotations.Update;
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

    // 查询所有数据
    @GetMapping
    public CommonResult findAll() {
        return CommonResult.successResult(modelService.queryAll());
    }

    @GetMapping("/{id}")
    public CommonResult findByModelId(@PathVariable Integer id) {
        return CommonResult.successResult(modelService.queryByModelId(id));
    }

    @GetMapping("/option/{id}")
    //TODO 查看,修改该模型可选的选项并且在model_option表中修改
    public CommonResult queryOptionOfModel(@PathVariable Integer id){
        return modelService.queryOptionOfModel(id);
    }

    @Update("{modelId}/option")
    public CommonResult updateModelOption(@PathVariable Integer modelId, @RequestBody List<Integer> ids){
        return modelService.updateModelOption(modelId, ids);
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
