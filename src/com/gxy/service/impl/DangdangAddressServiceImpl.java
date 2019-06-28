package com.gxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.DangdangAddressDao;
import com.gxy.entity.DangdangAddress;
import com.gxy.service.DangdangAddressService;
@Service
public class DangdangAddressServiceImpl implements DangdangAddressService{
	@Autowired
	private DangdangAddressDao addressDao;
	//保存收货地址
	public int insertAddress(DangdangAddress address) {
		int insertAddress = addressDao.insertAddress(address);
		return insertAddress;
	}
	//查询用户下所有地址
	public List<DangdangAddress> selectAddress(int ddUserId) {
		List<DangdangAddress> selectAddress = addressDao.selectAddress(ddUserId);
		return selectAddress;
	}
	//选中该用户地址进行填充
	public List<DangdangAddress> ChangeAddress(int addressId){
		List<DangdangAddress> address = addressDao.ChangeAddress(addressId);
		return address;

	}
}
