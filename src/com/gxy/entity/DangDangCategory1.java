package com.gxy.entity;

import java.util.Date;
import java.util.List;

public class DangDangCategory1 {
	//id1
	private int ddCategory1Id;

	//Ãû×Ö1
	private String ddCategory1Name;

	//Ê±¼ä´Á
	private Date ddCategory1CreateDate;

	private List<DangDangCategory2> listCategory2;
	
	private int ddCategory1Count;
	
	public DangDangCategory1() {
		super();
	}

	
	public int getDdCategory1Count() {
		return ddCategory1Count;
	}


	public void setDdCategory1Count(int ddCategory1Count) {
		this.ddCategory1Count = ddCategory1Count;
	}


	public List<DangDangCategory2> getListCategory2() {
		return listCategory2;
	}

	public void setListCategory2(List<DangDangCategory2> listCategory2) {
		this.listCategory2 = listCategory2;
	}


	public int getDdCategory1Id() {
		return ddCategory1Id;
	}

	public void setDdCategory1Id(int ddCategory1Id) {
		this.ddCategory1Id = ddCategory1Id;
	}

	public String getDdCategory1Name() {
		return ddCategory1Name;
	}

	public void setDdCategory1Name(String ddCategory1Name) {
		this.ddCategory1Name = ddCategory1Name;
	}

	public Date getDdCategory1CreateDate() {
		return ddCategory1CreateDate;
	}

	public void setDdCategory1CreateDate(Date ddCategory1CreateDate) {
		this.ddCategory1CreateDate = ddCategory1CreateDate;
	}


	@Override
	public String toString() {
		return "DangDangCategory1 [ddCategory1Id=" + ddCategory1Id + ", ddCategory1Name=" + ddCategory1Name
				+ ", ddCategory1CreateDate=" + ddCategory1CreateDate + ", listCategory2=" + listCategory2
				+ ", ddCategory1Count=" + ddCategory1Count + "]";
	}

}