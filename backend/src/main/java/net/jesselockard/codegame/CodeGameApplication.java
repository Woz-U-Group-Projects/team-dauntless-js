package net.jesselockard.codegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CodeGameApplication {

	public static void main(String[] args) {
		//MongoClientURI uri = new MongoClientURI("mongodb+srv://codersquest:uRIRQs6QKCdZJ1FR@cluster0.mongodb.net/admin");

		//MongoClient mongoClient = new MongoClient(uri);
		//MongoDatabase database = mongoClient.getDatabase("codersquest");
		
		SpringApplication.run(CodeGameApplication.class, args);
	}

}
