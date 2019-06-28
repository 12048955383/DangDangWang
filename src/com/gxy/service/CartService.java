package com.gxy.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.gxy.entity.Cart;

public interface CartService {
	//��ȡ���ﳵ
	public List<Cart> getCar(HttpSession session);
	//���ﳵ���
	public List<Cart> addCar(List<Cart> cart,Cart book);
	//���㹺�ﳵ�۸�
	public Map<String,Double> countPrice(List<Cart> cart);
	//ɾ�����ָ���
	public List<Cart> removeToStore(HttpSession session,Cart book);
}
