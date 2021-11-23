package com.dci.payroll.tds.otherheadentry;

import java.util.ArrayList;
import java.util.List;

public interface OtherHeadEntryService {

	public List<OtherHeadEntryBean> getOtherHeadEntryList(String employeeId, String financialYearId) throws Exception;

	boolean insertOtherHead(ArrayList<OtherHeadEntryBean> otherHeadEntryBean) throws Exception;

	OtherHeadEntryBean getOtherHeadById(Integer otherHeadId) throws Exception;

	boolean updateHeadEntry(OtherHeadEntryBean otherHeadEntryBean) throws Exception;

	boolean deleteOtherHeadEntry(Integer otherHeadId) throws Exception;
}