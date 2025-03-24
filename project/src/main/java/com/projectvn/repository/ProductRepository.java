package com.projectvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectvn.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
