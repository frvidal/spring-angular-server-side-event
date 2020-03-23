/**
 * 
 */
package com.fitzhi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * This class is configuring the application.
 * </p>
 * @author Fr&eacute;d&eacute;ric VIDAL
 */


@Configuration
@Slf4j
public class FitzhiWebMvcConfigurer implements WebMvcConfigurer {

	/**
	 * Origins allowed to access the server<br/>
	 * By default, for testing purpose, <b>*</b> is stored in the application properties file 
	 */
	@Value("${allowedOrigins}")
	private String allowedOrigins;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins(allowedOrigins)
			.exposedHeaders(Global.BACKEND_RETURN_CODE, Global.BACKEND_RETURN_MESSAGE);
	}
	
	
}
