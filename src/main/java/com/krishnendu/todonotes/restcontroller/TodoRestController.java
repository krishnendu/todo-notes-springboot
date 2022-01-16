package com.krishnendu.todonotes.restcontroller;

import java.util.List;

import com.krishnendu.todonotes.models.Todo;
import com.krishnendu.todonotes.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin
@RestController()
@RequestMapping("/todos")
public class TodoRestController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/")
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Todo getTodoById(@PathVariable("id") long id) {
        return todoRepository.findById(id).get();
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public long createTodo(@RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo.getId();
    }
    
    @RequestMapping("/admin")
    public String admin() {
        return("<h1>Welcome Admin</h1>");
    }
}
