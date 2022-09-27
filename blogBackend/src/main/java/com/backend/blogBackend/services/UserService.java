package com.backend.blogBackend.services;


import java.util.List;

import com.backend.blogBackend.VO.UserVo;



public interface UserService {
	UserVo createUser(UserVo user);
	UserVo updateUser(UserVo user, Integer userId);
	UserVo getUserByUserId(Integer userId); 
	List<UserVo> getAllUsers();
	void deleteUser(Integer userId);
	
}
