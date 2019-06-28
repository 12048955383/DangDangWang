package com.gxy.entity;

import java.util.Date;

public class DangdangOrderDetail {
    //����
    private int detailId;
    //����������
    private String detailSsid;
    //ͼ������
    private String detailProductName;
    //ÿ��ͼ�������
    private Integer detailCount;
    //ÿ��ͼ��ĵ�����
    private int detailDdprice;
    //�����ͼ��
    private int ddProductId;
    //���������
    private String orderSsid;
    //�������ַ
    private int addressId;
    //������û�
    private int ddUserId;
    //ʱ���
    private Date detailCreatedate;

    
    public DangdangOrderDetail() {
		super();
	}

	@Override
	public String toString() {
		return "DangdangOrderDetail [detailId=" + detailId + ", detailSsid=" + detailSsid + ", detailProductName="
				+ detailProductName + ", detailCount=" + detailCount + ", detailDdprice=" + detailDdprice
				+ ", ddProductId=" + ddProductId + ", orderSsid=" + orderSsid + ", addressId=" + addressId
				+ ", ddUserId=" + ddUserId + ", detailCreatedate=" + detailCreatedate + "]";
	}

	public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getDetailSsid() {
        return detailSsid;
    }

    public void setDetailSsid(String detailSsid) {
        this.detailSsid = detailSsid;
    }

    public String getDetailProductName() {
        return detailProductName;
    }

    public void setDetailProductName(String detailProductName) {
        this.detailProductName = detailProductName;
    }

    public Integer getDetailCount() {
        return detailCount;
    }

    public void setDetailCount(Integer detailCount) {
        this.detailCount = detailCount;
    }

    public int getDetailDdprice() {
        return detailDdprice;
    }

    public void setDetailDdprice(int detailDdprice) {
        this.detailDdprice = detailDdprice;
    }

    public int getDdProductId() {
        return ddProductId;
    }

    public void setDdProductId(int ddProductId) {
        this.ddProductId = ddProductId;
    }

    public String getOrderSsid() {
        return orderSsid;
    }

    public void setOrderSsid(String orderSsid) {
        this.orderSsid = orderSsid;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getDdUserId() {
        return ddUserId;
    }

    public void setDdUserId(int ddUserId) {
        this.ddUserId = ddUserId;
    }

    public Date getDetailCreatedate() {
        return detailCreatedate;
    }

    public void setDetailCreatedate(Date detailCreatedate) {
        this.detailCreatedate = detailCreatedate;
    }
}