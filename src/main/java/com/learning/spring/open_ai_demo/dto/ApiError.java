package com.learning.spring.open_ai_demo.dto;

public record ApiError(
        String code,
        String message
) {
}
