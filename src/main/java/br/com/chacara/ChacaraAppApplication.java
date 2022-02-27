package br.com.chacara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ChacaraAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChacaraAppApplication.class, args);
	}
	
}
