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
	//��ȡ���ﳵ���������ܼ�
	public Map<String,Double> getCar(HttpSession session){
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		Map<String, Double> map = cartService.countPrice(cartList);
		//���뵱���ܼ۴���session
		session.setAttribute("totalDDPrice", map.get("totalDDPrice"));
		return map;
	}
	@RequestMapping("/addBook")
	//����䵽���ﳵ
	public String addBook(int id,HttpSession session) throws NumberFormatException, IOException {
		//��ȡ���ﳵ
		List<Cart> cartList = cartService.getCar(session);
		//��ѯ��Ʒ��Ϣ
		List<DangDangProduct> product = dangDangProductService.selectByid(id);
		//DTO
		Cart book = dangDangProductService.transferProduct(product);
		//��ӹ��ﳵlist
		cartService.addCar(cartList, book);
		session.setAttribute("cartList", cartList);
		return "forward:cart/cart_list.jsp";
	}
	@RequestMapping("/setBookCount")
	@ResponseBody
	//�޸���Ʒ����
	public Boolean setBookCount(int id,int count,HttpSession session) {
		//��ȡ���ﳵ
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		//ѭ��������Ϣ���鵽id�Ƿ���Ҫ�޸ĵ�id��ȣ�������set��ȥҪ�޸ĵ�����
		for (Cart c : cartList) {
			//�ж��Ƿ���ͬ������Ʒ
			if (c.getBookId() == id) {
				c.setBookCount(count);
				//�����ﳵ����session
				session.setAttribute("cartList", cartList);
				break;
			}
		}
		return true;
	}
	@RequestMapping("/deleteBook")
	public String deleteBook(int id,HttpSession session) {
		//��ȡ���ﳵ
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		for (Cart cart : cartList) {
			if (cart.getBookId() == id) {
				//ɾ�����ָ���
				List<Cart> cartList2 = cartService.removeToStore(session, cart);
				//����ָ�����session
				session.setAttribute("cartList2", cartList2);
				//ɾ��Ŀ��ͼ��
				cartList.remove(cart);
				//�����ﳵ����session
				session.setAttribute("cartList", cartList);
				//����ѭ��
				break;
			}
		}
		return "redirect:/cart/cart_list.jsp";
	}
	@RequestMapping("/restoreBook")
	//�ָ������ﳵ
	public String restoreBook(HttpSession session,int id) {
		//��ȡ�ָ�����Ʒ��Ϣ
		List<Cart> cartList2 = (List<Cart>) session.getAttribute("cartList2");
		for (Cart cart : cartList2) {
			if (id == cart.getBookId()) {
				//���Ի�ȡ���ﳵ��Ϣ
				List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
				//��ӵ����ﳵ/�ָ������ﳵ
				cartService.addCar(cartList, cart);
				//�Ƴ��ָ�������Ʒ
				cartList2.remove(cart);
				//����ָ���sesion
				session.setAttribute("cartList2", cartList2);
				break;
			}
		}
		return "redirect:/cart/cart_list.jsp";
	}
	@RequestMapping("/removeBook")
	//����ɾ��
	public String removeBook(int id,HttpSession session) {
		//��ȡ�ָ���������Ʒ��Ϣ
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
