package com.recordrock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;


@SpringBootApplication
public class RecordRockApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordRockApplication.class, args);
	}

}
