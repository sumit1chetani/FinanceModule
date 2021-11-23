package com.dci.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MultiTenancyJpaConfiguration.
 *
 * 
 */

@Configuration
@ComponentScan("com.dci.configutil")
@EnableConfigurationProperties(JpaProperties.class)
@EnableJpaRepositories(entityManagerFactoryRef = "tenantEntityManager", transactionManagerRef = "tenantTransactionManager", basePackages = {
		"com.dci.tenant" })
@EnableTransactionManagement
public class MultiTenancyJpaConfiguration {

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean(name = "tenantEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource,
			MultiTenantConnectionProvider connectionProvider,
			CurrentTenantIdentifierResolver tenantResolver) {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setDataSource(dataSource);
		emfBean.setPackagesToScan("com.dci.tenant");
		emfBean.setJpaVendorAdapter(jpaVendorAdapter());

		Map<String, Object> properties = new HashMap<>();
		properties.put(org.hibernate.cfg.Environment.MULTI_TENANT,
				MultiTenancyStrategy.DATABASE);
		properties.put(
				org.hibernate.cfg.Environment.MULTI_TENANT_CONNECTION_PROVIDER,
				connectionProvider);
		properties.put(
				org.hibernate.cfg.Environment.MULTI_TENANT_IDENTIFIER_RESOLVER,
				tenantResolver);
		properties.put("hibernate.ejb.naming_strategy",
				"org.hibernate.cfg.ImprovedNamingStrategy");
		emfBean.setJpaPropertyMap(properties);
		return emfBean;
	}

	@Bean(name = "tenantTransactionManager")
	public JpaTransactionManager transactionManager(
			@Qualifier("tenantEntityManager") EntityManagerFactory tenantEntityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(tenantEntityManager);
		return transactionManager;
	}
}
