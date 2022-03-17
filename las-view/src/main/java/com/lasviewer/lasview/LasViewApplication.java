package com.lasviewer.lasview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"*"})
@SpringBootApplication
@EnableMongoRepositories("com.lasviewer.lasview.repository")
public class LasViewApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LasViewApplication.class, args);
	}

}
