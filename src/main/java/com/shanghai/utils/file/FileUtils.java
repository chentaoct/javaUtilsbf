package com.shanghai.utils.file;

import java.io.File;

/**
 * Created by 陈涛 on 2017/6/20.
 */
public class FileUtils {
    public static void main(String[] args) {
String createFile="D:\\fileTest\\csv\\customer\\hold\\data\\20170623\\20170623110900\\customer_hold_20170623110900_0.csv";
        boolean file = createFile(createFile);
    }
    /**
     * 创建目录
     * 如果路径中没有写文件就创直接创建目录
     * 辨别路径是否有文件是通过，路径中是否有.后缀
     * @return
     */
    public static boolean createFile(String fileName){
        String [] fbol= fileName.split("\\.");
        String folder="";
        if (fbol.length>1) {
            folder= fileName.substring(0,fileName.lastIndexOf(File.separator));
        }else {
            folder= fileName;
        }
        File file=new File(folder);
        boolean bol= file.mkdirs();	//创建文件夹
        return bol;
    }
}
