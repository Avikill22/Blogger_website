package com.backend.blogBackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.blogBackend.VO.PostVo;
import com.backend.blogBackend.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	@PostMapping("/")
	public ResponseEntity<PostVo> createPost(@RequestBody PostVo postVo){
		PostVo createPost=this.postService.createPost(postVo);
		return new ResponseEntity<>(createPost,HttpStatus.CREATED);
	}

}
