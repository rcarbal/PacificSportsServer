package com.pacificport.pacificsport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PacificsportApplication {
	public static void main(String[] args) {
		SpringApplication.run(PacificsportApplication.class, args);
	}
}

@RestController
class HelloController {
	@GetMapping("/")
	String home() {
		return "Hello World!";
	}	

}

