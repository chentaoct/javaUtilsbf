package com.shanghai.service.impl;


import com.shanghai.service.TransferUploadService;
import com.shanghai.utils.excel.AppendToFile;
import com.shanghai.utils.excel.ExportExcel;
import com.shanghai.utils.excel.ParseExcel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 陈涛 on 2017/5/26.
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class TransferUploadServiceImpl implements TransferUploadService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferUploadServiceImpl.class);


    @Override
    public Map<String, String> importExcel(CommonsMultipartFile file, String realPath) {
        Map<String,String> returnMap = new HashMap<String, String>();
        try {

            String originalFilename = file.getOriginalFilename();
            //解析excel
            List excelList = new ArrayList();
            HashMap<String, Object> parseExcelAll = ParseExcel.parseExcelAll(file.getInputStream(), 0);
            excelList= (List) parseExcelAll.get("resultList");
            List<String> columnName = (List<String>) excelList.get(0);
            if(!"标的编号".equals(columnName.get(0)) || !"打款金额".equals(columnName.get(1)) || !"打款时间".equals(columnName.get(2)) || !"收款账号".equals(columnName.get(3)) ){
                LOGGER.error("模板不对");
            }

            List<List<String>> errList = new ArrayList<List<String>>();

            for (int i = 0; i < excelList.size(); i++) {
                List<String> rec = (List<String>)excelList.get(i);
                ArrayList listObject = (ArrayList) excelList.get(i);
                //每一行的内容,包含原来excel和错误的信息
                List<String> contentList = (List<String>)excelList.get(i);
                if(i>0){
                    String proCode = contentList.get(0);
                    String transferAmt = contentList.get(1);
                    String transferDate = contentList.get(2);
                    String account = contentList.get(3);
                }

            }
            if(0 != errList.size()){
                Map<String, Object> objOut = new HashMap<String, Object>();
                objOut.put("resultList", errList);

                Map<String, Object> objIn = new HashMap<String, Object>();
                List<String> excelColName = new ArrayList<String>();
                excelColName.add("标的编号");
                excelColName.add("打款金额");
                excelColName.add("打款时间");
                excelColName.add("收款账号");
                excelColName.add("错误原因");
                try {
                    Date now = new Date();
                    String timeDir = (1900+now.getYear())+"_" + (now.getMonth()+1) + "_" + now.getDate();
                  //  String errPath = FileConfig.getInstance().getImpErrFilePath();

                    String errPath = realPath+ File.separator;
                    String[] fn_arr = originalFilename.split("\\.");
                    String format = fn_arr[0].trim();
                    String timeTag = timeDir + "_"+now.getHours() + "_" + now.getMinutes() + "_" +now.getSeconds();
                    String createfile=errPath+ timeDir+"/"+format+"("+timeTag+")"+".xls";
                    AppendToFile.createFile(createfile);
                    objIn.put("outputStream", new FileOutputStream(createfile));
                    objIn.put("excelColName", excelColName);
                    objIn.put("fileName", "教师导入");
                    System.out.println("=======================================1excelColName:"+excelColName);
                    System.out.println("=======================================createfile:"+createfile);
                    ExportExcel.exportExcel(objIn, objOut);
                    returnMap.put("failFileName",   timeDir+";"+format+"("+timeTag+")"+".xls");
                    //删除非今天的临时文件及文件夹
                    //AppendToFile.deleteImpErrFileAll(new File(errPath), realPath);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                returnMap.put("failFileName", "");
            }

          /*  returnMap.put("successCount", loanUserTransfers.size()+"");
            returnMap.put("failureCount", (excelList.size()-loanUserTransfers.size()-1)+"");*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnMap;
    }

}
