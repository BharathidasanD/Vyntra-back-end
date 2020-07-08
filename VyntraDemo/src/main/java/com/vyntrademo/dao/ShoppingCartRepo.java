package com.vyntrademo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyntrademo.model.ShoppingCart;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {
	
	public List<ShoppingCart> findByuserId(Long uid);

}
