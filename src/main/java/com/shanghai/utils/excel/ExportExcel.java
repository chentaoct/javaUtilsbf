package com.shanghai.utils.excel;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class ExportExcel {

	private static Log log = LogFactory.getLog(ExportExcel.class);

	/**
	 * objOut存放需要导出的数据    objIn存放Response对象(用于获得返回前台页面的输出流),Excel的列名以及文件名
	 * 
	 * */
	public static void exportExcel(Map<String, Object> objIn,
			Map<String, Object> objOut) throws Exception{
		try {
			// 取得response HttpServletResponse
			HttpServletResponse response = (HttpServletResponse) objIn
					.get("response");

			String fileName = (String)objIn.get("fileName");
			Long numTag = new Date().getTime()-1303290794406l;
			while(numTag>334750){
				numTag -=12345l; 
			}
			// 设置table列名
			List<String> excelColName = (List<String>) objIn.get("excelColName");
			WritableWorkbook wwb = null;
			if(null != response){
				OutputStream os = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				response
						.setHeader("Content-disposition", "attachment; filename="
								+ new String((fileName + numTag).getBytes("GB2312"), "8859_1")
								+ ".xls");// 设定输出文件头
				response.setContentType("application/msexcel");// 定义输出类型

				wwb = Workbook.createWorkbook(os); // 建立excel文件
			}else{
				FileOutputStream os = (FileOutputStream)objIn.get("outputStream");
				wwb = Workbook.createWorkbook(os);
			}
			

			WritableSheet ws = wwb.createSheet("Sheet1", 10); // 创建一个工作表
			
			
			int rowIndex = 0;
			String tabTop = (String)objOut.get("tabTop");
			Integer font = (Integer) objOut.get("font");
			if(null == font){
				font = 15;
			}
			if(null != tabTop && !"".equals(tabTop)){
				//设置表头内容
				WritableFont wfTop = new WritableFont(WritableFont.ARIAL, font,
						WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
						Colour.BLACK);
					
				WritableCellFormat wcfTop = new WritableCellFormat(wfTop);
				wcfTop.setWrap(true);	
				wcfTop.setVerticalAlignment(VerticalAlignment.CENTRE);
				wcfTop.setAlignment(Alignment.CENTRE);
				ws.addCell(new Label(0,0,tabTop, wcfTop));
				ws.mergeCells(0, 0, excelColName.size()-1, 0);
				rowIndex=1;
			}
			
			
			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setAlignment(Alignment.CENTRE);
			ws.setRowView(0, 500);

			// 填充数据的内容
			List<List<String>> resultList = (List<List<String>>) objOut.get("resultList");
			// 设置列头名
			for (int i = 0; i < excelColName.size(); i++) {
				ws.addCell(new Label(i, rowIndex, excelColName.get(i), wcf));
			}
			rowIndex++;
			// 设置内容
			wcf = new WritableCellFormat();
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setAlignment(Alignment.CENTRE);
			for (int i = 0; i < resultList.size(); i++) {					
				//设置内容信息
				for (int j = 0; j < excelColName.size(); j++) {					
					ws.addCell(new Label(j, i + rowIndex, resultList.get(i).get(j),
							wcf));
				}
			}
			wwb.write();
			wwb.close();

		} catch (Exception e) {
			log.error(e);
			throw new Exception(e);
		}
	}

}
