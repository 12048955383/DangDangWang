package com.gxy.dao;

import java.util.List;
import java.util.Map;


import com.gxy.entity.DangDangCategory1;

public interface DangDangCategory1Dao {
	//多表查询
	public List<DangDangCategory1> selectByCategory();
	//统计各类图书的数量
	public List<Map<String, Object>> selectCategory1();

}
