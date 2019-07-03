package com.cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.cn.model.LogData_Extract;

/**
 * Servlet implementation class LogData_ExtractServlet
 */
@WebServlet("/LogData_ExtractServlet")
public class LogData_ExtractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogData_ExtractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取form表单穿过来的抽取数据的起始行数、抽取的起始列数、抽取的结束列数、每隔几行读数据、每次抽取的行数
		// request.getParameter("")

		int row=Integer.parseInt(request.getParameter("row").trim());
		int col1=Integer.parseInt(request.getParameter("col1").trim());
		int col2=Integer.parseInt(request.getParameter("col2").trim());
		int num1=Integer.parseInt(request.getParameter("num1").trim());
		int num2=Integer.parseInt(request.getParameter("num2").trim());
		System.out.println(row+":"+col1+":"+col2+":"+num1+":"+num2);
		
		ArrayList<String>[] chanlist = null;
		/*for(int i=0;i<col2-col1+1;i++){
			chanlist[i]=new ArrayList<String>();
		}*/
		chanlist=LogData_Extract.Data_Extract(row, col1, col2, num1, num2);
		
		//将list集合转换成数组
		String[][]  array=new String[chanlist.length][chanlist[0].size()];
		for(int i=0;i<chanlist.length;i++){			
			//array[i]= (String[]) chanlist[i].toArray();
			//System.out.println("chanlist----------"+chanlist[0].toString());
			for(int j=0;j<chanlist[i].size();j++){
				//System.out.println(chanlist[i].toString());
				array[i][j]=chanlist[i].get(j);
			}						
		}
			
		JSONArray arr=new JSONArray();
		arr.add(array[3]);
		//System.out.println(arr.toJSONString());
		/*for(int i=0;i<chanlist.length;i++){
		System.out.println("+++++"+Arrays.deepToString(array));
		}*/
		
		request.setAttribute("array", arr);
			request.getRequestDispatcher("/jsp/DataExtraction.jsp").forward(request, response);
			
	}

}
