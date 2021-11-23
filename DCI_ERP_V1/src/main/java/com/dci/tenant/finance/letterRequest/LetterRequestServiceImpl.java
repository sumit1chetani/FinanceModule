package com.dci.tenant.finance.letterRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;

@Service
public class LetterRequestServiceImpl implements LetterRequestService {
	@Autowired
	LetterRequestDAO letterRequestDAO;

	@Override
	public List<LetterRequestBean> getLetterTypeList() throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.getLetterTypeList();
	}

	@Override
	public boolean insertLetterRequestType(LetterRequestBean bean) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.insertLetterRequestType(bean);
	}

	@Override
	public boolean updateLetterRequestType(LetterRequestBean bean) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.updateLetterRequestType(bean);
	}

	@Override
	public LetterRequestBean editLetterRequestType(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.editLetterRequestType(id);
	}

	@Override
	public boolean delete(LetterRequestBean bean) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.delete(bean);
	}

	@Override
	public List<LetterRequestBean> letterReqList() throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.letterReqList();
	}

	@Override
	public boolean save(LetterRequestBean bean) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.save(bean);
	}

	@Override
	public boolean update(LetterRequestBean bean) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.update(bean);
	}

	@Override
	public LetterRequestBean edit(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.edit(id);
	}

	@Override
	public boolean deleteLR(LetterRequestBean bean) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.deleteLR(bean);
	}

	@Override
	public List<SelectivityBean> getLetterReqTypeList() throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.getLetterReqTypeList();
	}

	@Override
	public boolean approve(LetterRequestBean bean) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.approve(bean);
	}

	@Override
	public boolean issueVal(LetterRequestBean bean) throws Exception {
		// TODO Auto-generated method stub
		return letterRequestDAO.issueVal(bean);
	}

}