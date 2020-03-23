/**
 * 
 */
package com.fitzhi;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Fr&eacute;d&eacute;ric VIDAL Starting class for the application
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Application {

	
	public static void main(String[] args) {
		LoggerFactory.getLogger(Application.class.getCanonicalName()).info("Starting SSE server");
		SpringApplication.run(Application.class, args);
	}

	@Bean
    CommandLineRunner init() {
        return (args) -> {
        };
	}
}
