package com.dci.payroll.tds.tds;

import java.util.List;
import java.util.Map;

public interface TdsDAO {
	public List<TdsBean> getSlabList(String employeeId, String financialYear) throws Exception;

	public List<Map<String, Object>> getPayList(String employeeId, String financialYear) throws Exception;

	public List<Map<String, Object>> getSubSectionList(String employeeId, String financialYear, boolean declared, boolean actuval) throws Exception;

	public List<Map<String, Object>> getOtherIncomeList(String employeeId, String financialYear) throws Exception;

	TdsBean getmothBean(String employeeId, String financialYear) throws Exception;
}