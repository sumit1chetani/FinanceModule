package com.dci.payroll.payroll.reimbursement;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface ReimbursementDAO {

	public boolean insertReimbursementreq(Reimbursement reimbursement) throws CustomException;

	public List<Reimbursement> getReimbursementList(int status) throws CustomException;

	public List<Reimbursement> getReimbursementListByStatus(int status, String approvalempId) throws CustomException;

	public List<Reimbursement> getCurrencyList() throws CustomException;

	public List<Reimbursement> getReimburseMentTypeList() throws CustomException;

	public Reimbursement getReimbursementById(int reimbursementId) throws CustomException;

	public boolean approvalupdate(Reimbursement reimbursement) throws CustomException;

	public boolean updateReimbursement(Reimbursement reimbursement) throws CustomException;

	public boolean deleteReimbursement(int reimbursementId) throws CustomException;

	ReimbursementResultBean uploadDocFile(MultipartFile file, String employeeName);
}
