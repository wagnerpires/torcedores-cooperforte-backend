package br.com.desafio.cooperforteservice;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@AllArgsConstructor
public class CooperforteServiceApplication {
	private static PasswordEncoder bcryptEncoder;

	public static void main(String[] args) {

		SpringApplication.run(CooperforteServiceApplication.class, args);
	}

}
