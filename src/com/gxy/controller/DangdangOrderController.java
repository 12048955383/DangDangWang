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
		//��ȡ��¼�û���id
		int ddUserId = (int) session.getAttribute("ddUserId");
		//��������û���id
		order.setDdUserId(ddUserId);
		//������������û���id
		orderDetail.setDdUserId(ddUserId);
		//�����ַ
		address.setDdUserId(ddUserId);
		address.setAddressReceiveName(addressReceiveName);
		address.setAddressAdd(addressAdd);
		address.setAddressMobile(addressMobile);
		address.setAddressZipcode(addressZipcode);
		addressService.insertAddress(address);
		//ȡ���ܼ�
		double totalDDPrice =  (Double) session.getAttribute("totalDDPrice");
		order.setOrderTotalprice(totalDDPrice);
		//���붩��
		int insertOrder = orderService.insertOrder(order);
		//��ѯ������
		List<Map<Integer, Integer>> orderSsid = orderService.seletOrderSsid(ddUserId);
		for (Map<Integer, Integer> map : orderSsid) {
			session.setAttribute("orderSSID", map.get("orderSsid"));
		}
		//���붩����
		orderDetail.setOrderSsid((String) session.getAttribute("orderSSID"));
		//�����ַid
		orderDetail.setAddressId(address.getAddressId());
		
		//ѭ�������ﳵ����
		for (Cart cart : list) {
			//���붩������ͼ������
			orderDetail.setDetailProductName(cart.getBookName());
			//��Ʒ����
			orderDetail.setDetailCount(cart.getBookCount());
			//��Ʒ�����۸�
			orderDetail.setDetailDdprice(cart.getBookDdprice());
			//��Ʒ��id
			orderDetail.setDdProductId(cart.getBookId());
			//���붩�������
			int detail = orderDetailService.insertOrderDetail(orderDetail);
		}
		return true;
	}
}
