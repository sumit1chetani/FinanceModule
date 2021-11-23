package com.dci.dashboard.gridTable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("tenantTransactionManager")
public class DashboardContainerDaoImpl implements DashboardContainerDao {

}
