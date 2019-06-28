package com.gxy.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.gxy.entity.Cart;

public interface CartService {
	//获取购物车
	public List<Cart> getCar(HttpSession session);
	//购物车添加
	public List<Cart> addCar(List<Cart> cart,Cart book);
	//计算购物车价格
	public Map<String,Double> countPrice(List<Cart> cart);
	//删除到恢复区
	public List<Cart> removeToStore(HttpSession session,Cart book);
}
