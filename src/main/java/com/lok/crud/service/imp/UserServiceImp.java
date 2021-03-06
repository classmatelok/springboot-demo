package com.lok.crud.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lok.crud.dao.UserDao;
import com.lok.crud.domain.User;
import com.lok.crud.service.UserService;

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
	 * 根据id查询用户
	 */
	public User findUser(Integer id) {
		return this.userDao.findById(id).get();//或(findOne(Example.of(user))构造带id的实体传入，低版本可直接findOne(id))
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
