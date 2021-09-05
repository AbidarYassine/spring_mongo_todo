package com.fstg.spring_mongoo.dao;

import com.fstg.spring_mongoo.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends MongoRepository<Todo, String> {

}
