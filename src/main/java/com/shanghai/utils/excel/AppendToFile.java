package com.shanghai.utils.excel;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.io.*;
import java.util.*;


/**
 * 文件写入工具类 
 * @author yangjian
 *
 */
public class AppendToFile {
	/**
	 * A方法追加文件：使用RandomAccessFile
	 * 
	 * @param fileName
	 *            文件名
	 * @param content
	 *            追加的内容
	 */
	public static void appendMethodA(String fileName, String content) throws IOException{
		createFile(fileName);	//创建文件夹
		
		// 打开一个随机访问文件流，按读写方式
		RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
		// 文件长度，字节数
		long fileLength = randomFile.length();
		// 将写文件指针移到文件尾。
		randomFile.seek(fileLength);
		//randomFile.writeBytes(content);	//中文有乱码
		randomFile.write(content.getBytes("utf-8"));	//中文无乱码
		randomFile.close();
	}

	/**
	 * B方法追加文件：使用FileWriter
	 * 
	 * @param fileName
	 * @param content
	 */
	public static void appendMethodB(String fileName, String content) throws IOException{
		createFile(fileName);	//创建文件夹
		
		// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
		FileWriter writer = new FileWriter(fileName, true);
		//writer.write(content);	//中文有乱码
		//writer.write(content.toCharArray());	//中文无乱码
		
		PrintWriter pw = new PrintWriter(writer);
		pw.print(content);	//写入文件中，中文无乱码
		
		pw.close();
		writer.close();
	
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
	 		folder= fileName.substring(0,fileName.lastIndexOf("/"));
		}else {
			folder= fileName;
		}
		File file=new File(folder);
		boolean bol= file.mkdirs();	//创建文件夹
		return bol;
	}
	
	
	/**
	 * 删除文件，或删除空文件夹
	 */
	public static boolean deleteFile(String fileName){
		boolean bol= new File(fileName).delete();
		return bol;
	}
	
	/**
	 * 递归删除目录中和目录中的文件
	 * @param file 要删除的目录
	 * @return 删除成功状态
	 */
	public static boolean deleteFileAll(File file){
		if (file.isDirectory()) {
			String [] children =file.list();
			//递归删除目录中的子目录下
			for (String s : children) {
				  boolean bol = deleteFileAll(new File(file, s));
				  if (!bol) {
					return false;
				}
			}
		}
		//删除最后的空文件夹
		return file.delete();
	}
	
	/**
	 * 生成excel文件
	 * @param fileName 文件存放路径(文件名必须是.xls)
	 * @param columnHead excel列头
	 * @param columnBody excel内容
	 */
	public static void createExcel(String fileName,List<String> columnHead,List<List<String>> columnBody){
		try {
			createFile(fileName);	//创建文件夹
		    WritableWorkbook book = Workbook.createWorkbook(new File(fileName));	// 建立excel文件
		    // -- 第一个参数是Sheet名，第二个参数是Sheet下标
		    // -- 下标是整数，只起标识作用，建立的时候会以create顺序建立，本例生成的EXCEL文件第一个Sheet是sheet1
		    WritableSheet sheet2 = book.createSheet("第一页",1);		//创建一个工作表
		    
		    //创建excel列头
		    for (int i = 0; i < columnHead.size(); i++) {
		    	// -- 参数:先定位列，再定位行，再表格内容
		    	Label lab = new Label(i,0,columnHead.get(i));
		    	sheet2.addCell(lab);
			}
		    //创建excel内容
		    for (int i = 0; i < columnBody.size(); i++) {
		    	List<String> li=columnBody.get(i);
		    	for (int j = 0; j < li.size(); j++) {
		    		// -- 参数:先定位列，再定位行，再表格内容
			    	Label lab = new Label(j,i+1,li.get(j));
			    	sheet2.addCell(lab);
				}
			}
			book.write();	//写文件
			book.close();	//关闭文件流
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 拆分excel数据集合
	 * @param fileName excel文件存放路径(不包含后缀)
	 * 	excel最大行数65535，如果大于65535就在文件名后面追加1，现在以65000行为一个文件
	 * @param columnBody 需要写入excel文件中的数据集
	 * @return 返回map(文件路径，拆分好后的数据集)
	 * 如果参数为空返回null
	 */
	public static Map<String, List<List<String>>> splitExcelList(String fileName,List<List<String>> columnBody){
		if (fileName==null||"".equals(fileName)||columnBody==null||columnBody.size()==0) {
			return null;
		}
		Map<String, List<List<String>>> map=new HashMap<String, List<List<String>>>();
		
		int count=columnBody.size();	//总函数
		int page=count/65000;		//一共有多少个文件
		if (page==0) {		//只有1个文件的数据
			map.put(fileName+".xls", columnBody);
		}else{
			int indexRow=0;		//分割起始下标
			int endRow=65000;	//分割结束下标
			for (int i = 0; i <= page; i++) {
				if (endRow>count) {		//当分割结束下标大于总行数，分割结束下标=总行数
					endRow=count;
				}
				List<List<String>> list=columnBody.subList(indexRow, endRow);
				if (indexRow==0) {	//如果是第一个文件
					map.put(fileName+".xls", list);
				}else { //否则文件名后追加1
					map.put(fileName+i+".xls", list);
				}
				indexRow=endRow;		//分割起始下标，等于分割结束下标
				endRow +=65000;			//分割结束下标+65000
			}
		}
		return map;
	}
	
	/***
	 * 删除指定文件夹下非今天的导入操作产生的错误文件， 文件夹下的命名规范为 年_月_日
	 * @param file
	 * @param realPath
	 * @return
	 */
	public static boolean deleteImpErrFileAll(File file, String realPath){
		Date date = new Date();
		String today = (1900+date.getYear()) + "_" +(date.getMonth()+1) + "_" +date.getDate();
		//String path = FileConfig.getInstance().getImpErrFilePath();
		String[] pathArr = realPath.split("/");
		String dir = pathArr[pathArr.length-1];
		if (file.isDirectory()) {
			if(!file.getName().equals(today)){			
				String [] children =file.list();
				//递归删除目录中的子目录下
				for (String s : children) {
					
					boolean bol = deleteImpErrFileAll(new File(file, s),s );
					if (!bol) {
						return false;
					}
				}
			}
		}
		if(!file.getName().equals(dir)){
			file.delete();
		}
		return true;
	}
	
	//生成文件
//	public static void main(String[] args) {
//		String fileName = "C:/Users/Administrator/Desktop/abc/bbc/newTemp3.txt";
//		String content = "asdsf杨坚sdfsf";
////		// 按方法A追加文件
////		AppendToFile.appendMethodA(fileName, content);
////		AppendToFile.appendMethodA(fileName, "append end. n");
//		
//		
////		// 按方法B追加文件
////		AppendToFile.appendMethodB(fileName, content);
////		//AppendToFile.appendMethodB(fileName, "append end. n");
//		createFile(fileName);
//		//deleteFile(fileName);
//		
//	}
	
	//生成excel
	public static void main(String[] args) throws IOException {
		List<String> li=new ArrayList<String>();
		li.add("1");
		li.add("2");
		li.add("3");
		li.add("4");
		li.add("5");
		li.add("6");
		li.add("7");
		li.add("8");
		li.add("9");
		li.add("10");
		List<String> li1=li.subList(0, 5);
		for (String s : li1) {
			System.out.println(s);
		}
		System.out.println("*******************************************");
		List<String> li2=li.subList(5, 10);
		for (String s : li2) {
			System.out.println(s);
		}
		
		try {
		    String fileName = "d:\\" +"生成的" + ".xls";
		    WritableWorkbook book = Workbook.createWorkbook(new File(fileName));
		    
		    // -- 第一个参数是Sheet名，第二个参数是Sheet下标
		    // -- 下标是整数，只起标识作用，建立的时候会以create顺序建立，本例生成的EXCEL文件第一个Sheet是sheet1   
		    WritableSheet sheet1 = book.createSheet("第一页",0);
		    WritableSheet sheet2 = book.createSheet("第二页",1);
		    WritableSheet sheet3 = book.createSheet("第三页",2);
		    WritableSheet sheet4 = book.createSheet("第四页",4);
		    WritableSheet sheet5 = book.createSheet("第五页",5);
		    
		    
		    WritableFont wfTop = new WritableFont(WritableFont.ARIAL, 15,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat wcfTop = new WritableCellFormat(wfTop);
			wcfTop.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcfTop.setAlignment(Alignment.CENTRE);
			
			sheet2.addCell(new Label(0,0,"3424234", wcfTop));
			//参数：第几列，第几行，合并到第几列下标，合并到第几行下标
			sheet2.mergeCells(0, 0, 4, 1);	//合并单元格
			// -- 参数:先定位列，再定位行，再表格内容
			Label labTitle1 = new Label(0,1,"姓名",wcfTop);
			Label labTitle2 = new Label(1,1,"性别",wcfTop);
			Label labTitle3 = new Label(2,1,"移动电话",wcfTop);
			Label labTitle4 = new Label(3,1,"固定电话",wcfTop);
			Label labTitle5 = new Label(4,1,"家庭电话1",wcfTop);
			sheet2.addCell(labTitle1);
			sheet2.addCell(labTitle2);
			sheet2.addCell(labTitle3);
			sheet2.addCell(labTitle4);
			sheet2.addCell(labTitle5);
			for(int i=2;i<4;i++) {
				Label lab1 = new Label(0,i,"老师23");
				Label lab2 = new Label(1,i,"男3213");
				Label lab3 = new Label(2,i,"adfadf");
				Label lab4 = new Label(3,i,"");
				Label lab5 = new Label(4,i,"gfff");
				sheet2.addCell(lab1);
				sheet2.addCell(lab2);
				sheet2.addCell(lab3);
				sheet2.addCell(lab4);
				sheet2.addCell(lab5);
			}
			book.write();
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}