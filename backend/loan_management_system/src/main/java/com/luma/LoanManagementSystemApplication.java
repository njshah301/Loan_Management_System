package com.luma;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//@EnableSwagger2
@SpringBootApplication(exclude = {SecurityFilterAutoConfiguration.class})
@ComponentScan({"com.luma"})
public class LoanManagementSystemApplication {

	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();}
	public static void main(String[] args) {
		SpringApplication.run(LoanManagementSystemApplication.class, args);
	}

}
