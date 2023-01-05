package com.gdutdb.carsales.po.poja;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @TableName distributor
 */
@TableName(value ="distributor")
@Data
@AllArgsConstructor
public class Distributor implements Serializable {
    /**
     * 经销商编号
     */
    @TableId
    private Integer distributorId;

    /**
     * 经销商名称
     */
    private String distributorName;

    /**
     * 经销商用户名
     */
    private String distributorUsername;

    /**
     * 经销商电话
     */
    private String distributorPhone;

    /**
     * 经销商密码
     */
    private String distributorPassword;

    /**
     * 经销商所在地址
     */
    private String distributorAddress;

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
        Distributor other = (Distributor) that;
        return (this.getDistributorId() == null ? other.getDistributorId() == null : this.getDistributorId().equals(other.getDistributorId()))
            && (this.getDistributorName() == null ? other.getDistributorName() == null : this.getDistributorName().equals(other.getDistributorName()))
            && (this.getDistributorUsername() == null ? other.getDistributorUsername() == null : this.getDistributorUsername().equals(other.getDistributorUsername()))
            && (this.getDistributorPhone() == null ? other.getDistributorPhone() == null : this.getDistributorPhone().equals(other.getDistributorPhone()))
            && (this.getDistributorPassword() == null ? other.getDistributorPassword() == null : this.getDistributorPassword().equals(other.getDistributorPassword()))
            && (this.getDistributorAddress() == null ? other.getDistributorAddress() == null : this.getDistributorAddress().equals(other.getDistributorAddress()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDistributorId() == null) ? 0 : getDistributorId().hashCode());
        result = prime * result + ((getDistributorName() == null) ? 0 : getDistributorName().hashCode());
        result = prime * result + ((getDistributorUsername() == null) ? 0 : getDistributorUsername().hashCode());
        result = prime * result + ((getDistributorPhone() == null) ? 0 : getDistributorPhone().hashCode());
        result = prime * result + ((getDistributorPassword() == null) ? 0 : getDistributorPassword().hashCode());
        result = prime * result + ((getDistributorAddress() == null) ? 0 : getDistributorAddress().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", distributorId=").append(distributorId);
        sb.append(", distributorName=").append(distributorName);
        sb.append(", distributorUsername=").append(distributorUsername);
        sb.append(", distributorPhone=").append(distributorPhone);
        sb.append(", distributorPassword=").append(distributorPassword);
        sb.append(", distributorAddress=").append(distributorAddress);
        sb.append(", enable=").append(enable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}