package com.gxy.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.DangDangCategory1Dao;
import com.gxy.entity.DangDangCategory1;
import com.gxy.service.DangDangCategory1Service;
@Service
public class DangDangCategory1ServiceImpl implements DangDangCategory1Service {

	@Autowired
	private DangDangCategory1Dao dangDangCategory1Dao;
	//多表查询
	public List<DangDangCategory1> selectByCategory()throws IOException {
		List<DangDangCategory1> list = dangDangCategory1Dao.selectByCategory();
		return list;
	}
	
	//统计各类图书的数量
	public Map<String, Integer> selectCategory1()throws IOException {
		List<Map<String, Object>> list = dangDangCategory1Dao.selectCategory1();
		//初始化一级分类Map
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (Map<String, Object> m : list) {
			//获取一级分类
			String ddCategory1Id = m.get("ddCategory1Id").toString();
			//获取一级分类数量
			int category1Count = Integer.parseInt(m.get("ddCategory1Count").toString());
			map.put(ddCategory1Id, category1Count);
		}
		return map;
	}
}
