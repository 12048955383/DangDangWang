package com.gxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.DangdangOrderDao;
import com.gxy.entity.DangdangOrder;
import com.gxy.service.DangdangOrderService;
@Service
public class DangdangOrderServiceImpl implements DangdangOrderService {
	@Autowired
	private DangdangOrderDao orderDao;
	//���붩���б���Ϣ
	public int insertOrder(DangdangOrder order) {
		int insertOrder = orderDao.insertOrder(order);
		return insertOrder;
	}
	//��ѯ�������
	public List<Map<Integer, Integer>> seletOrderSsid(int ddUserId){
		List<Map<Integer,Integer>> orderSsid = orderDao.seletOrderSsid(ddUserId);
		return orderSsid;
	}

}
