package com.gok.shop.pojo;

import java.util.List;

/*
 * ��Ӧ��ǰ�˵����νṹ��Ӧ��javabean
 */
public class ProductTypeVo {
	int id;
	String text;
	// ��ǰ�ڵ����һ������
	List<ProductTypeVo> children;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<ProductTypeVo> getChildren() {
		return children;
	}
	public void setChildren(List<ProductTypeVo> children) {
		this.children = children;
	}
	public ProductTypeVo(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public ProductTypeVo(){
		
	}
	
}
