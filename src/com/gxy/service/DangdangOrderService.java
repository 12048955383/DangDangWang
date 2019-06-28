package com.gxy.service;

import java.util.List;
import java.util.Map;

import com.gxy.entity.DangdangOrder;

public interface DangdangOrderService {
	//插入订单列表信息
	public int insertOrder(DangdangOrder order);
	//查询订单编号
	public List<Map<Integer, Integer>> seletOrderSsid(int ddUserId);
}
