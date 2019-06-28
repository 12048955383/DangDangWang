package com.gxy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxy.entity.DangdangAddress;
import com.gxy.service.DangdangAddressService;

@Controller
@RequestMapping("/address")
public class DangdangAddressController {
	@Autowired
	private DangdangAddressService addressService;
	@RequestMapping("/insertAddress")
	@ResponseBody
	//������û���ַ
	public boolean insertAddress(HttpSession session,DangdangAddress address,String addressReceiveName,String addressAdd,String addressZipcode,String addressMobile,String bookName) {
		int ddUserId = (int) session.getAttribute("ddUserId");
		address.setDdUserId(ddUserId);
		address.setAddressReceiveName(addressReceiveName);
		address.setAddressAdd(addressAdd);
		address.setAddressMobile(addressMobile);
		address.setAddressZipcode(addressZipcode);
		int insertAddress = addressService.insertAddress(address);
		if (insertAddress>0) {
			return true;
		}
		return false;
	}
	@RequestMapping("/queryAddress")
	@ResponseBody
	//��ѯ���û��µ����е�ַ
	public List<DangdangAddress> queryAddress(HttpSession session){
		int ddUserId = (int) session.getAttribute("ddUserId");
		List<DangdangAddress> list = addressService.selectAddress(ddUserId);
		for (DangdangAddress dangdangAddress : list) {
			int addressId = dangdangAddress.getAddressId();
			session.setAttribute("addressId", addressId);
		}
		return list;
	}
	@RequestMapping("/addressChange")
	@ResponseBody
	//�ı��ַ��Ϣ
	public DangdangAddress addressChange(int addressId) {
		 DangdangAddress address = addressService.ChangeAddress(addressId).get(0);
		 return address;
	}
}
