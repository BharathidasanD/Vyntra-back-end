package com.vyntrademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyntrademo.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
