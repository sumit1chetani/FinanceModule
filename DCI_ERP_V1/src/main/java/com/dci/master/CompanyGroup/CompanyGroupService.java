package com.dci.master.CompanyGroup;

import java.util.List;

public interface CompanyGroupService {

	public boolean addCompanyDetails(CompanyGroupBean objCompanyDetailsBean) throws Exception;

	public List<CompanyGroupBean> getCompanyDetailsList() throws Exception;

	public List<CompanyGroupBean> CompanyGroupEditDetList(Integer groupId) throws Exception;

	public List<CompanyGroupBean> getCompanyGroupTableList() throws Exception;

	boolean deleteCompanyDetail(int groupId) throws Exception;

	boolean companyGroupNameCheck(String companyGroupName) throws Exception;

	boolean multideleteCompanyDetail(String companycode) throws Exception;
	
	public List<CompanyGroupBean> getCompanyList() throws Exception;


}
