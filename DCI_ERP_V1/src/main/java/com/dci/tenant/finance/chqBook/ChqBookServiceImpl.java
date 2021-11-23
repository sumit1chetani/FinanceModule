package com.dci.tenant.finance.chqBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChqBookServiceImpl implements ChqBookService {

	@Autowired
	ChqBookDAO chqBookDAO;

	@Override
	public List<ChqBookBean> getStatusList() throws Exception {
		return chqBookDAO.getStatusList();
	}

	@Override
	public List<ChqBookBean> getChqBookList() throws Exception {
		return chqBookDAO.getChqBookList();
	}

	@Override
	public List<ChqBookBean> getChqBookListdummy() throws Exception {
		return chqBookDAO.getChqBookListdummy();
	}

	@Override
	public boolean saveChqBook(ChqBookBean objChqBookBean) throws Exception {
		// TODO Auto-generated method stub
		return chqBookDAO.saveChqBook(objChqBookBean);
	}

	@Override
	public boolean updateChqBook(ChqBookBean objChqBookBean) throws Exception {
		// TODO Auto-generated method stub
		return chqBookDAO.updateChqBook(objChqBookBean);
	}

	@Override
	public ChqBookResultBean editChqBook(int chqBookId) throws Exception {
		// TODO Auto-generated method stub
		return chqBookDAO.editChqBook(chqBookId);
	}

	@Override
	public boolean deleteChqBook(int chqBookId) throws Exception {
		// TODO Auto-generated method stub
		return chqBookDAO.deleteChqBook(chqBookId);
	}

	@Override
	public List<ChqBookBean> searchList(ChqBookBean objChqBookBean) throws Exception {
		// TODO Auto-generated method stub
		return chqBookDAO.searchList(objChqBookBean);
	}

}
