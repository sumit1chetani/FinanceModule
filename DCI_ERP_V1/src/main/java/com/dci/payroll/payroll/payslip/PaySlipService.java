package com.dci.payroll.payroll.payslip;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;



public interface PaySlipService {

	PaySlipListDTO getPaySlipList(String companyId, String branchId, String departmentId, String employeeId, String monthYear) throws Exception;

	PaySlipBean getPaySlipList1(String employeeId) throws Exception;

	PaySlipResultBean getPaySlipList2(List<PaySlipBean> employeeIdlist) throws Exception;

	PaySlipResultBean sendMailForPaySlip(String companyId, String branchId, String dept, String employeeId, String monthYear, String emailAddress, UserDetail userDetails, HttpServletRequest request, HttpServletResponse response, PaySlipListDTO paySlipListDTO) throws Exception;

	public void exportExcel(PaySlipBean paySlipBean, String filePath) throws CustomException, IOException, Exception;
}