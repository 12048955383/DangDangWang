package com.gxy.entity;

import java.util.Date;

public class DangdangOrder {
    //����
    private int orderId;

    //�������
    private String orderSsid;

    //�ö�����Ʒ�ܼ�
    private Double orderTotalprice;

    //����״̬
    private int orderState;

    //������û�
    private int ddUserId;

    //ʱ���
    private Date orderCreatedate;

    
    public DangdangOrder() {
		super();
	}

    
	@Override
	public String toString() {
		return "DangdangOrder [orderId=" + orderId + ", orderSsid=" + orderSsid + ", orderTotalprice=" + orderTotalprice
				+ ", orderState=" + orderState + ", ddUserId=" + ddUserId + ", orderCreatedate=" + orderCreatedate
				+ "]";
	}


	public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderSsid() {
        return orderSsid;
    }

    public void setOrderSsid(String orderSsid) {
        this.orderSsid = orderSsid;
    }

    public Double getOrderTotalprice() {
        return orderTotalprice;
    }

    public void setOrderTotalprice(Double orderTotalprice) {
        this.orderTotalprice = orderTotalprice;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getDdUserId() {
        return ddUserId;
    }

    public void setDdUserId(int ddUserId) {
        this.ddUserId = ddUserId;
    }

    public Date getOrderCreatedate() {
        return orderCreatedate;
    }

    public void setOrderCreatedate(Date orderCreatedate) {
        this.orderCreatedate = orderCreatedate;
    }
}