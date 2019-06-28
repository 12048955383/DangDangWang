package com.gxy.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.DangDangProductDao;
import com.gxy.entity.Cart;
import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangProduct;
import com.gxy.service.DangDangProductService;
@Service
public class DangDangProductServiceImpl implements DangDangProductService {

	@Autowired
	private DangDangProductDao dangDangProductDao;
	//推荐图书
	public List<DangDangProduct> selectAll() throws IOException {
		List<DangDangProduct> list = dangDangProductDao.selectAll();
		return list;
	}
	//热销图书
	public List<DangDangProduct> selectByCount() throws IOException{
		List<DangDangProduct> list = dangDangProductDao.selectByCount();
		return list;
	}
	//最新上架
	public List<DangDangProduct> selectByNew() throws IOException{
		List<DangDangProduct> list = dangDangProductDao.selectByNew();
		return list;
	}
	//主页新书热销
	public List<DangDangProduct> selectByNewhot() throws IOException{
		List<DangDangProduct> list = dangDangProductDao.selectByNewhot();
		return list;
	}
	//主页新书热销更多
	public List<DangDangProduct> selectByNewhotMore() throws IOException{
		List<DangDangProduct> list = dangDangProductDao.selectByNewhotMore();
		return list;
	}
	//图书详情页
	public List<DangDangProduct> selectByid(int ddProductId) throws IOException{
		List<DangDangProduct> product = dangDangProductDao.selectByid(ddProductId);
		return product;
	}
	//一、二级列表显示/搜索
	public List<DangDangProduct> selectByCategory1(String id,String ddProductName,String ddProductAuthor,String ddProductPress) throws IOException{
		List<DangDangProduct> category1 = dangDangProductDao.selectByCategory1(id,ddProductName,ddProductAuthor,ddProductPress);
		return category1;
	}
	//动态查询出版社
	public List<String> selectByPress()throws IOException{
		List<String> list = dangDangProductDao.selectByPress();
		return list;
	}
	//DTO数据传输
	public Cart transferProduct(List<DangDangProduct> product) {
		Cart cart = new Cart();
		for (DangDangProduct Product : product) {
			cart.setBookName(Product.getDdProductName());
			cart.setBookImg(Product.getDdProductImg());
			cart.setBookPrice(Product.getDdProductPrice());
			cart.setBookDdprice(Product.getDdProductDdprice());
			cart.setBookId(Product.getDdProductId());
		}
		return cart;
	}
}
