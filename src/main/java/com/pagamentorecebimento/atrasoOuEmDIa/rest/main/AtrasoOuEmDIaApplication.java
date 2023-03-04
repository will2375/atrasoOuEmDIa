package com.pagamentorecebimento.atrasoOuEmDIa.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.pagamentorecebimento")
@EntityScan(basePackages = "com.pagamentorecebimento")
@ComponentScan(basePackages="com.pagamentorecebimento")
public class AtrasoOuEmDIaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtrasoOuEmDIaApplication.class, args);
	}

}
