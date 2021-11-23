package com.dci.master.CompanyGroup;

import java.util.List;

import com.dci.common.util.CustomException;


public interface CompanyGroupDAO {

	public boolean addCompanyDetails(CompanyGroupBean objCompanyDetailsBean) throws CustomException;

	public List<CompanyGroupBean> getCompanyDetailsList() throws CustomException;

	public List<CompanyGroupBean> CompanyGroupEditDetList(Integer groupId) throws CustomException;

	public List<CompanyGroupBean> getCompanyGroupTableList() throws CustomException;

	public boolean deleteCompanyDetail(int groupId) throws CustomException;

	public boolean companyGroupNameCheck(String companyGroupName) throws CustomException;

	public boolean multideleteCompanyDetail(String companycode) throws CustomException;

	public List<CompanyGroupBean> getCompanyList() throws CustomException;

}
