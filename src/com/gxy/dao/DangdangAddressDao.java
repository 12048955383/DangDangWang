package com.gxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangdangAddress;

public interface DangdangAddressDao {
	//�����ַ
	public int insertAddress(DangdangAddress address);
	//��ѯ�û������е�ַ
	public List<DangdangAddress> selectAddress(@Param("ddUserId")int ddUserId);
	//ѡ�и��û���ַ�������
	public List<DangdangAddress> ChangeAddress(@Param("addressId")int addressId);
}
