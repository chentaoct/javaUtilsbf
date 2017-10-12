package com.shanghai.utils.demo;

import java.math.BigDecimal;

/**
 * Created by 陈涛 on 2017/9/7.
 */
public class TestBigdecimel {
    public static void main(String[] args) {
        test();
    }
    private static void test() {
        String origin = "\"dealCode\":\"9F697B7DE3F044E680F9E2C558F4EDC4\",\"signMsg\":\"5d2c\",\"sign\":null}";//原始字符串
        String matter1 = "signMsg";//目标字符串1
        String matter2 = "sign";//目标字符串2
        int a = origin.indexOf(matter1);//第一个字符串的起始位置
        int b = origin.indexOf(matter2);//第二个字符串的起始位置
        String result = origin.substring(0, a+matter1.length())+origin.substring(b, origin.length());//利用substring进行字符串截取
        System.out.println(result);
    }

    
}
