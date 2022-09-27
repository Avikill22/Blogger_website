package com.backend.blogBackend.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.blogBackend.VO.UserVo;
import com.backend.blogBackend.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserVo> createUser(@RequestBody UserVo userVo){
		UserVo createUserVo = this.userService.createUser(userVo);
		return new ResponseEntity<>(createUserVo,HttpStatus.CREATED);
	} 
	@PutMapping("/{id}")
	public ResponseEntity<UserVo> updateUserInformation(@RequestBody UserVo userVo,@PathVariable("id") int id ){
		UserVo updateUserVo = this.userService.updateUser(userVo, id);
		return new ResponseEntity<UserVo>(updateUserVo,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletedUser(@PathVariable("id") int id){
		this.userService.deleteUser(id);
		return new ResponseEntity<>(Map.of("message", "User Deleted Successfully"),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserVo>> getAllUserInformation(){
		return new ResponseEntity<List<UserVo>>(this.userService.getAllUsers(),HttpStatus.FOUND);
	}
}
