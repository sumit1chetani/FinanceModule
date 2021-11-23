package com.dci.tenant.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

	@Id
	@Column(name = "route_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;

	@Column(name = "route_name")
	private String routeName;

	@Column(name = "no_of_stoppings")
	private Integer NoOfStopping;

	@Column(name = "description")
	private String routeDescription;

	@Column(name = "total_distance")
	private Integer totalDistance;

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Integer getNoOfStopping() {
		return NoOfStopping;
	}

	public void setNoOfStopping(Integer noOfStopping) {
		NoOfStopping = noOfStopping;
	}

	public String getRouteDescription() {
		return routeDescription;
	}

	public void setRouteDescription(String routeDescription) {
		this.routeDescription = routeDescription;
	}

	public Integer getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(Integer totalDistance) {
		this.totalDistance = totalDistance;
	}

	
	
	

}
