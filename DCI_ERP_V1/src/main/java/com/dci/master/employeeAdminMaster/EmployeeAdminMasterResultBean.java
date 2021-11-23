package com.dci.master.employeeAdminMaster;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;



public class EmployeeAdminMasterResultBean extends BasicResultBean implements Serializable {

	private String status1;
	private static final long serialVersionUID = 1L;
	private List<EmployeeAdminMasterBean> companyList;
	private List<EmployeeAdminMasterBean> branchList;
	private List<EmployeeAdminMasterBean> departmentList;
	private List<EmployeeAdminMasterBean> designationList;
	private List<EmployeeAdminMasterBean> divisionList;
	private List<EmployeeAdminMasterBean> gradeList;
	private List<EmployeeAdminMasterBean> editList;
	private int status = 0;
	private boolean designationStatus;
	private boolean salesStatus;
	private String dependentFileName;
	private String empId;
	private Integer empDocId;
	private List<EmployeeAdminMasterBean> reportToBranchList;
	private List<EmployeeAdminMasterBean> reportToDeptList;
	private List<EmployeeAdminMasterBean> reportToDesigList;
	private List<EmployeeAdminMasterBean> reportToManager;
	private List<EmployeeAdminMasterBean> principalList;
	private List<EmployeeAdminMasterBean> msList;
	private List<SelectivityBean> bloodGroupList;
	private List<SelectivityBean> leaveTypeList;

	private List<EmployeeAdminEducationBean> yearList;
	private List<Integer> yearsList;
	private List<EmployeeAdminExperianceBean> employeeExperianceList;
	private List<EmployeeMAsterPerDetailsBean> EmployeeMAsterPerDetailsBeanList;
	private List<EmployeeMasterPhysicalBean> EmployeeMasterPhysicalBeanBeanList;
	private List<EmployeeAdminMasterPhoneNoDetailBean> objPhoneNo;
	private List<EmployeeAdminMasterPhoneNoDetailBean> objMobileNo;
	private List<EmployeeAdminMasterPhoneNoDetailBean> presentAddressMultiple;
	private EmployeeAdminExperianceBean employeeExperianceBean;
	private List<EmployeeAdminEducationBean> EmployeeEducationBeanList;
	private List<EmployeeAdminEmergencyBean> EmployeeEmergencyBeanList;
	private List<EmployeeAdminMeritsBean> EmployeeMeritsBeanList;
	private List<EmployeeAdminFamilyBean> EmployeeFamilyBeanList;
	private List<EmployeeAdminReferanceBean> EmployeeReferanceBeanList;
	private List<EmployeeAdminDuplicateBean> employeeDuplicateList;
	private List<EmployeeAdminNominationBean> EmployeeNominationBeanList;
	private List<EmployeeAdminNominationBean> EmployeePhoneNoList;
	private List<EmployeeAdminNominationBean> EmployeeMobileNoList;
	private List<EmployeeAdminEmergencyBean> EmployeeEmePhNoList;
	private List<EmployeeAdminEmergencyBean> EmployeeEmeMobNoList;
	private List<EmployeeAdminDocumentBean> EmployeeDocumentBeanList;
	private List<EmployeeAdminProbationBean> EmployeeProbationBeanList;
	private List<EmployeeAdminMasterPersonalBean> EmployeePersonalBeanList;
	private EmployeeAdminDocumentBean objEmployeeDocumentBean;
	private EmployeeAdminMeritsBean objEmployeeMeritsBean;
	private EmployeeAdminFamilyBean objEmployeeFamilyBean;
	private EmployeeAdminExperianceBean objEmployeeExperianceBean;
	private EmployeeAdminEducationBean objEmployeeEducationBean;
	private EmployeeAdminReferanceBean objEmployeeReferanceBean;
	private EmployeeAdminEmergencyBean objEmployeeEmergencyBean;
	private EmployeeAdminNominationBean objEmployeeNominationBean;
	private EmployeeAdminProbationBean objEmployeeProbationBean;
	private EmployeeAdminMasterPersonalBean objEmployeeMasterPersonalBean;
	private EmployeeAdminMasterAddressBean objEmployeeMasterAddressBean;
	private EmployeeAdminMasterRulesBean objEmployeeMasterRulesBean;
	private EmployeeAdminMAsterPerDetailsBean objEmployeeMAsterPerDetailsBean;
	private EmployeeAdminMasterPhysicalBean objEmployeeMasterPhysicalBean;
	private int principalCount;
	private int msCount;
	private String empUserId;
	private List<EmployeeAdminMasterBean> EmployeeLeaveBeanList;
	private List<EmployeeAdminMasterBean> employeePayrolldedBeanList;

