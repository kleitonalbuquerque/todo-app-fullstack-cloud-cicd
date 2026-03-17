package com.kleiton.todo_api.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTodoRequest(

        @NotNull
        @NotBlank
        String title,

        Boolean completed
) {}
