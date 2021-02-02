package com.example.Fakebook.Services;

import com.example.Fakebook.DomainAccess.PostRepository;
import com.example.Fakebook.Models.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<PostModel> getPosts() {return postRepository.findAll();}
    public void addNewPost(long userId, String content) {
        PostModel post = new PostModel(userId, content);
    }

    public void addNewPost(PostModel post) {
        postRepository.save(post);
    }
}
