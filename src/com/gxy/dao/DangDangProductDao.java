package com.gxy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangCategory2;
import com.gxy.entity.DangDangProduct;

public interface DangDangProductDao {
	//��ҳ�Ƽ�ͼ��
	public List<DangDangProduct> selectAll();
	//��ҳ����ͼ��
	public List<DangDangProduct> selectByCount();
	//��ҳ�����ϼ�
	public List<DangDangProduct> selectByNew();
	//��ҳ��������
	public List<DangDangProduct> selectByNewhot();
	//��ҳ������������
	public List<DangDangProduct> selectByNewhotMore();
	//ͼ������ҳ
	public List<DangDangProduct> selectByid(@Param("ddProductId")int ddProductId);
	//һ���б���ʾ/����
	public List<DangDangProduct> selectByCategory1(@Param("id")String id,
												   @Param("ddProductName") String ddProductName,
												   @Param("ddProductAuthor") String ddProductAuthor,
												   @Param("ddProductPress") String ddProductPress);
	//��̬��ѯ������
	public List<String> selectByPress();
}
