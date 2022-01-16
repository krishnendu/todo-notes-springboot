package com.krishnendu.todonotes;

import com.krishnendu.todonotes.repository.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ToDoNotesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ToDoNotesApplication.class, args);
	}

}
