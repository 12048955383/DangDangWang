package com.gxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangUser;

public interface DangDangUserDao {
	//µÇÂ¼
	public List<DangDangUser> selectByname(@Param("ddUserEmail")String ddUserEmail);
	//×¢²á
	public int insert(@Param("dangdangUser")DangDangUser user);
}
