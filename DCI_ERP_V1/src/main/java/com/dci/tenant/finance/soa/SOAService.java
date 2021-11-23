package com.dci.tenant.finance.soa;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SOAService {

	List<SOABean> getSoaCustomerRprtList(SOABean soabean);

	List<SOABean> soaCustomerRprtSubList(SOABean soabean);


	boolean exportExcel(String filepath, SOABean soabean);

	double debtorBalance(SOABean soabean);


}
