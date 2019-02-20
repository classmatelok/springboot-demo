package com.lok.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	public List<User> listUser() {
		return this.userDao.findAll();
	}

	/**
	 * 添加或修改用户
	 */
	public User addOrUpdateUser(User user) {
		User newUser = this.userDao.save(user);
		return newUser;
	}

	/**
	 * 删除
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void deleteUser(List<Integer> ids) {
		this.userDao.deleteByIds(ids);
	}

}
