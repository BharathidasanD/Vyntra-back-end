package com.vyntrademo.dao;

import com.vyntrademo.model.Customer;

public interface CustomerRepo extends UserBaseRepo<Customer> {

	public Customer findByEmail(String email);
	
	public Customer findByPhone(String phone);
}
