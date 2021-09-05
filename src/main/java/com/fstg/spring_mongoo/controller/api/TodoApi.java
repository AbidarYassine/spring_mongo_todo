package com.fstg.spring_mongoo.controller.api;


import com.fstg.spring_mongoo.controller.dto.TodoRequestDto;
import com.fstg.spring_mongoo.controller.dto.TodoResponseDto;
import com.fstg.spring_mongoo.model.Todo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    List<TodoResponseDto> findAll();

    @ApiOperation(value = "Add new Todo", notes = "Add new Todo", response = Todo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "return todo created")
    })
    @PostMapping("/todos")
    TodoResponseDto save(@Valid @RequestBody TodoRequestDto todo);

    @GetMapping("/todos/id/{id}")
    @ApiOperation(value = "get Todo By Id", notes = "Get Todo By id Id string", response = Todo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "return todo")
    })
    TodoResponseDto findById(@PathVariable String id);

    @DeleteMapping("/todos/id/{id}")
    @ApiOperation(value = "Delete a todo", notes = "delete todo by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "return 1")
    })
    int delete(@PathVariable String id);


    @PutMapping("/todos")
    @ApiOperation(value = "Update Todo", notes = "update Todo title and description and status")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "return todo", response = Todo.class)
    })
    TodoResponseDto updateTodo(@Valid @RequestBody TodoRequestDto todo, String id);
}
