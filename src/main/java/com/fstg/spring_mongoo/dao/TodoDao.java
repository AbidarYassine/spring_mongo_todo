package com.fstg.spring_mongoo.dao;

import com.fstg.spring_mongoo.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoDao extends MongoRepository<Todo, String> {
    @Query("{'todo':?0}")
    Optional<Todo> findByTodo(String todo);
}
