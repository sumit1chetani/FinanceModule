package com.dci;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class mbkApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder trmsapplication) {
		return trmsapplication.sources(mbkApplication.class);
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(mbkApplication.class, args);
	}

	@Bean
	public static Properties propertyConfigurer() {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream("user_rights_form.properties");
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
