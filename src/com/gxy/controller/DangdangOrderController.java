package com.gxy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxy.entity.Cart;
import com.gxy.entity.DangdangAddress;
import com.gxy.entity.DangdangOrder;
import com.gxy.entity.DangdangOrderDetail;
import com.gxy.service.CartService;
import com.gxy.service.DangdangAddressService;
import com.gxy.service.DangdangOrderDetailService;
import com.gxy.service.DangdangOrderService;

@Controller
@RequestMapping("/order")
public class DangdangOrderController {
	@Autowired
	private DangdangOrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	private DangdangOrderDetailService orderDetailService;
	@Autowired
	private DangdangAddressService addressService;
	@RequestMapping("/createOrder")
	@ResponseBody
	public boolean createOrder(HttpSession session,DangdangOrder order,DangdangOrderDetail orderDetail,DangdangAddress address,String addressReceiveName,String addressAdd,String addressZipcode,String addressMobile,String bookName) {
		List<Cart> list = cartService.getCar(session);
		//获取登录用户的id
		int ddUserId = (int) session.getAttribute("ddUserId");
		//订单外键用户表id
		order.setDdUserId(ddUserId);
		//订单详情外键用户表id
		orderDetail.setDdUserId(ddUserId);
		//保存地址
		address.setDdUserId(ddUserId);
		address.setAddressReceiveName(addressReceiveName);
		address.setAddressAdd(addressAdd);
		address.setAddressMobile(addressMobile);
		address.setAddressZipcode(addressZipcode);
		addressService.insertAddress(address);
		//取出总价
		double totalDDPrice =  (Double) session.getAttribute("totalDDPrice");
		order.setOrderTotalprice(totalDDPrice);
		//插入订单
		int insertOrder = orderService.insertOrder(order);
		//查询订单号
		List<Map<Integer, Integer>> orderSsid = orderService.seletOrderSsid(ddUserId);
		for (Map<Integer, Integer> map : orderSsid) {
			session.setAttribute("orderSSID", map.get("orderSsid"));
		}
		//插入订单号
		orderDetail.setOrderSsid((String) session.getAttribute("orderSSID"));
		//插入地址id
		orderDetail.setAddressId(address.getAddressId());
		
		//循环出购物车的书
		for (Cart cart : list) {
			//插入订单详情图书名字
			orderDetail.setDetailProductName(cart.getBookName());
			//商品数量
			orderDetail.setDetailCount(cart.getBookCount());
			//商品当当价格
			orderDetail.setDetailDdprice(cart.getBookDdprice());
			//商品的id
			orderDetail.setDdProductId(cart.getBookId());
			//插入订单详情表
			int detail = orderDetailService.insertOrderDetail(orderDetail);
		}
		return true;
	}
}
