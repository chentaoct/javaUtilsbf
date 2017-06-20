package com.shanghai.utils.csv;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by 陈涛 on 2017/6/20.
 */
public class CsvTest {
    public static void main(String[] args) throws IOException {
//生成CsvReader对象，以，为分隔符，GBK编码方式
        CsvReader r = new CsvReader("D:\\fileTest\\yingbei_hold_20170623094800_01.csv", ',', Charset.forName("GBK"));
        //读取表头
       // r.readHeaders();
        //逐条读取记录，直至读完
        while (r.readRecord()) {
            //读取一条记录
            System.out.println(r.getRawRecord());
            //按列名读取这条记录的值
            /*System.out.println(r.get("Name"));
            System.out.println(r.get("class"));
            System.out.println(r.get("number"));
            System.out.println(r.get("sex"));*/
        }
        r.close();
    }
}
