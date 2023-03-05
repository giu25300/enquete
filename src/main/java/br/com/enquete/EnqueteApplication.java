package br.com.enquete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EnqueteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnqueteApplication.class, args);
	}
}
