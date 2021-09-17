package com.fstg.spring_mongoo.service.impl;

import com.fstg.spring_mongoo.controller.dto.TodoRequestDto;
import com.fstg.spring_mongoo.controller.dto.TodoResponseDto;
import com.fstg.spring_mongoo.dao.TodoDao;
import com.fstg.spring_mongoo.exception.EntityAlreadyExistsException;
import com.fstg.spring_mongoo.exception.EntityNotFoundException;
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
        Todo todo_f = todoDao.findByTodo(todo.getTodo()).orElse(null);
        if (todo_f != null)
            throw new EntityAlreadyExistsException("Todo with name " + todo.getTodo() + " already exists");
        Todo todo1 = todoDao.save(modelMapper.map(todo, Todo.class));
        return modelMapper.map(todo1, TodoResponseDto.class);
    }

    @Override
    public TodoResponseDto findById(String id) {
        Todo todo = todoDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found by id " + id));
        return modelMapper.map(todo, TodoResponseDto.class);
    }

    @Override
    public int delete(String id) {
        Todo todo = todoDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found by id " + id));
        todoDao.delete(todo);
        return 1;
    }

    @Override
    public TodoResponseDto updateTodo(TodoRequestDto todo, String id) {
        Todo toUpdate = todoDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found by id " + id));
        toUpdate.setTodo(todo.getTodo());
        toUpdate.setDescription(todo.getDescription());
        Todo saved = todoDao.save(toUpdate);
        return modelMapper.map(saved, TodoResponseDto.class);
    }

    @Override
    public TodoResponseDto findByTodo(String todo) {
        Todo todo1 = todoDao.findByTodo(todo).orElseThrow(() -> new EntityNotFoundException("Todo not found by name " + todo));
        return modelMapper.map(todo1, TodoResponseDto.class);
    }
}
