package com.gxy.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxy.entity.Cart;
import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangProduct;
import com.gxy.entity.DangDangUser;
import com.gxy.entity.DangdangAddress;
import com.gxy.service.CartService;
import com.gxy.service.DangDangCategory1Service;
import com.gxy.service.DangDangProductService;
import com.gxy.service.DangDangUserService;
import com.gxy.service.DangdangAddressService;
import com.gxy.service.DangdangOrderService;
import com.gxy.util.RandomCharecters;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:com/gxy/config/applicationContext.xml"})
public class TestJunit {
	@Autowired
	private DangDangUserService dangDangUserService;
	@Autowired
	private DangDangProductService dangDangProductService;
	@Autowired
	private DangDangCategory1Service dangDangCategory1Service;
	@Autowired
	private CartService cartService;
	@Autowired
	private DangdangAddressService addressService;
	@Autowired
	private DangdangOrderService orderService;
	@Test
	public void method() throws IOException {
		List<DangDangUser> selectByname = dangDangUserService.login("admin");
		System.out.println(selectByname);
	}
	@Test
	public void method1() throws IOException {
		DangDangUser user = new DangDangUser();
		user.setDdUserEmail("1204895383");
		user.setDdUserNickname("a");
		user.setDdUserPassword("123456");
		user.setDdUserSalt("a");
		int insert = dangDangUserService.insert(user);
		System.out.println(insert);
	}
	@Test
	public void method2() throws IOException {
		List<DangDangCategory1> list = dangDangCategory1Service.selectByCategory();
		for (DangDangCategory1 dangDangCategory1 : list) {
			System.out.println(dangDangCategory1);
		}
	}
	@Test
	public void method3() throws IOException {
		List<DangDangProduct> selectByid = dangDangProductService.selectByid(28);
		System.out.println(selectByid);
	}
	@Test
	public void method4() throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectByNewhotMore();
		int m = 0;
		DangDangProduct dangDangProduct = list.get(m);
		System.out.println(dangDangProduct);
	}
	@Test
	public void method5() throws IOException {
		List<DangDangProduct> product = dangDangProductService.selectByid(28);
		Cart cart = dangDangProductService.transferProduct(product);
		System.out.println(cart);
	}
	@Test
	public void method6() throws IOException {
		DangdangAddress address = new DangdangAddress();
		address.setDdUserId(5);
		address.setAddressReceiveName("zs");
		address.setAddressAdd("±±¾©");
		address.setAddressZipcode("a");
		address.setAddressMobile("132");
		int insertAddress = addressService.insertAddress(address);
		int AddressId = address.getAddressId();
		System.out.println("id:"+AddressId);
		System.out.println(insertAddress);
	}
	@Test
	public void method7() throws IOException {
		List<DangdangAddress> selectAddress = addressService.selectAddress(7);
		System.out.println(selectAddress);
		}
}
