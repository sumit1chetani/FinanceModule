package com.dci.payroll.payroll.advance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CustomException;


public interface AdvanceService {

	List<Advance> getEmployeeList() throws Exception;

	Advance getEmployeeDetail(String emp) throws Exception;

	List<Advance> getDesignationList() throws Exception;

	List<Advance> getEmployeeListbasondes(String des) throws Exception;

	List<Advance> getInsList(Advance Advance) throws Exception;

	boolean addAdvance(Advance Advance) throws Exception;

	List<Advance> getAdvanceListList() throws Exception;

	List<Advance> getAdvanceListbyCode(String advanceCode) throws Exception;

	boolean updateAdvance(Advance Advance) throws Exception;

	boolean deleteAdvance(String advanceCode) throws Exception;

	List<Advance> getAdvanceAddList(Advance Advance) throws Exception;

	AdvanceResultBean addAdvanceAmount(ArrayList<Advance> Advance) throws Exception;

	boolean deleteAdvanceAdd(String monthYear, Integer departmentId, String employeeId) throws Exception;

	List<Advance> getAdvanceReport(Advance Advance) throws Exception;

	public void exportExcel(Advance Advance, String filePath) throws CustomException, IOException, Exception;

}
