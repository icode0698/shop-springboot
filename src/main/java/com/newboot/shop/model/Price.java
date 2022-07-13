package com.newboot.shop.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class Price implements Serializable {
    private Integer sku;

    private Integer goodsid;

    private Integer spid1;

    private Integer spid2;

    private Integer spid3;

    private BigDecimal price;

    private Integer stock;

    private static final long serialVersionUID = 1L;

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getSpid1() {
        return spid1;
    }

    public void setSpid1(Integer spid1) {
        this.spid1 = spid1;
    }

    public Integer getSpid2() {
        return spid2;
    }

    public void setSpid2(Integer spid2) {
        this.spid2 = spid2;
    }

    public Integer getSpid3() {
        return spid3;
    }

    public void setSpid3(Integer spid3) {
        this.spid3 = spid3;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sku=").append(sku);
        sb.append(", goodsid=").append(goodsid);
        sb.append(", spid1=").append(spid1);
        sb.append(", spid2=").append(spid2);
        sb.append(", spid3=").append(spid3);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}