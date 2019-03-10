package com.lok.service;

import java.util.List;

import com.lok.domain.User;

/**
 * @Description 
 * @date 2017年9月18日
 */

public interface UserService {

	List<User> listUser();
	
	User findUser(Integer id);
	
	User addOrUpdateUser(User user);
	
	void deleteUser(List<Integer> ids);
}
