package com.gdutdb.carsales.po.dto;

import com.gdutdb.carsales.po.poja.Order;
import com.gdutdb.carsales.po.poja.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail extends Order {
    private Staff staff;
    private CarDetail carDetail;
}
