package com.gxy.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.Cart;
import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangCategory2;
import com.gxy.entity.DangDangProduct;

public interface DangDangProductService {
	//��ҳ�Ƽ�ͼ��
	public List<DangDangProduct> selectAll() throws IOException;
	//��ҳ����ͼ��
	public List<DangDangProduct> selectByCount() throws IOException;
	//��ҳ�����ϼ�
	public List<DangDangProduct> selectByNew() throws IOException;
	//��ҳ��������
	public List<DangDangProduct> selectByNewhot() throws IOException;
	//��ҳ������������
	public List<DangDangProduct> selectByNewhotMore() throws IOException;
	//ͼ������ҳ
	public List<DangDangProduct> selectByid(int ddProductId) throws IOException;
	//һ�������б���ʾ/����
	public List<DangDangProduct> selectByCategory1(String id,String ddProductName,String ddProductAuthor,String ddProductPress) throws IOException;
	//��̬��ѯ������
	public List<String> selectByPress()throws IOException;
	//DTO���ݴ���
	public Cart transferProduct(List<DangDangProduct> product);
}
