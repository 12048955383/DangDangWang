package com.gxy.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.gxy.entity.DangDangCategory1;

public interface DangDangCategory1Service {
	//����ѯ
	public List<DangDangCategory1> selectByCategory() throws IOException;
	//ͳ�Ƹ���ͼ�������
	public Map<String, Integer> selectCategory1()throws IOException;
}
