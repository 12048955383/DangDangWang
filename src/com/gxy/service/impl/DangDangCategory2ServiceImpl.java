package com.gxy.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.DangDangCategory2Dao;
import com.gxy.service.DangDangCategory2Service;
@Service
public class DangDangCategory2ServiceImpl implements DangDangCategory2Service {
	@Autowired
	private DangDangCategory2Dao dangDangCategory2Dao;
	//ͳ�Ƹ���ͼ�������
	public Map<String, Integer> selectCategory2() throws IOException {
		List<Map<String, Object>> list = dangDangCategory2Dao.selectCategory2();
		//��ʼ����������Map
		Map<String, Integer> map = new HashMap<String,Integer>();
		for (Map<String, Object> m : list) {
			//��ȡ��������
			String ddCategory2Id = m.get("ddCategory2Id").toString();
			//��ȡ������������
			int category2Count = Integer.parseInt(m.get("ddCategory2Count").toString());
			map.put(ddCategory2Id, category2Count);
		}
		return map;
	}

}
