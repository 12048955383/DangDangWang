package com.gxy.service;

import java.util.List;
import java.util.Map;

import com.gxy.entity.DangdangOrder;

public interface DangdangOrderService {
	//���붩���б���Ϣ
	public int insertOrder(DangdangOrder order);
	//��ѯ�������
	public List<Map<Integer, Integer>> seletOrderSsid(int ddUserId);
}
