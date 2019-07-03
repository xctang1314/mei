package com.cn.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.model.city;
import com.cn.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	@Autowired
     private CityService cityService;
	@RequestMapping("/show")
	public String toIndex(HttpServletRequest request,Model model){
		Integer i=1;
		city ci = this.cityService.selectByPK(i);
		System.out.println(ci.getName());
		model.addAttribute("user", ci);
		return "show";
	}
	@RequestMapping("/showAll")
	public String showAll(Model model){
		ArrayList<city> cit=this.cityService.selectA();
		model.addAttribute("ci",cit);
		return "showAll";
	}
	
	@RequestMapping("/createNew")
	public String create(){
		return "createNew";
	}
	@RequestMapping("/createNew1")
	public String create1(HttpServletRequest req,HttpServletResponse res){
		String str=req.getServletPath();
		System.out.println(str);
		//city ci;
		String i=req.getParameter("id");
		int j=Integer.parseInt(i);
		System.out.println(j);
		String name=req.getParameter("name");
		System.out.println(name);
		String countrycode=req.getParameter("countrycode");
		System.out.println(countrycode);
		String district=req.getParameter("district");
		System.out.println(district);
		String population=req.getParameter("population");
		int k=Integer.parseInt(population);
		System.out.println(k);
		city ci=new city();
		ci.setName(name);
		ci.setCountrycode(countrycode);
		ci.setDistrict(district);
		ci.setPopulation(k);
		ci.setId(j);
		//System.out.println(ci.getName());
		this.cityService.creatNew(ci);

		//System.out.println(i);

		return "createNew";
	}
}
