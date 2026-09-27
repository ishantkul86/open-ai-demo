package com.learning.spring.open_ai_demo.exception;

import com.learning.spring.open_ai_demo.dto.ApiError;
import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Spring AI errors.
     */
    @ExceptionHandler(NonTransientAiException.class)
    public ResponseEntity<ApiError> handleAiException(
            NonTransientAiException ex) {

        String errorMessage = ex.getMessage();

        //  credit exhausted
        if (errorMessage != null &&
                (errorMessage.contains("insufficient_quota")
                        || errorMessage.contains("credit_balance_exhausted"))) {

            return ResponseEntity
                    .status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(new ApiError(
                            "OPEN_AI_LIMIT_EXCEEDED",
                            "AI service limit has been exhausted. Please add credits and try again."
                    ));
        }

        // Other AI provider errors
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(new ApiError(
                        "AI_PROVIDER_ERROR",
                        "AI provider returned an error."
                ));
    }

    /**
     * Handles requests blocked by Prompt Guard.
     */
    @ExceptionHandler(UnsafePromptException.class)
    public ResponseEntity<ApiError> handleUnsafePrompt(
            UnsafePromptException ex) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiError(
                        "UNSAFE_REQUEST",
                        ex.getMessage()
                ));
    }

    /**
     * Fallback for unexpected exceptions.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(
            Exception ex) {

        ex.printStackTrace();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(
                        "INTERNAL_ERROR",
                        "Error while processing your request."
                ));
    }
}
