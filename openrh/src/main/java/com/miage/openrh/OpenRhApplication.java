package com.miage.openrh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class OpenRhApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenRhApplication.class, args);
	}
	@GetMapping
	public String index(){
		return "index";
	}

}
