package com.gxy.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.gxy.entity.DangDangCategory1;

public interface DangDangCategory1Service {
	//多表查询
	public List<DangDangCategory1> selectByCategory() throws IOException;
	//统计各类图书的数量
	public Map<String, Integer> selectCategory1()throws IOException;
}
