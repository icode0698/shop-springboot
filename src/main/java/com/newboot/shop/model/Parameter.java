package com.newboot.shop.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Parameter implements Serializable {
    private Integer parameterid;

    private String parametername;

    private static final long serialVersionUID = 1L;

    public Integer getParameterid() {
        return parameterid;
    }

    public void setParameterid(Integer parameterid) {
        this.parameterid = parameterid;
    }

    public String getParametername() {
        return parametername;
    }

    public void setParametername(String parametername) {
        this.parametername = parametername;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", parameterid=").append(parameterid);
        sb.append(", parametername=").append(parametername);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}