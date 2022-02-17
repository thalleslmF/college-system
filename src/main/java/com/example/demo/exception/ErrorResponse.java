package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    public ErrorResponse(String message, int code) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;
}
