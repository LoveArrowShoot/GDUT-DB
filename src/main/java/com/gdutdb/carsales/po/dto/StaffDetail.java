package com.gdutdb.carsales.po.dto;

import com.gdutdb.carsales.po.poja.Distributor;
import com.gdutdb.carsales.po.poja.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDetail extends Staff {
    Distributor distributor;
}
