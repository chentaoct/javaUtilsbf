package com.shanghai.utils.excel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 陈涛 on 2017/6/2.
 */
public class ParseExcel {
    private static Log log = LogFactory.getLog(ParseExcel.class);
    public static HashMap<String, Object> parseExcelAll(InputStream is, int readFrom) {
        StringBuffer stringBuffer = new StringBuffer();
        Workbook workBook = null;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        List resultList = new ArrayList();
        try {
            workBook = Workbook.getWorkbook(is);
            //获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了
            Sheet[] sheet = workBook.getSheets();
            if (sheet != null && sheet.length > 0) {
                //对每个工作表进行循环
                for (int i = 0; i < sheet.length; i++) {

                    //得到当前工作表的行数
                    int rowNum = sheet[i].getRows();
                    log.info("总行数:" + rowNum);
                    for (int j = readFrom; j < rowNum; j++) {
                        List rowList = new ArrayList();
                        //得到当前行的所有单元格
                        Cell[] cells = sheet[i].getRow(j);
                        log.info("总列数:" + cells.length);
                        hashMap.put("cellsLength", cells.length);
                        if (cells != null && cells.length > 0) {
                            //对每个单元格进行循环
                            for (int k = 0; k < cells.length; k++) {
                                //读取当前单元格的值
                                String cellValue = cells[k].getContents();
                                rowList.add(k, cellValue);
                                stringBuffer.append(cellValue + "\t");
                                log.info("行数:" + j + "---列：" + k + "---单元格：" + cellValue);
                            }
                        }
                        resultList.add(rowList);
                        stringBuffer.append("\r\n");
                    }

                }
                stringBuffer.append("\r\n");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        log.info("最终:" + stringBuffer.toString());
        hashMap.put("resultList", resultList);
        return hashMap;

    }
}
