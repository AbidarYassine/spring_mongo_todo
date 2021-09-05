package com.fstg.spring_mongoo.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
public abstract class AbstractEntity {
    @Id
    private String id;
    @CreatedDate
    private Instant created_at;
    @LastModifiedDate
    private Instant updated_at;
}
