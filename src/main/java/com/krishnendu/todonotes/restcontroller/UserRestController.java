package com.krishnendu.todonotes.restcontroller;

import java.util.List;

import com.krishnendu.todonotes.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishnendu.todonotes.models.User;

@RestController()
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }
    
}
