package com.pg.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pg.todo.repositories")
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}

// https://github.com/WitMar/PRA/blob/Feature/SpringFinal/src/main/java/com/pracownia/spring/repositories/ProductRepository.java
// https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/
