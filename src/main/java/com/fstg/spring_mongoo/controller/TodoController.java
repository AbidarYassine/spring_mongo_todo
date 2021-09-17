package com.fstg.spring_mongoo.controller;

import com.fstg.spring_mongoo.controller.api.TodoApi;
import com.fstg.spring_mongoo.controller.dto.TodoRequestDto;
import com.fstg.spring_mongoo.controller.dto.TodoResponseDto;
import com.fstg.spring_mongoo.service.facade.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController implements TodoApi {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public ResponseEntity<List<TodoResponseDto>> findAll() {
        List<TodoResponseDto> todoResponseDtos = todoService.findAll();
        return ResponseEntity.ok(todoResponseDtos);
    }

    @Override
    public ResponseEntity<TodoResponseDto> save(TodoRequestDto todo) {
        TodoResponseDto todoResponseDto = todoService.save(todo);
        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TodoResponseDto> findById(String id) {
        TodoResponseDto todoResponseDto = todoService.findById(id);
        return ResponseEntity.ok(todoResponseDto);
    }

    @Override
    public ResponseEntity<TodoResponseDto> findByTodo(String todo) {
        TodoResponseDto todoResponseDto = todoService.findByTodo(todo);
        return ResponseEntity.ok(todoResponseDto);
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TodoResponseDto> updateTodo(TodoRequestDto todo, String id) {
        TodoResponseDto todoResponseDto = todoService.updateTodo(todo, id);
        return ResponseEntity.accepted().body(todoResponseDto);
    }
}
