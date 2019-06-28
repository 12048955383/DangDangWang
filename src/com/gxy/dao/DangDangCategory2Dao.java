package com.gxy.dao;

import java.util.List;
import java.util.Map;

public interface DangDangCategory2Dao {
	//统计各类图书的数量
	public List<Map<String, Object>> selectCategory2();
}
