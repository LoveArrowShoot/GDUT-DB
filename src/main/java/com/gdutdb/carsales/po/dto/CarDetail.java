package com.gdutdb.carsales.po.dto;

import com.gdutdb.carsales.po.poja.Brand;
import com.gdutdb.carsales.po.poja.Car;
import com.gdutdb.carsales.po.poja.Distributor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetail extends Car {
    private ModelDetail modelDetail;
    private Distributor distributor;
}
