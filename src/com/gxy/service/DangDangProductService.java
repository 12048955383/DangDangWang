package com.gxy.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.Cart;
import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangCategory2;
import com.gxy.entity.DangDangProduct;

public interface DangDangProductService {
	//主页推荐图书
	public List<DangDangProduct> selectAll() throws IOException;
	//主页热销图书
	public List<DangDangProduct> selectByCount() throws IOException;
	//主页新书上架
	public List<DangDangProduct> selectByNew() throws IOException;
	//主页新书热销
	public List<DangDangProduct> selectByNewhot() throws IOException;
	//主页新书热销更多
	public List<DangDangProduct> selectByNewhotMore() throws IOException;
	//图书详情页
	public List<DangDangProduct> selectByid(int ddProductId) throws IOException;
	//一、二级列表显示/搜索
	public List<DangDangProduct> selectByCategory1(String id,String ddProductName,String ddProductAuthor,String ddProductPress) throws IOException;
	//动态查询出版社
	public List<String> selectByPress()throws IOException;
	//DTO数据传递
	public Cart transferProduct(List<DangDangProduct> product);
}
