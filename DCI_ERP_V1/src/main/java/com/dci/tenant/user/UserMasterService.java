package com.dci.tenant.user;

import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.common.util.InvoiceMoveToDraft;

public interface UserMasterService {

	/**
	 * @return
	 * @throws Exception
	 */
	List<ModuleMasterBean> getModuleMasterList() throws Exception;

	/**
	 * @param userId
	 * @param companyCode
	 * @param moduleCode
	 * @return
	 * @throws Exception
	 */
	List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode) throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	List<PropertyMasterBean> getPropertyMasterBeanList() throws Exception;

	/**
	 * @param desgnCode
	 * @param moduleCode
	 * @return
	 * @throws Exception
	 */
	List<FormMasterBean> getFormMasterListByDesgn(String desgnCode, String moduleCode) throws Exception;

	/**
	 * @param companyUserId
	 * @return
	 * @throws Exception
	 */
	List<FormMasterBean> getFormMasterListAll(int companyUserId, boolean isAgent) throws Exception;

	/**
	 * @param lFormMasterBean
	 * @param userId
	 * @param companyCode
	 * @param moduleCode
	 * @return
	 * @throws Exception
	 */
	List<FormMasterBean> saveFormMasterListByCompanyUser(List<FormMasterBean> lFormMasterBean, String userId, String companyCode, String moduleCode,String mode)
			throws Exception;

	/**
	 * @param lFormMasterBean
	 * @param desgnCode
	 * @param moduleCode
	 * @return
	 * @throws Exception
	 */
	List<FormMasterBean> saveFormMasterListByDesgn(List<FormMasterBean> lFormMasterBean, String desgnCode, String moduleCode) throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	List<UserMasterBean> getUserList() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	List<CompanyDetailsBean> getCompanyList() throws Exception;

	
	public List<GrantedAuthority> loadPermissionsByUsernameCustomer(boolean isAgent);
	
	/**
	 * @return
	 * @throws Exception
	 */
	List<DesignationMasterBean> getDesignationList() throws Exception;

	/**
	 * @param fromCompId
	 * @param toCompId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	UserMasterBean insertCompanyToCompany(String fromCompId, String toCompId, String userId) throws Exception;

	/**
	 * @param fromUserId
	 * @param toUserId
	 * @return
	 * @throws CustomException
	 */
	boolean insertUserToUser(String fromUserId, String toUserId, String compMapped) throws CustomException;

	/**
	 * @param companyCode
	 * @return
	 * @throws Exception
	 */
	List<UserMasterBean> getUserList(String companyCode) throws Exception;

	public List<UserMasterBean> getCompanyList(String formCode);
	
	public List<UserMasterBean> getCompanyList1(String formCode);

	public void excellexport(UserMasterResultBean objWholeData, String filepath, String fileNme);

	void insertUserLogIp(UserDetail user, String string);

	public void generateEmployeeCompany(UserMasterBean objWholeData, String exportFilesPath);
	
	UserDetail loadUserByUsername(String username) throws CustomException;
	
	int getCompanyUserId(String companyCode, String userId) throws CustomException;
	
	int getcount(String userName) throws CustomException;

	List<GrantedAuthority> loadPermissionsByUsername(int companyUserId, boolean isAgent);
	
	Map<String, String> getFormCodeUrlMap() throws CustomException;
	
	Map<String, String> getAddUrlFormCodeMap() throws CustomException;

	boolean forgetPassword(String emailId) throws Exception;
	
	void sendMail2(Email email, String sFilePath) throws Exception;
	
	public List<UserDetail> getBranchList() throws Exception;

	boolean invoicemovetodraft(InvoiceMoveToDraft invoiceDraft);
	
	public List<SelectivityBean> getInvoiceList(String invoiceType,String mode);
	
	public List<FormPropertyBean> getFormNames();


	void excelFormexport(String formCode, String filePath);
}
