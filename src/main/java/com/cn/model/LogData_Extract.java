package com.cn.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class LogData_Extract {
	static List<String> Dirlist = new ArrayList<String>();
	
	
	public static ArrayList<String>[] Data_Extract(int row,int col1,int col2,int num1,int num2) throws IOException {

		
		ArrayList<String>[] chanlist=new ArrayList[col2-col1+1];
		// ������
		for(int j=0;j<col2-col1+1;j++){
			 chanlist[j]=new ArrayList();
		}
		try {
			String Dir = "E:\\mei\\data\\log";
			System.out.println(Dir);
			List<String> fileDir = getPath(Dir);	
			System.out.println(fileDir);
			for (String fd : fileDir) {

				//List<Map<String, Object>> list = new ArrayList<>();
				List<Map<String, Object>> list_mp = new ArrayList<>();
				String[] filePath = fd.split("\\\\");
				String fileName = filePath[filePath.length - 2] + "_" + filePath[filePath.length - 1];//
				String Date = null;

				Date = fileName.split("\\.")[1];
				BufferedReader in = new BufferedReader(new FileReader(fd));// ���ļ�����������
				String str; // ����String������������ÿһ�ζ�����ÿһ�е�����
				// List<Map<String, Object>> list = new ArrayList<>();
				String path;
				// ����������ݽ���ɸѡ 

				// ��������¼��ǰ����
				int current_row = 1;
				//�ӵڼ��п�ʼ������
				//int row=7;
				// ��ȡ�ļ���
				//int col1 = 1;
				//int col2 = 5;
				// ÿ�ζ�����
				//int num1 = 2;
				// ÿ�����ж�һ��
				//int num2 = 3;
				int i = 0;// ��¼�Ѵ�����
			
					
					while ((str = in.readLine()) != null) {
						int flag = 1;// �Ƿ������
						if (current_row >= row) {
							if ((current_row - row) % num2 == i) {
								flag = 0;
							}
							if (i > (num1 - 1)) {
								i = 0;
								flag = 1;
							}

							if (flag == 0) {

								if (str.length() > 0) {

									String[] retval = new String[col2 - col1 + 1];

									if (str.trim().length() > 0) {
										retval = str.split("\\s+");
									}
									Map<Object, Object> map = new LinkedHashMap<>();

									
									for(int j=0;j<col2-col1+1;j++)
									{
										//System.out.println(retval[j].toString());
										chanlist[j].add(retval[j]);
										
									}
									
								
									i++;

								}

							}

						}
						current_row++;
					}
					
					
					
				
				in.close();

				/*// ��ȡ��Ŀ��·��

				// ·��ת���¸�ʽ

				path = "data\\" + fileName + ".xlsx";
				// д�뵽excel
				writeExcel(list, path);*/

			}
			for(int j=0;j<col2-col1+1;j++){
			// chanlist[j]=new ArrayList();
			// System.out.println(chanlist[j].toString());
		}

			System.out.println("Done!");
			

		} catch (IOException e) {
		}

		return chanlist;
	}

	/*public static void Data_Extract(int row,int col1,int col2,int num1,int num2) throws IOException {

		try {
			String Dir = "data\\log";
			List<String> fileDir = getPath(Dir);

			for (String fd : fileDir) {

				List<Map<String, Object>> list = new ArrayList<>();// 1
				List<Map<String, Object>> list_mp = new ArrayList<>();
				String[] filePath = fd.split("\\\\");
				String fileName = filePath[filePath.length - 2] + "_" + filePath[filePath.length - 1];//
				String Date = null;

				Date = fileName.split("\\.")[1];
				BufferedReader in = new BufferedReader(new FileReader(fd));// ���ļ�����������
				String str; // ����String������������ÿһ�ζ�����ÿһ�е�����
				// List<Map<String, Object>> list = new ArrayList<>();
				String path;
				// ����������ݽ���ɸѡ 

				// �������ӵ�N�п�ʼ��
				//int row = 1;
				// ��ȡ�ļ���
				//int col1 = 1;
				//int col2 = 5;
				// ÿ�ζ�����
				//int num1 = 2;
				// ÿ�����ж�һ��
				//int num2 = 3;
				int i = 0;// ��¼�Ѵ�����

				while ((str = in.readLine()) != null) {
					int flag = 1;// �Ƿ������
					if (row >= 7) {
						if ((row - 7) % num2 == i) {
							flag = 0;
						}
						if (i > (num1 - 1)) {
							i = 0;
							flag = 1;
						}

						if (flag == 0) {

							if (str.length() > 0) {

								String[] retval = new String[col2 - col1 + 1];

								if (str.trim().length() > 0) {
									retval = str.split("\\s+");
								}
								Map<String, Object> map = new LinkedHashMap<>();

								map.put("����", Date);
								map.put("ʱ��", retval[0]);
								map.put("%usr", retval[1]);
								map.put("%sys", retval[2]);
								map.put("%wio", retval[3]);
								map.put("%idle", retval[4]);
								list.add(map);
								// ������
								i++;

							}

						}

					}
					row++;
				}
				in.close();

				// ��ȡ��Ŀ��·��

				// ·��ת���¸�ʽ

				path = "data\\" + fileName + ".xlsx";
				// д�뵽excel
				writeExcel(list, path);

			}
			System.out.println("Done!");

		} catch (IOException e) {
		}
	}*/

	public static void CreateDate() {
		String[] time = new String[] { "00:00:00" };
		String t = "00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date d = null;
		Calendar c = Calendar.getInstance();
		try {
			d = sdf.parse(t);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setTime(d);
		c.add(Calendar.MINUTE, 1);
		String str = sdf.format(c.getTime());
		System.out.println(str);
	}

	public static List<String> getPath(String fileDir) {

		File file = new File(fileDir);
		File[] tempList = file.listFiles();
		List<File> filelist = new ArrayList<File>();
		// List<String> list = new ArrayList<String>();
		// System.out.println("������"+tempList.length);
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {
				filelist.add(tempList[i]);
				Dirlist.add(tempList[i].getPath());

			}
			if (tempList[i].isDirectory()) {
				// System.out.println("123"+tempList[i].getPath());
				getPath(tempList[i].getPath());

			}
		}
		// System.out.println(list);
		return Dirlist;
	}

	public static void writeExcel(List<Map<String, Object>> list, String path) {
		try {
			// Excel�ײ��ı���
			String sheetn = "table1";

			// ��JXL���½����ļ����������
			File myFilePath = new File(path);
			if (!myFilePath.exists())
				myFilePath.createNewFile();
			OutputStream outf = new FileOutputStream(path);

			WritableWorkbook wwb = Workbook.createWorkbook(outf);
			jxl.write.WritableSheet writesheet = wwb.createSheet(sheetn, 1);
			// ���ñ���
			if (list.size() > 0) {
				int j = 0;
				for (Entry<String, Object> entry : list.get(0).entrySet()) {
					String title = entry.getKey();
					writesheet.addCell(new Label(j, 0, title));
					j++;
				}
			}
			// �������
			for (int i = 1; i <= list.size(); i++) {
				int j = 0;
				for (Entry<String, Object> entry : list.get(i - 1).entrySet()) {
					Object o = entry.getValue();
					if (o instanceof Double) {
						writesheet.addCell(new jxl.write.Number(j, i, (Double) entry.getValue()));
					} else if (o instanceof Integer) {
						writesheet.addCell(new jxl.write.Number(j, i, (Integer) entry.getValue()));
					} else if (o instanceof Float) {
						writesheet.addCell(new jxl.write.Number(j, i, (Float) entry.getValue()));
					} else if (o instanceof Float) {
						writesheet.addCell(new jxl.write.DateTime(j, i, (Date) entry.getValue()));
					} else if (o instanceof BigDecimal) {
						writesheet.addCell(new jxl.write.Number(j, i, ((BigDecimal) entry.getValue()).doubleValue()));
					} else if (o instanceof Long) {
						writesheet.addCell(new jxl.write.Number(j, i, ((Long) entry.getValue()).doubleValue()));
					} else {
						writesheet.addCell(new Label(j, i, (String) entry.getValue()));
					}
					j++;
				}
			}
			wwb.write();
			wwb.close();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		Data_Extract(1,1,5,2,3);
	}
	
}
