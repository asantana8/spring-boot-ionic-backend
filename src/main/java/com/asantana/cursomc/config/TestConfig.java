package com.asantana.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;

import com.asantana.cursomc.services.DBService;

public class TestConfig {

	@Autowired
	private DBService dbService;

	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateDatabase();
		return true;
	}
}
