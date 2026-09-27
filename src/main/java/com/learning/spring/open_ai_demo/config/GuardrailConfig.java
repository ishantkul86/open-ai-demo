package com.learning.spring.open_ai_demo.config;

import com.learning.spring.open_ai_demo.dto.GuardrailRule;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "guardrail")
@Component
@Getter
@Setter
public class GuardrailConfig {

    private List<GuardrailRule> rules;

}
