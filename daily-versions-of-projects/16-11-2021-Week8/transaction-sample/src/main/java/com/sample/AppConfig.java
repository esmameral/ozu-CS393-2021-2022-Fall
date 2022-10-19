package com.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({ "com.sample" })
@PropertySource(value = "classpath:database.properties")
@EnableTransactionManagement
public class AppConfig {
	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(driverClassName);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(username);
		driverManagerDataSource.setPassword(password);
		return driverManagerDataSource;
	}

	@Autowired
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate(DriverManagerDataSource ds) {
		JdbcTemplate jtemp = new JdbcTemplate();
		jtemp.setDataSource(ds);
		return jtemp;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager txManager(DriverManagerDataSource ds) {
		DataSourceTransactionManager txMan = new DataSourceTransactionManager();
		txMan.setDataSource(ds);
		return txMan;
	}

}
