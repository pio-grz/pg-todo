package com.pg.todo.controller;

import com.pg.todo.exception.ResourceNotFoundException;
import com.pg.todo.model.Todo;
import com.pg.todo.service.TodoService;
import com.pg.todo.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/rest/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Todo> list(
            @RequestParam(value = "page_no", required = false, defaultValue = "0") String pageNo,
            @RequestParam(value = "page_size", required = false, defaultValue = "10") String pageSize) {
        int pageNoParsed = RequestUtils.parseInt(pageNo, "page_no");
        int opageSizeParsed = RequestUtils.parseInt(pageSize, "page_size");
        return todoService.listAll(pageNoParsed, opageSizeParsed);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo get(@PathVariable Integer id) {
        return todoService.get(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo create(@Valid @RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return todoService.get(id).map(todo -> {
            todoService.delete(id);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
    }
}
