package com.articlenewsletter.author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(AuthorApplication.class, args);
	}

}
