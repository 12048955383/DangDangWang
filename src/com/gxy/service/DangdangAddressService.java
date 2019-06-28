package com.gxy.service;

import java.util.List;

import com.gxy.entity.DangdangAddress;

public interface DangdangAddressService {
	//保存地址
	public int insertAddress(DangdangAddress address);
	//查询用户下所有地址
	public List<DangdangAddress> selectAddress(int ddUserId);
	//选中该用户地址进行填充
	public List<DangdangAddress> ChangeAddress(int addressId);
}
