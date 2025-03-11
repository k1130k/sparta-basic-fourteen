package com.example.basicfilter.todo.dto;

import lombok.Getter;

@Getter
public class TodoResponseDto {
    private final Long id;
    private final String contnet;

    public TodoResponseDto(Long id, String contnet) {
        this.id = id;
        this.contnet = contnet;
    }
}
