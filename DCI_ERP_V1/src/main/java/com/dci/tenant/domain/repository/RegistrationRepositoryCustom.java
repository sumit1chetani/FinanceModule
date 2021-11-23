package com.dci.tenant.domain.repository;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.TenantUser;

@Resource
@Transactional("tenantTransactionManager")
public interface RegistrationRepositoryCustom {

	boolean authenticateUser(String loginId, String otp, String password);

	public TenantUser getUserInfo(Integer tenantUserId);

}