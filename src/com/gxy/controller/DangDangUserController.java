package com.gxy.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Producer;
import com.gxy.entity.DangDangUser;
import com.gxy.service.DangDangUserService;
import com.gxy.util.MD5Util;
import com.gxy.util.RandomCharecters;

@Controller
@RequestMapping("/user")
public class DangDangUserController {
	@Autowired
	private DangDangUserService dangdangUserService;
	@Autowired
	private Producer producer;
	//登录
	@RequestMapping("/login")
	@ResponseBody
	public String login(DangDangUser dangdangUser,HttpSession session) throws IOException {
		//获取页面账号
		String ddUserEmail = dangdangUser.getDdUserEmail();
		//获取页面密码
		String ddUserPassword = dangdangUser.getDdUserPassword();
		List<DangDangUser> login = dangdangUserService.login(ddUserEmail);
		//取出盐值
		String salt = login.get(0).getDdUserSalt();
		//取出密码
		String ddUserPasswordSalt = login.get(0).getDdUserPassword();
		if (MD5Util.md5(ddUserPassword+salt).equals(ddUserPasswordSalt)) {
			String ddUserNickname = login.get(0).getDdUserNickname();
			session.setAttribute("user", ddUserNickname);
			int ddUserId = login.get(0).getDdUserId();
			//保存登录用户的id
			session.setAttribute("ddUserId", ddUserId);
			return "true";
		}
		return "false";
	}
	//注销
	@RequestMapping("/clearSessionUser")
	public String clearSessionUser(HttpSession session) throws IOException {
		session.invalidate();
		return "redirect:/user/login.jsp";
	}
	//验证码
	@RequestMapping("/validateCode")
	public void Check(HttpSession session,HttpServletResponse response) throws IOException {
		//获取验证码字符
		String kaptcha = producer.createText();
		//保留验证码，存储在session
		session.setAttribute("kaptcha", kaptcha);
		//把字符加干扰线装进图片
		BufferedImage image = producer.createImage(kaptcha);
		try {
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//注册
	@RequestMapping("/registUser")
	@ResponseBody
	public boolean register1(DangDangUser dangdangUser,HttpSession session,String verifyCode) throws IOException {
		//加盐
		String ddUserSalt = RandomCharecters.getRandomString(4);
		//获取session中的验证码
		String kaptcha = (String) session.getAttribute("kaptcha");
		if (verifyCode.equals(kaptcha)) {
			dangdangUser.setDdUserEmail(dangdangUser.getDdUserEmail());
			dangdangUser.setDdUserNickname(dangdangUser.getDdUserNickname());
			dangdangUser.setDdUserPassword(MD5Util.md5(dangdangUser.getDdUserPassword()+ddUserSalt));
			dangdangUser.setDdUserSalt(ddUserSalt);
			session.setAttribute("register1", dangdangUser);
			return true;
		}
		return false;
	}
	//添加用户
	@RequestMapping("/insertUser")
	@ResponseBody
	public boolean register2(HttpSession session) throws IOException {
		//获取session中的注册用户信息
		DangDangUser user = (DangDangUser) session.getAttribute("register1");
		int i = dangdangUserService.insert(user);
		if (i>0) {
			return true;
		}
		return false;
	}

}
