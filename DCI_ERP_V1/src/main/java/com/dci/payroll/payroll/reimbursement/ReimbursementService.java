package com.dci.payroll.payroll.reimbursement;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface ReimbursementService {

	boolean insertReimbursementreq(Reimbursement reimbursement) throws Exception;

	public void exportExcel(Reimbursement reimbursement, String filePath) throws CustomException, IOException, Exception;

	List<Reimbursement> getReimbursementList(int status) throws Exception;

	List<Reimbursement> getReimbursementListByStatus(int status, String approvalempId) throws Exception;

	Reimbursement getReimbursementById(int reimbursementId) throws Exception;

	boolean updateReimbursement(Reimbursement reimbursement) throws Exception;

	boolean approvalupdate(Reimbursement reimbursement) throws Exception;

	boolean deleteReimbursement(int reimbursementId) throws Exception;

	List<Reimbursement> getCurrencyList() throws Exception;

	List<Reimbursement> getReimburseMentTypeList() throws Exception;

	ReimbursementResultBean uploadDocFile(MultipartFile file, String fileName);
}
