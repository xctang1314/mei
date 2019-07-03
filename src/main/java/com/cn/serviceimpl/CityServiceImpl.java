package com.cn.serviceimpl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.dao.cityMapper;
import com.cn.model.city;
import com.cn.service.CityService;
@Service
public class CityServiceImpl implements CityService{
    @Autowired
	private cityMapper city;
	@Override
	public city selectByPK(Integer id) {
		// TODO Auto-generated method stub
		return this.city.selectByPrimaryKey(id);
	}
	@Override
	public ArrayList<city> selectA() {
		// TODO Auto-generated method stub
		return this.city.selectAll();
	}
	@Override
	public void creatNew(city ci) {
		// TODO Auto-generated method stub
		this.city.insert(ci);
	}
	
}
