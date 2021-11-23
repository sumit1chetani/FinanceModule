package com.dci.tenant.user;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.common.util.InvoiceMoveToDraft;

public interface UserMasterDAO {

	/**
	 * @return
	 */
	List<ModuleMasterBean> getModuleMasterList();

	public List<GrantedAuthority> loadPermissionsByUsernameCustomer(boolean isAgent);

	int getcount(String userName) throws CustomException;

	/**
	 * @return
	 * @throws CustomException
	 */
	List<FormMasterBean> getFormMasterListAll(boolean isAgent) throws CustomException;

	/**
	 * @param formCodeSet
	 * @param desgnCode
	 * @return
	 * @throws CustomException
	 */
	List<FormPropertyBean> getFormPropertyBeanListByDesgn(Set<String> formCodeSet, String desgnCode) throws CustomException;

	/**
	 * @param formCode
	 * @return
	 * @throws CustomException
	 */
	List<FormPropertyBean> getFormPropertyBeanListByFormCode(String formCode) throws CustomException;

	Map<String, FormPropertyBean> getFormPropertyBeanMapByFormCode(String formCode) throws CustomException;

	/**
	 * @param formCodeSet
	 * @param companyUserId
	 * @return
	 * @throws CustomException
	 */
	List<FormPropertyBean> getFormPropertyBeanListByCompanyUser(Set<String> formCodeSet, Integer companyUserId) throws CustomException;

	/**
	 * @param lFormPropertyId
	 * @param companyUserId
	 * @param mode 
	 * @param companyCode 
	 * @param userId 
	 * @throws CustomException
	 */
	void insertFormPropertyBeanListByCompanyUser(List<Integer> lFormPropertyId, int companyUserId, String userId, String companyCode, String mode) throws CustomException;

	/**
	 * @param lFormPropertyId
	 * @param companyUserId
	 * @throws CustomException
	 */
	void deleteFormPropertyBeanListByCompanyUser(List<Integer> lFormPropertyId, int companyUserId) throws CustomException;

	/**
	 * @param lFormPropertyId
	 * @param desgnCode
	 */
	void insertFormPropertyBeanListDesgn(List<Integer> lFormPropertyId, String desgnCode);

	/**
	 * @param lFormPropertyId
	 * @param desgnCode
	 */
	void deleteFormPropertyBeanListDesgn(List<Integer> lFormPropertyId, String desgnCode);

	/**
	 * @param userId
	 * @return
	 * @throws CustomException
	 */
	List<String> getCompanyCodeList(String userId) throws CustomException;

	/**
	 * @return
	 * @throws CustomException
	 */
	List<DesignationMasterBean> getDesignationList() throws CustomException;

	/**
	 * @return
	 * @throws CustomException
	 */
	List<CompanyDetailsBean> getCompanyList() throws CustomException;

	/**
	 * @return
	 * @throws Exception
	 */
	List<UserMasterBean> getUserList() throws Exception;

	/**
	 * @param companyCode
	 * @param userId
	 * @return
	 * @throws CustomException
	 */
	int getCompanyUserId(String companyCode, String userId) throws CustomException;

	/**
	 * @param companyCode
	 * @param userId
	 * @return
	 * @throws CustomException
	 */
	int insertCompanyUserId(String companyCode, String userId,String mode) throws CustomException;

	/**
	 * @param username
	 * @return
	 * @throws CustomException
	 */
	UserDetail loadUserByUsername(String username) throws CustomException;

	/**
	 * @param companyUserId
	 * @return
	 */
	List<GrantedAuthority> loadPermissionsByUsername(int companyUserId, boolean isAgent);

	/**
	 * @return
	 * @throws CustomException
	 */
	List<PropertyMasterBean> getPropertyMasterBeanList() throws CustomException;

	/**
	 * @param userId
	 * @return
	 * @throws CustomException
	 */
	UserMasterBean getUser(String userId) throws CustomException;

