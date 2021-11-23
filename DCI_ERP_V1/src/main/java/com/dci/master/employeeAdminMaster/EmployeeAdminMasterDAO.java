package com.dci.master.employeeAdminMaster;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;




public interface EmployeeAdminMasterDAO {
	public EmployeeAdminMasterResultBean getCompanyList() throws CustomException;

	public EmployeeAdminMasterResultBean getBranchList() throws CustomException;
	public EmployeeAdminMasterResultBean getBranchList1(String comp) throws CustomException;

	// // department
	EmployeeAdminMasterResultBean editFormReview(String editEmployeeID);


	public EmployeeAdminMasterResultBean getDepartmentList() throws CustomException;

	public EmployeeAdminMasterResultBean getDesignationList() throws CustomException;

	public EmployeeAdminMasterResultBean getDivisionList() throws CustomException;

	public EmployeeAdminMasterResultBean getGradeList() throws CustomException;

	public EmployeeAdminMasterResultBean getReportToBranchList() throws CustomException;

	public EmployeeAdminMasterResultBean getReportToDeptList(String branchId) throws CustomException;

	public EmployeeAdminMasterResultBean getReportToDesigList(String repManagerId) throws CustomException;

	public List getReporingManager(int depId, String branchId);

	public EmployeeAdminMasterResultBean getEmpTypeList() throws CustomException;

	public EmployeeAdminMasterResultBean getEmployeeById(String empId) throws CustomException;

	public EmployeeAdminMasterResultBean viewEmployeeById(String empId) throws CustomException;

	
	public List<EmployeeAdminMasterBean> getEmployeeList(int limit, int offset, EmployeeAdminMasterBean bean) throws CustomException;

	public List<EmployeeAdminMasterBean> getEmployeeReportList(int limit, int offset, String cmp, int dept, String branch) throws CustomException;

	public EmployeeAdminMasterResultBean insertEmployee(EmployeeAdminMasterBean objEmployee) throws CustomException, IOException;

	public boolean updateEmployee(EmployeeAdminMasterBean objEmployeeMasterBean) throws CustomException;

	public boolean deleteEmployee(String empId) throws CustomException;

	EmployeeAdminMasterResultBean uploadDocFile(MultipartFile file);

	public boolean uploadExeFile(MultipartFile file);

	public EmployeeAdminMasterResultBean getBloodGroupList() throws CustomException;

	public EmployeeAdminMasterResultBean getEmployeeNameList() throws CustomException;

	public EmployeeAdminMasterResultBean insertEmployeeExperiance(EmployeeAdminExperianceBean objEmp);

	public EmployeeAdminMasterResultBean getEmpExList(String empId);

	public EmployeeAdminMasterResultBean getEmpEduList(String empId);

	public EmployeeAdminMasterResultBean getEmpMeritList(String empId);

	public EmployeeAdminMasterResultBean getEmpFamList(String empId);

	public EmployeeAdminMasterResultBean getNominationList(String empId);

	public EmployeeAdminMasterResultBean getReferenceList(String empId);
	
	public EmployeeAdminMasterResultBean getAssetsList(String empId);
	public EmployeeAdminMasterResultBean getLeaveList(String empId);
	
	
	public EmployeeAdminMasterResultBean getContractList(String empId);
	
	public EmployeeAdminMasterResultBean getPayslipList(String empId);

	
	public EmployeeAdminMasterResultBean getAirClaimList(String empId);
	public EmployeeAdminMasterResultBean getAddressBookList(String empId);

	
	
	public EmployeeAdminMasterResultBean getLetterRequestList(String empId);

	public EmployeeAdminMasterResultBean getSettlementList(String empId);


	public EmployeeAdminMasterResultBean getLoanList(String empId);

	
	public EmployeeAdminMasterResultBean getPassportRelease(String empId);

	
	public EmployeeAdminMasterResultBean getpayrolldeductionList(String empId);
	
	public EmployeeAdminMasterResultBean getformList(String empId);

	
	public EmployeeAdminMasterResultBean getEndofserviceList(String empId);

	
	public EmployeeAdminMasterResultBean getPayrollBankList(String empId);

