package com.gxy.entity;

import java.util.Date;
import java.util.List;

public class DangDangCategory2 {
    //id2
    private int ddCategory2Id;
    //名字2
    private String ddCategory2Name;
    //id1
    private int ddCategory1Id;
    //时间戳
    private Date ddCategory2CreateDate;
    //关联product表
    private int ddCategory2Count;
    
    
    public DangDangCategory2() {
		super();
	}


	public int getDdCategory2Count() {
		return ddCategory2Count;
	}

	public void setDdCategory2Count(int ddCategory2Count) {
		this.ddCategory2Count = ddCategory2Count;
	}


	public int getDdCategory2Id() {
        return ddCategory2Id;
    }

    public void setDdCategory2Id(int ddCategory2Id) {
        this.ddCategory2Id = ddCategory2Id;
    }

    public String getDdCategory2Name() {
        return ddCategory2Name;
    }

    public void setDdCategory2Name(String ddCategory2Name) {
        this.ddCategory2Name = ddCategory2Name;
    }

    public int getDdCategory1Id() {
        return ddCategory1Id;
    }

    public void setDdCategory1Id(int ddCategory1Id) {
        this.ddCategory1Id = ddCategory1Id;
    }

    public Date getDdCategory2CreateDate() {
        return ddCategory2CreateDate;
    }

    public void setDdCategory2CreateDate(Date ddCategory2CreateDate) {
        this.ddCategory2CreateDate = ddCategory2CreateDate;
    }


	@Override
	public String toString() {
		return "DangDangCategory2 [ddCategory2Id=" + ddCategory2Id + ", ddCategory2Name=" + ddCategory2Name
				+ ", ddCategory1Id=" + ddCategory1Id + ", ddCategory2CreateDate=" + ddCategory2CreateDate
				+ ", ddCategory2Count=" + ddCategory2Count + "]";
	}


}