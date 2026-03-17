package com.kleiton.todo_api.todo.dto;

public record TodoResponse(
        Long id,
        String title,
        Boolean completed
) {}