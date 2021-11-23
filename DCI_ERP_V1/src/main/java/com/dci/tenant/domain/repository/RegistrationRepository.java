package com.dci.tenant.domain.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.TenantUser;

@Resource
@Transactional("tenantTransactionManager")
public interface RegistrationRepository extends JpaRepository<TenantUser, Long> {

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM TenantUser c WHERE c.loginId = :loginId")
	boolean checkUserExist(@Param("loginId") String loginId);

	@Modifying
	@Query("update TenantUser r set r.active = true where r.loginId =:loginId")
	void updateActiveFlag(@Param("loginId") String loginId);

	@Query("SELECT c FROM TenantUser c WHERE c.loginId = :loginId")
	TenantUser getRegistrationDetails(@Param("loginId") String loginId);

}
