package com.gdutdb.carsales.po.poja;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName model
 */
@TableName(value ="model")
@Data
public class Model implements Serializable {
    /**
     * 模型编号
     */
    @TableId
    private Integer modelId;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * 模型所属的品牌编号
     */
    private Integer modelBrandId;

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
        Model other = (Model) that;
        return (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getModelBrandId() == null ? other.getModelBrandId() == null : this.getModelBrandId().equals(other.getModelBrandId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getModelBrandId() == null) ? 0 : getModelBrandId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", modelId=").append(modelId);
        sb.append(", modelName=").append(modelName);
        sb.append(", modelBrandId=").append(modelBrandId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}