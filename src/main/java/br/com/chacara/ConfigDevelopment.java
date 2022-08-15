package br.com.chacara;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import annotations.Development;

@Development
public class ConfigDevelopment {

	@Bean
	public CommandLineRunner executa() {
		return args -> {
			System.out.println("Iniciando config desenvolvimento");
		};
	}

}
