package com.shanghai.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by 陈涛 on 2017/6/20.
 */
public class FileTest {
    public static void main(String[] args) {
        String filePath="D:\\fileTest\\csv\\customer\\hold\\data\\20170623\\20170623110900";
        File file1 = new File("D:\\fileTest\\customer_hold_20170623110900_0.csv");
        File file2 = new File("D:\\fileTest\\csv\\customer\\hold\\data\\20170623\\20170623110900\\1.csv");
        FileUtils.createFile(filePath);
        copyFiles(file1,file2);
    }

    private static void copyFiles(File source, File target) {
        try {
            long time=new Date().getTime();
            int length=2097152;
            FileInputStream in=new FileInputStream(source);
            FileOutputStream out=new FileOutputStream(target);
            byte[] buffer=new byte[length];
            while(true){
                int ins=in.read(buffer);
                if(ins==-1){
                    in.close();
                    out.flush();
                    out.close();
                }else
                    out.write(buffer,0,ins);
            }
        }catch (Exception e){

        }

    }
}

