package com.dci.tenant.finance.journalVoucherType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalVoucherTypeServiceImpl implements JournalVoucherTypeService {

	@Autowired
	JournalVoucherTypeDAO journalVoucherTypeDAO;

	@Override
	public List<JournalVoucherTypeBean> getList() throws Exception {
		// TODO Auto-generated method stub
		return journalVoucherTypeDAO.getList();
	}

	@Override
	public boolean save(JournalVoucherTypeBean journalVoucherTypeBean) throws Exception {
		// TODO Auto-generated method stub
		return journalVoucherTypeDAO.save(journalVoucherTypeBean);
	}

	@Override
	public boolean update(JournalVoucherTypeBean journalVoucherTypeBean) throws Exception {
		// TODO Auto-generated method stub
		return journalVoucherTypeDAO.update(journalVoucherTypeBean);
	}

	@Override
	public boolean delete(Integer jvTypeId) throws Exception {
		// TODO Auto-generated method stub
		return journalVoucherTypeDAO.delete(jvTypeId);
	}

	@Override
	public JournalVoucherTypeBean getJvTypeId(int jvTypeId) throws Exception {
		// TODO Auto-generated method stub
		return journalVoucherTypeDAO.getJvTypeId(jvTypeId);
	}

	@Override
	public List<JournalVoucherTypeBean> getJvTypeList() throws Exception {
		// TODO Auto-generated method stub
		return journalVoucherTypeDAO.getJvTypeList();
	}

}
