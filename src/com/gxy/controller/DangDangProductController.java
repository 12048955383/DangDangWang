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
	//�Ƽ�ͼ��
	@RequestMapping("/selectRecommed")
	public String product(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectAll();
		model.addAttribute("list", list);
		return "forward:/main/recommend.jsp";
	}
	//����ͼ��
	@RequestMapping("/selectHot")
	public String productHot(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectByCount();
		model.addAttribute("list", list);
		return "forward:/main/hot.jsp";
	}
	//�����ϼ�
	@RequestMapping("/selectNew")
	public String productNew(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectByNew();
		model.addAttribute("list", list);
		return "forward:/main/new.jsp";
	}
	//��������
	@RequestMapping("/selectHotBoard")
	public String selectHotBoard(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectByNewhot();
		model.addAttribute("list", list);
		return "forward:/main/hotBoard.jsp";
	}
	//��������������ʾ
	@RequestMapping("/selectHotBoardMore")
	@ResponseBody
	public List<DangDangProduct> selectHotBoardMore(Model model) throws IOException {
		List<DangDangProduct> list = dangDangProductService.selectByNewhotMore();
		return list;
	}
	//����������ʾ��Ʒ
	@RequestMapping("/selectProductAndCategory")
	public String selectProductAndCategory(Model model,String id,String ddProductName,String ddProductAuthor,String ddProductPress) throws IOException {
		//��ѯ��������
		List<DangDangCategory1> categoryList = dangDangCategory1Service.selectByCategory();
		//����id��ѯ�б��µ���Ʒ��Ϣ
		List<DangDangProduct> productList = dangDangProductService.selectByCategory1(id,ddProductName,ddProductAuthor,ddProductPress);
		model.addAttribute("ddProductName", ddProductName);
		model.addAttribute("ddProductAuthor", ddProductAuthor);
		model.addAttribute("ddProductPress", ddProductPress);
		//ͳ��һ����������
		Map<String, Integer> c1Map = dangDangCategory1Service.selectCategory1();
		//ͳ�ƶ�����������
		Map<String, Integer> c2Map = dangDangCategory2Service.selectCategory2();
		//��ʼ��ȫ����������
		int totalCategoryCount = 0;
		for (DangDangCategory1 c1 : categoryList) {
			//��ȡһ������id
			String ddCategory1Id = String.valueOf(c1.getDdCategory1Id());
			//��ȡһ����������
			Integer ddCategory1Count = c1Map.get(ddCategory1Id);
			//��ֵ����
			if (ddCategory1Count == null) {
				ddCategory1Count = 0;
			}
			//����ȫ����
			totalCategoryCount = totalCategoryCount + ddCategory1Count;
			//����һ����������
			c1.setDdCategory1Count(ddCategory1Count);
			//������������
			for (DangDangCategory2 c2 : c1.getListCategory2()) {
				//��ȡ��������id
				String ddCategory2Id = String.valueOf(c2.getDdCategory2Id());
				//��ȡ������������
				Integer ddCategory2Count = c2Map.get(ddCategory2Id);
				//��ֵ����
				if (ddCategory2Count == null) {
					ddCategory2Count = 0;
				}
				//���������������
				c2.setDdCategory2Count(ddCategory2Count);
			}
		}
		//�������LIst
		model.addAttribute("categoryList",categoryList);
		//����ѡ��id
		model.addAttribute("productList",productList);
		model.addAttribute("chooseId",id);
		//����ȫ��������
		model.addAttribute("totalCategoryCount",totalCategoryCount);
		return "forward:/main/book_list.jsp";
	}
	//��̬���ز�ѯ-������
	@RequestMapping("/searchPress")
	@ResponseBody
	public List<String> searchPress() throws IOException{
		List<String> list = dangDangProductService.selectByPress();
		return list;
	}
	//ͼ������ҳ
	@RequestMapping("/selectById")
	public String selectById(Model model,int ddProductId) throws IOException {
		List<DangDangProduct> product = dangDangProductService.selectByid(ddProductId);
		model.addAttribute("product",product);
		return "forward:/main/product.jsp";
	}
}
