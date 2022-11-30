package com.gdutdb.carsales.po.dto;

import com.gdutdb.carsales.po.poja.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ModelDetail extends Model{
    String brandName;
}
