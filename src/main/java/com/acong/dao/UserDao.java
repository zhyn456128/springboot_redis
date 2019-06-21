package com.acong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.acong.entity.User;

@Mapper
public interface UserDao {
	
	List<User> queryAll();

	User findUserById(int id);
 
	int updateUser(@Param("user") User user);

	int deleteUserById(int id);
}