	/**
	 * @param moduleCode
	 * @param desgnCode
	 * @return
	 * @throws CustomException
	 */
	List<FormMasterBean> getFormMasterListByDesgn(String moduleCode, String desgnCode) throws CustomException;

	/**
	 * @param fromCompUserId
	 * @param toCompUserId
	 * @throws CustomException
	 */
	void insertCompanyToCompany(int fromCompUserId, int toCompUserId) throws CustomException;

	/**
	 * @param userId
	 * @param companyCode
	 * @param moduleCode
	 * @return
	 * @throws CustomException
	 */
	List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode) throws CustomException;

	/**
	 * @param companyCode
	 * @return
	 * @throws Exception
	 */
	List<UserMasterBean> getUserList(String companyCode) throws Exception;

	/**
	 * @param userId
	 * @throws CustomException
	 */
	void deleteFormPropertyBeanListByUser(String userId) throws CustomException;

	/**
	 * @param companyCode
	 * @param userId
	 * @param desgnCode
	 * @throws CustomException
	 */
	void insertFormPropertyBeanListDesgnNCompUser(String companyCode, String userId, String desgnCode) throws CustomException;

	/**
	 * @param moduleCode
	 * @param isParent
	 * @return
	 * @throws CustomException
	 */
	List<FormMasterBean> getFormMasterListByModuleCode(String moduleCode, String formCode, boolean isParent) throws CustomException;

	/**
	 * @return
	 * @throws CustomException
	 */
	Map<String, PropertyMasterBean> getPropertyMasterBeanMap() throws CustomException;

	/**
	 * @param desgnCode
	 * @return
	 * @throws CustomException
	 */
	List<Integer> getlFormPropIdByDesgn(String desgnCode) throws CustomException;

	/**
	 * @param companyUserId
	 * @return
	 * @throws CustomException
	 */
	List<Integer> getlFormPropIdByCompUser(int companyUserId) throws CustomException;
	
	
	List<Integer> getlFormPropIdByCustomer() throws CustomException;


	/**
	 * @return
	 * @throws CustomException
	 */
	Map<String, String> getFormCodeUrlMap() throws CustomException;

	/**
	 * @param companyUserId
	 * @return
	 * @throws CustomException
	 */
	List<String> getlEnabledFormCode(int companyUserId) throws CustomException;

	List<UserMasterBean> getCompanyList(String formCode);
	
	List<UserMasterBean> getCompanyList1(String formCode);

	Map<String, String> getAddUrlFormCodeMap() throws CustomException;

	List<String> getlFormCodeByCompUser(int companyUserId) throws CustomException;

	List<FormMasterBean> getFormMasterListByModuleCodeBase(String moduleCode, String formCode, boolean isParent) throws CustomException;

	/**
	 * @param companyCode
	 * @return
	 * @throws CustomException
	 */
	CompanyDetailsBean getCompanyDetailsBean(String companyCode) throws CustomException;

	/**
	 * @return
	 * @throws CustomException
	 */
	Map<String, String> getFormCodeNameMap() throws CustomException;

	/**
	 * @return
	 * @throws CustomException
	 */
	Map<String, String> getEmpIdNameMap() throws CustomException;

	void insertUserLogIp(UserDetail user,String actionType);
	
	public List<Map<String, Object>> getEmployeeIncompany(UserMasterBean obj);
	public List<Map<String, Object>> getEmployeeModule(String employee,String company) ;
	public List<Map<String, Object>> getEmployeeRights(String employee,String moduleId,String company);
	boolean forgetPassword(String emailId) throws Exception;
	
	public List<UserDetail> getBranchList() throws Exception;

	boolean invoicemovetodraft(InvoiceMoveToDraft invoiceDraft);
	
	public List<SelectivityBean> getInvoiceList(String invoiceType,String mode);
	
	List<FormPropertyBean> getFormNames();

	UserFormRightsPropertyBean getUserFormRights(String formCode);

	/*void insertFormPropertyBeanListByCompanyUsermode(String companyCode, String userId, Integer companyUserId,
			String mode) 	throws CustomException ;*/


}
