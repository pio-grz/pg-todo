package com.pg.todo.service;

import com.pg.todo.model.Todo;

import java.util.Optional;

public interface TodoService {
    Iterable<Todo> listAllTodos(Integer pageNr, Integer howManyOnPage);
    Optional<Todo> getTodoById(Integer id);
    Todo saveTodo(Todo todo);
    void deleteTodo(Integer id);
}
