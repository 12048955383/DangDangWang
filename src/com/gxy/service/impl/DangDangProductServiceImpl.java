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
	//�Ƽ�ͼ��
	public List<DangDangProduct> selectAll() throws IOException {
		List<DangDangProduct> list = dangDangProductDao.selectAll();
		return list;
	}
	//����ͼ��
	public List<DangDangProduct> selectByCount() throws IOException{
		List<DangDangProduct> list = dangDangProductDao.selectByCount();
		return list;
	}
	//�����ϼ�
	public List<DangDangProduct> selectByNew() throws IOException{
		List<DangDangProduct> list = dangDangProductDao.selectByNew();
		return list;
	}
	//��ҳ��������
	public List<DangDangProduct> selectByNewhot() throws IOException{
		List<DangDangProduct> list = dangDangProductDao.selectByNewhot();
		return list;
	}
	//��ҳ������������
	public List<DangDangProduct> selectByNewhotMore() throws IOException{
		List<DangDangProduct> list = dangDangProductDao.selectByNewhotMore();
		return list;
	}
	//ͼ������ҳ
	public List<DangDangProduct> selectByid(int ddProductId) throws IOException{
		List<DangDangProduct> product = dangDangProductDao.selectByid(ddProductId);
		return product;
	}
	//һ�������б���ʾ/����
	public List<DangDangProduct> selectByCategory1(String id,String ddProductName,String ddProductAuthor,String ddProductPress) throws IOException{
		List<DangDangProduct> category1 = dangDangProductDao.selectByCategory1(id,ddProductName,ddProductAuthor,ddProductPress);
		return category1;
	}
	//��̬��ѯ������
	public List<String> selectByPress()throws IOException{
		List<String> list = dangDangProductDao.selectByPress();
		return list;
	}
	//DTO���ݴ���
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
