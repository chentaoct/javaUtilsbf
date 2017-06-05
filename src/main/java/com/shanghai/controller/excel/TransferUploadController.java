package com.shanghai.controller.excel;


import com.shanghai.service.TransferUploadService;
import com.shanghai.utils.excel.ViewExcel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈涛 on 2017/5/26.
 */
@Controller
@RequestMapping("transferUpload")
public class TransferUploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferUploadController.class);
    @Autowired
    TransferUploadService transferUploadService;
    @RequestMapping(value = "/transferUploadInfo")
    public ModelAndView transferUploadInfo() {
        ModelAndView mav = new ModelAndView("/sysmng/staff/transferUpload");
        return mav;
    }
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, String> upload(HttpSession session, HttpServletRequest request, HttpServletResponse response
            , @RequestParam("file") CommonsMultipartFile file) throws IOException {
        Map<String, String> stringStringHashMap = new HashMap<String, String>();
        String realPath = request.getSession().getServletContext().getRealPath("/download")+File.separator+"transfer";
        System.out.println("realPath:"+realPath);
        String realPath2 = request.getSession().getServletContext().getRealPath("download");
        System.out.println(realPath2);
        PrintWriter out;
        String failFileName=null;
        boolean flag = false;
        if (file.getSize() > 0) {
            Map<String, String> resultMap = transferUploadService.importExcel(file, realPath);
             failFileName = resultMap.get("failFileName");
            request.getSession().setAttribute("excelFailFileName",failFileName);

        if (StringUtils.isNoneBlank(failFileName)) {
            stringStringHashMap.put("failFileName",failFileName);
            stringStringHashMap.put("status","FAILL");
        } else {
            stringStringHashMap.put("failFileName",null);
            stringStringHashMap.put("status","FAILL");
        }
        String successCount = resultMap.get("successCount");
        String failureCount = resultMap.get("failureCount");
        stringStringHashMap.put("successCount",successCount);
        stringStringHashMap.put("failureCount",failureCount);
        }
        return stringStringHashMap;
    }
    @RequestMapping("/download")
    public String downloadTempFileByName(HttpSession session, HttpServletRequest request, HttpServletResponse response)  {
        Object failFileName = request.getAttribute("failFileName");
        String fileName = (String) request.getSession().getAttribute("excelFailFileName");
        System.out.println(fileName);
        String realPath = request.getSession().getServletContext().getRealPath("/download")+File.separator+"transfer";
        //DocUploadLog docUploadLog = docUploadLogService.get(Long.valueOf(dupId));
        //String fileName=docUploadLog.getFilename();
        response.reset();//设置为没有缓存
        response.setContentType("application/x-download");
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try{
            outputStream = response.getOutputStream();
            response.reset();// 清空输出流
            ViewExcel viewExcel = new ViewExcel();
            String fileNameStr = viewExcel.encodeFilename(fileName.split(";")[1], request);
           /* response
                    .setHeader("Content-disposition", "attachment; filename="
                            + new String((fileName.split(";")[1]).getBytes("GB2312"), "8859_1"));// 设定输出文件头*/

           response
                    .setHeader("Content-disposition", "attachment; filename="
                            +fileNameStr);// 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
           // String errPath = FileConfig.getInstance().getImpErrFilePath();
            String errPath =realPath + File.separator;
            fileName = fileName.split(";")[0] + File.separator +  fileName.split(";")[1];
            inputStream = new FileInputStream(errPath+fileName);
            byte[] bytes = new byte[1024];
            int readBye;
            while ((readBye = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, readBye);
            }
            outputStream.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(inputStream != null)
                    inputStream.close();
                if(outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error(e.getMessage());
            }
        }
        return null;
    }
    @RequestMapping("/downloadTransferTempl")
    public String downloadTransferTempl(HttpSession session, HttpServletRequest request, HttpServletResponse response)  {
        String realPath = request.getSession().getServletContext().getRealPath("/download")+File.separator+"tmpl";
        String fileName="企业打款模板.xls";
        response.reset();//设置为没有缓存
        response.setContentType("application/x-download");
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try{
            outputStream = response.getOutputStream();
            response.reset();// 清空输出流
            ViewExcel viewExcel = new ViewExcel();
            String fileNameStr = viewExcel.encodeFilename(fileName, request);
            response
                    .setHeader("Content-disposition", "attachment; filename="
                            + fileNameStr);// 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            // String errPath = FileConfig.getInstance().getImpErrFilePath();
            String errPath =realPath + File.separator;
            inputStream = new FileInputStream(errPath+fileName);
            byte[] bytes = new byte[1024];
            int readBye;
            while ((readBye = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, readBye);
            }
            outputStream.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(inputStream != null)
                    inputStream.close();
                if(outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error(e.getMessage());
            }
        }
        return null;
    }
}
