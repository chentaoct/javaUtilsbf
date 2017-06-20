package com.shanghai.utils.zip;

import java.io.*;

/**
 * Created by 陈涛 on 2017/6/20.
 */
public class TestFile2 {
    public static void main(String[] args) {
        String filePath = "D:\\fileTest\\zip1\\2012\\a.txt";

        readTxtFile(filePath);
        writeFile(filePath);
    }

    private static void writeFile(String filePath) {
        FileOutputStream out  = null;
        try {
            out = new FileOutputStream(filePath);
            long begin = System.currentTimeMillis();
            out.write("123123123123".getBytes());

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void readTxtFile(String filePath){
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    System.out.println(lineTxt);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }
}
