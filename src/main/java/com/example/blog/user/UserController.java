package com.example.blog.user;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {


    @RequestMapping
    public List<User> getAllUsers() {
        return null;
    }

    

}
