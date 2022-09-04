package com.newboot.shop.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String user;

    private String password;

    private String nickName;

    private String headPic;

    private Date regTime;

    private Date currentTime;

    private Date lastTime;

    private Integer viewCount;

    private Byte online;

    private String ipAddress;

    private String ipRegion;

    private String ipIOCount;

    private String ipCostTime;

    private String email;

    private static final long serialVersionUID = 1L;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Byte getOnline() {
        return online;
    }

    public void setOnline(Byte online) {
        this.online = online;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpRegion() {
        return ipRegion;
    }

    public void setIpRegion(String ipRegion) {
        this.ipRegion = ipRegion;
    }

    public String getIpIOCount() {
        return ipIOCount;
    }

    public void setIpIOCount(String ipIOCount) {
        this.ipIOCount = ipIOCount;
    }

    public String getIpCostTime() {
        return ipCostTime;
    }

    public void setIpCostTime(String ipCostTime) {
        this.ipCostTime = ipCostTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user=").append(user);
        sb.append(", password=").append(password);
        sb.append(", nickName=").append(nickName);
        sb.append(", headPic=").append(headPic);
        sb.append(", regTime=").append(regTime);
        sb.append(", currentTime=").append(currentTime);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", viewCount=").append(viewCount);
        sb.append(", online=").append(online);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}