package com.challange.order.status.fastfood;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "OrderStatusService", version = "1.0.0", description = ""))
@SpringBootApplication
public class FastfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastfoodApplication.class, args);
	}

}
