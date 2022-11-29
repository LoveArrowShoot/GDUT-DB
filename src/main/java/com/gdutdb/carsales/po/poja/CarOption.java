package com.gdutdb.carsales.po.poja;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName car_option
 */
@TableName(value ="car_option")
@Data
public class CarOption implements Serializable {
    /**
     * 车辆标识号
     */
    private Integer carVin;

    /**
     * 选项编号
     */
    private Integer optionId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public CarOption(Integer carVin, Integer optionId) {
        this.carVin=carVin;
        this.optionId=optionId;
    }

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
        CarOption other = (CarOption) that;
        return (this.getCarVin() == null ? other.getCarVin() == null : this.getCarVin().equals(other.getCarVin()))
            && (this.getOptionId() == null ? other.getOptionId() == null : this.getOptionId().equals(other.getOptionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCarVin() == null) ? 0 : getCarVin().hashCode());
        result = prime * result + ((getOptionId() == null) ? 0 : getOptionId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carVin=").append(carVin);
        sb.append(", optionId=").append(optionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
