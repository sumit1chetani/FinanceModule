package com.dci.tenant.user.resetPassword;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class ResetPasswordResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ResetPasswordBean> lResetPasswordBean;

	public List<ResetPasswordBean> getlResetPasswordBean() {
		return lResetPasswordBean;
	}

	public void setlResetPasswordBean(List<ResetPasswordBean> lResetPasswordBean) {
		this.lResetPasswordBean = lResetPasswordBean;
	}
}
