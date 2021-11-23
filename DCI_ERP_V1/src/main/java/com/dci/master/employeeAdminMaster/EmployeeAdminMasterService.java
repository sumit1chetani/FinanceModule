package com.dci.master.employeeAdminMaster;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;



//
public interface EmployeeAdminMasterService {
	EmployeeAdminMasterResultBean getCompanyList() throws Exception;

	EmployeeAdminMasterResultBean getBranchList() throws Exception;
	EmployeeAdminMasterResultBean getBranchList1(String comp) throws Exception;

	public EmployeeAdminMasterResultBean getBloodGroupList() throws CustomException;

	// department
	public EmployeeAdminMasterResultBean getDesigantion(String designationId);

	EmployeeAdminMasterResultBean getDepartmentList() throws Exception;

	EmployeeAdminMasterResultBean getDesignationList() throws Exception;

	EmployeeAdminMasterResultBean getDivisionList() throws Exception;

	EmployeeAdminMasterResultBean getGradeList() throws Exception;

	EmployeeAdminMasterResultBean getReportToBranchList() throws Exception;

	EmployeeAdminMasterResultBean getReportToDeptList(String branchId) throws Exception;

	EmployeeAdminMasterResultBean getReportToDesigList(String repManagerId) throws Exception;

	public List getReporingManager(int depId, String branchId);

	EmployeeAdminMasterResultBean getEmpTypeList() throws Exception;

	EmployeeAdminMasterResultBean getEmployeeById(String empId) throws Exception;

	public List<EmployeeAdminMasterBean> getEmployeeList(int limit, int offset, EmployeeAdminMasterBean bean) throws Exception;

	public List<EmployeeAdminMasterBean> getEmployeeReportList(int limit, int offset, String cmp, int dept, String branch) throws Exception;

	EmployeeAdminMasterResultBean insertEmployee(EmployeeAdminMasterBean objEmp) throws Exception;

	boolean updateEmployee(EmployeeAdminMasterBean objEmployeeMasterBean) throws Exception;

	boolean deleteEmployee(String empId) throws Exception;

	EmployeeAdminMasterResultBean uploadDocFile(MultipartFile file);

	public boolean uploadExeFile(MultipartFile file);

	EmployeeAdminMasterResultBean getEmployeeNameList() throws Exception;

	EmployeeAdminMasterResultBean insertEmployeeExperiance(EmployeeAdminExperianceBean objEmp);

	EmployeeAdminMasterResultBean getEmpExList(String empId);

	EmployeeAdminMasterResultBean getEmpEduList(String empId);

	EmployeeAdminMasterResultBean getEmpMeritList(String empId);

	EmployeeAdminMasterResultBean getEmpFamList(String empId);

	EmployeeAdminMasterResultBean getNominationList(String empId);

	EmployeeAdminMasterResultBean getReferenceList(String empId);
	
	EmployeeAdminMasterResultBean getLeaveList(String empId);
	
	
	EmployeeAdminMasterResultBean getContractList(String empId);
	
	EmployeeAdminMasterResultBean getPayslipList(String empId);

	
	EmployeeAdminMasterResultBean getAssetsList(String empId);

	
	EmployeeAdminMasterResultBean getLeaveListSeach(EmployeeAdminMasterBean empId);

	EmployeeAdminMasterResultBean getAirClaimList(String empId);

	
	EmployeeAdminMasterResultBean getAddressBookList(String empId);

	
	EmployeeAdminMasterResultBean getLetterRequestList(String empId);

	EmployeeAdminMasterResultBean getSettlementList(String empId);

	EmployeeAdminMasterResultBean getLoanList(String empId);

	
	EmployeeAdminMasterResultBean getPassportRelease(String empId);

	
	EmployeeAdminMasterResultBean getpayrolldeductionList(String empId);
	
	EmployeeAdminMasterResultBean getformList(String empId);

	
	
	EmployeeAdminMasterResultBean getEndofserviceList(String empId);

	
	EmployeeAdminMasterResultBean getPayrollBankList(String empId);

	
	EmployeeAdminMasterResultBean gettravelHistorysList(String empId);

	EmployeeAdminMasterResultBean getEmergencyList(String empId);

