package com.dci.master.employeeAdminMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;



//
@Service
public class EmployeeAdminMasterServiceImpl implements EmployeeAdminMasterService {
	@Autowired
	EmployeeAdminMasterDAO employeeMasterDAO;

	@Override
	public List<EmployeeAdminMasterBean> getEmployeeList(int limit, int offset, EmployeeAdminMasterBean bean) throws Exception {

		return employeeMasterDAO.getEmployeeList(limit, offset, bean);
	}

	@Override
	public List<EmployeeAdminMasterBean> getEmployeeReportList(int limit, int offset, String cmp, int dept, String branch) throws Exception {

		return employeeMasterDAO.getEmployeeReportList(limit, offset, cmp, dept, branch);
	}

	@Override
	public EmployeeAdminMasterResultBean getEmployeeById(String empId) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmployeeById(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployee(EmployeeAdminMasterBean objEmployee) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployee(objEmployee);
	}

	@Override
	public boolean updateEmployee(EmployeeAdminMasterBean objEmployeeMasterBean) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployee(objEmployeeMasterBean);
	}

	@Override
	public boolean deleteEmployee(String empId) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployee(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean getCompanyList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getCompanyList();
	}

	@Override
	public EmployeeAdminMasterResultBean getBranchList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getBranchList();
	}
	@Override
	public EmployeeAdminMasterResultBean getBranchList1(String comp) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getBranchList1(comp);
	}
	// department

	@Override
	public EmployeeAdminMasterResultBean getDepartmentList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getDepartmentList();
	}

	@Override
	public EmployeeAdminMasterResultBean getDesignationList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getDesignationList();
	}

	@Override
	public EmployeeAdminMasterResultBean getDivisionList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getDivisionList();
	}

	@Override
	public EmployeeAdminMasterResultBean getGradeList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getGradeList();
	}

	@Override
	public EmployeeAdminMasterResultBean getReportToBranchList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getReportToBranchList();
	}

	@Override
	public EmployeeAdminMasterResultBean getReportToDeptList(String branchId) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getReportToDeptList(branchId);
	}

	@Override
	public EmployeeAdminMasterResultBean getReportToDesigList(String repManagerId) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getReportToDesigList(repManagerId);
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpTypeList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmpTypeList();
	}

	@Override
	public List getReporingManager(int depId, String branchId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getReporingManager(depId, branchId);

	}

	@Override
	public EmployeeAdminMasterResultBean uploadFile(MultipartFile file, String fileName) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.uploadFile(file, fileName);
	}
	
	@Override
	public EmployeeAdminMasterResultBean uploadDocFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.uploadDocFile(file);
	}

	@Override
	public boolean uploadExeFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.uploadExeFile(file);

	}

	@Override
	public EmployeeAdminMasterResultBean getEmployeeNameList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmployeeNameList();
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeExperiance(EmployeeAdminExperianceBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeExperiance(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpExList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmpExList(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpEduList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmpEduList(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpMeritList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmpMeritList(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpFamList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmpFamList(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean getNominationList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getNominationList(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean getReferenceList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getReferenceList(empId);
	}
	
	@Override
	public EmployeeAdminMasterResultBean getLeaveList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getLeaveList(empId);
	}
	
	
	@Override
	public EmployeeAdminMasterResultBean getContractList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getContractList(empId);
	}
	
	
	@Override
	public EmployeeAdminMasterResultBean getPayslipList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getPayslipList(empId);
	}
	@Override
	public EmployeeAdminMasterResultBean getAssetsList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getAssetsList(empId);
	}
	
	@Override
	public EmployeeAdminMasterResultBean getAirClaimList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getAirClaimList(empId);
	}
	
	
	@Override
	public EmployeeAdminMasterResultBean getLetterRequestList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getLetterRequestList(empId);
	}
	
	
	@Override
	public EmployeeAdminMasterResultBean getAddressBookList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getAddressBookList(empId);
	}
	
	@Override
	public EmployeeAdminMasterResultBean getSettlementList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getSettlementList(empId);
	}
	@Override
	public EmployeeAdminMasterResultBean getLoanList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getLoanList(empId);
	}
	
	@Override
	public EmployeeAdminMasterResultBean getPassportRelease(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getPassportRelease(empId);
	}
	@Override
	public EmployeeAdminMasterResultBean getpayrolldeductionList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getpayrolldeductionList(empId);
	}
	
	
	@Override
	public EmployeeAdminMasterResultBean getformList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getformList(empId);
	}
	
	@Override
	public EmployeeAdminMasterResultBean getEndofserviceList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEndofserviceList(empId);
	}
	@Override
	public EmployeeAdminMasterResultBean getPayrollBankList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getPayrollBankList(empId);
	}
	@Override
	public EmployeeAdminMasterResultBean gettravelHistorysList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.gettravelHistorysList(empId);
	}
	
	@Override
	public EmployeeAdminMasterResultBean getEmergencyList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmergencyList(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeMerits(EmployeeAdminMeritsBean objEmployeeMeritsBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeMerits(objEmployeeMeritsBean);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeFamily(EmployeeAdminFamilyBean objEmployeeFamilyBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeFamily(objEmployeeFamilyBean);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeExperiance(EmployeeAdminExperianceBean objEmployeeExperianceBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeExperiance(objEmployeeExperianceBean);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeEducation(EmployeeAdminEducationBean objEmployeeEducationBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeEducation(objEmployeeEducationBean);
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeEducation(EmployeeAdminEducationBean objEmployeeEducationBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployeeEducation(objEmployeeEducationBean);
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeFamily(EmployeeAdminFamilyBean objEmployeeFamilyBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployeeFamily(objEmployeeFamilyBean);
	}

	@Override
	public EmployeeAdminMasterResultBean UpdateExperianceDetail(EmployeeAdminExperianceBean objEmployeeExperianceBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.UpdateExperianceDetail(objEmployeeExperianceBean);
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeMerit(EmployeeAdminMeritsBean objEmployeeMeritsBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployeeMerit(objEmployeeMeritsBean);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeReference(EmployeeAdminReferanceBean objBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeReference(objBean);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeEmergency(EmployeeAdminEmergencyBean objBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeEmergency(objBean);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeNomination(EmployeeAdminNominationBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeNomination(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeReference(EmployeeAdminReferanceBean objEmployeeReferanceBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployeeReference(objEmployeeReferanceBean);
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeEmergency(EmployeeAdminEmergencyBean objEmployeeEmergencyBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployeeEmergency(objEmployeeEmergencyBean);
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeNomination(EmployeeAdminNominationBean objEmployeeNominationBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployeeNomination(objEmployeeNominationBean);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeePersonal(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeePersonal(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeAddress(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeAddress(objEmp);
	}
	
	@Override
	public EmployeeAdminMasterResultBean savePayBank(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.savePayBank(objEmp);
	}
	
	
	
	@Override
	public EmployeeAdminMasterResultBean savefrmAssets(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.savefrmAssets(objEmp);
	}
	@Override
	public EmployeeAdminMasterResultBean saveAirClaim(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.saveAirClaim(objEmp);
	}
	
	
	@Override
	public EmployeeAdminMasterResultBean saveSettle(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.saveSettle(objEmp);
	}
	@Override
	public EmployeeAdminMasterResultBean savePassport(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.savePassport(objEmp);
	}
	
	@Override
	public EmployeeAdminMasterResultBean saveFormReview(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.saveFormReview(objEmp);
	}
	@Override
	public EmployeeAdminMasterResultBean insertEmployeeRule(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeRule(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeDocument(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeDocument(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeePhysical(EmployeeAdminMasterBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeePhysical(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeFamily(EmployeeAdminFamilyBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeFamily(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeEducation(EmployeeAdminEducationBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeEducation(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeMerits(EmployeeAdminMeritsBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeMerits(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeEmergency(EmployeeAdminEmergencyBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeEmergency(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeReference(EmployeeAdminReferanceBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeReference(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeNomination(EmployeeAdminNominationBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeNomination(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeNomination(EmployeeAdminNominationBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployeeNomination(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeEmergency(EmployeeAdminEmergencyBean objemp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployeeEmergency(objemp);
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeReference(EmployeeAdminReferanceBean objBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployeeReference(objBean);
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeExperiance(EmployeeAdminExperianceBean objBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployeeExperiance(objBean);
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeMerit(EmployeeAdminMeritsBean objBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployeeMerit(objBean);
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeFamily(EmployeeAdminFamilyBean objBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployeeFamily(objBean);
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeEducation(EmployeeAdminEducationBean objBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployeeEducation(objBean);
	}

	@Override
	public boolean updatePersonalInfo(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updatePersonalInfo(objEmployeeMasterBean);
	}

	@Override
	public boolean updateAddress(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateAddress(objEmployeeMasterBean);
	}
	
	@Override
	public boolean updatePayBank(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updatePayBank(objEmployeeMasterBean);
	}
	
	
	@Override
	public boolean updateformReview(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateformReview(objEmployeeMasterBean);
	}
	
	
	@Override
	public boolean updatefrmAssets(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updatefrmAssets(objEmployeeMasterBean);
	}
	
	@Override
	public boolean updateAirClaim(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateAirClaim(objEmployeeMasterBean);
	}
	
	@Override
	public boolean updateSettle(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateSettle(objEmployeeMasterBean);
	}
	@Override
	public boolean updatePassport(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updatePassport(objEmployeeMasterBean);
	}
	@Override
	public boolean updateRules(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateRules(objEmployeeMasterBean);
	}

	@Override
	public boolean updateDocument(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateDocument(objEmployeeMasterBean);
	}

	@Override
	public boolean updatePhysical(EmployeeAdminMasterBean objEmployeeMasterBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updatePhysical(objEmployeeMasterBean);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeDoc(EmployeeAdminDocumentBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeDoc(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeDoc(EmployeeAdminDocumentBean objEmployeeDocumentBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeDoc(objEmployeeDocumentBean);
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpDocumentList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmpDocumentList(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeDoc(EmployeeAdminDocumentBean objEmployeeDocumentBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployeeDoc(objEmployeeDocumentBean);
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeDoc(EmployeeAdminDocumentBean objDocumentBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployeeDoc(objDocumentBean);
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeProbation(EmployeeAdminProbationBean objEmp) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployeeProbation(objEmp);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeProbation(EmployeeAdminProbationBean objEmployeeProbationBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeProbation(objEmployeeProbationBean);
	}

	@Override
	public EmployeeAdminMasterResultBean getProbationList(String empId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getProbationList(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeProbation(EmployeeAdminProbationBean objEmployeeProbationBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployeeProbation(objEmployeeProbationBean);
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeProbation(EmployeeAdminProbationBean objProbationBean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployeeProbation(objProbationBean);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeePersonal(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeePersonal(editEmployeeID);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeePhysical(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeePhysical(editEmployeeID);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeDetail(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeDetail(editEmployeeID);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeRule(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeRule(editEmployeeID);
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeAddress(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editEmployeeAddress(editEmployeeID);
	}
	
	@Override
	public EmployeeAdminMasterResultBean editPayRoll(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editPayRoll(editEmployeeID);
	}
	

	@Override
	public EmployeeAdminMasterResultBean editFormReview(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editFormReview(editEmployeeID);
	}
	
	
	@Override
	public EmployeeAdminMasterResultBean editAssets(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editAssets(editEmployeeID);
	}
	@Override
	public EmployeeAdminMasterResultBean editPassportReqeuest(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editPassportReqeuest(editEmployeeID);
	}
	
	
	

	@Override
	public EmployeeAdminMasterResultBean editAirClaim(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editAirClaim(editEmployeeID);
	}
	
	
	

	@Override
	public EmployeeAdminMasterResultBean editSettlement(String editEmployeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.editSettlement(editEmployeeID);
	}
	
	@Override
	public EmployeeAdminMasterResultBean getYearList() {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getYearList();
	}

	@Override
	public EmployeeAdminMasterResultBean uploadDependentFile(MultipartFile file, String employeeID) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.uploadDependentFile(file, employeeID);
	}

	@Override
	public EmployeeAdminMasterBean getProfileInfo() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getProfileInfo();
	}

	@Override
	public int checkESICNo(String esic) throws Exception {
		return employeeMasterDAO.checkESICNo(esic);
	}

	@Override
	public int checkEPFNo(String epfNo) throws Exception {
		return employeeMasterDAO.checkEPFNo(epfNo);
	}

	@Override
	public int checkPersonalInfoPANNo(String panNo) throws Exception {
		return employeeMasterDAO.checkPersonalInfoPANNo(panNo);
	}

	@Override
	public EmployeeAdminMasterResultBean getDesigantion(String designationId) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getDesigantion(designationId);
	}

	@Override
	public EmployeeAdminMasterResultBean getBloodGroupList()
			throws CustomException {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getBloodGroupList();
	}

	@Override
	public EmployeeAdminMasterResultBean viewEmployeeById(String empId)
			throws CustomException {
		// TODO Auto-generated method stub
		return employeeMasterDAO.viewEmployeeById(empId);
	}

	@Override
	public EmployeeAdminMasterResultBean getLeaveListSeach(EmployeeAdminMasterBean bean) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getLeaveListSeach(bean);
	}
	@Override
	public EmployeeAdminMasterResultBean uploadFileNew(MultipartFile file) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.uploadFileNew(file);
	}

}
