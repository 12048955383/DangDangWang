package com.gxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangdangAddress;

public interface DangdangAddressDao {
	//保存地址
	public int insertAddress(DangdangAddress address);
	//查询用户下所有地址
	public List<DangdangAddress> selectAddress(@Param("ddUserId")int ddUserId);
	//选中该用户地址进行填充
	public List<DangdangAddress> ChangeAddress(@Param("addressId")int addressId);
}
