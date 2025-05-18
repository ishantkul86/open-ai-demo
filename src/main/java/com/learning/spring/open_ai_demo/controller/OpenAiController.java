package com.learning.spring.open_ai_demo.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi")
public class OpenAiController {

   private final ChatClient chatClient;

    public OpenAiController(ChatClient.Builder chatClientBuilder) {

        this.chatClient = chatClientBuilder.build();
    }

   @GetMapping("chatBot")
    public String getChatResponse(@RequestParam String message){
       String response;
        try {
            response = chatClient.prompt()
                    .user(message)
                    .call()
                    .content();
        }
        catch (Exception e){
            System.out.print("exception"+e);
            return "Error";
        }
       return response;
    }

}
