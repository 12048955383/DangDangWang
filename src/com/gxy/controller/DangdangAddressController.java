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
	//保存该用户地址
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
	//查询该用户下的所有地址
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
	//改变地址信息
	public DangdangAddress addressChange(int addressId) {
		 DangdangAddress address = addressService.ChangeAddress(addressId).get(0);
		 return address;
	}
}
