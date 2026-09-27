package com.learning.spring.open_ai_demo.dto;

import java.util.List;

public record GuardrailRule(
        String code,
        String message,
        List<String> patterns
) {
}
