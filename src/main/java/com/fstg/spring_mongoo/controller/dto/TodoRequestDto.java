package com.fstg.spring_mongoo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequestDto {
    @NotNull
    @NotBlank
    private String todo;
    @NotNull
    private boolean completed = false;
    @NotNull
    @NotBlank
    private String description;
}
