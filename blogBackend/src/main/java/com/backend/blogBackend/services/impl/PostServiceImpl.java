package com.backend.blogBackend.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.blogBackend.Entity.Post;
import com.backend.blogBackend.VO.PostVo;
import com.backend.blogBackend.services.PostService;
import com.backend.blogBackend.repositories.PostRepository;
@Service

public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public PostVo createPost(PostVo postVo) {
		Post post=this.dtoToPost(postVo);
		Post savedPost= this.postRepository.save(post);
		PostVo savedPostVo= this.postToDto(savedPost);
		return savedPostVo;
		
	}
	@Override
	public void deletePost(Integer postId) {
		
		
	}
	
	private Post dtoToPost(PostVo postVo) {
		Post post = new Post();
		post.setPostId(postVo.getPostId());
		post.setDescription(postVo.getDescription());
		post.setImgByte(postVo.getImgByte());
		post.setTitle(postVo.getTitle());
		post.setActive(postVo.isActive());
		return post;
		
	}
	private PostVo postToDto(Post post) {
		PostVo postVo = new PostVo();
		postVo.setPostId(post.getPostId());
		postVo.setDescription(post.getDescription());
		postVo.setImgByte(post.getImgByte());
		postVo.setTitle(post.getTitle());
		postVo.setActive(post.isActive());
		return postVo;
	}
	
}
