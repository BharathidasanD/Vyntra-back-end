package com.vyntrademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyntrademo.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
