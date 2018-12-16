package com.lok.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lok.dao.UserDao;
import com.lok.domain.User;
import com.lok.service.UserService;

/**
 * @Description 
 * @date 2017年9月18日
 */
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 查询所有用户
	 */
	public List<User> findUser() {
		return userDao.findAll();
	}

}
