package com.gxy.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.DangDangUserDao;
import com.gxy.entity.DangDangUser;
import com.gxy.service.DangDangUserService;
@Service
public class DangDangUserServiceImpl implements DangDangUserService {
	
	@Autowired
	private DangDangUserDao dangdangUserDao;
	//µÇÂ¼
	public List<DangDangUser> login(String ddUserEmail)throws IOException {
		List<DangDangUser> selectByname = dangdangUserDao.selectByname(ddUserEmail);
		return selectByname;
	}
	//×¢²á
	public int insert(DangDangUser user) throws IOException {
		int insert = dangdangUserDao.insert(user);
		return insert;
	}
	
	
}
