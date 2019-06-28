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
	//��¼
	@RequestMapping("/login")
	@ResponseBody
	public String login(DangDangUser dangdangUser,HttpSession session) throws IOException {
		//��ȡҳ���˺�
		String ddUserEmail = dangdangUser.getDdUserEmail();
		//��ȡҳ������
		String ddUserPassword = dangdangUser.getDdUserPassword();
		List<DangDangUser> login = dangdangUserService.login(ddUserEmail);
		//ȡ����ֵ
		String salt = login.get(0).getDdUserSalt();
		//ȡ������
		String ddUserPasswordSalt = login.get(0).getDdUserPassword();
		if (MD5Util.md5(ddUserPassword+salt).equals(ddUserPasswordSalt)) {
			String ddUserNickname = login.get(0).getDdUserNickname();
			session.setAttribute("user", ddUserNickname);
			int ddUserId = login.get(0).getDdUserId();
			//�����¼�û���id
			session.setAttribute("ddUserId", ddUserId);
			return "true";
		}
		return "false";
	}
	//ע��
	@RequestMapping("/clearSessionUser")
	public String clearSessionUser(HttpSession session) throws IOException {
		session.invalidate();
		return "redirect:/user/login.jsp";
	}
	//��֤��
	@RequestMapping("/validateCode")
	public void Check(HttpSession session,HttpServletResponse response) throws IOException {
		//��ȡ��֤���ַ�
		String kaptcha = producer.createText();
		//������֤�룬�洢��session
		session.setAttribute("kaptcha", kaptcha);
		//���ַ��Ӹ�����װ��ͼƬ
		BufferedImage image = producer.createImage(kaptcha);
		try {
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ע��
	@RequestMapping("/registUser")
	@ResponseBody
	public boolean register1(DangDangUser dangdangUser,HttpSession session,String verifyCode) throws IOException {
		//����
		String ddUserSalt = RandomCharecters.getRandomString(4);
		//��ȡsession�е���֤��
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
	//����û�
	@RequestMapping("/insertUser")
	@ResponseBody
	public boolean register2(HttpSession session) throws IOException {
		//��ȡsession�е�ע���û���Ϣ
		DangDangUser user = (DangDangUser) session.getAttribute("register1");
		int i = dangdangUserService.insert(user);
		if (i>0) {
			return true;
		}
		return false;
	}

}
