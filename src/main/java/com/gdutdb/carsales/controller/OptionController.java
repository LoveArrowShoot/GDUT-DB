package com.gdutdb.carsales.controller;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Option;
import com.gdutdb.carsales.service.OptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/option")
public class OptionController {
    @Resource
    private OptionService optionService;

    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Option option) {
        return optionService.save(option);
    }

    // 查询所有数据
    @GetMapping
    public CommonResult findAll() {
        return optionService.queryAllByEnable();
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        return optionService.deleteByOptionId(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return optionService.removeByIds(ids);
    }

    @PutMapping()
    public CommonResult update(@RequestBody List<Option> options){
        return optionService.updateBatchById(options) ? CommonResult.successResult() : CommonResult.failResult();
    }

//    // 分页查询 - mybatis-plus的方式
//    @GetMapping("/page")
//    public IPage<Option> findPage(@RequestParam Integer pageNum,
//                                  @RequestParam Integer pageSize,
//                                  @RequestParam(defaultValue = "") String name)
//    {
//        IPage<Option> page = new Page<>(pageNum, pageSize);
//        QueryWrapper<Option> queryWrapper = new QueryWrapper<>();
//        if (!"".equals(name)) {
//            queryWrapper.like("option_name", name);
//        }
//
//        queryWrapper.orderByDesc("option_id");
//        return optionService.page(page, queryWrapper);
//    }
}
