package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfigurartion {

	@Value("${spring.datasource.url}")
	private String JDBC_URL;

	@Value("${spring.datasource.driver-class-name}")
	private String DRIVER_CLASS_NAME;

	@Value("${spring.datasource.username}")
	private String USERNAME;

	@Value("${spring.datasource.password}")
	private String PASSWORD;

	@Bean
	DataSource getDataSource() {
		return DataSourceBuilder.create().url(JDBC_URL).username(USERNAME).password(PASSWORD)
				.driverClassName(DRIVER_CLASS_NAME).build();
	}
}
