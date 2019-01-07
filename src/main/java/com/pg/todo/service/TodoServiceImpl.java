package com.pg.todo.service;

import com.pg.todo.model.Todo;
import com.pg.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Iterable<Todo> listAll(Integer pageNr, Integer howManyOnPage) {
        return todoRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    @Override
    public Optional<Todo> get(Integer id) {
        return todoRepository.findById(id);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }
}
