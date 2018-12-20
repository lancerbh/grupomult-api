package br.com.grupomult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.grupomult")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
