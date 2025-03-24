package com.projectvn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectvn.models.Product;
import com.projectvn.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	public Boolean create(Product product) {
		// TODO Auto-generated method stub
		try {
			this.productRepository.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(id).get();
	}

	@Override
	public Boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			this.productRepository.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			this.productRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> searchProduct(String keyword) {
		// TODO Auto-generated method stub
		return this.productRepository.searchProduct(keyword);
	}
	
}
