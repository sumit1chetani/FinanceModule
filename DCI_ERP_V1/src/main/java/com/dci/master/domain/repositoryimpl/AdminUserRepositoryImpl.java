package com.dci.master.domain.repositoryimpl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.master.domain.repository.AdminUserRepository;
import com.dci.tenant.domain.model.TenantUser;
import com.dci.tenant.domain.model.resultbean.RegistrationResultBean;

@Repository
@Transactional("masterTransactionManager")
public class AdminUserRepositoryImpl implements AdminUserRepository {

	@PersistenceContext(unitName = "masterEntityManager")
	private EntityManager em;

	@Override
	public RegistrationResultBean authenticateUser(String userName,
			String password) {
		RegistrationResultBean objBean = new RegistrationResultBean();
		try {
			Query query = em
					.createQuery("SELECT u FROM TenantUser u WHERE u.loginId = :userName and u.password = :password");
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			TenantUser regBean = (TenantUser) query.getSingleResult();
			if (regBean.isActive()) {
				objBean.setSuccess(regBean.isActive());
				objBean.setMessage("Successfully Authenticated!");
			} else {
				objBean.setSuccess(regBean.isActive());
				objBean.setMessage("User Account De Activated!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return objBean;
	}

	@Override
	public RegistrationResultBean authenticateMasterUser(String userName,String password) {
		RegistrationResultBean objBean = null;
		try {
			Query query = em.createNativeQuery("SELECT u.user_id FROM user u where u.login_name=:userName and u.password=:password");
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			Integer userId = (Integer) query.getSingleResult();
			objBean = new RegistrationResultBean();
			if (userId>0) {
				objBean.setSuccess(true);
				objBean.setMessage("Successfully Authenticated");
				objBean.setTenantUserId(userId);
			} else {
				objBean.setSuccess(false);
				objBean.setMessage("Username or password does not match!");
			}
		} catch (NoResultException ex) {
			objBean.setSuccess(false);
			objBean.setMessage("Username does not exists!");
		}
		return objBean;
	
	}
}
