package com.newboot.shop.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Parametervalue implements Serializable {
    private Integer valueID;

    private Integer parameterID;

    private String value;

    private static final long serialVersionUID = 1L;

    public Integer getValueID() {
        return valueID;
    }

    public void setValueID(Integer valueID) {
        this.valueID = valueID;
    }

    public Integer getParameterID() {
        return parameterID;
    }

    public void setParameterID(Integer parameterID) {
        this.parameterID = parameterID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", valueID=").append(valueID);
        sb.append(", parameterID=").append(parameterID);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}