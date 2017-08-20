package com.eshop.dao.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GoodsClass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int classId;
	private String className;
	private String classNo;
	private String superClass;
	
	private Set<Goods> goodsSet = new HashSet<Goods>();
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getSuperClass() {
		return superClass;
	}
	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}
	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}
	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}

	public GoodsClass(String className, String classNo, String superClass) {
		super();
		this.className = className;
		this.classNo = classNo;
		this.superClass = superClass;
	}
	
	public GoodsClass() {
		super();
	}
	
	@Override
	public String toString() {
		return "GoodsClass [classId=" + classId + ", className=" + className + ", classNo=" + classNo + ", superClass="
				+ superClass + ", goodsSet=" + goodsSet + "]";
	}
	
	
	
}
