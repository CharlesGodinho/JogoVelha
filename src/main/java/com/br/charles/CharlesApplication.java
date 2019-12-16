package com.br.charles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.br.charles.Service", "com.br.charles.Controller" })
public class CharlesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CharlesApplication.class, args);
	}

}
