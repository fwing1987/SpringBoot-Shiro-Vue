package com.example.springboot.gentry;

import java.io.Serializable;
import java.util.Date;

public class DnPromotionInfo implements Serializable {
    private Integer id;

    private Integer channelId;

    private String channelCode;

    private String yybImei1;

    private String yybImei2;

    private String imei1;

    private String imei2;

    private String imsi;

    private String model;

    private String company;

    private String brand;

    private String mac;

    private String wifiId;

    private String hardware;

    private String androidId;

    private String androidApi;

    private String oldimei;

    private Integer income;

    private Integer discntedincome;

    private Integer incomeEst;

    private Integer incomeAct;

    private Integer incomeEstmgr;

    private Integer incomeMgr;

    private Integer quality;

    private Byte sceneid;

    private Byte flag;

    private Byte state;

    private Byte isbadimei;

    private Integer noincome;

    private Integer bstate;

    private Date updTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getYybImei1() {
        return yybImei1;
    }

    public void setYybImei1(String yybImei1) {
        this.yybImei1 = yybImei1 == null ? null : yybImei1.trim();
    }

    public String getYybImei2() {
        return yybImei2;
    }

    public void setYybImei2(String yybImei2) {
        this.yybImei2 = yybImei2 == null ? null : yybImei2.trim();
    }

    public String getImei1() {
        return imei1;
    }

    public void setImei1(String imei1) {
        this.imei1 = imei1 == null ? null : imei1.trim();
    }

    public String getImei2() {
        return imei2;
    }

    public void setImei2(String imei2) {
        this.imei2 = imei2 == null ? null : imei2.trim();
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getWifiId() {
        return wifiId;
    }

    public void setWifiId(String wifiId) {
        this.wifiId = wifiId == null ? null : wifiId.trim();
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware == null ? null : hardware.trim();
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId == null ? null : androidId.trim();
    }

    public String getAndroidApi() {
        return androidApi;
    }

    public void setAndroidApi(String androidApi) {
        this.androidApi = androidApi == null ? null : androidApi.trim();
    }

    public String getOldimei() {
        return oldimei;
    }

    public void setOldimei(String oldimei) {
        this.oldimei = oldimei == null ? null : oldimei.trim();
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getDiscntedincome() {
        return discntedincome;
    }

    public void setDiscntedincome(Integer discntedincome) {
        this.discntedincome = discntedincome;
    }

    public Integer getIncomeEst() {
        return incomeEst;
    }

    public void setIncomeEst(Integer incomeEst) {
        this.incomeEst = incomeEst;
    }

    public Integer getIncomeAct() {
        return incomeAct;
    }

    public void setIncomeAct(Integer incomeAct) {
        this.incomeAct = incomeAct;
    }

    public Integer getIncomeEstmgr() {
        return incomeEstmgr;
    }

    public void setIncomeEstmgr(Integer incomeEstmgr) {
        this.incomeEstmgr = incomeEstmgr;
    }

    public Integer getIncomeMgr() {
        return incomeMgr;
    }

    public void setIncomeMgr(Integer incomeMgr) {
        this.incomeMgr = incomeMgr;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Byte getSceneid() {
        return sceneid;
    }

    public void setSceneid(Byte sceneid) {
        this.sceneid = sceneid;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getIsbadimei() {
        return isbadimei;
    }

    public void setIsbadimei(Byte isbadimei) {
        this.isbadimei = isbadimei;
    }

    public Integer getNoincome() {
        return noincome;
    }

    public void setNoincome(Integer noincome) {
        this.noincome = noincome;
    }

    public Integer getBstate() {
        return bstate;
    }

    public void setBstate(Integer bstate) {
        this.bstate = bstate;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", yybImei1=").append(yybImei1);
        sb.append(", yybImei2=").append(yybImei2);
        sb.append(", imei1=").append(imei1);
        sb.append(", imei2=").append(imei2);
        sb.append(", imsi=").append(imsi);
        sb.append(", model=").append(model);
        sb.append(", company=").append(company);
        sb.append(", brand=").append(brand);
        sb.append(", mac=").append(mac);
        sb.append(", wifiId=").append(wifiId);
        sb.append(", hardware=").append(hardware);
        sb.append(", androidId=").append(androidId);
        sb.append(", androidApi=").append(androidApi);
        sb.append(", oldimei=").append(oldimei);
        sb.append(", income=").append(income);
        sb.append(", discntedincome=").append(discntedincome);
        sb.append(", incomeEst=").append(incomeEst);
        sb.append(", incomeAct=").append(incomeAct);
        sb.append(", incomeEstmgr=").append(incomeEstmgr);
        sb.append(", incomeMgr=").append(incomeMgr);
        sb.append(", quality=").append(quality);
        sb.append(", sceneid=").append(sceneid);
        sb.append(", flag=").append(flag);
        sb.append(", state=").append(state);
        sb.append(", isbadimei=").append(isbadimei);
        sb.append(", noincome=").append(noincome);
        sb.append(", bstate=").append(bstate);
        sb.append(", updTime=").append(updTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}