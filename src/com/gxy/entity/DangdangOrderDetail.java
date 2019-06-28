package com.gxy.entity;

import java.util.Date;

public class DangdangOrderDetail {
    //主键
    private int detailId;
    //订单详情编号
    private String detailSsid;
    //图书名称
    private String detailProductName;
    //每本图书的数量
    private Integer detailCount;
    //每本图书的当当价
    private int detailDdprice;
    //外键，图书
    private int ddProductId;
    //外键，订单
    private String orderSsid;
    //外键，地址
    private int addressId;
    //外键，用户
    private int ddUserId;
    //时间戳
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