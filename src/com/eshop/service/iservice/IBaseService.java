package com.eshop.service.iservice;

import java.util.List;

public interface IBaseService<T,K> {
	String save(T t);
	String update(T t);
	String delete(T t);
	List<T>  findAll();
	T findById(K k);
	
	
}