	EmployeeAdminMasterResultBean editEmployeeMerits(EmployeeAdminMeritsBean objEmployeeMeritsBean);

	EmployeeAdminMasterResultBean editEmployeeFamily(EmployeeAdminFamilyBean objEmployeeFamilyBean);

	EmployeeAdminMasterResultBean editEmployeeExperiance(EmployeeAdminExperianceBean objEmployeeExperianceBean);

	EmployeeAdminMasterResultBean editEmployeeEducation(EmployeeAdminEducationBean objEmployeeEducationBean);

	EmployeeAdminMasterResultBean updateEmployeeEducation(EmployeeAdminEducationBean objEmployeeEducationBean);

	EmployeeAdminMasterResultBean updateEmployeeFamily(EmployeeAdminFamilyBean objEmployeeFamilyBean);

	EmployeeAdminMasterResultBean UpdateExperianceDetail(EmployeeAdminExperianceBean objEmployeeExperianceBean);

	EmployeeAdminMasterResultBean updateEmployeeMerit(EmployeeAdminMeritsBean objEmployeeMeritsBean);

	EmployeeAdminMasterResultBean editEmployeeReference(EmployeeAdminReferanceBean objBean);

	EmployeeAdminMasterResultBean editEmployeeEmergency(EmployeeAdminEmergencyBean objBean);

	EmployeeAdminMasterResultBean editEmployeeNomination(EmployeeAdminNominationBean objEmp);

	EmployeeAdminMasterResultBean updateEmployeeReference(EmployeeAdminReferanceBean objEmployeeReferanceBean);

	EmployeeAdminMasterResultBean updateEmployeeEmergency(EmployeeAdminEmergencyBean objEmployeeEmergencyBean);

	EmployeeAdminMasterResultBean updateEmployeeNomination(EmployeeAdminNominationBean objEmployeeNominationBean);

	EmployeeAdminMasterResultBean insertEmployeePersonal(EmployeeAdminMasterBean objEmp);

	EmployeeAdminMasterResultBean insertEmployeeAddress(EmployeeAdminMasterBean objEmp);
	
	
	EmployeeAdminMasterResultBean savePayBank(EmployeeAdminMasterBean objEmp);
	
	EmployeeAdminMasterResultBean savefrmAssets(EmployeeAdminMasterBean objEmp);

	
	EmployeeAdminMasterResultBean saveAirClaim(EmployeeAdminMasterBean objEmp);
	
	
	EmployeeAdminMasterResultBean saveSettle(EmployeeAdminMasterBean objEmp);

	EmployeeAdminMasterResultBean savePassport(EmployeeAdminMasterBean objEmp);
	
	
	EmployeeAdminMasterResultBean saveFormReview(EmployeeAdminMasterBean objEmp);


	EmployeeAdminMasterResultBean insertEmployeeRule(EmployeeAdminMasterBean objEmp);

	EmployeeAdminMasterResultBean insertEmployeeDocument(EmployeeAdminMasterBean objEmp);

	EmployeeAdminMasterResultBean insertEmployeePhysical(EmployeeAdminMasterBean objEmp);

	EmployeeAdminMasterResultBean insertEmployeeFamily(EmployeeAdminFamilyBean objEmp);

	EmployeeAdminMasterResultBean insertEmployeeEducation(EmployeeAdminEducationBean objEmp);

	EmployeeAdminMasterResultBean insertEmployeeMerits(EmployeeAdminMeritsBean objEmp);

	EmployeeAdminMasterResultBean insertEmployeeEmergency(EmployeeAdminEmergencyBean objEmp);

	EmployeeAdminMasterResultBean insertEmployeeReference(EmployeeAdminReferanceBean objEmp);

	EmployeeAdminMasterResultBean insertEmployeeNomination(EmployeeAdminNominationBean objEmp);

	EmployeeAdminMasterResultBean deleteEmployeeNomination(EmployeeAdminNominationBean objEmp);

	EmployeeAdminMasterResultBean deleteEmployeeEmergency(EmployeeAdminEmergencyBean objemp);

	EmployeeAdminMasterResultBean deleteEmployeeReference(EmployeeAdminReferanceBean objBean);

	EmployeeAdminMasterResultBean deleteEmployeeExperiance(EmployeeAdminExperianceBean objExperianceBean);

