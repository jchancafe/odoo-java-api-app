package com.techruna.restaurante.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.techruna.restaurante.menu.service.SessionOdooService;

@SpringBootApplication(scanBasePackages = {"com.techruna"})
public class Application extends SpringBootServletInitializer {
	@Autowired
	static
	SessionOdooService sessionService;
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
