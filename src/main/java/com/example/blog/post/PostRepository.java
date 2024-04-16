
package com.example.blog.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    // You can add custom query methods here if needed
}
