package com.dci.tenant.master.terms;

import java.util.List;

import com.dci.common.util.CustomException;





public interface TermsService {
	public TermsResultBean selectivity() throws Exception;

	public List<TermsBean> getList();

	Object save(TermsBean bean) throws CustomException;

	public TermsBean edit(int rowid) throws Exception;

	public boolean update(TermsBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}
