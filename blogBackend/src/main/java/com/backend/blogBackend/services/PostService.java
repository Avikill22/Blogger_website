package com.backend.blogBackend.services;

import com.backend.blogBackend.VO.PostVo;

public interface PostService {
PostVo createPost(PostVo postVo);
void deletePost(Integer postId);
}
