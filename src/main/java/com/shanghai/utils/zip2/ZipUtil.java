package com.shanghai.utils.zip2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
 
 
public class ZipUtil {  
      
    //private static final Log log = LogFactory.getLog(ZipUtil.class);
  
  
    /** 
     * 压缩文件 
     *  
     * @param srcfile File[] 需要压缩的文件列表 
     * @param zipfile File 压缩后的文件 
     */  
    public static void zipFiles(List<File> srcfile, File zipfile) {  
        byte[] buf = new byte[1024];  
        try {  
            // Create the ZIP file  
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));  
            // Compress the files  
            for (int i = 0; i < srcfile.size(); i++) {  
                File file = srcfile.get(i);  
                FileInputStream in = new FileInputStream(file);  
                // Add ZIP entry to output stream. 
                out.putNextEntry(new ZipEntry(file.getName()));
                out.setEncoding("gbk");
                // Transfer bytes from the file to the ZIP file  
                int len;  
                while ((len = in.read(buf)) > 0) {  
                    out.write(buf, 0, len);  
                }  
                // Complete the entry  
                out.closeEntry();  
                in.close();  
            }  
            // Complete the ZIP file  
            out.close();  
        } catch (IOException e) {
            e.printStackTrace();
          // log.error("ZipUtil zipFiles exception:"+e);
        }  
    }  
  
    /** 
     * 解压缩 
     *  
     * @param zipfile File 需要解压缩的文件 
     * @param descDir String 解压后的目标目录 
     */  
    public static void unZipFiles(File zipfile, String descDir) {  
        try {  
            // Open the ZIP file  
            ZipFile zf = new ZipFile(zipfile);  
            for (Enumeration entries = zf.getEntries(); entries.hasMoreElements();) {  
                // Get the entry name  
                ZipEntry entry = ((ZipEntry) entries.nextElement());  
                String zipEntryName = entry.getName();  
                InputStream in = zf.getInputStream(entry);  
                // System.out.println(zipEntryName);  
                OutputStream out = new FileOutputStream(descDir + zipEntryName);  
                byte[] buf1 = new byte[1024];  
                int len;  
                while ((len = in.read(buf1)) > 0) {  
                    out.write(buf1, 0, len);  
                }  
                // Close the file and stream  
                in.close();  
                out.close();  
            }  
        } catch (IOException e) {
            e.printStackTrace();
            //log.error("ZipUtil unZipFiles exception:"+e);
        }  
    }  
  
    /** 
     * Main 
     *  
     * @param args 
     */  
    public static void main(String[] args) {  
        List<File> srcfile=new ArrayList<File>();
      /*  srcfile.add(new File("e:\\1.txt"));
        srcfile.add(new File("e:\\2.txt"));
        File zipfile = new File("e:\\edm.zip");
        ZipUtil.zipFiles(srcfile, zipfile);*/
       // File file = new File("e:\\edm.zip");
        File file = new File("e:\\zip1.zip");
        ZipUtil.unZipFiles(file,"D:\\fileTest\\unfile\\");
    }
}  
