package com.dci.tenant.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "container_type")
public class ContainerType {

	@Id
	@Column(name = "container_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int containerTypeId;
	
	@Column(name = "container_type")
	private String containerType;
	
	@Column(name = "description")
	private String description;

	public int getContainerTypeId() {
		return containerTypeId;
	}

	public void setContainerTypeId(int containerTypeId) {
		this.containerTypeId = containerTypeId;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}