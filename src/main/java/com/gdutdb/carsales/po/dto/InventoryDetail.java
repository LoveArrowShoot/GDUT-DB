package com.gdutdb.carsales.po.dto;

import com.gdutdb.carsales.po.poja.Distributor;
import com.gdutdb.carsales.po.poja.Inventory;
import com.gdutdb.carsales.po.poja.Model;
import lombok.Data;

@Data
public class InventoryDetail {
    /**
     * 模型
     */
    ModelDetail modelDetail;
    /**
     * 供应商
     */
    Distributor distributor;
}
