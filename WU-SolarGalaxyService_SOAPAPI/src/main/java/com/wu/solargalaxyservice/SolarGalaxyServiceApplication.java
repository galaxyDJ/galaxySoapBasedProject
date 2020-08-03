package com.wu.solargalaxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.wu.config.SolarGalaxyConfig;
import com.wu.config.SwaggerConfiguration;
import com.wu.config.PersistanceORMConfig;

@Import({SolarGalaxyConfig.class,PersistanceORMConfig.class,SwaggerConfiguration.class})
@SpringBootApplication(scanBasePackages = "com.wu")
public class SolarGalaxyServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SolarGalaxyServiceApplication.class, args);
	}

}
