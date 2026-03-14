package com.kleiton.todo_api.todo.infrastructure;

import com.kleiton.todo_api.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}