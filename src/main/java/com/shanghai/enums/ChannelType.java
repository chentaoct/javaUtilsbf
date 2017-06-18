package com.shanghai.enums;

/**
 * Created by Paul on 2016/07/14.
 */
public enum ChannelType {

    CHANNEL_TYPE("channel_type", "124", "支付"),
    /** 京东支付*/
    JD_PAY("jd_pay", "124001", "京东支付"),
    /** 连连支付*/
    LIANLIAN_PAY("lianlian_pay", "124002", "连连支付"),
    /** 京东网关支付*/
    JD_WEB_PAY("jd_web_pay", "124003", "京东网关支付"),
    /**宝付支付*/
    BAOFU_PAY("baofu_pay","124004", "宝付支付"),
    /**盛付通支付*/
    SHENG_PAY("shengpay_pay","124005", "盛付通支付");
    ChannelType(String key, String value, String name) {
        this.key = key;
        this.value = value;
        this.name = name;

    }


    public static ChannelType getExamType(String value) {
        for (ChannelType examType : ChannelType.values()) {
            if (value.equals(examType.getValue())) {
                return examType;
            }
        }
        return null;
    }

    private String key;
    private String value;
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}