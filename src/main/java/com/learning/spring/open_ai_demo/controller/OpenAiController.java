package com.learning.spring.open_ai_demo.controller;


import com.learning.spring.open_ai_demo.component.promptGuard;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OpenAiController {

   private final ChatClient chatClient;

    private final promptGuard promptGuard;

    public OpenAiController(ChatClient.Builder chatClientBuilder,
                            promptGuard promptGuard) {
        this.chatClient = chatClientBuilder.build();
        this.promptGuard = promptGuard;
    }

   @GetMapping("chatBot")
    public ResponseEntity<String> getChatResponse(@RequestParam("message") String message){

       System.out.println(">>> REQUEST REACHED CONTROLLER");
       System.out.println(">>> request = " );

       promptGuard.validate(message);

       String response = chatClient.prompt()
               .user(message)
               .call()
               .content();

       return ResponseEntity.ok().body(response);

    }


    @GetMapping("/summarize")
    @Operation(description = "Endpoint take text as input return the output based on input text i.e.Summarize the text")
    public ResponseEntity<String> summarize(@RequestParam("text") String request){

        String message =String.format("Summarize the following text :%s", request);
        System.out.println(message);

        String response;
        try {
            promptGuard.validate(message);

            response = chatClient.prompt()
                    .user(request)
                    .call()
                    .content();
        }
        catch (Exception e){
            System.out.print("exception"+e.getStackTrace());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("encounter error");
        }
        return ResponseEntity.ok().body(response);
    }

}
