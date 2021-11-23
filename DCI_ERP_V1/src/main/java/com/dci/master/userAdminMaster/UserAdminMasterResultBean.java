package com.dci.master.userAdminMaster;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class UserAdminMasterResultBean extends BasicResultBean implements Serializable {

	private String status1;
	private static final long serialVersionUID = 1L;
	private List<UserAdminMasterBean> companyList;
	private List<UserAdminMasterBean> branchList;
	private List<UserAdminMasterBean> branchEditList;
	public List<UserAdminMasterBean> getBranchEditList() {
		return branchEditList;
	}

	public void setBranchEditList(List<UserAdminMasterBean> branchEditList) {
		this.branchEditList = branchEditList;
	}

	private List<UserAdminMasterBean> departmentList;
	private List<UserAdminMasterBean> designationList;
	private List<UserAdminMasterBean> divisionList;
	private List<UserAdminMasterBean> gradeList;
	private List<UserAdminMasterBean> editList;
	private int status = 0;
	private boolean designationStatus;
	private boolean salesStatus;
	private String dependentFileName;
	private String empId;
	private Integer empDocId;
	private List<UserAdminMasterBean> reportToBranchList;
	private List<UserAdminMasterBean> reportToDeptList;
	private List<UserAdminMasterBean> reportToDesigList;
	private List<UserAdminMasterBean> reportToManager;
	private List<UserAdminMasterBean> principalList;
	private List<UserAdminMasterBean> msList;
	private List<SelectivityBean> bloodGroupList;

	private List<UserAdminEducationBean> yearList;
	private List<Integer> yearsList;
	private List<UserAdminExperianceBean> employeeExperianceList;
	private List<UserMAsterPerDetailsBean> EmployeeMAsterPerDetailsBeanList;
	private List<UserMasterPhysicalBean> EmployeeMasterPhysicalBeanBeanList;
	private List<UserAdminMasterPhoneNoDetailBean> objPhoneNo;
	private List<UserAdminMasterPhoneNoDetailBean> objMobileNo;
	private List<UserAdminMasterPhoneNoDetailBean> presentAddressMultiple;
	private UserAdminExperianceBean employeeExperianceBean;
	private List<UserAdminEducationBean> EmployeeEducationBeanList;
	private List<UserAdminEmergencyBean> EmployeeEmergencyBeanList;
	private List<UserAdminMeritsBean> EmployeeMeritsBeanList;
	private List<UserAdminFamilyBean> EmployeeFamilyBeanList;
	private List<UserAdminReferanceBean> EmployeeReferanceBeanList;
	private List<UserAdminDuplicateBean> employeeDuplicateList;
	private List<UserAdminNominationBean> EmployeeNominationBeanList;
	private List<UserAdminNominationBean> EmployeePhoneNoList;
	private List<UserAdminNominationBean> EmployeeMobileNoList;
	private List<UserAdminEmergencyBean> EmployeeEmePhNoList;
	private List<UserAdminEmergencyBean> EmployeeEmeMobNoList;
	private List<UserAdminDocumentBean> EmployeeDocumentBeanList;
	private List<UserAdminProbationBean> EmployeeProbationBeanList;
	private List<UserAdminMasterPersonalBean> EmployeePersonalBeanList;
	private UserAdminDocumentBean objEmployeeDocumentBean;
	private UserAdminMeritsBean objEmployeeMeritsBean;
	private UserAdminFamilyBean objEmployeeFamilyBean;
	private UserAdminExperianceBean objEmployeeExperianceBean;
	private UserAdminEducationBean objEmployeeEducationBean;
	private UserAdminReferanceBean objEmployeeReferanceBean;
	private UserAdminEmergencyBean objEmployeeEmergencyBean;
	private UserAdminNominationBean objEmployeeNominationBean;
	private UserAdminProbationBean objEmployeeProbationBean;
	private UserAdminMasterPersonalBean objEmployeeMasterPersonalBean;
	private UserAdminMasterAddressBean objEmployeeMasterAddressBean;
	private UserAdminMasterRulesBean objEmployeeMasterRulesBean;
	private UserAdminMAsterPerDetailsBean objEmployeeMAsterPerDetailsBean;
	private UserAdminMasterPhysicalBean objEmployeeMasterPhysicalBean;
	private int principalCount;
	private int msCount;
	private String empUserId;

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public List<UserAdminNominationBean> getEmployeePhoneNoList() {
		return EmployeePhoneNoList;
	}

	public void setEmployeePhoneNoList(List<UserAdminNominationBean> employeePhoneNoList) {
		EmployeePhoneNoList = employeePhoneNoList;
	}

	public List<UserAdminNominationBean> getEmployeeMobileNoList() {
		return EmployeeMobileNoList;
	}

	public void setEmployeeMobileNoList(List<UserAdminNominationBean> employeeMobileNoList) {
		EmployeeMobileNoList = employeeMobileNoList;
	}

	public List<UserAdminEmergencyBean> getEmployeeEmePhNoList() {
		return EmployeeEmePhNoList;
	}

	public void setEmployeeEmePhNoList(List<UserAdminEmergencyBean> employeeEmePhNoList) {
		EmployeeEmePhNoList = employeeEmePhNoList;
	}

	public List<UserAdminEmergencyBean> getEmployeeEmeMobNoList() {
		return EmployeeEmeMobNoList;
	}

	public void setEmployeeEmeMobNoList(List<UserAdminEmergencyBean> employeeEmeMobNoList) {
		EmployeeEmeMobNoList = employeeEmeMobNoList;
	}

	public UserAdminEmergencyBean getObjEmployeeEmergencyBean() {
		return objEmployeeEmergencyBean;
	}

	public void setObjEmployeeEmergencyBean(UserAdminEmergencyBean objEmployeeEmergencyBean) {
		this.objEmployeeEmergencyBean = objEmployeeEmergencyBean;
	}

	public UserAdminNominationBean getObjEmployeeNominationBean() {
		return objEmployeeNominationBean;
	}

	public void setObjEmployeeNominationBean(UserAdminNominationBean objEmployeeNominationBean) {
		this.objEmployeeNominationBean = objEmployeeNominationBean;
	}

	public UserAdminReferanceBean getObjEmployeeReferanceBean() {
		return objEmployeeReferanceBean;
	}

	public void setObjEmployeeReferanceBean(UserAdminReferanceBean objEmployeeReferanceBean) {
		this.objEmployeeReferanceBean = objEmployeeReferanceBean;
	}

	public UserAdminExperianceBean getObjEmployeeExperianceBean() {
		return objEmployeeExperianceBean;
	}

	public void setObjEmployeeExperianceBean(UserAdminExperianceBean objEmployeeExperianceBean) {
		this.objEmployeeExperianceBean = objEmployeeExperianceBean;
	}

	public UserAdminEducationBean getObjEmployeeEducationBean() {
		return objEmployeeEducationBean;
	}

	public void setObjEmployeeEducationBean(UserAdminEducationBean objEmployeeEducationBean) {
		this.objEmployeeEducationBean = objEmployeeEducationBean;
	}

	public UserAdminFamilyBean getObjEmployeeFamilyBean() {
		return objEmployeeFamilyBean;
	}

	public void setObjEmployeeFamilyBean(UserAdminFamilyBean objEmployeeFamilyBean) {
		this.objEmployeeFamilyBean = objEmployeeFamilyBean;
	}

	public List<UserAdminEmergencyBean> getEmployeeEmergencyBeanList() {
		return EmployeeEmergencyBeanList;
	}

	public void setEmployeeEmergencyBeanList(List<UserAdminEmergencyBean> employeeEmergencyBeanList) {
		EmployeeEmergencyBeanList = employeeEmergencyBeanList;
	}

	public List<UserAdminMeritsBean> getEmployeeMeritsBeanList() {
		return EmployeeMeritsBeanList;
	}

	public void setEmployeeMeritsBeanList(List<UserAdminMeritsBean> employeeMeritsBeanList) {
		EmployeeMeritsBeanList = employeeMeritsBeanList;
	}

	public List<UserAdminFamilyBean> getEmployeeFamilyBeanList() {
		return EmployeeFamilyBeanList;
	}

	public void setEmployeeFamilyBeanList(List<UserAdminFamilyBean> employeeFamilyBeanList) {
		EmployeeFamilyBeanList = employeeFamilyBeanList;
	}

	public List<UserAdminReferanceBean> getEmployeeReferanceBeanList() {
		return EmployeeReferanceBeanList;
	}

	public void setEmployeeReferanceBeanList(List<UserAdminReferanceBean> employeeReferanceBeanList) {
		EmployeeReferanceBeanList = employeeReferanceBeanList;
	}

	public List<UserAdminNominationBean> getEmployeeNominationBeanList() {
		return EmployeeNominationBeanList;
	}

	public void setEmployeeNominationBeanList(List<UserAdminNominationBean> employeeNominationBeanList) {
		EmployeeNominationBeanList = employeeNominationBeanList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<UserAdminEducationBean> getEmployeeEducationBeanList() {
		return EmployeeEducationBeanList;
	}

	public void setEmployeeEducationBeanList(List<UserAdminEducationBean> employeeEducationBeanList) {
		EmployeeEducationBeanList = employeeEducationBeanList;
	}

	public UserAdminExperianceBean getEmployeeExperianceBean() {
		return employeeExperianceBean;
	}

	public void setEmployeeExperianceBean(UserAdminExperianceBean employeeExperianceBean) {
		this.employeeExperianceBean = employeeExperianceBean;
	}

	public List<UserAdminExperianceBean> getEmployeeExperianceList() {
		return employeeExperianceList;
	}

	public void setEmployeeExperianceList(List<UserAdminExperianceBean> employeeExperianceList) {
		this.employeeExperianceList = employeeExperianceList;
	}

	public List<UserAdminMasterPhoneNoDetailBean> getObjPhoneNo() {
		return objPhoneNo;
	}

	public void setObjPhoneNo(List<UserAdminMasterPhoneNoDetailBean> objPhoneNo) {
		this.objPhoneNo = objPhoneNo;
	}

	public List<UserAdminMasterPhoneNoDetailBean> getObjMobileNo() {
		return objMobileNo;
	}

	public void setObjMobileNo(List<UserAdminMasterPhoneNoDetailBean> objMobileNo) {
		this.objMobileNo = objMobileNo;
	}

	private String employeeId;

	public String getEmployeeId() {
		return empId;
	}

	public void setEmployeeId(String employeeId) {
		this.empId = employeeId;
	}

	private List<UserAdminMasterBean> employeeNameList;
	private List<UserAdminMasterBean> employeeReportShow;

	public List<UserAdminMasterBean> getEmployeeReportShow() {
		return employeeReportShow;
	}

	public void setEmployeeReportShow(List<UserAdminMasterBean> employeeReportShow) {
		this.employeeReportShow = employeeReportShow;
	}

	public List<UserAdminMasterBean> getEmployeeNameList() {
		return employeeNameList;
	}

	public void setEmployeeNameList(List<UserAdminMasterBean> employeeNameList) {
		this.employeeNameList = employeeNameList;
	}

	public List<UserAdminMasterBean> getEditList() {
		return editList;
	}

	public void setEditList(List<UserAdminMasterBean> editList) {
		this.editList = editList;
	}

	private String fileName;
	private String docFileName;

	private String docPath;
	private String imgPath;

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public String getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private List<UserAdminMasterBean> empDataList;

	public List<UserAdminMasterBean> getReportToManager() {
		return reportToManager;
	}

	public void setReportToManager(List<UserAdminMasterBean> reportToManager) {
		this.reportToManager = reportToManager;
	}

	public List<UserAdminMasterBean> getEmpDataList() {
		return empDataList;
	}

	public void setEmpDataList(List<UserAdminMasterBean> empDataList) {
		this.empDataList = empDataList;
	}

	private List<UserAdminMasterBean> empTypeList;

	public List<UserAdminMasterBean> getEmpTypeList() {
		return empTypeList;
	}

	public void setEmpTypeList(List<UserAdminMasterBean> empTypeList) {
		this.empTypeList = empTypeList;
	}

	public List<UserAdminMasterBean> getReportToBranchList() {
		return reportToBranchList;
	}

	public void setReportToBranchList(List<UserAdminMasterBean> reportToBranchList) {
		this.reportToBranchList = reportToBranchList;
	}

	public List<UserAdminMasterBean> getReportToDeptList() {
		return reportToDeptList;
	}

	public void setReportToDeptList(List<UserAdminMasterBean> reportToDeptList) {
		this.reportToDeptList = reportToDeptList;
	}

	public List<UserAdminMasterBean> getReportToDesigList() {
		return reportToDesigList;
	}

	public void setReportToDesigList(List<UserAdminMasterBean> reportToDesigList) {
		this.reportToDesigList = reportToDesigList;
	}

	public List<UserAdminMasterBean> getDivisionList() {
		return divisionList;
	}

	public void setDivisionList(List<UserAdminMasterBean> divisionList) {
		this.divisionList = divisionList;
	}

	public List<UserAdminMasterBean> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<UserAdminMasterBean> gradeList) {
		this.gradeList = gradeList;
	}

	public List<UserAdminMasterBean> getDesignationList() {
		return designationList;
	}

	public void setDesignationList(List<UserAdminMasterBean> designationList) {
		this.designationList = designationList;
	}

	public List<UserAdminMasterBean> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<UserAdminMasterBean> departmentList) {
		this.departmentList = departmentList;
	}

	public List<UserAdminMasterBean> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<UserAdminMasterBean> branchList) {
		this.branchList = branchList;
	}

	public List<UserAdminMasterBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<UserAdminMasterBean> companyList) {
		this.companyList = companyList;
	}

	private List<UserAdminMasterBean> lEmployeeMasterBean;

	public List<UserAdminMasterBean> getlEmployeeMasterBean() {
		return lEmployeeMasterBean;
	}

	public void setlEmployeeMasterBean(List<UserAdminMasterBean> lEmployeeMasterBean) {
		this.lEmployeeMasterBean = lEmployeeMasterBean;
	}

	public List<UserAdminMasterPhoneNoDetailBean> getPresentAddressMultiple() {
		return presentAddressMultiple;
	}

	public void setPresentAddressMultiple(List<UserAdminMasterPhoneNoDetailBean> presentAddressMultiple) {
		this.presentAddressMultiple = presentAddressMultiple;
	}

	public UserAdminMeritsBean getObjEmployeeMeritsBean() {
		return objEmployeeMeritsBean;
	}

	public void setObjEmployeeMeritsBean(UserAdminMeritsBean objEmployeeMeritsBean) {
		this.objEmployeeMeritsBean = objEmployeeMeritsBean;
	}

	public List<UserAdminDocumentBean> getEmployeeDocumentBeanList() {
		return EmployeeDocumentBeanList;
	}

	public void setEmployeeDocumentBeanList(List<UserAdminDocumentBean> employeeDocumentBeanList) {
		EmployeeDocumentBeanList = employeeDocumentBeanList;
	}

	public UserAdminDocumentBean getObjEmployeeDocumentBean() {
		return objEmployeeDocumentBean;
	}

	public void setObjEmployeeDocumentBean(UserAdminDocumentBean objEmployeeDocumentBean) {
		this.objEmployeeDocumentBean = objEmployeeDocumentBean;
	}

	public Integer getEmpDocId() {
		return empDocId;
	}

	public void setEmpDocId(Integer empDocId) {
		this.empDocId = empDocId;
	}

	public List<UserAdminProbationBean> getEmployeeProbationBeanList() {
		return EmployeeProbationBeanList;
	}

	public void setEmployeeProbationBeanList(List<UserAdminProbationBean> employeeProbationBeanList) {
		EmployeeProbationBeanList = employeeProbationBeanList;
	}

	public UserAdminProbationBean getObjEmployeeProbationBean() {
		return objEmployeeProbationBean;
	}

	public void setObjEmployeeProbationBean(UserAdminProbationBean objEmployeeProbationBean) {
		this.objEmployeeProbationBean = objEmployeeProbationBean;
	}

	public UserAdminMasterPersonalBean getObjEmployeeMasterPersonalBean() {
		return objEmployeeMasterPersonalBean;
	}

	public void setObjEmployeeMasterPersonalBean(UserAdminMasterPersonalBean objEmployeeMasterPersonalBean) {
		this.objEmployeeMasterPersonalBean = objEmployeeMasterPersonalBean;
	}

	public UserAdminMasterAddressBean getObjEmployeeMasterAddressBean() {
		return objEmployeeMasterAddressBean;
	}

	public void setObjEmployeeMasterAddressBean(UserAdminMasterAddressBean objEmployeeMasterAddressBean) {
		this.objEmployeeMasterAddressBean = objEmployeeMasterAddressBean;
	}

	public UserAdminMasterRulesBean getObjEmployeeMasterRulesBean() {
		return objEmployeeMasterRulesBean;
	}

	public void setObjEmployeeMasterRulesBean(UserAdminMasterRulesBean objEmployeeMasterRulesBean) {
		this.objEmployeeMasterRulesBean = objEmployeeMasterRulesBean;
	}

	public UserAdminMAsterPerDetailsBean getObjEmployeeMAsterPerDetailsBean() {
		return objEmployeeMAsterPerDetailsBean;
	}

	public void setObjEmployeeMAsterPerDetailsBean(UserAdminMAsterPerDetailsBean objEmployeeMAsterPerDetailsBean) {
		this.objEmployeeMAsterPerDetailsBean = objEmployeeMAsterPerDetailsBean;
	}

	public UserAdminMasterPhysicalBean getObjEmployeeMasterPhysicalBean() {
		return objEmployeeMasterPhysicalBean;
	}

	public void setObjEmployeeMasterPhysicalBean(UserAdminMasterPhysicalBean objEmployeeMasterPhysicalBean) {
		this.objEmployeeMasterPhysicalBean = objEmployeeMasterPhysicalBean;
	}

	public List<UserAdminEducationBean> getYearList() {
		return yearList;
	}

	public void setYearList(List<UserAdminEducationBean> yearList) {
		this.yearList = yearList;
	}

	public List<Integer> getYearsList() {
		return yearsList;
	}

	public void setYearsList(List<Integer> yearsList) {
		this.yearsList = yearsList;
	}

	public int getPrincipalCount() {
		return principalCount;
	}

	public void setPrincipalCount(int principalCount) {
		this.principalCount = principalCount;
	}

	public int getMsCount() {
		return msCount;
	}

	public void setMsCount(int msCount) {
		this.msCount = msCount;
	}

	public List<UserAdminMasterBean> getPrincipalList() {
		return principalList;
	}

	public void setPrincipalList(List<UserAdminMasterBean> principalList) {
		this.principalList = principalList;
	}

	public List<UserAdminMasterBean> getMsList() {
		return msList;
	}

	public void setMsList(List<UserAdminMasterBean> msList) {
		this.msList = msList;
	}

	public String getDependentFileName() {
		return dependentFileName;
	}

	public void setDependentFileName(String dependentFileName) {
		this.dependentFileName = dependentFileName;
	}

	public List<UserAdminDuplicateBean> getEmployeeDuplicateList() {
		return employeeDuplicateList;
	}

	public void setEmployeeDuplicateList(List<UserAdminDuplicateBean> employeeDuplicateList) {
		this.employeeDuplicateList = employeeDuplicateList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmpUserId() {
		return empUserId;
	}

	public void setEmpUserId(String empUserId) {
		this.empUserId = empUserId;
	}

	public List<UserMAsterPerDetailsBean> getEmployeeMAsterPerDetailsBeanList() {
		return EmployeeMAsterPerDetailsBeanList;
	}

	public void setEmployeeMAsterPerDetailsBeanList(List<UserMAsterPerDetailsBean> employeeMAsterPerDetailsBeanList) {
		EmployeeMAsterPerDetailsBeanList = employeeMAsterPerDetailsBeanList;
	}

	public List<UserMasterPhysicalBean> getEmployeeMasterPhysicalBeanBeanList() {
		return EmployeeMasterPhysicalBeanBeanList;
	}

	public void setEmployeeMasterPhysicalBeanBeanList(List<UserMasterPhysicalBean> employeeMasterPhysicalBeanBeanList) {
		EmployeeMasterPhysicalBeanBeanList = employeeMasterPhysicalBeanBeanList;
	}

	public List<UserAdminMasterPersonalBean> getEmployeePersonalBeanList() {
		return EmployeePersonalBeanList;
	}

	public void setEmployeePersonalBeanList(List<UserAdminMasterPersonalBean> lPersonalBean) {
		EmployeePersonalBeanList = lPersonalBean;
	}

	public boolean isDesignationStatus() {
		return designationStatus;
	}

	public void setDesignationStatus(boolean designationStatus) {
		this.designationStatus = designationStatus;
	}

	public boolean isSalesStatus() {
		return salesStatus;
	}

	public void setSalesStatus(boolean salesStatus) {
		this.salesStatus = salesStatus;
	}

	public List<SelectivityBean> getBloodGroupList() {
		return bloodGroupList;
	}

	public void setBloodGroupList(List<SelectivityBean> bloodGroupList) {
		this.bloodGroupList = bloodGroupList;
	}

}
