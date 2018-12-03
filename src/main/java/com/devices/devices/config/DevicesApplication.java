package com.devices.devices.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.devices.devices")
@EnableJpaRepositories(basePackages = "com.devices.devices.dao")
@EntityScan(basePackages = "com.devices.devices.domain")
public class DevicesApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DevicesApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(DevicesApplication.class, args);
	}
}
