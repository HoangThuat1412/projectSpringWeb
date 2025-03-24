package com.projectvn.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectvn.models.Product;

public interface ProductService {
	List<Product> getAll();
	Boolean create(Product product);
	Product findById(Integer id);
	Boolean update(Product product);
	Boolean delete(Integer id);
}
