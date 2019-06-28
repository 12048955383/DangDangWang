package com.gxy.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxy.entity.DangDangCategory1;
import com.gxy.service.DangDangCategory1Service;

@Controller
public class DangDangCategory1Controller {
	@Autowired
	private DangDangCategory1Service dangDangCategory1Service;
	//×óÀ¸¿ªÊ¼
	@RequestMapping("/category/selectCategory")
	public String selectCategory(ModelMap model,DangDangCategory1 dangDangCategory1) throws IOException {
		List<DangDangCategory1> list = dangDangCategory1Service.selectByCategory();
		model.addAttribute("list", list);
		return "forward:/main/category.jsp";
	}
	
}
