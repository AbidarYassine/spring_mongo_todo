package com.fstg.spring_mongoo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos")
public class Todo extends AbstractEntity {

    private String todo;
    private boolean completed;
    private String description;


}
