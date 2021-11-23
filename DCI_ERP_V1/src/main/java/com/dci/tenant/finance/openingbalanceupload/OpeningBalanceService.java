package com.dci.tenant.finance.openingbalanceupload;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface OpeningBalanceService {

	public List<OpeningBalanceBean> getBranchList() throws Exception;

	public OpeningBalanceResultBean getdropList() throws Exception;

	OpeningBalanceResultBean save(OpeningBalanceBean mablBean);

	OpeningBalanceResultBean generateJv(OpeningBalanceBean mablBean);

	OpeningBalanceResultBean editMabl(int transactionid);

	public OpeningBalanceResultBean update(OpeningBalanceBean mablBean);

	public List<OpeningBalanceBean> getBranchList1(OpeningBalanceBean bean) throws Exception;

	void excellExport(List<OpeningBalanceBean> feereport, OpeningBalanceBean FeeBeanobj, String pdfFile);

	OpeningBalanceResultBean uploadFile(MultipartFile file);

	public String uploadFile1(MultipartFile file);

	public List<OpeningBalanceBean> getJournalVoucherList(OpeningBalanceBean journalVoucherBean) throws Exception;

}
