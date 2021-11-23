package com.dci.tenant.finance.soa;

import java.util.List;

public interface SOADao {

	List<SOABean> getSoaCustomerRprtList(SOABean soabean);

	List<SOABean> soaCustomerRprtSubList(SOABean soabean);

	double debtorBalance(SOABean soabean);

}
