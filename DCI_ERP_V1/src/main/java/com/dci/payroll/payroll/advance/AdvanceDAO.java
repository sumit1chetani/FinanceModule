package com.dci.payroll.payroll.advance;

import java.util.ArrayList;
import java.util.List;

public interface AdvanceDAO {

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

}
