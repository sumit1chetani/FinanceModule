package com.dci.master.domain.repository;

import javax.annotation.Resource;

import com.dci.tenant.domain.model.resultbean.RegistrationResultBean;

@Resource
public interface AdminUserRepository {

	public RegistrationResultBean authenticateUser(String userName,
			String password);

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public RegistrationResultBean authenticateMasterUser(String username,
			String password);
}
