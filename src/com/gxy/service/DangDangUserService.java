package com.gxy.service;

import java.io.IOException;
import java.util.List;


import com.gxy.entity.DangDangUser;

public interface DangDangUserService  {
	//��¼
	public List<DangDangUser> login(String ddUserEmail) throws IOException;
	//ע��
	public int insert(DangDangUser user) throws IOException;
}
