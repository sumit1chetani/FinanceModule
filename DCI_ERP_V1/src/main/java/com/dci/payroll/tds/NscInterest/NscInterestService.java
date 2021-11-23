package com.dci.payroll.tds.NscInterest;

import java.util.List;

public interface NscInterestService {

	List<NscInterestBean> getNscInterestList() throws Exception;

	NscInterestBean getNscInterestById(String financialYear) throws Exception;

	boolean insertNscInterest(NscInterestBean nscInterest) throws Exception;

	boolean updateNscInterest(NscInterestBean nscInterest) throws Exception;

}
