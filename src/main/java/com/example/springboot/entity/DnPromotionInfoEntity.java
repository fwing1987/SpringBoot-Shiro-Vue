package com.example.springboot.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dn_promotion_info")
@DynamicInsert
public class DnPromotionInfoEntity {
    private Integer id;
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
    private String oldImei;
    private Integer income;
    private Byte sceneId;
    private Byte flag;
    private Byte state;
    private Timestamp updTime;
    private Timestamp createTime;
    private Integer channelId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "channel_code")
    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    @Basic
    @Column(name = "yyb_imei1")
    public String getYybImei1() {
        return yybImei1;
    }

    public void setYybImei1(String yybImei1) {
        this.yybImei1 = yybImei1;
    }

    @Basic
    @Column(name = "yyb_imei2")
    public String getYybImei2() {
        return yybImei2;
    }

    public void setYybImei2(String yybImei2) {
        this.yybImei2 = yybImei2;
    }

    @Basic
    @Column(name = "imei1")
    public String getImei1() {
        return imei1;
    }

    public void setImei1(String imei1) {
        this.imei1 = imei1;
    }

    @Basic
    @Column(name = "imei2")
    public String getImei2() {
        return imei2;
    }

    public void setImei2(String imei2) {
        this.imei2 = imei2;
    }

    @Basic
    @Column(name = "imsi")
    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    @Basic
    @Column(name = "entity")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "mac")
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Basic
    @Column(name = "wifi_id")
    public String getWifiId() {
        return wifiId;
    }

    public void setWifiId(String wifiId) {
        this.wifiId = wifiId;
    }

    @Basic
    @Column(name = "hardware")
    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    @Basic
    @Column(name = "android_id")
    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    @Basic
    @Column(name = "android_api")
    public String getAndroidApi() {
        return androidApi;
    }

    public void setAndroidApi(String androidApi) {
        this.androidApi = androidApi;
    }

    @Basic
    @Column(name = "oldImei")
    public String getOldImei() {
        return oldImei;
    }

    public void setOldImei(String oldImei) {
        this.oldImei = oldImei;
    }

    @Basic
    @Column(name = "income")
    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    @Basic
    @Column(name = "sceneId")
    public Byte getSceneId() {
        return sceneId;
    }

    public void setSceneId(Byte sceneId) {
        this.sceneId = sceneId;
    }

    @Basic
    @Column(name = "flag")
    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "state")
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "upd_time",insertable = false,updatable = false)
    public Timestamp getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Timestamp updTime) {
        this.updTime = updTime;
    }

    @Basic
    @Column(name = "create_time",insertable = false,updatable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "channel_Id")
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DnPromotionInfoEntity entity = (DnPromotionInfoEntity) o;

        if (channelId != entity.channelId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return channelId;
    }
}
