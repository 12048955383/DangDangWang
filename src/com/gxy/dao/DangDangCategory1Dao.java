package com.gxy.dao;

import java.util.List;
import java.util.Map;


import com.gxy.entity.DangDangCategory1;

public interface DangDangCategory1Dao {
	//����ѯ
	public List<DangDangCategory1> selectByCategory();
	//ͳ�Ƹ���ͼ�������
	public List<Map<String, Object>> selectCategory1();

}
