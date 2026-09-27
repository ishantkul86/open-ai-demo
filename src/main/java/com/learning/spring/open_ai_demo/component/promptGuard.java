package com.learning.spring.open_ai_demo.component;


import com.learning.spring.open_ai_demo.config.GuardrailConfig;
import com.learning.spring.open_ai_demo.dto.GuardrailRule;
import com.learning.spring.open_ai_demo.exception.UnsafePromptException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class promptGuard {

    private final GuardrailConfig config;

    /*public promptGuard(GuardrailConfig config) {
        this.config = config;
    }*/

    public void validate(String prompt) {

        if (prompt == null || prompt.isBlank()) {
            throw new UnsafePromptException(
                    "INVALID_PROMPT",
                    "Prompt cannot be empty."
            );
        }

        String text = prompt.toLowerCase();

        for (GuardrailRule rule : config.getRules()) {

            for (String pattern : rule.patterns()) {

                if (text.contains(pattern.toLowerCase())) {
                    throw new UnsafePromptException(
                            rule.code(),
                            rule.message()
                    );
                }
            }
        }
    }
}