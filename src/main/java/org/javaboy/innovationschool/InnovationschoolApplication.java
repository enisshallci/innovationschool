package org.javaboy.innovationschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
	Annotation i tregon Spring boot aplikacionit cfare beans me aktivizu, cfare komponenta me aktivizu.
 */
@SpringBootApplication		//gradle e din qe eshte spring boot application me kete annotation
public class InnovationschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnovationschoolApplication.class, args);
	}

}

