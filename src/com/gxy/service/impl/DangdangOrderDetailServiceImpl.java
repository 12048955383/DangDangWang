package com.gxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.DangdangOrderDetailDao;
import com.gxy.entity.DangdangOrderDetail;
import com.gxy.service.DangdangOrderDetailService;
@Service
public class DangdangOrderDetailServiceImpl implements DangdangOrderDetailService {
	@Autowired
	private DangdangOrderDetailDao orderDetailDao;
	//≤Â»Î∂©µ•œÍ«È
	public int insertOrderDetail(DangdangOrderDetail orderDetail) {
		int detail = orderDetailDao.insertOrderDetail(orderDetail);
		return detail;
	}
}
