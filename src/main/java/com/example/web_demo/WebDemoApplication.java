package com.example.web_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // annotation-> özellik kazandırma
public class WebDemoApplication {

	public static void main(String[] args) {
		// spring bileşenleri konsol açıldığında başlatılsın
        SpringApplication.run(WebDemoApplication.class, args);
	}

}
