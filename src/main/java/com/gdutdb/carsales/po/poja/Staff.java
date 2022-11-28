package com.gdutdb.carsales.po.poja;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName staff
 */
@TableName(value ="staff")
@Data
public class Staff implements Serializable {
    /**
     * 销售人员编号
     */
    @TableId
    private Integer staffId;

    /**
     * 销售人员用户名
     */
    private String staffName;

    /**
     * 销售人员手机号
     */
    private String staffPhone;

    /**
     * 销售人员密码
     */
    private String staffPassword;

    /**
     * 所属经销商的id
     */
    private Integer staffDistributorId;

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
        Staff other = (Staff) that;
        return (this.getStaffId() == null ? other.getStaffId() == null : this.getStaffId().equals(other.getStaffId()))
            && (this.getStaffName() == null ? other.getStaffName() == null : this.getStaffName().equals(other.getStaffName()))
            && (this.getStaffPhone() == null ? other.getStaffPhone() == null : this.getStaffPhone().equals(other.getStaffPhone()))
            && (this.getStaffPassword() == null ? other.getStaffPassword() == null : this.getStaffPassword().equals(other.getStaffPassword()))
            && (this.getStaffDistributorId() == null ? other.getStaffDistributorId() == null : this.getStaffDistributorId().equals(other.getStaffDistributorId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStaffId() == null) ? 0 : getStaffId().hashCode());
        result = prime * result + ((getStaffName() == null) ? 0 : getStaffName().hashCode());
        result = prime * result + ((getStaffPhone() == null) ? 0 : getStaffPhone().hashCode());
        result = prime * result + ((getStaffPassword() == null) ? 0 : getStaffPassword().hashCode());
        result = prime * result + ((getStaffDistributorId() == null) ? 0 : getStaffDistributorId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", staffId=").append(staffId);
        sb.append(", staffName=").append(staffName);
        sb.append(", staffPhone=").append(staffPhone);
        sb.append(", staffPassword=").append(staffPassword);
        sb.append(", staffDistributorId=").append(staffDistributorId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}