package com.newboot.shop.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Comment implements Serializable {
    private Integer id;

    private String user;

    private Integer sku;

    private Integer spu;

    private BigDecimal ratevalue;

    private Date createtime;

    private String comment;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getSpu() {
        return spu;
    }

    public void setSpu(Integer spu) {
        this.spu = spu;
    }

    public BigDecimal getRatevalue() {
        return ratevalue;
    }

    public void setRatevalue(BigDecimal ratevalue) {
        this.ratevalue = ratevalue;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", sku=").append(sku);
        sb.append(", spu=").append(spu);
        sb.append(", ratevalue=").append(ratevalue);
        sb.append(", createtime=").append(createtime);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}