package com.learn.learnings;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LearningsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningsApplication.class, args);
		log.info("Hello World");
		log.error("Hello World");
		log.warn("Hello World");
		log.debug("Hello World");
		log.trace("Hello World");
	}

}
