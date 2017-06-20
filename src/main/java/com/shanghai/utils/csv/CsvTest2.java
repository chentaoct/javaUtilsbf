package com.shanghai.utils.csv;

import com.csvreader.CsvReader;

import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by 陈涛 on 2017/6/20.
 */
public class CsvTest2 {

    public static void main(String[] args) {
        readTest();

    }

    private static void readTest() {
        try {

            ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据
            String csvFilePath = "D:\\fileTest\\customer_hold_20170623110900_0.csv";
            CsvReader reader = new CsvReader(csvFilePath,',', Charset.forName("UTF-8"));    //一般用这编码读就可以了

          //  reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。

            while(reader.readRecord()){ //逐行读入除表头的数据
                System.out.println(reader.getRawRecord());
                csvList.add(reader.getValues());
            }
            reader.close();

            for(int row=0;row<csvList.size();row++){

                String  cell = csvList.get(row)[0]; //取得第row行第0列的数据
                String  cell2 = csvList.get(row)[1]; //取得第row行第0列的数据
                String  cell3 = csvList.get(row)[2]; //取得第row行第0列的数据
                System.out.println(cell+":"+cell2+":"+cell3);

            }


        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
