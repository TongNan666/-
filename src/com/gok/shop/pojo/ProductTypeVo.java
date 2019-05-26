package com.gok.shop.pojo;

import java.util.List;

/*
 * 相应给前端的树形结构对应的javabean
 */
public class ProductTypeVo {
	int id;
	String text;
	// 当前节点的下一级分类
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
