package com.shanghai.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by 陈涛 on 2017/6/2.
 */
public class Test {
    public static void main(String[] args) {
       // test();
       //test2();
        //test3();
       // test4();
        test5();

    }

    private static void test5() {
        Double collectPeriodRate = 8.1222222;
        BigDecimal collectPeriodRateBigDecimal = new BigDecimal(String.valueOf(collectPeriodRate)).divide(new BigDecimal(100));
        Double aDouble = collectPeriodRateBigDecimal.setScale(8, BigDecimal.ROUND_DOWN).doubleValue();
        System.out.println(aDouble);
    }

    private static void test4() {
        Double collectPeriodRate = 8.1222222;
                BigDecimal collectPeriodRateBigDecimal = new BigDecimal(String.valueOf(collectPeriodRate)).divide(new BigDecimal(100));
        System.out.println(collectPeriodRateBigDecimal);
       /* Double aDouble = collectPeriodRateBigDecimal.setScale(8, BigDecimal.ROUND_DOWN).doubleValue();
        System.out.println(aDouble);*/


    }

    private static void test3() {
        Double collectPeriodRate = 8d;
        BigDecimal collectPeriodRateBigDecimal = new BigDecimal(collectPeriodRate).divide(new BigDecimal(100));
        System.out.println(collectPeriodRateBigDecimal.setScale(4,BigDecimal.ROUND_DOWN).doubleValue());
    }

    private static void test2() {
        Double collectPeriodRate = 88d;
        String collectPeriodRateStr = collectPeriodRate.toString();
        collectPeriodRateStr="99";
        int bitPos=collectPeriodRateStr.indexOf(".");
        if(bitPos>0){
            System.out.println("bitPos:"+bitPos);
            int numOfBits=collectPeriodRateStr.length()-bitPos-1;
            System.out.println("小数位数为： "+numOfBits);
        }else {

        }

    }

    private static void test() {
        Double collectPeriodRate = 88.123D;
        String collectPeriodRateStr = collectPeriodRate.toString();
        int bitPos=collectPeriodRateStr.indexOf(".");
        if(bitPos>0){
            System.out.println("bitPos:"+bitPos);
            int numOfBits=(collectPeriodRateStr.length()-bitPos-1)+2;
            System.out.println("小数位数为： "+numOfBits);

            Double collectPeriodRate2= divideDouble(collectPeriodRateStr,numOfBits);
            System.out.println(collectPeriodRate2);
        }else {
            Double collectPeriodRate2= divideDouble(collectPeriodRateStr,0);
            System.out.println(collectPeriodRate2);
        }

       /* BigDecimal aa= new BigDecimal(8.8);
        BigDecimal collectPeriodRateBigDecimal =aa.divide(new BigDecimal(100));
        Double aDouble = new Double(collectPeriodRateBigDecimal.doubleValue());
        System.out.println(collectPeriodRateBigDecimal);*/

    }

    private static Double divideDouble(String collectPeriodRateStr, int scale) {
        if(collectPeriodRateStr!=null){
            BigDecimal collectPeriodRateBigDecimal = new BigDecimal(collectPeriodRateStr).divide(new BigDecimal(100),scale,BigDecimal.ROUND_HALF_DOWN);
            return  new Double(collectPeriodRateBigDecimal.doubleValue());
        }


        return null;

    }
}
