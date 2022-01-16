package com.krishnendu.todonotes.controller;

import com.krishnendu.todonotes.models.User;
import com.krishnendu.todonotes.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/users")
    public String viewUsers(ModelMap model) {
        model.addAttribute("users", userRepository.findAll());
        System.out.println("working");
        return "/user-view.jsp";
    }

    @PostMapping("/register")
    public RedirectView addUser(@ModelAttribute("users") User user) {
        userRepository.save(user);        
        return new RedirectView("/todo");
    } 
    
    @GetMapping("/register")
    public String userRegisterPage(ModelMap model){
        model.addAttribute("add_user_url", "/register");
        model.addAttribute("users", new User());
        model.addAttribute("method", "post");
        return "/user-register.jsp";
    }
    
}
