package com.gxy.entity;

import java.util.Date;

public class DangdangAddress {
    //����
    private int addressId;

    //�ռ���
    private String addressReceiveName;

    //�ռ���ַ
    private String addressAdd;

    //�ռ��˵绰
    private String addressMobile;

    //��������
    private String addressZipcode;

    //��ַ״̬
    private int addressState;

    //������û�
    private int ddUserId;

    //ʱ���
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