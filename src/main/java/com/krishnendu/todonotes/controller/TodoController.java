package com.krishnendu.todonotes.controller;

import java.security.Principal;

import com.krishnendu.todonotes.models.Todo;
import com.krishnendu.todonotes.models.User;
import com.krishnendu.todonotes.repository.TodoRepository;
import com.krishnendu.todonotes.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/todo")
    public String viewTodo(Principal principal, ModelMap model) {
        User user = userRepository.findByUserName(principal.getName()).get();
        model.addAttribute("todos", todoRepository.findAllByUser(user));
        System.out.println("working");
        return "/todo-view.jsp";
    }

    @PostMapping("/todo/register")
    public RedirectView addTodo(Principal principal, @ModelAttribute("todo") Todo todo) {
        User user = userRepository.findByUserName(principal.getName()).get();
        todo.setUser(user);
        todoRepository.save(todo);        
        return new RedirectView("/todo");
    } 
    
    @GetMapping("/todo/register")
    public String userRegisterPage(ModelMap model){
        model.addAttribute("add_todo_url", "/todo/register");
        model.addAttribute("todo", new Todo());
        model.addAttribute("method", "post");
        return "/todo-register.jsp";
    }
    @GetMapping("/todo/{id}/complete")
    public RedirectView userUpdatePage(Principal principal, @PathVariable("id") Long id){
        User user = userRepository.findByUserName(principal.getName()).get();
        Todo todo = todoRepository.findByUserAndId(user, id).get();
        todo.setCompleted(true);
        todoRepository.save(todo);
        return new RedirectView("/todo");
    }

    @GetMapping("/")
    public RedirectView home(Principal principal){
        try{
            userRepository.findByUserName(principal.getName()).get();
            return new RedirectView("/todo");
        }
        catch(Exception  e){
        return new RedirectView("/register");
        }
    }
}
