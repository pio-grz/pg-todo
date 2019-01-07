package com.pg.todo.repositories;

import com.pg.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer>, PagingAndSortingRepository<Todo, Integer> {
}