package net.jesselockard.codegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CodeGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeGameApplication.class, args);
	}

}
