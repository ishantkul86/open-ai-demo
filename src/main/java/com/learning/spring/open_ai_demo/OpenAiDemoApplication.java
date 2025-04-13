package com.learning.spring.open_ai_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class OpenAiDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(OpenAiDemoApplication.class, args);
	}


	@Bean
	CommandLineRunner cli(ChatClient.Builder builder) {
		return args -> {
			var chat = builder.build();
			var scanner = new Scanner(System.in);
			System.out.println("\nConnected with open AI, Start Chat !");
			while (true) {
				System.out.print("\n chat user: ");
				System.out.println("AI assistance : " +
						chat.prompt(scanner.nextLine()).call().content());
			}
		};
	}
}
