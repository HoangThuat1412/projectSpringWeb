package com.projectvn.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.projectvn.models.Category;

public interface CategorySercive {
	List<Category> getAll();
	Boolean create(Category category);
	Category findById(Integer id);
	Boolean update(Category category);
	Boolean delete(Integer id);
	List<Category> searchCategory(String keyword);
	Page<Category> getAll(Integer pageNo);
}
