package com.example.springboot.gentry;

import java.io.Serializable;
import java.util.Date;

public class DnChannel implements Serializable {
    private Integer id;

    private Integer rootId;

    private Integer pid;

    private String name;

    private Byte level;

    private String channelCode;

    private String username;

    private String token;

    private String phone;

    private String password;

    private String province;

    private String city;

    private String country;

    private Integer platformFee;

    private Byte accType;

    private Byte ctype;

    private String isRedPack;

    private String payMethod;

    private Byte state;

    private Date updTime;

    private Date createTime;

    private String taobao;

    private Integer wxId;

    private String pids;

    private Integer isTop;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Integer getPlatformFee() {
        return platformFee;
    }

    public void setPlatformFee(Integer platformFee) {
        this.platformFee = platformFee;
    }

    public Byte getAccType() {
        return accType;
    }

    public void setAccType(Byte accType) {
        this.accType = accType;
    }

    public Byte getCtype() {
        return ctype;
    }

    public void setCtype(Byte ctype) {
        this.ctype = ctype;
    }

    public String getIsRedPack() {
        return isRedPack;
    }

    public void setIsRedPack(String isRedPack) {
        this.isRedPack = isRedPack == null ? null : isRedPack.trim();
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTaobao() {
        return taobao;
    }

    public void setTaobao(String taobao) {
        this.taobao = taobao == null ? null : taobao.trim();
    }

    public Integer getWxId() {
        return wxId;
    }

    public void setWxId(Integer wxId) {
        this.wxId = wxId;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids == null ? null : pids.trim();
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rootId=").append(rootId);
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", username=").append(username);
        sb.append(", token=").append(token);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", country=").append(country);
        sb.append(", platformFee=").append(platformFee);
        sb.append(", accType=").append(accType);
        sb.append(", ctype=").append(ctype);
        sb.append(", isRedPack=").append(isRedPack);
        sb.append(", payMethod=").append(payMethod);
        sb.append(", state=").append(state);
        sb.append(", updTime=").append(updTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", taobao=").append(taobao);
        sb.append(", wxId=").append(wxId);
        sb.append(", pids=").append(pids);
        sb.append(", isTop=").append(isTop);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}