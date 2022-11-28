package com.gdutdb.carsales.po.poja;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName car
 */
@TableName(value ="car")
@Data
public class Car implements Serializable {
    /**
     * 车辆标识号
     */
    @TableId
    private Integer carVin;

    /**
     * 车辆所属品牌
     */
    private String carBrand;

    /**
     * 车辆所属模型
     */
    private String carModel;

    /**
     * 是否启用
     */
    private Boolean enable;

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
        Car other = (Car) that;
        return (this.getCarVin() == null ? other.getCarVin() == null : this.getCarVin().equals(other.getCarVin()))
            && (this.getCarBrand() == null ? other.getCarBrand() == null : this.getCarBrand().equals(other.getCarBrand()))
            && (this.getCarModel() == null ? other.getCarModel() == null : this.getCarModel().equals(other.getCarModel()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCarVin() == null) ? 0 : getCarVin().hashCode());
        result = prime * result + ((getCarBrand() == null) ? 0 : getCarBrand().hashCode());
        result = prime * result + ((getCarModel() == null) ? 0 : getCarModel().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carVin=").append(carVin);
        sb.append(", carBrand=").append(carBrand);
        sb.append(", carModel=").append(carModel);
        sb.append(", enable=").append(enable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}