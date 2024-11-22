package com.example.ecommerce.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI CustomOpenAi(){
		return new OpenAPI()
			   .info(new Info()
					   .title("EcommercePlatform")
					   .version("1.7.0")
					   .description("API Documenttion for Ecommerce Platform"));
		
	}

}
