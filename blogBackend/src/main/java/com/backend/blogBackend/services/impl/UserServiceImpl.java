package com.backend.blogBackend.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.blogBackend.Entity.User;
import com.backend.blogBackend.VO.UserVo;
import com.backend.blogBackend.exceptions.ResourceNotFoundException;
import com.backend.blogBackend.repositories.UserRepository;
import com.backend.blogBackend.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserVo createUser(UserVo userVo) {
		User user = this.dtoToUser(userVo);
		User savedUser = this.userRepository.save(user);
		UserVo savedUserVo = this.userToDto(savedUser);
		return savedUserVo;
	}

	@Override
	public UserVo updateUser(UserVo userVo, Integer userId) {
		
		User user = this.userRepository.findById(userId)
							.orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		
		user.setName(userVo.getName());
		user.setEmail(userVo.getEmail());
		user.setPassword(userVo.getPassword());
		
		UserVo updateduserVo = this.userToDto(user);
		return updateduserVo;
	}

	@Override
	public UserVo getUserByUserId(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserVo> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserVo> userVos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userVos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		this.userRepository.delete(user);
	}

	private User dtoToUser(UserVo userVo) {
		User user = new User();
		user.setUserId(userVo.getUserId());
		user.setName(userVo.getName());
		user.setEmail(userVo.getEmail());
		user.setPassword(userVo.getPassword());
		return user;
	}
	
	private UserVo userToDto(User user) {
		UserVo userVo = new UserVo();
		userVo.setUserId(user.getUserId());
		userVo.setName(user.getName());
		userVo.setEmail(user.getEmail());
		userVo.setPassword(user.getPassword());
		return userVo;
	}
}
