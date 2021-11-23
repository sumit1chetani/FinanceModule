package com.dci.tenant.finance.salesorder;

import java.util.List;

import com.dci.common.util.CustomException;

public interface SalesOrderService {

	List<SalesOrderBean> getSalesOrderList() throws CustomException;

	SalesOrderResultBean getDropDownList() throws CustomException;

	boolean save(SalesOrderBean salesOrderBean) throws CustomException;

	SalesOrderBean getSalesOrder(int salesOrderId) throws CustomException;

	boolean update(SalesOrderBean salesOrderBean) throws CustomException;

	boolean deleteSalesOrder(int salesOrderId) throws CustomException;
}
