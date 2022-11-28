package com.gdutdb.carsales.po.poja;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName inventory
 */
@TableName(value ="inventory")
@Data
public class Inventory implements Serializable {
    /**
     * 模型编号
     */
    private Integer inventoryModelId;

    /**
     * 经销商编号
     */
    private Integer inventoryDistributorId;

    /**
     * 库存数量
     */
    private Integer inventoryCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Inventory other = (Inventory) that;
        return (this.getInventoryModelId() == null ? other.getInventoryModelId() == null : this.getInventoryModelId().equals(other.getInventoryModelId()))
            && (this.getInventoryDistributorId() == null ? other.getInventoryDistributorId() == null : this.getInventoryDistributorId().equals(other.getInventoryDistributorId()))
            && (this.getInventoryCount() == null ? other.getInventoryCount() == null : this.getInventoryCount().equals(other.getInventoryCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInventoryModelId() == null) ? 0 : getInventoryModelId().hashCode());
        result = prime * result + ((getInventoryDistributorId() == null) ? 0 : getInventoryDistributorId().hashCode());
        result = prime * result + ((getInventoryCount() == null) ? 0 : getInventoryCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", inventoryModelId=").append(inventoryModelId);
        sb.append(", inventoryDistributorId=").append(inventoryDistributorId);
        sb.append(", inventoryCount=").append(inventoryCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}