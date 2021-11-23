package com.dci.dashboard;

import java.util.List;

public class HighChartColumnHeadingBean {

	public List<String> categories;
	public String name;
	public String fill;
	
	
	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}
