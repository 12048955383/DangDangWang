package com.gxy.service;

import java.io.IOException;
import java.util.List;


import com.gxy.entity.DangDangUser;

public interface DangDangUserService  {
	//µÇÂ¼
	public List<DangDangUser> login(String ddUserEmail) throws IOException;
	//×¢²á
	public int insert(DangDangUser user) throws IOException;
}
