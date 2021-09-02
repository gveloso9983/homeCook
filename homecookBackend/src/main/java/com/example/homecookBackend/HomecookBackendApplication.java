package com.example.homecookBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//estava a dar um erro de não termos uma data origin configurada
@SpringBootApplication
public class HomecookBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(HomecookBackendApplication.class, args);
	}

}
