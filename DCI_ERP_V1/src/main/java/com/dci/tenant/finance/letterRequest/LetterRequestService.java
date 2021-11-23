package com.dci.tenant.finance.letterRequest;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface LetterRequestService {

	List<LetterRequestBean> getLetterTypeList() throws Exception;
	
	List<SelectivityBean> getLetterReqTypeList() throws Exception;

	public boolean insertLetterRequestType(LetterRequestBean bean) throws Exception;
	
	public boolean updateLetterRequestType(LetterRequestBean bean) throws Exception;

	public LetterRequestBean editLetterRequestType(Integer id) throws Exception;

	public boolean delete(LetterRequestBean bean) throws Exception;

	List<LetterRequestBean> letterReqList() throws Exception;

	public boolean save(LetterRequestBean bean) throws Exception;
	
	public boolean update(LetterRequestBean bean) throws Exception;

	public LetterRequestBean edit(Integer id) throws Exception;
	
	public boolean deleteLR(LetterRequestBean bean) throws Exception;
	
	public boolean approve(LetterRequestBean bean) throws Exception;
	
	public boolean issueVal(LetterRequestBean bean) throws Exception;

}