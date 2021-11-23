package com.dci.config;

import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import liquibase.integration.spring.SpringLiquibase;

/**
 *
 *  
 */
@Configuration
@EnableConfigurationProperties(JpaProperties.class)
@EnableJpaRepositories(entityManagerFactoryRef = "masterEntityManager", transactionManagerRef = "masterTransactionManager", basePackages = {
		"com.dci.master" })
@EnableTransactionManagement
public class DatabaseConfiguration {
	private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseConfiguration.class);

	@Value("${liquibase.context}")
	private String liquibaseContext;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.dataSourceClassName}")
	private String dataSourceClassName;

	@Value("${spring.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.minIdle}")
	private int minIdle;

	// kavitha added

	//@Value("${spring.datasource.trmsUrl}")
	private String trmsurl;

	//@Value("${spring.datasource.trmsusername}")
	private String trmsuser;

	//@Value("${spring.datasource.trmspassword}")
	private String trmspassword;

	@Inject
	private JpaProperties jpaProperties;

	@Inject
	private DataSource dataSource;

	// @Bean(destroyMethod = "close")
	@Bean(name = "dataSource")
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {

		LOGGER.debug("Configuring datasource {} {} {}", driverClassName, url, user);
		HikariConfig config = new HikariConfig();
		// config.setDriverClassName(driverClassName);
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(password);
		config.setMinimumIdle(minIdle);
		config.setConnectionTestQuery("select 1;");
		return new HikariDataSource(config);
	}

	/*
	 * @Bean(name = "TrmsDataSource") public DataSource TrmsDataSource() {
	 * LOGGER.debug("Configuring datasource {} {} {}", driverClassName, trmsurl,
	 * trmsuser); HikariConfig config = new HikariConfig();
	 * config.setJdbcUrl(trmsurl); config.setUsername(trmsuser);
	 * config.setPassword(trmspassword); config.setMinimumIdle(minIdle);
	 * config.setConnectionTestQuery("select 1;"); return new
	 * HikariDataSource(config); }
	 */
	@Bean
	public SpringLiquibase liquibase(DataSource dataSource) {
		SpringLiquibase sl = new SpringLiquibase();
		sl.setDataSource(dataSource);
		sl.setContexts(liquibaseContext);
		sl.setChangeLog("classpath:dbchangelog.xml");
		sl.setShouldRun(true);
		return sl;
	}

	@Primary
	@Bean(name = "masterEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.dci.master" });
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalJpaProperties());
		em.setPersistenceUnitName("master");

		return em;
	}

	private Properties additionalJpaProperties() {
		Properties properties = new Properties();
		for (Map.Entry<String, String> entry : jpaProperties.getHibernateProperties(dataSource).entrySet()) {
			properties.setProperty(entry.getKey(), entry.getValue());
		}
		properties.put("hibernate.query.factory_class",
				"org.hibernate.hql.internal.classic.ClassicQueryTranslatorFactory");
		return properties;
	}

	@Primary
	@Bean(name = "masterTransactionManager")
	public JpaTransactionManager transactionManager(
			@Qualifier("masterEntityManager") EntityManagerFactory masterEntityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(masterEntityManager);
		return transactionManager;
	}

}
