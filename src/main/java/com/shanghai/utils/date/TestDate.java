package com.shanghai.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈涛 on 2017/10/12.
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //跨年不会出现问题
        //如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
        Date fDate=sdf.parse("2017-10-12 08:00:00");
        Date oDate=sdf.parse("2017-10-13 00:00:00");
        long days=(oDate.getTime()-fDate.getTime())/(1000*3600*24);
        System.out.print(days);
    }
}
