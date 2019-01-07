package com.pg.todo.controller;

import com.pg.todo.model.Todo;
import com.pg.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Todo> list(Model model) {
        return todoService.listAllTodos(0,1000);
    }
}
