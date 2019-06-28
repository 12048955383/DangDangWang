package com.gxy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.entity.Cart;
import com.gxy.service.CartService;
@Service
public class CartServiceImpl implements CartService {
	//�½����ﳵ
	public List<Cart> getCar(HttpSession session){
		//��ʼ��list
		List<Cart> cart =null;
		//���Դ�session��ȡ���ﳵ
		cart = (List<Cart>) session.getAttribute("cartList");
		if (cart == null) {
			//û�й��ﳵ���½����ﳵ
			cart = new ArrayList<Cart>();
		}
		return cart;
	}
	//���ﳵ���
	public List<Cart> addCar(List<Cart> cart,Cart book){
		//��ȡ���ﳵid
		int bookId = book.getBookId();
		for (Cart b : cart) {
			//��ʾ��Ʒ�ظ�
			if (bookId == b.getBookId()) {
				//�������Ʒ������+1
				int count = b.getBookCount();
				b.setBookCount(++count);
				return cart;
			}
		}
		//�ж��Ƿ�������
		int count = book.getBookCount();
		//����Ϊ1
		if (count == 0) {
			book.setBookCount(1);
		}else {
			//�ָ�ԭ����
			book.setBookCount(count);
		}
		cart.add(book);
		return cart;
	}
	//���㹺�ﳵ�۸�
	public Map<String,Double> countPrice(List<Cart> cartList){
		//��ʼ������
		HashMap<String, Double> map = new HashMap<String, Double>();
		//��ʼ���г��ܼ�
		double totalPrice = 0;
		//��ʼ�������۸�
		double totalDDPrice = 0;
		if (cartList != null) {
			for (Cart c : cartList) {
				totalPrice = totalPrice + c.getBookPrice() * c.getBookCount();
				totalDDPrice = totalDDPrice + c.getBookDdprice() * c.getBookCount();
			}
		}
		map.put("totalPrice", totalPrice);
		map.put("totalDDPrice", totalDDPrice);
		return map;
	}
	//ɾ�����ָ���
	public List<Cart> removeToStore(HttpSession session,Cart book){
		//��ʼ���ָ���
		List<Cart> cartList2 = null;
		//���Ի�ȡsession�еĹ��ﳵ
		cartList2 = (List<Cart>) session.getAttribute("cartList2");
		if (cartList2 == null) {
			//û�лָ������Ƚ�һ��
			cartList2 = new ArrayList<Cart>();
		}
		for (Cart cart : cartList2) {
			if (book.getBookId() == cart.getBookId()) {
				//�����Ʒ�ظ���ֵ������Ʒ����
				int count = cart.getBookCount();
				cart.setBookCount(count+cart.getBookCount());
				return cartList2;
			}
		}
		//������ظ���ֱ�����
		cartList2.add(book);
		return cartList2;
	}
}
