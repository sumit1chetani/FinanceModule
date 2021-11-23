package com.dci.master.organization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization {

	// `organization_id` int(11) NOT NULL AUTO_INCREMENT,
	// `organization_name` varchar(60) NOT NULL,
	// `organization_code` varchar(15) NOT NULL,
	// `datasource_name` varchar(60) NOT NULL,
	@Id
	@Column(name = "organization_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer organizationId;

	@Column(name = "organization_name")
	private String organizationName;

	@Column(name = "organization_code")
	private String organizationCode;

	@Column(name = "description")
	private String description;
	
	@Column(name = "tenant_db")
	private String tenantDb;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTenantDb() {
		return tenantDb;
	}

	public void setTenantDb(String tenantDb) {
		this.tenantDb = tenantDb;
	}
}
