package com.fstg.spring_mongoo.service.impl;

import com.fstg.spring_mongoo.controller.dto.TodoRequestDto;
import com.fstg.spring_mongoo.controller.dto.TodoResponseDto;
import com.fstg.spring_mongoo.dao.TodoDao;
import com.fstg.spring_mongoo.model.Todo;
import com.fstg.spring_mongoo.service.facade.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoImpl implements TodoService {
    private final TodoDao todoDao;
    private final ModelMapper modelMapper;

    public TodoImpl(TodoDao todoDao, ModelMapper modelMapper) {
        this.todoDao = todoDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TodoResponseDto> findAll() {
        return todoDao.findAll().stream().map(el -> modelMapper.map(el, TodoResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public TodoResponseDto save(TodoRequestDto todo) {
        Todo todo1 = todoDao.save(modelMapper.map(todo, Todo.class));
        return modelMapper.map(todo1, TodoResponseDto.class);
    }

    @Override
    public TodoResponseDto findById(String id) {
        Todo todo = todoDao.findById(id).orElse(null);
        if (todo != null) {
            return modelMapper.map(todo, TodoResponseDto.class);
        } else {
            return null;
        }
    }

    @Override
    public int delete(String id) {
        Todo todo = todoDao.findById(id).orElse(null);
        if (todo != null) {
            todoDao.delete(todo);
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public TodoResponseDto updateTodo(TodoRequestDto todo, String id) {
        Todo toUpdate = todoDao.findById(id).orElse(null);
        if (toUpdate != null) {
            toUpdate.setTodo(todo.getTodo());
            toUpdate.setDescription(todo.getDescription());
            Todo saved = todoDao.save(toUpdate);
            return modelMapper.map(saved, TodoResponseDto.class);
        } else {
            return null;
        }
    }
}
