package com.gxy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangdangOrder;

public interface DangdangOrderDao {
	//���붩���б���Ϣ
	public int insertOrder(DangdangOrder order);
	//��ѯ�������
	public List<Map<Integer, Integer>> seletOrderSsid(@Param("ddUserId")int ddUserId);
}
