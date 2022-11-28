package com.gdutdb.carsales.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdutdb.carsales.po.poja.Car;
import com.gdutdb.carsales.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
        @Resource
        private CarService carService;

        // 新增和修改
        @PostMapping
        public boolean save(@RequestBody Car car) {
            //TODO 新增,修改车的时候，需要修改car_option表
            return carService.save(car);
        }

        //TODO 查看这个车所具有的选项

        // 查询所有数据
        @GetMapping
        public List<Car> findAll() {
            return carService.list();
        }

    // TODO 伪删除

    @DeleteMapping("/{id}")
        public boolean delete(@PathVariable Integer id) {
            return carService.removeById(id);
        }

        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {
            return carService.removeByIds(ids);
        }


        // 分页查询 - mybatis-plus的方式
        @GetMapping("/page")
        public IPage<Car> findPage(@RequestParam Integer pageNum,
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
            return carService.page(page, queryWrapper);
        }
}
