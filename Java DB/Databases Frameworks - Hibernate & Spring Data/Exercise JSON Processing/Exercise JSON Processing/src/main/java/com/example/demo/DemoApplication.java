package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.builder.lib.ANSRBuilder;
import repository.builder.lib.enums.interfaces.Strategy;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ANSRBuilder.run(Strategy.REPOSITORIES_AND_SERVICES(),DemoApplication.class,args);
	}
}
