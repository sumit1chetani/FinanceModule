package com.dci.tenant.finance.ManageCostCenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageCostCenterServiceImpl implements ManageCostCenterService {
	@Autowired
	ManageCostCenterDAO manageCostCenterDAO;

	@Override
	public boolean insertManageCostCenter(ManageCostCenterBean manageCostCenterBean) throws Exception {
		// TODO Auto-generated method stub
		return manageCostCenterDAO.insertManageCostCenter(manageCostCenterBean);
	}

	@Override
	public List<ManageCostCenterBean> getList() throws Exception {
		// TODO Auto-generated method stub
		return manageCostCenterDAO.getList();
	}

	@Override
	public boolean deleteManageCostCenter(Integer costCenterId) throws Exception {
		// TODO Auto-generated method stub
		return manageCostCenterDAO.deleteManageCostCenter(costCenterId);

	}

	@Override
	public ManageCostCenterBean editManageCostCenter(Integer costCenterId) throws Exception {
		// TODO Auto-generated method stub
		return manageCostCenterDAO.editManageCostCenter(costCenterId);
	}

	@Override
	public boolean updateManageCostCenter(ManageCostCenterBean manageCostCenterBean) throws Exception {
		// TODO Auto-generated method stub
		return manageCostCenterDAO.updateManageCostCenter(manageCostCenterBean);
	}

}
