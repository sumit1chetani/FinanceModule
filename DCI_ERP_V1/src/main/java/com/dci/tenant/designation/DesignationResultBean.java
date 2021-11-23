package com.dci.tenant.designation;



import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class DesignationResultBean extends BasicResultBean implements Serializable {


	private static final long serialVersionUID = 1L;

	private List<DesignationBean> lDesignationBean;

	public List<DesignationBean> getlDesignationBean() {
		return lDesignationBean;
	}

	public void setlDesignationBean(List<DesignationBean> lDesignationBean) {
		this.lDesignationBean = lDesignationBean;
	}

}
