package com.cn.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * Servlet implementation class GetSheet
 */
@WebServlet("/GetSheet")
public class GetSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetSheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Test
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		factory.setSizeThreshold(1024 * 500);// 设置内存的临界值为500K
		File linshi = new File("E:\\linshi");// 当超过500K的时候，存到一个临时文件夹中
		factory.setRepository(linshi);
		upload.setSizeMax(1024 * 1024 * 500);// 设置上传的文件总的大小不能超过500M
		try {
			// 1. 得到 FileItem 的集合 items
			List<FileItem> /* FileItem */items = upload.parseRequest(request);

			// 2. 遍历 items:
			for (FileItem item : items) {
				// 若是一个一般的表单域, 打印信息
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("utf-8");

					System.out.println(name + ": " + value);

				}
				// 若是文件域则把文件保存到 e:\\files 目录下.
				else {
					String fileName = item.getName();
					long sizeInBytes = item.getSize();
					System.out.println(fileName);
					System.out.println(sizeInBytes);

					InputStream in = item.getInputStream();
					byte[] buffer = new byte[1024];
					int len = 0;

					fileName = "e:\\files\\" + fileName;// 文件最终上传的位置
					System.out.println(fileName);
					OutputStream out = new FileOutputStream(fileName);

					while ((len = in.read(buffer)) != -1) {
						out.write(buffer, 0, len);
					}

					out.close();
					in.close();
					System.out.println("上传完成");

					// String excelPath = "E:\\mei\\data\\aaaa.xlsx";

					try {
						// String encoding = "GBK";
						File excel = new File(fileName);
						if (excel.isFile() && excel.exists()) { // 判断文件是否存在
							String[] split = excel.getName().split("\\."); // .是特殊字符，需要转义！！！！！
							Workbook wb;
							// 根据文件后缀（xls/xlsx）进行判断
							if ("xls".equals(split[1])) {
								FileInputStream fis = new FileInputStream(excel); // 文件流对象
								wb = new HSSFWorkbook(fis);
							} else if ("xlsx".equals(split[1])) {
								wb = new XSSFWorkbook(excel);
							} else {
								System.out.println("文件类型错误!");
								return;
							}

							// 开始解析
							Sheet sheet = wb.getSheetAt(0); // 读取sheet 0
							//int firstRowIndex = sheet.getFirstRowNum() + 1; // 第一行是列名，所以不读
							int firstRowIndex = sheet.getFirstRowNum();
							int lastRowIndex = sheet.getLastRowNum();
							// 第一行及最后一行
							// System.out.println("firstRowIndex: "+firstRowIndex);
							// System.out.println("lastRowIndex: "+lastRowIndex);

							int cellNum = sheet.getRow(0)
									.getPhysicalNumberOfCells();

							System.out.println(cellNum);

							LinkedList<String>[] L = new LinkedList[cellNum];
							for (int k = 0; k < cellNum; k++) {
								L[k] = new LinkedList<String>();
							}

							for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) { // 遍历行
								// 按行读取，行号
								// System.out.println("rIndex: " + rIndex);
								Row row = sheet.getRow(rIndex);
								if (row != null) {
									int firstCellIndex = row.getFirstCellNum();
									int lastCellIndex = row.getLastCellNum();
									for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) { // 遍历列
										Cell cell = row.getCell(cIndex);
										if (cell != null) {
											L[cIndex].add(cell.toString());
											// System.out.println(cell.toString());
										}/*
										 * else{ System.out.println("0"); }
										 */
									}
								}

							}
							//模型值数组
							float mxz[]=new float[cellNum];
							for (int k = 0; k < cellNum; k++) {  //L[k]   linkedlist
								//System.out.println(L[k].toString());
								
								String[] numbers = new String[L[k].size()];
						        String a[]=L[k].toArray(numbers);
								
						        Float aa[]=new Float[a.length];
						        for(int b=0;b<a.length;b++){
						        	aa[b]=Float.parseFloat(a[b]);
						        }
						        
						        //求模型值
						        
						        
						        mxz[k]=getMXZ(aa);
						        
						        
							}
							
							
							//int a[]= {1,2,3,4,5,6,7,9,0,5,6,7,8};
							JSONArray json= new JSONArray();
							json.add(mxz);
							//JSONObject json = JSONObject.fromObject(a);
							System.out.println(json);
							//System.out.println("aaaa");
							response.getWriter().print(json);
							
						} else {
							System.out.println("找不到指定的文件");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		
		
	}
	public static float getMXZ(Float[] a){
		//最小二乘法
		float sum=0;
		for(int i=0;i<a.length;i++)
			sum+=a[i];
		
		return sum/a.length;
	}
}
