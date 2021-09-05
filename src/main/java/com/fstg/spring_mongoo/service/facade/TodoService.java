package com.fstg.spring_mongoo.service.facade;

import com.fstg.spring_mongoo.controller.dto.TodoRequestDto;
import com.fstg.spring_mongoo.controller.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {

    List<TodoResponseDto> findAll();

    TodoResponseDto save(TodoRequestDto todo);

    TodoResponseDto findById(String id);

    int delete(String id);

    TodoResponseDto updateTodo(TodoRequestDto todo, String id);

}
