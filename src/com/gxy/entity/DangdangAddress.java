package com.gxy.entity;

import java.util.Date;

public class DangdangAddress {
    //主键
    private int addressId;

    //收件人
    private String addressReceiveName;

    //收件地址
    private String addressAdd;

    //收件人电话
    private String addressMobile;

    //邮政编码
    private String addressZipcode;

    //地址状态
    private int addressState;

    //外键，用户
    private int ddUserId;

    //时间戳
    private Date addressCreatedate;

    public DangdangAddress() {
		super();
	}

	@Override
	public String toString() {
		return "DangdangAddress [addressId=" + addressId + ", addressReceiveName=" + addressReceiveName
				+ ", addressAdd=" + addressAdd + ", addressMobile=" + addressMobile + ", addressZipcode="
				+ addressZipcode + ", addressState=" + addressState + ", ddUserId=" + ddUserId + ", addressCreatedate="
				+ addressCreatedate + "]";
	}

	public int getAddressId() {
        return addressId;
    }
	
	public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressReceiveName() {
        return addressReceiveName;
    }

    public void setAddressReceiveName(String addressReceiveName) {
        this.addressReceiveName = addressReceiveName;
    }

    public String getAddressAdd() {
        return addressAdd;
    }

    public void setAddressAdd(String addressAdd) {
        this.addressAdd = addressAdd;
    }

    public String getAddressMobile() {
        return addressMobile;
    }

    public void setAddressMobile(String addressMobile) {
        this.addressMobile = addressMobile;
    }

    public String getAddressZipcode() {
        return addressZipcode;
    }

    public void setAddressZipcode(String addressZipcode) {
        this.addressZipcode = addressZipcode;
    }

    public int getAddressState() {
        return addressState;
    }

    public void setAddressState(int addressState) {
        this.addressState = addressState;
    }

    public int getDdUserId() {
        return ddUserId;
    }

    public void setDdUserId(int ddUserId) {
        this.ddUserId = ddUserId;
    }

    public Date getAddressCreatedate() {
        return addressCreatedate;
    }

    public void setAddressCreatedate(Date addressCreatedate) {
        this.addressCreatedate = addressCreatedate;
    }
}