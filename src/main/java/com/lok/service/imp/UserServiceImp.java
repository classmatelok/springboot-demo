package com.lok.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lok.domain.User;
import com.lok.service.UserService;

/**
 * @Description 
 * @date 2017年9月18日
 */
@Service
public class UserServiceImp implements UserService {

	//@Autowired
	//private UserDao userDao;
	
	/**
	 * 查询所有用户
	 */
	public List<User> findUser() {
		//return userDao.findAll();
		List<User> users = new ArrayList<>();
		User user1 = new User(1,"Tom","男",23);
		users.add(user1);
		User user2 = new User(2,"Sam","男",24);
		users.add(user2);
		User user3 = new User(3,"Sherry","女",18);
		users.add(user3);
		return users;
	}

}
