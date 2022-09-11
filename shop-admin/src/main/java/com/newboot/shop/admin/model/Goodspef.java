package com.newboot.shop.admin.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Goodspef implements Serializable {
    private Integer spID;

    private Integer goodsID;

    private Integer pefID;

    private Integer parameterID;

    private static final long serialVersionUID = 1L;

    public Integer getSpID() {
        return spID;
    }

    public void setSpID(Integer spID) {
        this.spID = spID;
    }

    public Integer getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Integer goodsID) {
        this.goodsID = goodsID;
    }

    public Integer getPefID() {
        return pefID;
    }

    public void setPefID(Integer pefID) {
        this.pefID = pefID;
    }

    public Integer getParameterID() {
        return parameterID;
    }

    public void setParameterID(Integer parameterID) {
        this.parameterID = parameterID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spID=").append(spID);
        sb.append(", goodsID=").append(goodsID);
        sb.append(", pefID=").append(pefID);
        sb.append(", parameterID=").append(parameterID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}