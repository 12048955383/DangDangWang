package com.gxy.entity;

import java.util.Date;

public class DangDangUser {
    //Ö÷¼ü
    private int ddUserId;

    //ÕËºÅ
    private String ddUserEmail;

    //ÃÜÂë
    private String ddUserPassword;

    //êÇ³Æ
    private String ddUserNickname;

    //ÓÃ»§×´Ì¬
    private Short ddUserState;

    //ÑÎÖµ
    private String ddUserSalt;

    //½ÇÉ«
    private String ddUserRole;

    //Ê±¼ä´Á
    private Date ddUserCreateDate;

    
    public DangDangUser() {
		super();
	}

	public int getDdUserId() {
        return ddUserId;
    }

    public void setDdUserId(int ddUserId) {
        this.ddUserId = ddUserId;
    }

    public String getDdUserEmail() {
        return ddUserEmail;
    }

    public void setDdUserEmail(String ddUserEmail) {
        this.ddUserEmail = ddUserEmail;
    }

    public String getDdUserPassword() {
        return ddUserPassword;
    }

    public void setDdUserPassword(String ddUserPassword) {
        this.ddUserPassword = ddUserPassword;
    }

    public String getDdUserNickname() {
        return ddUserNickname;
    }

    public void setDdUserNickname(String ddUserNickname) {
        this.ddUserNickname = ddUserNickname;
    }

    public Short getDdUserState() {
        return ddUserState;
    }

    public void setDdUserState(Short ddUserState) {
        this.ddUserState = ddUserState;
    }

    public String getDdUserSalt() {
        return ddUserSalt;
    }

    public void setDdUserSalt(String ddUserSalt) {
        this.ddUserSalt = ddUserSalt;
    }

    public String getDdUserRole() {
        return ddUserRole;
    }

    public void setDdUserRole(String ddUserRole) {
        this.ddUserRole = ddUserRole;
    }

    public Date getDdUserCreateDate() {
        return ddUserCreateDate;
    }

    public void setDdUserCreateDate(Date ddUserCreateDate) {
        this.ddUserCreateDate = ddUserCreateDate;
    }

	@Override
	public String toString() {
		return "DangDangUser [ddUserId=" + ddUserId + ", ddUserEmail=" + ddUserEmail + ", ddUserPassword="
				+ ddUserPassword + ", ddUserNickname=" + ddUserNickname + ", ddUserState=" + ddUserState
				+ ", ddUserSalt=" + ddUserSalt + ", ddUserRole=" + ddUserRole + ", ddUserCreateDate=" + ddUserCreateDate
				+ "]";
	}
    
}