package com.gxy.service;

import java.util.List;

import com.gxy.entity.DangdangAddress;

public interface DangdangAddressService {
	//�����ַ
	public int insertAddress(DangdangAddress address);
	//��ѯ�û������е�ַ
	public List<DangdangAddress> selectAddress(int ddUserId);
	//ѡ�и��û���ַ�������
	public List<DangdangAddress> ChangeAddress(int addressId);
}