	private List<EmployeeAdminMasterBean> employeeTravelhistoryBeanList;
	private EmployeeAdminMasterAddressBean objEmployeeMasterPayRollBean;
	
	private List<EmployeeAdminMasterBean> employeePayrollBankBeanList;
	
	private List<EmployeeAdminMasterBean> EmployeePassportBeanList;

	private List<EmployeeAdminMasterBean> employeeLoanBeanList;
	
	
	private List<EmployeeAdminMasterBean> employeeAirBeanList;

	private List<EmployeeAdminMasterBean> employeeSettleBeanList;


	private List<EmployeeAdminMasterBean> employeeadddressBeanList;
	private List<EmployeeAdminMasterBean> employeeLetterReqBeanList;

	private List<EmployeeAdminMasterBean> employeeLetterAssetsBeanList;

	private List<EmployeeAdminMasterBean> employeePayslipBeanList;

	
	private List<EmployeeAdminMasterBean> employeeFormrevList;

	private List<EmployeeAdminMasterBean> EmployeecontractBeanList;

	
	
	public List<EmployeeAdminMasterBean> getEmployeecontractBeanList() {
		return EmployeecontractBeanList;
	}

	public void setEmployeecontractBeanList(
			List<EmployeeAdminMasterBean> employeecontractBeanList) {
		EmployeecontractBeanList = employeecontractBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeeFormrevList() {
		return employeeFormrevList;
	}

	public void setEmployeeFormrevList(
			List<EmployeeAdminMasterBean> employeeFormrevList) {
		this.employeeFormrevList = employeeFormrevList;
	}

	public List<EmployeeAdminMasterBean> getEmployeePayslipBeanList() {
		return employeePayslipBeanList;
	}

	public void setEmployeePayslipBeanList(List<EmployeeAdminMasterBean> employeePayslipBeanList) {
		this.employeePayslipBeanList = employeePayslipBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeeLetterAssetsBeanList() {
		return employeeLetterAssetsBeanList;
	}

	public void setEmployeeLetterAssetsBeanList(List<EmployeeAdminMasterBean> employeeLetterAssetsBeanList) {
		this.employeeLetterAssetsBeanList = employeeLetterAssetsBeanList;
	}

	public List<SelectivityBean> getLeaveTypeList() {
		return leaveTypeList;
	}

	public void setLeaveTypeList(List<SelectivityBean> leaveTypeList) {
		this.leaveTypeList = leaveTypeList;
	}

	public List<EmployeeAdminMasterBean> getEmployeeLetterReqBeanList() {
		return employeeLetterReqBeanList;
	}

	public void setEmployeeLetterReqBeanList(List<EmployeeAdminMasterBean> employeeLetterReqBeanList) {
		this.employeeLetterReqBeanList = employeeLetterReqBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeeadddressBeanList() {
		return employeeadddressBeanList;
	}

	public void setEmployeeadddressBeanList(List<EmployeeAdminMasterBean> employeeadddressBeanList) {
		this.employeeadddressBeanList = employeeadddressBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeeSettleBeanList() {
		return employeeSettleBeanList;
	}

	public void setEmployeeSettleBeanList(List<EmployeeAdminMasterBean> employeeSettleBeanList) {
		this.employeeSettleBeanList = employeeSettleBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeeAirBeanList() {
		return employeeAirBeanList;
	}

	public void setEmployeeAirBeanList(List<EmployeeAdminMasterBean> employeeAirBeanList) {
		this.employeeAirBeanList = employeeAirBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeeLoanBeanList() {
		return employeeLoanBeanList;
	}

	public void setEmployeeLoanBeanList(List<EmployeeAdminMasterBean> employeeLoanBeanList) {
		this.employeeLoanBeanList = employeeLoanBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeePassportBeanList() {
		return EmployeePassportBeanList;
	}

	public void setEmployeePassportBeanList(List<EmployeeAdminMasterBean> employeePassportBeanList) {
		EmployeePassportBeanList = employeePassportBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeePayrollBankBeanList() {
		return employeePayrollBankBeanList;
	}

	public void setEmployeePayrollBankBeanList(List<EmployeeAdminMasterBean> employeePayrollBankBeanList) {
		this.employeePayrollBankBeanList = employeePayrollBankBeanList;
	}

	public EmployeeAdminMasterAddressBean getObjEmployeeMasterPayRollBean() {
		return objEmployeeMasterPayRollBean;
	}

	public void setObjEmployeeMasterPayRollBean(EmployeeAdminMasterAddressBean objEmployeeMasterPayRollBean) {
		this.objEmployeeMasterPayRollBean = objEmployeeMasterPayRollBean;
	}

	public List<EmployeeAdminMasterBean> getEmployeeTravelhistoryBeanList() {
		return employeeTravelhistoryBeanList;
	}

	public void setEmployeeTravelhistoryBeanList(List<EmployeeAdminMasterBean> employeeTravelhistoryBeanList) {
		this.employeeTravelhistoryBeanList = employeeTravelhistoryBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeePayrolldedBeanList() {
		return employeePayrolldedBeanList;
	}

	public void setEmployeePayrolldedBeanList(List<EmployeeAdminMasterBean> employeePayrolldedBeanList) {
		this.employeePayrolldedBeanList = employeePayrolldedBeanList;
	}

	public List<EmployeeAdminMasterBean> getEmployeeLeaveBeanList() {
		return EmployeeLeaveBeanList;
	}

	public void setEmployeeLeaveBeanList(List<EmployeeAdminMasterBean> employeeLeaveBeanList) {
		EmployeeLeaveBeanList = employeeLeaveBeanList;
	}

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

	public List<EmployeeAdminNominationBean> getEmployeePhoneNoList() {
		return EmployeePhoneNoList;
	}

	public void setEmployeePhoneNoList(List<EmployeeAdminNominationBean> employeePhoneNoList) {
		EmployeePhoneNoList = employeePhoneNoList;
	}

	public List<EmployeeAdminNominationBean> getEmployeeMobileNoList() {
		return EmployeeMobileNoList;
	}

	public void setEmployeeMobileNoList(List<EmployeeAdminNominationBean> employeeMobileNoList) {
		EmployeeMobileNoList = employeeMobileNoList;
	}

	public List<EmployeeAdminEmergencyBean> getEmployeeEmePhNoList() {
		return EmployeeEmePhNoList;
	}

	public void setEmployeeEmePhNoList(List<EmployeeAdminEmergencyBean> employeeEmePhNoList) {
		EmployeeEmePhNoList = employeeEmePhNoList;
	}

	public List<EmployeeAdminEmergencyBean> getEmployeeEmeMobNoList() {
		return EmployeeEmeMobNoList;
	}

	public void setEmployeeEmeMobNoList(List<EmployeeAdminEmergencyBean> employeeEmeMobNoList) {
		EmployeeEmeMobNoList = employeeEmeMobNoList;
	}

	public EmployeeAdminEmergencyBean getObjEmployeeEmergencyBean() {
		return objEmployeeEmergencyBean;
	}

	public void setObjEmployeeEmergencyBean(EmployeeAdminEmergencyBean objEmployeeEmergencyBean) {
		this.objEmployeeEmergencyBean = objEmployeeEmergencyBean;
	}

	public EmployeeAdminNominationBean getObjEmployeeNominationBean() {
		return objEmployeeNominationBean;
	}

	public void setObjEmployeeNominationBean(EmployeeAdminNominationBean objEmployeeNominationBean) {
		this.objEmployeeNominationBean = objEmployeeNominationBean;
	}

	public EmployeeAdminReferanceBean getObjEmployeeReferanceBean() {
		return objEmployeeReferanceBean;
	}

	public void setObjEmployeeReferanceBean(EmployeeAdminReferanceBean objEmployeeReferanceBean) {
		this.objEmployeeReferanceBean = objEmployeeReferanceBean;
	}

	public EmployeeAdminExperianceBean getObjEmployeeExperianceBean() {
		return objEmployeeExperianceBean;
	}

	public void setObjEmployeeExperianceBean(EmployeeAdminExperianceBean objEmployeeExperianceBean) {
		this.objEmployeeExperianceBean = objEmployeeExperianceBean;
	}

	public EmployeeAdminEducationBean getObjEmployeeEducationBean() {
		return objEmployeeEducationBean;
	}

	public void setObjEmployeeEducationBean(EmployeeAdminEducationBean objEmployeeEducationBean) {
		this.objEmployeeEducationBean = objEmployeeEducationBean;
	}

	public EmployeeAdminFamilyBean getObjEmployeeFamilyBean() {
		return objEmployeeFamilyBean;
	}

	public void setObjEmployeeFamilyBean(EmployeeAdminFamilyBean objEmployeeFamilyBean) {
		this.objEmployeeFamilyBean = objEmployeeFamilyBean;
	}

	public List<EmployeeAdminEmergencyBean> getEmployeeEmergencyBeanList() {
		return EmployeeEmergencyBeanList;
	}

	public void setEmployeeEmergencyBeanList(List<EmployeeAdminEmergencyBean> employeeEmergencyBeanList) {
		EmployeeEmergencyBeanList = employeeEmergencyBeanList;
	}

	public List<EmployeeAdminMeritsBean> getEmployeeMeritsBeanList() {
		return EmployeeMeritsBeanList;
	}

	public void setEmployeeMeritsBeanList(List<EmployeeAdminMeritsBean> employeeMeritsBeanList) {
		EmployeeMeritsBeanList = employeeMeritsBeanList;
	}

	public List<EmployeeAdminFamilyBean> getEmployeeFamilyBeanList() {
		return EmployeeFamilyBeanList;
	}

	public void setEmployeeFamilyBeanList(List<EmployeeAdminFamilyBean> employeeFamilyBeanList) {
		EmployeeFamilyBeanList = employeeFamilyBeanList;
	}

	public List<EmployeeAdminReferanceBean> getEmployeeReferanceBeanList() {
		return EmployeeReferanceBeanList;
	}

	public void setEmployeeReferanceBeanList(List<EmployeeAdminReferanceBean> employeeReferanceBeanList) {
		EmployeeReferanceBeanList = employeeReferanceBeanList;
	}

	public List<EmployeeAdminNominationBean> getEmployeeNominationBeanList() {
		return EmployeeNominationBeanList;
	}

	public void setEmployeeNominationBeanList(List<EmployeeAdminNominationBean> employeeNominationBeanList) {
		EmployeeNominationBeanList = employeeNominationBeanList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<EmployeeAdminEducationBean> getEmployeeEducationBeanList() {
		return EmployeeEducationBeanList;
	}

	public void setEmployeeEducationBeanList(List<EmployeeAdminEducationBean> employeeEducationBeanList) {
		EmployeeEducationBeanList = employeeEducationBeanList;
	}

	public EmployeeAdminExperianceBean getEmployeeExperianceBean() {
		return employeeExperianceBean;
	}

	public void setEmployeeExperianceBean(EmployeeAdminExperianceBean employeeExperianceBean) {
		this.employeeExperianceBean = employeeExperianceBean;
	}

	public List<EmployeeAdminExperianceBean> getEmployeeExperianceList() {
		return employeeExperianceList;
	}

	public void setEmployeeExperianceList(List<EmployeeAdminExperianceBean> employeeExperianceList) {
		this.employeeExperianceList = employeeExperianceList;
	}

	public List<EmployeeAdminMasterPhoneNoDetailBean> getObjPhoneNo() {
		return objPhoneNo;
	}

	public void setObjPhoneNo(List<EmployeeAdminMasterPhoneNoDetailBean> objPhoneNo) {
		this.objPhoneNo = objPhoneNo;
	}

	public List<EmployeeAdminMasterPhoneNoDetailBean> getObjMobileNo() {
		return objMobileNo;
	}

	public void setObjMobileNo(List<EmployeeAdminMasterPhoneNoDetailBean> objMobileNo) {
		this.objMobileNo = objMobileNo;
	}

	private String employeeId;

	public String getEmployeeId() {
		return empId;
	}

	public void setEmployeeId(String employeeId) {
		this.empId = employeeId;
	}

	private List<EmployeeAdminMasterBean> employeeNameList;
	private List<EmployeeAdminMasterBean> employeeReportShow;

	public List<EmployeeAdminMasterBean> getEmployeeReportShow() {
		return employeeReportShow;
	}

	public void setEmployeeReportShow(List<EmployeeAdminMasterBean> employeeReportShow) {
		this.employeeReportShow = employeeReportShow;
	}

	public List<EmployeeAdminMasterBean> getEmployeeNameList() {
		return employeeNameList;
	}

	public void setEmployeeNameList(List<EmployeeAdminMasterBean> employeeNameList) {
		this.employeeNameList = employeeNameList;
	}

	public List<EmployeeAdminMasterBean> getEditList() {
		return editList;
	}

	public void setEditList(List<EmployeeAdminMasterBean> editList) {
		this.editList = editList;
	}

	private String fileName;
	private String docFileName;

	private String docPath;
	private String imgPath;
	private MultipartFile imgPath1;


	public MultipartFile getImgPath1() {
		return imgPath1;
	}

	public void setImgPath1(MultipartFile imgPath1) {
		this.imgPath1 = imgPath1;
	}

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

	private List<EmployeeAdminMasterBean> empDataList;

	public List<EmployeeAdminMasterBean> getReportToManager() {
		return reportToManager;
	}

	public void setReportToManager(List<EmployeeAdminMasterBean> reportToManager) {
		this.reportToManager = reportToManager;
	}

	public List<EmployeeAdminMasterBean> getEmpDataList() {
		return empDataList;
	}

	public void setEmpDataList(List<EmployeeAdminMasterBean> empDataList) {
		this.empDataList = empDataList;
	}

	private List<EmployeeAdminMasterBean> empTypeList;

	public List<EmployeeAdminMasterBean> getEmpTypeList() {
		return empTypeList;
	}

	public void setEmpTypeList(List<EmployeeAdminMasterBean> empTypeList) {
		this.empTypeList = empTypeList;
	}

	public List<EmployeeAdminMasterBean> getReportToBranchList() {
		return reportToBranchList;
	}

	public void setReportToBranchList(List<EmployeeAdminMasterBean> reportToBranchList) {
		this.reportToBranchList = reportToBranchList;
	}

	public List<EmployeeAdminMasterBean> getReportToDeptList() {
		return reportToDeptList;
	}

	public void setReportToDeptList(List<EmployeeAdminMasterBean> reportToDeptList) {
		this.reportToDeptList = reportToDeptList;
	}

	public List<EmployeeAdminMasterBean> getReportToDesigList() {
		return reportToDesigList;
	}

	public void setReportToDesigList(List<EmployeeAdminMasterBean> reportToDesigList) {
		this.reportToDesigList = reportToDesigList;
	}

	public List<EmployeeAdminMasterBean> getDivisionList() {
		return divisionList;
	}

	public void setDivisionList(List<EmployeeAdminMasterBean> divisionList) {
		this.divisionList = divisionList;
	}

	public List<EmployeeAdminMasterBean> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<EmployeeAdminMasterBean> gradeList) {
		this.gradeList = gradeList;
	}

	public List<EmployeeAdminMasterBean> getDesignationList() {
		return designationList;
	}

	public void setDesignationList(List<EmployeeAdminMasterBean> designationList) {
		this.designationList = designationList;
	}

	public List<EmployeeAdminMasterBean> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<EmployeeAdminMasterBean> departmentList) {
		this.departmentList = departmentList;
	}

	public List<EmployeeAdminMasterBean> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<EmployeeAdminMasterBean> branchList) {
		this.branchList = branchList;
	}

	public List<EmployeeAdminMasterBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<EmployeeAdminMasterBean> companyList) {
		this.companyList = companyList;
	}

	private List<EmployeeAdminMasterBean> lEmployeeMasterBean;

	public List<EmployeeAdminMasterBean> getlEmployeeMasterBean() {
		return lEmployeeMasterBean;
	}

	public void setlEmployeeMasterBean(List<EmployeeAdminMasterBean> lEmployeeMasterBean) {
		this.lEmployeeMasterBean = lEmployeeMasterBean;
	}

	public List<EmployeeAdminMasterPhoneNoDetailBean> getPresentAddressMultiple() {
		return presentAddressMultiple;
	}

	public void setPresentAddressMultiple(List<EmployeeAdminMasterPhoneNoDetailBean> presentAddressMultiple) {
		this.presentAddressMultiple = presentAddressMultiple;
	}

	public EmployeeAdminMeritsBean getObjEmployeeMeritsBean() {
		return objEmployeeMeritsBean;
	}

	public void setObjEmployeeMeritsBean(EmployeeAdminMeritsBean objEmployeeMeritsBean) {
		this.objEmployeeMeritsBean = objEmployeeMeritsBean;
	}

	public List<EmployeeAdminDocumentBean> getEmployeeDocumentBeanList() {
		return EmployeeDocumentBeanList;
	}

	public void setEmployeeDocumentBeanList(List<EmployeeAdminDocumentBean> employeeDocumentBeanList) {
		EmployeeDocumentBeanList = employeeDocumentBeanList;
	}

	public EmployeeAdminDocumentBean getObjEmployeeDocumentBean() {
		return objEmployeeDocumentBean;
	}

	public void setObjEmployeeDocumentBean(EmployeeAdminDocumentBean objEmployeeDocumentBean) {
		this.objEmployeeDocumentBean = objEmployeeDocumentBean;
	}

	public Integer getEmpDocId() {
		return empDocId;
	}

	public void setEmpDocId(Integer empDocId) {
		this.empDocId = empDocId;
	}

	public List<EmployeeAdminProbationBean> getEmployeeProbationBeanList() {
		return EmployeeProbationBeanList;
	}

	public void setEmployeeProbationBeanList(List<EmployeeAdminProbationBean> employeeProbationBeanList) {
		EmployeeProbationBeanList = employeeProbationBeanList;
	}

	public EmployeeAdminProbationBean getObjEmployeeProbationBean() {
		return objEmployeeProbationBean;
	}

	public void setObjEmployeeProbationBean(EmployeeAdminProbationBean objEmployeeProbationBean) {
		this.objEmployeeProbationBean = objEmployeeProbationBean;
	}

	public EmployeeAdminMasterPersonalBean getObjEmployeeMasterPersonalBean() {
		return objEmployeeMasterPersonalBean;
	}

	public void setObjEmployeeMasterPersonalBean(EmployeeAdminMasterPersonalBean objEmployeeMasterPersonalBean) {
		this.objEmployeeMasterPersonalBean = objEmployeeMasterPersonalBean;
	}

	public EmployeeAdminMasterAddressBean getObjEmployeeMasterAddressBean() {
		return objEmployeeMasterAddressBean;
	}

	public void setObjEmployeeMasterAddressBean(EmployeeAdminMasterAddressBean objEmployeeMasterAddressBean) {
		this.objEmployeeMasterAddressBean = objEmployeeMasterAddressBean;
	}

	public EmployeeAdminMasterRulesBean getObjEmployeeMasterRulesBean() {
		return objEmployeeMasterRulesBean;
	}

	public void setObjEmployeeMasterRulesBean(EmployeeAdminMasterRulesBean objEmployeeMasterRulesBean) {
		this.objEmployeeMasterRulesBean = objEmployeeMasterRulesBean;
	}

	public EmployeeAdminMAsterPerDetailsBean getObjEmployeeMAsterPerDetailsBean() {
		return objEmployeeMAsterPerDetailsBean;
	}

	public void setObjEmployeeMAsterPerDetailsBean(EmployeeAdminMAsterPerDetailsBean objEmployeeMAsterPerDetailsBean) {
		this.objEmployeeMAsterPerDetailsBean = objEmployeeMAsterPerDetailsBean;
	}

	public EmployeeAdminMasterPhysicalBean getObjEmployeeMasterPhysicalBean() {
		return objEmployeeMasterPhysicalBean;
	}

	public void setObjEmployeeMasterPhysicalBean(EmployeeAdminMasterPhysicalBean objEmployeeMasterPhysicalBean) {
		this.objEmployeeMasterPhysicalBean = objEmployeeMasterPhysicalBean;
	}

	public List<EmployeeAdminEducationBean> getYearList() {
		return yearList;
	}

	public void setYearList(List<EmployeeAdminEducationBean> yearList) {
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

	public List<EmployeeAdminMasterBean> getPrincipalList() {
		return principalList;
	}

	public void setPrincipalList(List<EmployeeAdminMasterBean> principalList) {
		this.principalList = principalList;
	}

	public List<EmployeeAdminMasterBean> getMsList() {
		return msList;
	}

	public void setMsList(List<EmployeeAdminMasterBean> msList) {
		this.msList = msList;
	}

	public String getDependentFileName() {
		return dependentFileName;
	}

	public void setDependentFileName(String dependentFileName) {
		this.dependentFileName = dependentFileName;
	}

	public List<EmployeeAdminDuplicateBean> getEmployeeDuplicateList() {
		return employeeDuplicateList;
	}

	public void setEmployeeDuplicateList(List<EmployeeAdminDuplicateBean> employeeDuplicateList) {
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

	public List<EmployeeMAsterPerDetailsBean> getEmployeeMAsterPerDetailsBeanList() {
		return EmployeeMAsterPerDetailsBeanList;
	}

	public void setEmployeeMAsterPerDetailsBeanList(List<EmployeeMAsterPerDetailsBean> employeeMAsterPerDetailsBeanList) {
		EmployeeMAsterPerDetailsBeanList = employeeMAsterPerDetailsBeanList;
	}

	public List<EmployeeMasterPhysicalBean> getEmployeeMasterPhysicalBeanBeanList() {
		return EmployeeMasterPhysicalBeanBeanList;
	}

	public void setEmployeeMasterPhysicalBeanBeanList(List<EmployeeMasterPhysicalBean> employeeMasterPhysicalBeanBeanList) {
		EmployeeMasterPhysicalBeanBeanList = employeeMasterPhysicalBeanBeanList;
	}

	public List<EmployeeAdminMasterPersonalBean> getEmployeePersonalBeanList() {
		return EmployeePersonalBeanList;
	}

	public void setEmployeePersonalBeanList(List<EmployeeAdminMasterPersonalBean> lPersonalBean) {
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
