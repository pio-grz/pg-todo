package com.pg.todo.service;

import com.pg.todo.model.Todo;

import java.util.Optional;

public interface TodoService {
    Iterable<Todo> listAll(Integer pageNr, Integer howManyOnPage);
    Optional<Todo> get(Integer id);
    Todo save(Todo todo);
    void delete(Integer id);
}
