package com.learning.spring.open_ai_demo.exception;

public class UnsafePromptException extends RuntimeException {

    private final String rule;

    public UnsafePromptException(String rule, String message) {
        super(message);
        this.rule = rule;
    }

    public String getRule() {
        return rule;
    }

}
