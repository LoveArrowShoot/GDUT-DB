package com.gdutdb.carsales.controller;

import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.poja.Inventory;
import com.gdutdb.carsales.service.InventoryService;
import com.gdutdb.carsales.service.ModelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Resource
    private InventoryService inventoryService;

    @Resource
    private ModelService modelService;
    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Inventory inventory) {
        // 新增或者更新
        return inventoryService.save(inventory);
    }

    // 查询所有数据
    @GetMapping
    public CommonResult findAll() {
        return inventoryService.queryAll();
    }

    // 查询经销商库存数据
    @GetMapping("/distributor/{distributorId}")
    public CommonResult findByDistributorId(@PathVariable Integer distributorId) {
        return inventoryService.queryByDistributorId(distributorId);
    }

    // 查询经销商库存数据
    @GetMapping("/staff/{staffId}")
    public CommonResult findByStaffrId(@PathVariable Integer staffId) {
        return inventoryService.queryByStaffId(staffId);
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        return inventoryService.deleteByInventoryId(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return inventoryService.removeByIds(ids);
    }

    @PutMapping("/update")
    public CommonResult updateInventory(@RequestParam Integer id, @RequestParam Integer count){
        return inventoryService.updateCount(id, count);
    }


//    // 分页查询 - mybatis-plus的方式
//    @GetMapping("/page")
//    public IPage<Inventory> findPage(@RequestParam Integer pageNum,
//                                    @RequestParam Integer pageSize,
//                                     @RequestParam(defaultValue = "") Integer id,
//                                     @RequestParam(defaultValue = "") String name)
//    {
//        IPage<Inventory> page = new Page<>(pageNum, pageSize);
//        QueryWrapper<Inventory> queryWrapper = new QueryWrapper<>();
//
//        //TODO 展示该库存对应的模型名称
//
//        if (!"".equals(name)) {
//            int modelId=modelService.getOne(new QueryWrapper<Model>().eq("model_name",name)).getModelId();
//            queryWrapper.like("inventory_model_id", modelId);
//            queryWrapper.like("inventory_distributor_id",id);
//        }
//
//        queryWrapper.orderByDesc("inventory_id");
//        return inventoryService.page(page, queryWrapper);
//    }
}
