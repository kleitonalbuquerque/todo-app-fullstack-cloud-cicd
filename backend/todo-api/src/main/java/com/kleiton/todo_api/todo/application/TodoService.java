package com.kleiton.todo_api.todo.application;

import com.kleiton.todo_api.todo.domain.Todo;
import com.kleiton.todo_api.todo.dto.CreateTodoRequest;
import com.kleiton.todo_api.todo.dto.TodoResponse;
import com.kleiton.todo_api.todo.dto.UpdateTodoRequest;
import com.kleiton.todo_api.todo.infrastructure.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<TodoResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(todo -> new TodoResponse(
                        todo.getId(),
                        todo.getTitle(),
                        todo.getCompleted()))
                .toList();
    }

    public TodoResponse getById(Long id) {

        Todo todo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo não encontrado"));

        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getCompleted()
        );
    }

    public TodoResponse create(CreateTodoRequest request) {

        Todo todo = new Todo();
        todo.setTitle(request.title());
        todo.setCompleted(request.completed());

        Todo saved = repository.save(todo);

        return new TodoResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getCompleted()
        );
    }

    public TodoResponse update(Long id, UpdateTodoRequest request) {

        Todo todo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo não encontrado"));

        todo.setTitle(request.title());
        todo.setCompleted(request.completed());

        Todo updated = repository.save(todo);

        return new TodoResponse(
                updated.getId(),
                updated.getTitle(),
                updated.getCompleted()
        );
    }

    public void delete(Long id) {

        Todo todo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo não encontrado"));

        repository.delete(todo);
    }
}