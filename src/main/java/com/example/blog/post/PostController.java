package com.example.blog.post;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/posts/")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping()
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id - " + id));
    }
    // create post

    @PostMapping()
    public Post createPost(@RequestBody Post post) {
        System.out.println("********************************************************************************************************");
        System.out.println(post);
        return postRepository.save(post);
    }
    // update post
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody Post post) {
        post.setId(id);
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
