package com.oracle.assessmentdemo.appdevdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;

@SpringBootApplication()
public class AppdevdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppdevdemoApplication.class, args);
	}

}
