package com.dci.tenant.finance.journalVoucherType;

import java.util.List;

public interface JournalVoucherTypeDAO {

	List<JournalVoucherTypeBean> getList() throws Exception;

	List<JournalVoucherTypeBean> getJvTypeList() throws Exception;

	JournalVoucherTypeBean getJvTypeId(int getSlabRateListbyId) throws Exception;

	boolean save(JournalVoucherTypeBean journalVoucherTypeBean) throws Exception;

	boolean update(JournalVoucherTypeBean journalVoucherTypeBean) throws Exception;

	boolean delete(Integer getSlabRateListbyId) throws Exception;
}
