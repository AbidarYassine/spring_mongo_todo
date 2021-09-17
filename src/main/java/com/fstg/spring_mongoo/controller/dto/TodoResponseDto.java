package com.fstg.spring_mongoo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponseDto {
    private String id;
    private String todo;
    private boolean completed;
    private String description;
    private Instant created_at;
    private Instant updated_at;
}
