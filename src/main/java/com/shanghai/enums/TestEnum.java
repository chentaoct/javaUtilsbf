package com.shanghai.enums;

/**
 * Created by 陈涛 on 2017/6/8.
 */
public class TestEnum {
    public static void main(String args[])
    {
        ChannelType baofuPay = ChannelType.BAOFU_PAY;
        String name = baofuPay.name();
        String value = ChannelType.BAOFU_PAY.getValue();
        System.out.println(value);
        System.out.println(name);
    }
}
