package com.lok.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lok.domain.User;

/**
 * @Description 
 * @date 2017年9月18日
 */

public interface UserDao extends JpaRepository<User, Integer>{

	@Query("Delete from User where id in(:ids)")
	@Modifying
	void deleteByIds(@Param("ids")List<Integer> ids);

}
