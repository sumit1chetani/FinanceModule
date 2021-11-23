package com.dci.payroll.tds.NscInterest;

import java.util.List;

import com.dci.common.util.CustomException;


public interface NscInterestDAO {
	public List<NscInterestBean> getNscInterestList() throws CustomException;

	public NscInterestBean getNscInterestById(String financialYear) throws CustomException;

	public boolean insertNscInterest(NscInterestBean nscInterest) throws CustomException;

	public boolean updateNscInterest(NscInterestBean nscInterest) throws CustomException;

}
