package com.dci.configutil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dci.master.domain.repository.DataSourceRepository;
import com.dci.master.organization.Organization;
import com.dci.master.organization.OrganizationRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

@Component
@Transactional(value = "masterTransactionManager", readOnly = true)
public class MultiTenantConnectionProviderImpl extends
		AbstractDataSourceBasedMultiTenantConnectionProviderImpl implements
		ApplicationListener<ContextRefreshedEvent>, DataSourceRepository {

	private static final long serialVersionUID = 8168907057647334460L;

	private Map<String, DataSource> map; // map holds the companyKey =>
											// DataSource

	@Inject
	private OrganizationRepository organizationRepository;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.dataSourceClassName}")
	private String dataSourceClassName;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.minIdle}")
	private int minIdle;

	@Inject
	private DataSource dataSource; // injected here to get properties and to
									// provide default.

	@PostConstruct
	public void load() {
		map = new HashMap<>();
	}

	public void init() {
		// List<Company> companyList = new ArrayList<Company>();
		for (Organization organization : organizationRepository.findAll()) {
			createTenantDataSource(organization);
		}
	}

	@Override
	protected DataSource selectAnyDataSource() {
		// LOGGER.debug("######### Selecting any data source");
		return dataSource;
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		// LOGGER.debug("+++++++++++ Selecting data source for {}",
		// tenantIdentifier);
		/*if(CommonUtil.schedulerdbName !="" && CommonUtil.schedulerdbName !=null){
			tenantIdentifier = CommonUtil.schedulerdbName;
		}*/
		if (map.containsKey(tenantIdentifier)) {
			return map.get(tenantIdentifier);
		} else {
			return dataSource;
		}
	}

	/*
	 * public DataSource getDefaultDataSource() { return
	 * map.get(DEFAULT_TENANT_ID);
	 * 
	 * }
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		// This is super critical to initialize after application is done with
		// configuring beans.
		// otherwise you can not use companyRepository to fetch all the
		// companies
		init();
	}

	public HikariDataSource createTenantDataSource(Organization organization) {
		try {
			String companyDbUrl = (url.replace(
					Utils.databaseNameFromJdbcUrl(url),
					organization.getTenantDb()))
					+ "?createDatabaseIfNotExist=true";
			// LOGGER.debug("Configuring datasource {} {} {}",
			// dataSourceClassName, companyDbUrl, user);
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(companyDbUrl);
			config.setUsername(user);
			config.setPassword(password);
			config.setMinimumIdle(minIdle);
			config.setConnectionTestQuery("SELECT 1;");
			HikariDataSource ds = new HikariDataSource(config);
			map.put(organization.getOrganizationCode(), ds);
			return ds;
		} catch (Exception e) {
			// LOGGER.error("Error in database URL {}", url, e);
		}
		return null;
	}

	@Override
	public void setDataSource(Organization organization) {
		// TODO Auto-generated method stub
		try {
			HikariDataSource ds = createTenantDataSource(organization);
			initDbWithLiquibase(ds);
		} catch (Exception e) {
			// LOGGER.error("Error in database URL {}", url, e);
		}
	}

	private void initDbWithLiquibase(HikariDataSource ds) throws SQLException,
			LiquibaseException {
		Database database = DatabaseFactory.getInstance()
				.findCorrectDatabaseImplementation(
						new JdbcConnection(ds.getConnection()));

		Liquibase liquibase = new Liquibase("dbchangelog-product.xml",
				new ClassLoaderResourceAccessor(), database);
		liquibase.update("test, production");
	}
}
