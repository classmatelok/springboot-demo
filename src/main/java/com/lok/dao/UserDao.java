package com.lok.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lok.domain.User;

/**
 * @Description 
 * @date 2017年9月18日
 */

public interface UserDao extends JpaRepository<User, String>{

}
