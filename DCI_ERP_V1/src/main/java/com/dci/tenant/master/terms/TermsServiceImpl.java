package com.dci.tenant.master.terms;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class TermsServiceImpl implements TermsService{
	@Autowired
	TermsDao portDao;
	@Override
	public TermsResultBean selectivity() throws Exception {
		
		return portDao.selectivity();
	}
	@Override
	public List<TermsBean> getList() {
		
		return portDao.getList();
	}

	@Override
	public Object save(TermsBean bean) throws CustomException {
		
		return portDao.save(bean);
	}

	@Override
	public TermsBean edit(int rowid) throws Exception {
		
		return portDao.edit(rowid);
	}

	@Override
	public boolean update(TermsBean update) throws Exception {
		
		return portDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return portDao.delete(rowid);
	}

	
}
