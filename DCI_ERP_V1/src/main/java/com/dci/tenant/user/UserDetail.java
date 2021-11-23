/**
 *
 */
package com.dci.tenant.user;

/**
 * @author paragon
 *
 */
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetail implements UserDetails {
	private static final long serialVersionUID = 1L;
	private int companyUserId;
	private String companyCode;
	private String companyCountry;
	private String userId;
	private String username;
	private String username2;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String profileImg;
	private List<FormMasterBean> lFormMasterBean;
	private boolean isAgent;
	private String departmentName;
	private String departmentCode;
	private String designationName;
	private String[] userPortList;
	private String userPortStr;
	private String userIpAddress;
	private Map<String, String> listUrlFormCodeMap;
	

//	private Map<String, FormServiceBeanView> listUrlFormServiceBeanVMap;

	private String tenantId;
	private String branchId;
	private String isVendor;
	private String vendorName;
	private Map<String, String> addUrlFormCodeMap;

	/* Spring Security fields */
	private List<GrantedAuthority> authorities;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	private  String customerId;
	
	private String userFullName;
	private String companyName;
	private String 	BranchName;
	private String 	designationId;
	private String  empId;
	
	
	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getIsVendor() {
		return isVendor;
	}

	public void setIsVendor(String isVendor) {
		this.isVendor = isVendor;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(List<GrantedAuthority> list) {
		this.authorities = list;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetail [username=");
		builder.append(username);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", authorities=");
		builder.append(authorities);
		builder.append(", accountNonExpired=");
		builder.append(accountNonExpired);
		builder.append(", accountNonLocked=");
		builder.append(accountNonLocked);
		builder.append(", credentialsNonExpired=");
		builder.append(credentialsNonExpired);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the companyUserId
	 */
	public int getCompanyUserId() {
		return companyUserId;
	}

	/**
	 * @param companyUserId
	 *            the companyUserId to set
	 */
	public void setCompanyUserId(int companyUserId) {
		this.companyUserId = companyUserId;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * @param companyId
	 *            the companyId to set
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * @return the lFormMasterBean
	 */
	public List<FormMasterBean> getlFormMasterBean() {
		return lFormMasterBean;
	}

	/**
	 * @param lFormMasterBean
	 *            the lFormMasterBean to set
	 */
	public void setlFormMasterBean(List<FormMasterBean> lFormMasterBean) {
		this.lFormMasterBean = lFormMasterBean;
	}

	/**
	 * @return the isAgent
	 */
	public boolean isAgent() {
		return isAgent;
	}

	/**
	 * @param isAgent
	 *            the isAgent to set
	 */
	public void setAgent(boolean isAgent) {
		this.isAgent = isAgent;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String[] getUserPortList() {
		return userPortList;
	}

	public void setUserPortList(String[] userPortList) {
		this.userPortList = userPortList;
	}

	public String getUserPortStr() {
		return userPortStr;
	}

	public void setUserPortStr(String userPortStr) {
		this.userPortStr = userPortStr;
	}

	public Map<String, String> getListUrlFormCodeMap() {
		return listUrlFormCodeMap;
	}

	public void setListUrlFormCodeMap(Map<String, String> listUrlFormCodeMap) {
		this.listUrlFormCodeMap = listUrlFormCodeMap;
	}
	
	/*public Map<String, FormServiceBeanView> getListUrlFormServiceBeanVMap() {
		return listUrlFormServiceBeanVMap;
	}

	public void setListUrlFormServiceBeanVMap(Map<String, FormServiceBeanView> listUrlFormServiceBeanVMap) {
		this.listUrlFormServiceBeanVMap = listUrlFormServiceBeanVMap;
	}*/

	public Map<String, String> getAddUrlFormCodeMap() {
		return addUrlFormCodeMap;
	}

	public void setAddUrlFormCodeMap(Map<String, String> addUrlFormCodeMap) {
		this.addUrlFormCodeMap = addUrlFormCodeMap;
	}

	/**
	 * @return the companyCountry
	 */
	public String getCompanyCountry() {
		return companyCountry;
	}

	/**
	 * @param companyCountry
	 *            the companyCountry to set
	 */
	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	/**
	 * @return the profileImg
	 */
	public String getProfileImg() {
		return profileImg;
	}

	/**
	 * @param profileImg
	 *            the profileImg to set
	 */
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getUserIpAddress() {
		return userIpAddress;
	}

	public void setUserIpAddress(String userIpAddress) {
		this.userIpAddress = userIpAddress;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
	}

	

}