package com.cn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class ReadArray {
	@Test
	public void read(){
		String url="/mei/src/main/webapp/data/data.txt";
		File f=new File(url);
		try {
			FileInputStream fis=new FileInputStream(f);
			byte b[]=new byte[1024];
			int hasRead=0;   //读取字符数
			try {
				while((hasRead=fis.read(b))>0){
					//利用Response提交给前端页面。
					String s=new String(b,0,hasRead);
					//System.out.println(new String(b,0,hasRead));
				}
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
