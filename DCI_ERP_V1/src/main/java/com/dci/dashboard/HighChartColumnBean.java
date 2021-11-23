package com.dci.dashboard;

import java.util.List;

public class HighChartColumnBean {

	public List<DataBean> data;
	public String name;
	public String type;
	public String color;
	public Tooltip tooltip = new Tooltip();
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public List<DataBean> getData() {
		return data;
	}

	public void setData(List<DataBean> data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	
	
}
