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
	//新建购物车
	public List<Cart> getCar(HttpSession session){
		//初始化list
		List<Cart> cart =null;
		//尝试从session获取购物车
		cart = (List<Cart>) session.getAttribute("cartList");
		if (cart == null) {
			//没有购物车就新建购物车
			cart = new ArrayList<Cart>();
		}
		return cart;
	}
	//购物车添加
	public List<Cart> addCar(List<Cart> cart,Cart book){
		//获取购物车id
		int bookId = book.getBookId();
		for (Cart b : cart) {
			//显示商品重复
			if (bookId == b.getBookId()) {
				//不添加商品，数量+1
				int count = b.getBookCount();
				b.setBookCount(++count);
				return cart;
			}
		}
		//判断是否是新书
		int count = book.getBookCount();
		//书量为1
		if (count == 0) {
			book.setBookCount(1);
		}else {
			//恢复原数量
			book.setBookCount(count);
		}
		cart.add(book);
		return cart;
	}
	//计算购物车价格
	public Map<String,Double> countPrice(List<Cart> cartList){
		//初始化参数
		HashMap<String, Double> map = new HashMap<String, Double>();
		//初始化市场总价
		double totalPrice = 0;
		//初始化当当价格
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
	//删除到恢复区
	public List<Cart> removeToStore(HttpSession session,Cart book){
		//初始化恢复区
		List<Cart> cartList2 = null;
		//尝试获取session中的购物车
		cartList2 = (List<Cart>) session.getAttribute("cartList2");
		if (cartList2 == null) {
			//没有恢复区就先建一个
			cartList2 = new ArrayList<Cart>();
		}
		for (Cart cart : cartList2) {
			if (book.getBookId() == cart.getBookId()) {
				//如果商品重复，值叠加商品数量
				int count = cart.getBookCount();
				cart.setBookCount(count+cart.getBookCount());
				return cartList2;
			}
		}
		//如果不重复。直接添加
		cartList2.add(book);
		return cartList2;
	}
}
