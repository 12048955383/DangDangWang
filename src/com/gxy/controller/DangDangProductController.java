package com.gxy.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxy.dao.DangDangCategory1Dao;
import com.gxy.dao.DangDangProductDao;
import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangCategory2;
import com.gxy.entity.DangDangProduct;
import com.gxy.service.DangDangCategory1Service;
import com.gxy.service.DangDangCategory2Service;
import com.gxy.service.DangDangProductService;
@RequestMapping("/product")
@Controller
public class DangDangProductController {
	@Autowired
	private DangDangProductService dangDangProductService;
	@Autowired
	private DangDangCategory1Service dangDangCategory1Service;
	@Autowired
	private DangDangCategory2Service dangDangCategory2Service;
	//推荐图书
	@RequestMapping("/selectRecommed")
	public String product(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectAll();
		model.addAttribute("list", list);
		return "forward:/main/recommend.jsp";
	}
	//热销图书
	@RequestMapping("/selectHot")
	public String productHot(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectByCount();
		model.addAttribute("list", list);
		return "forward:/main/hot.jsp";
	}
	//新书上架
	@RequestMapping("/selectNew")
	public String productNew(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectByNew();
		model.addAttribute("list", list);
		return "forward:/main/new.jsp";
	}
	//新书热销
	@RequestMapping("/selectHotBoard")
	public String selectHotBoard(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectByNewhot();
		model.addAttribute("list", list);
		return "forward:/main/hotBoard.jsp";
	}
	//新书热销更多显示
	@RequestMapping("/selectHotBoardMore")
	@ResponseBody
	public List<DangDangProduct> selectHotBoardMore(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectByNewhotMore();
		return list;
	}
	//数量及其显示商品
	@RequestMapping("/selectProductAndCategory")
	public String selectProductAndCategory(Model model,String id,String ddProductName,String ddProductAuthor,String ddProductPress) throws IOException {
		//查询关联分类
		List<DangDangCategory1> categoryList = dangDangCategory1Service.selectByCategory();
		//根据id查询列表下的商品信息
		List<DangDangProduct> productList = dangDangProductService.selectByCategory1(id,ddProductName,ddProductAuthor,ddProductPress);
		model.addAttribute("ddProductName", ddProductName);
		model.addAttribute("ddProductAuthor", ddProductAuthor);
		model.addAttribute("ddProductPress", ddProductPress);
		//统计一级分类数量
		Map<String, Integer> c1Map = dangDangCategory1Service.selectCategory1();
		//统计二级分类数量
		Map<String, Integer> c2Map = dangDangCategory2Service.selectCategory2();
		//初始化全部分类数量
		int totalCategoryCount = 0;
		for (DangDangCategory1 c1 : categoryList) {
			//获取一级分类id
			String ddCategory1Id = String.valueOf(c1.getDdCategory1Id());
			//获取一级分类数量
			Integer ddCategory1Count = c1Map.get(ddCategory1Id);
			//空值处理
			if (ddCategory1Count == null) {
				ddCategory1Count = 0;
			}
			//叠加全部量
			totalCategoryCount = totalCategoryCount + ddCategory1Count;
			//放入一级分类数量
			c1.setDdCategory1Count(ddCategory1Count);
			//遍历二级分类
			for (DangDangCategory2 c2 : c1.getListCategory2()) {
				//获取二级分类id
				String ddCategory2Id = String.valueOf(c2.getDdCategory2Id());
				//获取二级分类数量
				Integer ddCategory2Count = c2Map.get(ddCategory2Id);
				//空值处理
				if (ddCategory2Count == null) {
					ddCategory2Count = 0;
				}
				//放入二级分类数量
				c2.setDdCategory2Count(ddCategory2Count);
			}
		}
		//放入分类LIst
		model.addAttribute("categoryList",categoryList);
		//放入选中id
		model.addAttribute("productList",productList);
		model.addAttribute("chooseId",id);
		//放入全部分类量
		model.addAttribute("totalCategoryCount",totalCategoryCount);
		return "forward:/main/book_list.jsp";
	}
	//动态加载查询-出版社
	@RequestMapping("/searchPress")
	@ResponseBody
	public List<String> searchPress() throws IOException{
		List<String> list = dangDangProductService.selectByPress();
		return list;
	}
	//图书详情页
	@RequestMapping("/selectById")
	public String selectById(Model model,int ddProductId) throws IOException {
		List<DangDangProduct> product = dangDangProductService.selectByid(ddProductId);
		model.addAttribute("product",product);
		return "forward:/main/product.jsp";
	}
}
