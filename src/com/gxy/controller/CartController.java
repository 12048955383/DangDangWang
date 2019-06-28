package com.gxy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxy.entity.Cart;
import com.gxy.entity.DangDangProduct;
import com.gxy.service.CartService;
import com.gxy.service.DangDangProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private DangDangProductService dangDangProductService;

	@RequestMapping("/getCart")
	@ResponseBody
	//获取购物车，并计算总价
	public Map<String,Double> getCar(HttpSession session){
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		Map<String, Double> map = cartService.countPrice(cartList);
		//计入当当总价存入session
		session.setAttribute("totalDDPrice", map.get("totalDDPrice"));
		return map;
	}
	@RequestMapping("/addBook")
	//添加输到购物车
	public String addBook(int id,HttpSession session) throws NumberFormatException, IOException {
		//获取购物车
		List<Cart> cartList = cartService.getCar(session);
		//查询商品信息
		List<DangDangProduct> product = dangDangProductService.selectByid(id);
		//DTO
		Cart book = dangDangProductService.transferProduct(product);
		//添加购物车list
		cartService.addCar(cartList, book);
		session.setAttribute("cartList", cartList);
		return "forward:cart/cart_list.jsp";
	}
	@RequestMapping("/setBookCount")
	@ResponseBody
	//修改商品数量
	public Boolean setBookCount(int id,int count,HttpSession session) {
		//获取购物车
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		//循环出商信息，查到id是否与要修改的id相等，如果相等set进去要修改的数量
		for (Cart c : cartList) {
			//判断是否是同样的商品
			if (c.getBookId() == id) {
				c.setBookCount(count);
				//将购物车存入session
				session.setAttribute("cartList", cartList);
				break;
			}
		}
		return true;
	}
	@RequestMapping("/deleteBook")
	public String deleteBook(int id,HttpSession session) {
		//获取购物车
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		for (Cart cart : cartList) {
			if (cart.getBookId() == id) {
				//删除到恢复区
				List<Cart> cartList2 = cartService.removeToStore(session, cart);
				//存入恢复区的session
				session.setAttribute("cartList2", cartList2);
				//删除目标图书
				cartList.remove(cart);
				//将购物车存入session
				session.setAttribute("cartList", cartList);
				//跳出循环
				break;
			}
		}
		return "redirect:/cart/cart_list.jsp";
	}
	@RequestMapping("/restoreBook")
	//恢复到购物车
	public String restoreBook(HttpSession session,int id) {
		//获取恢复区商品信息
		List<Cart> cartList2 = (List<Cart>) session.getAttribute("cartList2");
		for (Cart cart : cartList2) {
			if (id == cart.getBookId()) {
				//尝试获取购物车信息
				List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
				//添加到购物车/恢复到购物车
				cartService.addCar(cartList, cart);
				//移除恢复区的商品
				cartList2.remove(cart);
				//存入恢复区sesion
				session.setAttribute("cartList2", cartList2);
				break;
			}
		}
		return "redirect:/cart/cart_list.jsp";
	}
	@RequestMapping("/removeBook")
	//彻底删除
	public String removeBook(int id,HttpSession session) {
		//获取恢复区所有商品信息
		List<Cart> cartList2 = (List<Cart>) session.getAttribute("cartList2");
		for (Cart cart : cartList2) {
			if (id == cart.getBookId()) {
				cartList2.remove(cart);
				break;
			}
		}
		return "redirect:/cart/cart_list.jsp";
	}
}