	public EmployeeAdminMasterResultBean gettravelHistorysList(String empId);
	

	public EmployeeAdminMasterResultBean getEmergencyList(String empId);

	public EmployeeAdminMasterResultBean editEmployeeMerits(EmployeeAdminMeritsBean objEmployeeMeritsBean);

	public EmployeeAdminMasterResultBean editEmployeeFamily(EmployeeAdminFamilyBean objEmployeeFamilyBean);

	public EmployeeAdminMasterResultBean editEmployeeExperiance(EmployeeAdminExperianceBean objEmployeeExperianceBean);

	public EmployeeAdminMasterResultBean editEmployeeEducation(EmployeeAdminEducationBean objEmployeeEducationBean);

	public EmployeeAdminMasterResultBean updateEmployeeEducation(EmployeeAdminEducationBean objEmployeeEducationBean);

	public EmployeeAdminMasterResultBean updateEmployeeFamily(EmployeeAdminFamilyBean objEmployeeFamilyBean);

	public EmployeeAdminMasterResultBean UpdateExperianceDetail(EmployeeAdminExperianceBean objEmployeeExperianceBean);

	public EmployeeAdminMasterResultBean updateEmployeeMerit(EmployeeAdminMeritsBean objEmployeeMeritsBean);

	public EmployeeAdminMasterResultBean editEmployeeReference(EmployeeAdminReferanceBean objBean);

	public EmployeeAdminMasterResultBean editEmployeeEmergency(EmployeeAdminEmergencyBean objBean);

	public EmployeeAdminMasterResultBean editEmployeeNomination(EmployeeAdminNominationBean objEmp);

	public EmployeeAdminMasterResultBean updateEmployeeReference(EmployeeAdminReferanceBean objEmployeeReferanceBean);

	public EmployeeAdminMasterResultBean updateEmployeeEmergency(EmployeeAdminEmergencyBean objEmployeeEmergencyBean);

	public EmployeeAdminMasterResultBean updateEmployeeNomination(EmployeeAdminNominationBean objEmployeeNominationBean);

