package com.gxy.entity;

import java.util.Date;

public class DangDangUser {
    //����
    private int ddUserId;

    //�˺�
    private String ddUserEmail;

    //����
    private String ddUserPassword;

    //�ǳ�
    private String ddUserNickname;

    //�û�״̬
    private Short ddUserState;

    //��ֵ
    private String ddUserSalt;

    //��ɫ
    private String ddUserRole;

    //ʱ���
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