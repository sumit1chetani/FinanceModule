package com.dci.master.company;

import java.util.List;


public interface CompanyDAO {

	public List<CompanyBean> getCompanyList();

	public List<CompanyBean> getCountry();

	public List<CompanyBean> getdropdown();

	public CompanyBean insert(CompanyBean company) throws Exception;

	public CompanyBean update(CompanyBean company) throws Exception;

	public boolean delete(String company_code);

	public CompanyBean getEdit(String company_code);
}
