package com.example.Fakebook.Controllers;

import com.example.Fakebook.Models.PostModel;
import com.example.Fakebook.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public List<PostModel> getAllPosts() {
        return postService.getPosts();
    }
    @PostMapping
    public void CreatePost(@RequestBody PostModel post) {
        postService.addNewPost(post);
    }
}
