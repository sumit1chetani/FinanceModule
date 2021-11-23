package com.dci.tenant.finance.salesorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {
	@Autowired
	public SalesOrderDAO salesOrderDAO;

	@Override
	public List<SalesOrderBean> getSalesOrderList() throws CustomException {
		return salesOrderDAO.getSalesOrderList();
	}

	@Override
	public SalesOrderResultBean getDropDownList() throws CustomException {
		return salesOrderDAO.getDropDownList();
	}

	@Override
	public boolean save(SalesOrderBean salesOrderBean) throws CustomException {
		return salesOrderDAO.save(salesOrderBean);
	}

	@Override
	public SalesOrderBean getSalesOrder(int salesOrderId) throws CustomException {
		return salesOrderDAO.getSalesOrder(salesOrderId);
	}

	@Override
	public boolean update(SalesOrderBean salesOrderBean) throws CustomException {
		return salesOrderDAO.update(salesOrderBean);
	}

	@Override
	public boolean deleteSalesOrder(int salesOrderId) throws CustomException {
		return salesOrderDAO.deleteSalesOrder(salesOrderId);
	}

}