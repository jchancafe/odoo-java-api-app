package com.techruna.restaurante.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techruna.restaurante.menu.service.SessionOdooService;

@SpringBootApplication(scanBasePackages = {"com.techruna"})
public class Application {
	@Autowired
	static
	SessionOdooService sessionService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
