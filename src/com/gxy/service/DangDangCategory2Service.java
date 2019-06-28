package com.gxy.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DangDangCategory2Service {
	//统计各类图书的数量
	public Map<String, Integer> selectCategory2() throws IOException ;
}
