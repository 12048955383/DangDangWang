package com.gxy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangdangOrder;

public interface DangdangOrderDao {
	//插入订单列表信息
	public int insertOrder(DangdangOrder order);
	//查询订单编号
	public List<Map<Integer, Integer>> seletOrderSsid(@Param("ddUserId")int ddUserId);
}
