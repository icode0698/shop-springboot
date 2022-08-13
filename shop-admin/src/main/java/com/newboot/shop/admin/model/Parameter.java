package com.newboot.shop.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Parameter implements Serializable {
    private Integer parameterID;

    private String parameterName;

    private static final long serialVersionUID = 1L;

    public Integer getParameterID() {
        return parameterID;
    }

    public void setParameterID(Integer parameterID) {
        this.parameterID = parameterID;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", parameterID=").append(parameterID);
        sb.append(", parameterName=").append(parameterName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}