package com.anand.facebook.clone.controller;

import com.anand.facebook.clone.model.Post;
import com.anand.facebook.clone.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    public PostController(PostService postService) {
        this.postService = postService;
    }

    private PostService postService;

    @PostMapping
    public Post addPost(@RequestParam Map<String,String> requestParams) throws Exception {
        String strpost = requestParams.get("post");
        String email = requestParams.get("email");
        String name = requestParams.get("name");
        String file = requestParams.get("file");
        String profilePic = requestParams.get("profilePic");

        Post post = Post.builder()
                .file(file)
                .name(name)
                .email(email)
                .post(strpost)
                .profilePic(profilePic)
                .timeStamp(new Date().toString())
                .build();

        post = postService.addPost(post);
        return post;
    }

    public List<Post> getPost(){
        return postService.getPost();
    }

}
