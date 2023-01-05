package com.gdutdb.carsales.po.poja;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName order
 */
@TableName(value ="order")
@Data
public class Order implements Serializable {
    /**
     * 订单编号
     */
    @TableId(type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单所属销售人员
     */
    private Integer orderStaffId;

    /**
     * 顾客电话
     */
    private String orderCustomerPhone;

    /**
     * 订单金额
     */
    private Integer orderMoney;

    /**
     * 车辆标识号
     */
    private Integer orderVin;

    /**
     * 顾客姓名
     */
    private String orderCustomerName;

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
        Order other = (Order) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderStaffId() == null ? other.getOrderStaffId() == null : this.getOrderStaffId().equals(other.getOrderStaffId()))
            && (this.getOrderCustomerPhone() == null ? other.getOrderCustomerPhone() == null : this.getOrderCustomerPhone().equals(other.getOrderCustomerPhone()))
            && (this.getOrderMoney() == null ? other.getOrderMoney() == null : this.getOrderMoney().equals(other.getOrderMoney()))
            && (this.getOrderVin() == null ? other.getOrderVin() == null : this.getOrderVin().equals(other.getOrderVin()))
            && (this.getOrderCustomerName() == null ? other.getOrderCustomerName() == null : this.getOrderCustomerName().equals(other.getOrderCustomerName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderStaffId() == null) ? 0 : getOrderStaffId().hashCode());
        result = prime * result + ((getOrderCustomerPhone() == null) ? 0 : getOrderCustomerPhone().hashCode());
        result = prime * result + ((getOrderMoney() == null) ? 0 : getOrderMoney().hashCode());
        result = prime * result + ((getOrderVin() == null) ? 0 : getOrderVin().hashCode());
        result = prime * result + ((getOrderCustomerName() == null) ? 0 : getOrderCustomerName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderStaffId=").append(orderStaffId);
        sb.append(", orderCustomerPhone=").append(orderCustomerPhone);
        sb.append(", orderMoney=").append(orderMoney);
        sb.append(", orderVin=").append(orderVin);
        sb.append(", orderCustomerName=").append(orderCustomerName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}