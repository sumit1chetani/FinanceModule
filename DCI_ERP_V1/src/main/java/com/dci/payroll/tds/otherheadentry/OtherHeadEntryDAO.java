package com.dci.payroll.tds.otherheadentry;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CustomException;


public interface OtherHeadEntryDAO {
	List<OtherHeadEntryBean> getOtherHeadEntryList(String employeeId, String financialYearId) throws CustomException;

	boolean insertOtherHead(ArrayList<OtherHeadEntryBean> otherHeadEntryBean) throws CustomException;

	OtherHeadEntryBean getOtherHeadById(Integer otherHeadId) throws CustomException;

	boolean updateHeadEntry(OtherHeadEntryBean otherHeadEntryBean) throws CustomException;

	boolean deleteOtherHeadEntry(Integer otherHeadId) throws CustomException;
}