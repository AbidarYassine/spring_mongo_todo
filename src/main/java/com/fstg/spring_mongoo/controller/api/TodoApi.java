package com.fstg.spring_mongoo.controller.api;


import com.fstg.spring_mongoo.controller.dto.TodoRequestDto;
import com.fstg.spring_mongoo.controller.dto.TodoResponseDto;
import com.fstg.spring_mongoo.model.Todo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("Todo Api")
public interface TodoApi {
    @ApiOperation(value = "Get All Todos", notes = "get All Todos", response = Todo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All Todo")
    })
    @GetMapping("/todos")
    ResponseEntity<List<TodoResponseDto>> findAll();

    @ApiOperation(value = "Add new Todo", notes = "Add new Todo", response = Todo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "return todo created")
    })
    @PostMapping("/todos")
    ResponseEntity<TodoResponseDto> save(@Valid @RequestBody TodoRequestDto todo);

    @GetMapping("/todos/id/{id}")
    @ApiOperation(value = "get Todo By Id", notes = "Get Todo By id Id string", response = Todo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "return todo")
    })
    ResponseEntity<TodoResponseDto> findById(@PathVariable String id);

    @GetMapping("/todos/todo/{todo}")
    @ApiOperation(value = "get Todo By Todo", notes = "Get Todo By todo name", response = Todo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "return todo")
    })
    ResponseEntity<TodoResponseDto> findByTodo(@PathVariable String todo);

    @DeleteMapping("/todos/id/{id}")
    @ApiOperation(value = "Delete a todo", notes = "delete todo by id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "return 1")
    })
    ResponseEntity<?> delete(@PathVariable String id);


    @PutMapping("/todos/id/{id}")
    @ApiOperation(value = "Update Todo", notes = "update Todo title and description and status")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "return todo", response = Todo.class)
    })
    ResponseEntity<TodoResponseDto> updateTodo(@Valid @RequestBody TodoRequestDto todo, @PathVariable String id);
}
