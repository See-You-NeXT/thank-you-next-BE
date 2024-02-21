package com.develop.thankyounext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ThankyounextApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThankyounextApplication.class, args);
	}

}
