package com.dci.tenant.domain.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.Route;
@Resource
@Transactional("tenantTransactionManager")
public interface RouteRepository extends JpaRepository<Route, Long> {


}
