package com.brighthealth.bowlingweb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.brighthealth.bowlingweb.models.BowlingLaneImpl;

@SpringBootApplication
public class BowlingwebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BowlingwebApplication.class, args);
	}

}
