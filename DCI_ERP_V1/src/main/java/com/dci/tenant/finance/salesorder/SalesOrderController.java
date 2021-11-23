package com.dci.tenant.finance.salesorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "app/salesorder")
public class SalesOrderController {
	private final static Logger LOGGER = LoggerFactory.getLogger(SalesOrderController.class);

	@Autowired
	public SalesOrderService salesOrderService;

	@RequestMapping(value = "/list")
	public SalesOrderResultBean getSalesOrderList() {
		SalesOrderResultBean salesOrderResultBean = new SalesOrderResultBean();
		try {
			salesOrderResultBean.setSalesOrderBeanList(salesOrderService.getSalesOrderList());
			salesOrderResultBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salesOrderResultBean;
	}

	@RequestMapping(value = "/edit")
	public SalesOrderBean getSalesOrder(@RequestParam("salesOrderId") int salesOrderId) {
		SalesOrderBean salesOrderBean = new SalesOrderBean();
		try {
			salesOrderBean = salesOrderService.getSalesOrder(salesOrderId);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salesOrderBean;
	}

	@RequestMapping(value = "/delete")
	public SalesOrderResultBean deleteSalesOrder(@RequestParam("salesOrderId") int salesOrderId) {
		SalesOrderResultBean salesOrderResultBean = new SalesOrderResultBean();
		try {
			salesOrderResultBean.setSuccess(salesOrderService.deleteSalesOrder(salesOrderId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salesOrderResultBean;
	}

	@RequestMapping(value = "/getDropDownList")
	public SalesOrderResultBean getDropDownList() {
		SalesOrderResultBean salesOrderResultBean = new SalesOrderResultBean();
		try {
			salesOrderResultBean = salesOrderService.getDropDownList();
			salesOrderResultBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salesOrderResultBean;
	}

	@RequestMapping(value = "/save")
	public SalesOrderResultBean save(@RequestBody SalesOrderBean salesOrderBean) {
		SalesOrderResultBean salesOrderResultBean = new SalesOrderResultBean();
		try {
			salesOrderService.save(salesOrderBean);
			salesOrderResultBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salesOrderResultBean;
	}

	@RequestMapping(value = "/update")
	public SalesOrderResultBean update(@RequestBody SalesOrderBean salesOrderBean) {
		SalesOrderResultBean salesOrderResultBean = new SalesOrderResultBean();
		try {
			salesOrderService.update(salesOrderBean);
			salesOrderResultBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salesOrderResultBean;
	}
}
