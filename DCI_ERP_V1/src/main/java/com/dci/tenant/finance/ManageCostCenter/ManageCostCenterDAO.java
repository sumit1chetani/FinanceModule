package com.dci.tenant.finance.ManageCostCenter;

import java.util.List;

public interface ManageCostCenterDAO {
	public boolean insertManageCostCenter(ManageCostCenterBean manageCostCenterBean) throws Exception;

	List<ManageCostCenterBean> getList() throws Exception;

	public boolean deleteManageCostCenter(Integer costCenterId) throws Exception;

	public ManageCostCenterBean editManageCostCenter(Integer costCenterId) throws Exception;

	public boolean updateManageCostCenter(ManageCostCenterBean manageCostCenterBean) throws Exception;
}
