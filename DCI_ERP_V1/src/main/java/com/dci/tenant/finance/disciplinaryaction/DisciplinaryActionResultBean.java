package com.dci.tenant.finance.disciplinaryaction;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

	
public class DisciplinaryActionResultBean extends BasicResultBean implements Serializable {

	private List<DisciplinaryActionBean> disciplinaryList;

	public List<DisciplinaryActionBean> getDisciplinaryList() {
		return disciplinaryList;
	}

	public void setDisciplinaryList(List<DisciplinaryActionBean> disciplinaryList) {
		this.disciplinaryList = disciplinaryList;
	}

}
