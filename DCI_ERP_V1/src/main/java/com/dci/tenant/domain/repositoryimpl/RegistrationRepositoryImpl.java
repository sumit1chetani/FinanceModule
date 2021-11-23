package com.dci.tenant.domain.repositoryimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.TenantUser;
import com.dci.tenant.domain.repository.RegistrationRepositoryCustom;

@SuppressWarnings("unchecked")
@Repository
@Transactional("tenantTransactionManager")
public class RegistrationRepositoryImpl implements RegistrationRepositoryCustom {

	@PersistenceContext(unitName = "tenantEntityManager")
	private EntityManager em;

	@Override
	public boolean authenticateUser(String loginId, String otp, String password) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		try {
			Query query = em
					.createQuery("SELECT u FROM TenantUser u WHERE u.loginId = :loginId and u.otp = :otp ");
			query.setParameter("loginId", loginId);
			query.setParameter("otp", otp);
			isSuccess = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public TenantUser getUserInfo(Integer loginId) {
		// TODO Auto-generated method stub
		TenantUser registration = null;
		try {
			Query query = em
					.createQuery("SELECT u FROM TenantUser u WHERE u.tenantUserId = :tenantUserId");
			query.setParameter("tenantUserId", loginId);
			registration = (TenantUser) query.getSingleResult();
		} catch (Exception ex) {

		}
		return registration;
	}
}