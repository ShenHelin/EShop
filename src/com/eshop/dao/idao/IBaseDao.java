package com.eshop.dao.idao;

import java.util.List;

public interface IBaseDao<T, K> {
	void save(T t) throws Exception;

	void update(T t) throws Exception;

	void delete(T t)throws Exception;

	List<T> findAll() throws Exception;

	T findById(K k) throws Exception;
}
