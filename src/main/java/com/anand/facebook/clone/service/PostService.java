package com.anand.facebook.clone.service;

import com.anand.facebook.clone.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getPost();
}
