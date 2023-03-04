package com.pagamentorecebimento.atrasoOuEmDIa.integration.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.pagamentorecebimento.atrasoOuEmDIa.integration.repository")
@EntityScan("com.pagamentorecebimento.atrasoOuEmDIa.integration.entity")
public class AtrasoOuEmDIaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtrasoOuEmDIaApplication.class, args);
	}

}