	EmployeeAdminMasterResultBean deleteEmployeeMerit(EmployeeAdminMeritsBean objMeritsBean);

	EmployeeAdminMasterResultBean deleteEmployeeFamily(EmployeeAdminFamilyBean objFamilyBean);

	EmployeeAdminMasterResultBean deleteEmployeeEducation(EmployeeAdminEducationBean objEducationBean);

	boolean updateAddress(EmployeeAdminMasterBean objEmployeeMasterBean);

	
	boolean updatePassport(EmployeeAdminMasterBean objEmployeeMasterBean);

	boolean updatePayBank(EmployeeAdminMasterBean objEmployeeMasterBean);
	
	boolean updateformReview(EmployeeAdminMasterBean objEmployeeMasterBean);

	
	boolean updatefrmAssets(EmployeeAdminMasterBean objEmployeeMasterBean);

	
	boolean updateAirClaim(EmployeeAdminMasterBean objEmployeeMasterBean);

	
	boolean updateSettle(EmployeeAdminMasterBean objEmployeeMasterBean);

	boolean updateRules(EmployeeAdminMasterBean objEmployeeMasterBean);

	boolean updateDocument(EmployeeAdminMasterBean objEmployeeMasterBean);

	boolean updatePhysical(EmployeeAdminMasterBean objEmployeeMasterBean);

	boolean updatePersonalInfo(EmployeeAdminMasterBean objEmployeeMasterBean);

	EmployeeAdminMasterResultBean insertEmployeeDoc(EmployeeAdminDocumentBean objEmp);

	EmployeeAdminMasterResultBean editEmployeeDoc(EmployeeAdminDocumentBean objEmployeeDocumentBean);

	public EmployeeAdminMasterResultBean viewEmployeeById(String empId) throws CustomException;

	EmployeeAdminMasterResultBean getEmpDocumentList(String empId);

	EmployeeAdminMasterResultBean updateEmployeeDoc(EmployeeAdminDocumentBean objEmployeeDocumentBean);

	EmployeeAdminMasterResultBean deleteEmployeeDoc(EmployeeAdminDocumentBean objDocumentBean);

	EmployeeAdminMasterResultBean insertEmployeeProbation(EmployeeAdminProbationBean objEmp);

	EmployeeAdminMasterResultBean editEmployeeProbation(EmployeeAdminProbationBean objEmployeeProbationBean);

	EmployeeAdminMasterResultBean getProbationList(String employeeId);

	EmployeeAdminMasterResultBean updateEmployeeProbation(EmployeeAdminProbationBean objEmployeeProbationBean);

	EmployeeAdminMasterResultBean deleteEmployeeProbation(EmployeeAdminProbationBean objProbationBean);

	EmployeeAdminMasterResultBean editEmployeePersonal(String editEmployeeID);

	EmployeeAdminMasterResultBean editEmployeePhysical(String editEmployeeID);

	EmployeeAdminMasterResultBean editEmployeeDetail(String editEmployeeID);

	EmployeeAdminMasterResultBean editEmployeeRule(String editEmployeeID);

	EmployeeAdminMasterResultBean editEmployeeAddress(String editEmployeeID);

	
	
	EmployeeAdminMasterResultBean editFormReview(String editEmployeeID);

	EmployeeAdminMasterResultBean editPayRoll(String editEmployeeID);
	
	EmployeeAdminMasterResultBean editAssets(String editEmployeeID);

	EmployeeAdminMasterResultBean editPassportReqeuest(String editEmployeeID);
	
	EmployeeAdminMasterResultBean editAirClaim(String editEmployeeID);
	
	EmployeeAdminMasterResultBean editSettlement(String editEmployeeID);


	EmployeeAdminMasterResultBean uploadFile(MultipartFile file, String fileName);

	EmployeeAdminMasterResultBean getYearList();

	EmployeeAdminMasterResultBean uploadDependentFile(MultipartFile file, String employeeID);

	EmployeeAdminMasterBean getProfileInfo() throws Exception;

	int checkESICNo(String esic) throws Exception;

	int checkEPFNo(String epfNo) throws Exception;

	int checkPersonalInfoPANNo(String panNo) throws Exception;

	EmployeeAdminMasterResultBean uploadFileNew(MultipartFile file);


}
