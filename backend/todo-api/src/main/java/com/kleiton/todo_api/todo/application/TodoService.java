package com.kleiton.todo_api.todo.application;

import com.kleiton.todo_api.todo.domain.Todo;
import com.kleiton.todo_api.todo.infrastructure.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public Todo getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo não encontrado"));
    }

    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    public Todo update(Long id, Todo todo) {

        Todo existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo não encontrado"));

        existing.setTitle(todo.getTitle());
        existing.setCompleted(todo.getCompleted());

        return repository.save(existing);
    }

    public void delete(Long id) {

        Todo existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo não encontrado"));

        repository.delete(existing);
    }
}