package com.newboot.shop.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class Price implements Serializable {
    private Integer sku;

    private Integer goodsID;

    private Integer spID1;

    private Integer spID2;

    private Integer spID3;

    private BigDecimal price;

    private Integer stock;

    private static final long serialVersionUID = 1L;

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Integer goodsID) {
        this.goodsID = goodsID;
    }

    public Integer getSpID1() {
        return spID1;
    }

    public void setSpID1(Integer spID1) {
        this.spID1 = spID1;
    }

    public Integer getSpID2() {
        return spID2;
    }

    public void setSpID2(Integer spID2) {
        this.spID2 = spID2;
    }

    public Integer getSpID3() {
        return spID3;
    }

    public void setSpID3(Integer spID3) {
        this.spID3 = spID3;
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
        sb.append(", goodsID=").append(goodsID);
        sb.append(", spID1=").append(spID1);
        sb.append(", spID2=").append(spID2);
        sb.append(", spID3=").append(spID3);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}