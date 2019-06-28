package com.gxy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangCategory2;
import com.gxy.entity.DangDangProduct;

public interface DangDangProductDao {
	//主页推荐图书
	public List<DangDangProduct> selectAll();
	//主页热销图书
	public List<DangDangProduct> selectByCount();
	//主页新书上架
	public List<DangDangProduct> selectByNew();
	//主页新书热销
	public List<DangDangProduct> selectByNewhot();
	//主页新书热销更多
	public List<DangDangProduct> selectByNewhotMore();
	//图书详情页
	public List<DangDangProduct> selectByid(@Param("ddProductId")int ddProductId);
	//一级列表显示/搜索
	public List<DangDangProduct> selectByCategory1(@Param("id")String id,
												   @Param("ddProductName") String ddProductName,
												   @Param("ddProductAuthor") String ddProductAuthor,
												   @Param("ddProductPress") String ddProductPress);
	//动态查询出版社
	public List<String> selectByPress();
}
