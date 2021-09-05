package com.fstg.spring_mongoo.controller;

import com.fstg.spring_mongoo.controller.api.TodoApi;
import com.fstg.spring_mongoo.controller.dto.TodoRequestDto;
import com.fstg.spring_mongoo.controller.dto.TodoResponseDto;
import com.fstg.spring_mongoo.service.facade.TodoService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController implements TodoApi {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public List<TodoResponseDto> findAll() {
        return todoService.findAll();
    }

    @Override
    public TodoResponseDto save(TodoRequestDto todo) {
        return todoService.save(todo);
    }

    @Override
    public TodoResponseDto findById(String id) {
        return todoService.findById(id);
    }

    @Override
    public int delete(String id) {
        return todoService.delete(id);
    }

    @Override
    public TodoResponseDto updateTodo(TodoRequestDto todo, String id) {
        return todoService.updateTodo(todo, id);
    }
}
