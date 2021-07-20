package com.pala.memsource.memsource.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.pala.memsource.memsource.*" })
@EnableJpaRepositories("com.pala.memsource.memsource.repository")
@EntityScan("com.pala.memsource.memsource.repository.domain")
public class MemsourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemsourceApplication.class, args);
	}

}