	public EmployeeAdminMasterResultBean insertEmployeePersonal(EmployeeAdminMasterBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeeAddress(EmployeeAdminMasterBean objEmp);

	public EmployeeAdminMasterResultBean savePayBank(EmployeeAdminMasterBean objEmp);
	
	
	public EmployeeAdminMasterResultBean savefrmAssets(EmployeeAdminMasterBean objEmp);

	public EmployeeAdminMasterResultBean saveAirClaim(EmployeeAdminMasterBean objEmp);

	
	public EmployeeAdminMasterResultBean saveSettle(EmployeeAdminMasterBean objEmp);

	
	public EmployeeAdminMasterResultBean savePassport(EmployeeAdminMasterBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeeRule(EmployeeAdminMasterBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeeDocument(EmployeeAdminMasterBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeePhysical(EmployeeAdminMasterBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeeFamily(EmployeeAdminFamilyBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeeEducation(EmployeeAdminEducationBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeeMerits(EmployeeAdminMeritsBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeeEmergency(EmployeeAdminEmergencyBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeeReference(EmployeeAdminReferanceBean objEmp);

	public EmployeeAdminMasterResultBean insertEmployeeNomination(EmployeeAdminNominationBean objEmp);

	public EmployeeAdminMasterResultBean deleteEmployeeNomination(EmployeeAdminNominationBean objEmp);

	public EmployeeAdminMasterResultBean deleteEmployeeEmergency(EmployeeAdminEmergencyBean objemp);

	public EmployeeAdminMasterResultBean deleteEmployeeReference(EmployeeAdminReferanceBean objBean);

	public EmployeeAdminMasterResultBean deleteEmployeeExperiance(EmployeeAdminExperianceBean objBean);

	public EmployeeAdminMasterResultBean deleteEmployeeMerit(EmployeeAdminMeritsBean objBean);

	public EmployeeAdminMasterResultBean deleteEmployeeFamily(EmployeeAdminFamilyBean objBean);

	public EmployeeAdminMasterResultBean deleteEmployeeEducation(EmployeeAdminEducationBean objBean);

	public boolean updatePersonalInfo(EmployeeAdminMasterBean objEmployeeMasterBean);

	public boolean updateAddress(EmployeeAdminMasterBean objEmployeeMasterBean);

	public boolean updatePayBank(EmployeeAdminMasterBean objEmployeeMasterBean);
	
	public boolean updateformReview(EmployeeAdminMasterBean objEmployeeMasterBean) ;

	
	public boolean updatefrmAssets(EmployeeAdminMasterBean objEmployeeMasterBean);

	public boolean updateSettle(EmployeeAdminMasterBean objEmployeeMasterBean);

	public boolean updateAirClaim(EmployeeAdminMasterBean objEmployeeMasterBean);

	public boolean updatePassport(EmployeeAdminMasterBean objEmployeeMasterBean);

	public boolean updateRules(EmployeeAdminMasterBean objEmployeeMasterBean);

	public boolean updateDocument(EmployeeAdminMasterBean objEmployeeMasterBean);

	public boolean updatePhysical(EmployeeAdminMasterBean objEmployeeMasterBean);
	
	public EmployeeAdminMasterResultBean getDesigantion(String designationId);


	public EmployeeAdminMasterResultBean insertEmployeeDoc(EmployeeAdminDocumentBean objEmp);

	public EmployeeAdminMasterResultBean editEmployeeDoc(EmployeeAdminDocumentBean objEmployeeDocumentBean);

	public EmployeeAdminMasterResultBean getEmpDocumentList(String empId);

	public EmployeeAdminMasterResultBean updateEmployeeDoc(EmployeeAdminDocumentBean objEmployeeDocumentBean);

	public EmployeeAdminMasterResultBean deleteEmployeeDoc(EmployeeAdminDocumentBean objDocumentBean);

	public EmployeeAdminMasterResultBean insertEmployeeProbation(EmployeeAdminProbationBean objEmp);

	public EmployeeAdminMasterResultBean editEmployeeProbation(EmployeeAdminProbationBean objEmployeeProbationBean);

	public EmployeeAdminMasterResultBean getProbationList(String objEmployeeProbationBean);

	public EmployeeAdminMasterResultBean updateEmployeeProbation(EmployeeAdminProbationBean objEmployeeProbationBean);

	public EmployeeAdminMasterResultBean deleteEmployeeProbation(EmployeeAdminProbationBean objProbationBean);

	public EmployeeAdminMasterResultBean editEmployeePersonal(String editEmployeeID);

	public EmployeeAdminMasterResultBean editEmployeeAddress(String editEmployeeID);

	
	public EmployeeAdminMasterResultBean editPassportReqeuest(String editEmployeeID);

	
	
	public EmployeeAdminMasterResultBean editSettlement(String editEmployeeID);

	public EmployeeAdminMasterResultBean editAirClaim(String editEmployeeID);

	public EmployeeAdminMasterResultBean editPayRoll(String editEmployeeID);
	
	public EmployeeAdminMasterResultBean editAssets(String editEmployeeID);

	public EmployeeAdminMasterResultBean editEmployeeRule(String editEmployeeID);

	public EmployeeAdminMasterResultBean editEmployeeDetail(String editEmployeeID);

	public EmployeeAdminMasterResultBean editEmployeePhysical(String editEmployeeID);

	public EmployeeAdminMasterResultBean uploadFile(MultipartFile file, String fileName);

	public EmployeeAdminMasterResultBean getYearList();

	EmployeeAdminMasterResultBean uploadDependentFile(MultipartFile file, String employeeID);

	public EmployeeAdminMasterBean getProfileInfo() throws Exception;

	public int checkESICNo(String esic) throws Exception;

	public int checkEPFNo(String epfNo) throws Exception;

	public int checkPersonalInfoPANNo(String panNo) throws Exception;
	
	EmployeeAdminMasterResultBean getLeaveListSeach(EmployeeAdminMasterBean bean);

	EmployeeAdminMasterResultBean saveFormReview(EmployeeAdminMasterBean objEmp);

	public EmployeeAdminMasterResultBean uploadFileNew(MultipartFile file);


}

