package com.gdutdb.carsales.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdutdb.carsales.po.dto.CommonResult;
import com.gdutdb.carsales.po.dto.OptionData;
import com.gdutdb.carsales.po.poja.*;
import com.gdutdb.carsales.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {
        @Resource
        private CarService carService;

        @Resource
        private CarOptionService carOptionService;

        // 新增和修改
        @PostMapping
        public CommonResult save(@RequestBody Car car) {
            return carService.save(car)?CommonResult.successResult():CommonResult.failResult("更新车辆信息失败");
        }

        //修改这个车所具有的选项
        @PostMapping("/{id}/option/update")
        public CommonResult updateOption(@PathVariable Integer id,@RequestBody List<Integer> optionId){
            List<CarOption> carOptions=new ArrayList<>();
            for (Integer oid:optionId) {
                carOptions.add(new CarOption(id,oid));
            }
            carOptionService.saveOrUpdateBatch(carOptions);
            return carOptionService.saveOrUpdateBatch(carOptions)? CommonResult.successResult():CommonResult.failResult("更新选项失败");
        }

        //查看这个车所对应的品牌的选项，已选的选项则进行标记
        @GetMapping("/{id}/option")
        public CommonResult findOption(@PathVariable Integer id){
            //根据获取的选项id找到选项
            List<Option> option = (List<Option>) carService.queryOptionOfCar(id).getData();
            //获取该车已有的选项的id
            List<Integer> carOption = carOptionService.list(new QueryWrapper<CarOption>().eq("car_vin", id)).
                                            stream().map(CarOption::getOptionId).collect(Collectors.toList());

            //采用该数据包装选项对象以及该选项对象是否被该车使用的判断
            List<OptionData> optionData=new ArrayList<>();
            for (Option a:option) {
                //如果该选项被当前的车使用，则标记位置为1
                optionData.add(new OptionData(a, (carOption.contains(a.getOptionId()))?1:0 ));
            }
            return CommonResult.successResult(optionData);
        }

        // 查询所有数据
        @GetMapping
        public CommonResult findAll() {
            return carService.queryAll();
        }

        // 查询销售商拥有的车辆
        @GetMapping("/distributor/{distributorId}")
        public CommonResult findByDistributorId(@PathVariable Integer distributorId) {
            return carService.queryByDistributorId(distributorId);
        }

        // 查询销售商拥有的某个品牌的车辆
        @GetMapping("/distributor/{distributorId}/brand/{brandId}")
        public CommonResult findByDistributorId(@PathVariable Integer distributorId, @PathVariable Integer brandId) {
            return carService.queryByDistributorIdAndBrandId(distributorId, brandId);
        }

        @DeleteMapping("/{id}")
        public CommonResult delete(@PathVariable Integer id) {
            return  carService.update(new UpdateWrapper<Car>().eq("car_vin",id).set("enable",1))
                    ? CommonResult.successResult():CommonResult.failResult("删除失败");
        }

        @PostMapping("/del/batch")
        public CommonResult deleteBatch(@RequestBody List<Integer> ids) {
            return carService.removeByIds(ids)?CommonResult.successResult():CommonResult.failResult("批量删除失败");
        }

        @PutMapping()
        public CommonResult update(@RequestBody Car car){
            return carService.updateById(car) ? CommonResult.successResult() : CommonResult.failResult();
        }


        // 分页查询 - mybatis-plus的方式
        @GetMapping("/page")
        public CommonResult findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam(defaultValue = "") String brand,
                                    @RequestParam(defaultValue = "") String model) {
            IPage<Car> page = new Page<>(pageNum, pageSize);
            QueryWrapper<Car> queryWrapper = new QueryWrapper<>();
            if (!"".equals(brand)) {
                queryWrapper.like("car_brand", brand);
            }
            if (!"".equals(model)) {
                queryWrapper.like("car_model", model);
            }
            queryWrapper.orderByDesc("car_vin");
            return CommonResult.successResult(carService.page(page, queryWrapper));
        }
}
