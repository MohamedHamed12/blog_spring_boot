package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.repositories.PostRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> getAllPosts() {
       
        return postRepository.findAll();
    }
    // create post

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // update post
    @PutMapping
    public Post updatePost(@RequestBody Post post) {
        return postRepository.save(post);
    }


    // delete post

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id - " + id));
        postRepository.delete(post);
    }



    
}
