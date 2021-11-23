package com.dci.tenant.finance.openingbalanceupload;

import java.util.HashMap;
import java.util.List;

public interface OpeningBalanceDAO {

	public List<OpeningBalanceBean> getBranchList1(OpeningBalanceBean bean) throws Exception;

	public List<OpeningBalanceBean> getBranchList() throws Exception;

	public OpeningBalanceResultBean getdropList() throws Exception;

	OpeningBalanceResultBean save(OpeningBalanceBean mablBean);

	OpeningBalanceResultBean generateJv(OpeningBalanceBean mablBean);

	OpeningBalanceResultBean editMabl(int transactionid);

	public OpeningBalanceResultBean update(OpeningBalanceBean mablBean);

	public HashMap<String, String> getSupplier();

	public HashMap<String, String> getAccount();

	public String InsertUploadData(List<OpeningBalanceBean> bean);

	public HashMap<String, String> getCompany();

	public HashMap<String, String> getCustomer();

	public List<OpeningBalanceBean> getJournalVoucherList(OpeningBalanceBean journalVoucherBean) throws Exception;

}
