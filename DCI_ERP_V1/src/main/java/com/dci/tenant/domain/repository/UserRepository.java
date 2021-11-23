package com.dci.tenant.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.UserBean;
@Transactional("tenantTransactionManager")

public interface UserRepository extends JpaRepository<UserBean, Long> {

}
