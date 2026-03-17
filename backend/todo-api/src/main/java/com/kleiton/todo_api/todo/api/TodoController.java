package com.kleiton.todo_api.todo.api;

import com.kleiton.todo_api.todo.application.TodoService;
import com.kleiton.todo_api.todo.dto.CreateTodoRequest;
import com.kleiton.todo_api.todo.dto.TodoResponse;
import com.kleiton.todo_api.todo.dto.UpdateTodoRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TodoResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TodoResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TodoResponse create(@RequestBody @Valid CreateTodoRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public TodoResponse update(
            @PathVariable Long id,
            @RequestBody @Valid UpdateTodoRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}