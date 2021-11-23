package com.dci.master.template;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class TemplateResultBean extends BasicResultBean implements Serializable {

	private List<TemplateBean> list;

	public List<TemplateBean> getList() {
		return list;
	}

	public void setList(List<TemplateBean> list) {
		this.list = list;
	}

}
