package com.projectvn.services;

import java.util.List;

import com.projectvn.models.Product;

public interface ProductService {
	List<Product> getAll();
	Boolean create(Product product);
	Product findById(Integer id);
	Boolean update(Product product);
	Boolean delete(Integer id);
	List<Product> searchProduct(String keyword);
}
