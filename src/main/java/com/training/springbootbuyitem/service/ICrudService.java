package com.training.springbootbuyitem.service;

import java.util.List;

public interface ICrudService<T> {


	List<T> list();

	T get(Long id);

	void delete(Long id);

	T update(T entity);

	T save(T entity);

}
