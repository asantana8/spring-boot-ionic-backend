package com.asantana.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

import com.asantana.cursomc.services.DBService;
import com.asantana.cursomc.services.EmailService;
import com.asantana.cursomc.services.MockEmailService;

@Configuration
@Profile("teste")
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException, java.text.ParseException {

		if (!"create".equals(strategy)) {
			return false;
		}

		dbService.instantiateDatabase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
