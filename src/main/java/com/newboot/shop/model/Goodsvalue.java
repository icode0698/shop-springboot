package com.newboot.shop.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Goodsvalue implements Serializable {
    private Integer spid;

    private Integer goodsid;

    private Integer valueid;

    private Integer parameterid;

    private static final long serialVersionUID = 1L;

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getValueid() {
        return valueid;
    }

    public void setValueid(Integer valueid) {
        this.valueid = valueid;
    }

    public Integer getParameterid() {
        return parameterid;
    }

    public void setParameterid(Integer parameterid) {
        this.parameterid = parameterid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spid=").append(spid);
        sb.append(", goodsid=").append(goodsid);
        sb.append(", valueid=").append(valueid);
        sb.append(", parameterid=").append(parameterid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}