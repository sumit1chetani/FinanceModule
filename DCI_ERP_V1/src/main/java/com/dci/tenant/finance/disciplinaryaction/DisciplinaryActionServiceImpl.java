package com.dci.tenant.finance.disciplinaryaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;


@Service
public class DisciplinaryActionServiceImpl implements DisciplinaryActionService {

	@Autowired
	DisciplinaryActionDAO disciplinaryDAO;

	@Override
	public List<DisciplinaryActionBean> getDisciplinaryActionList() throws Exception {
		// TODO Auto-generated method stub
		return disciplinaryDAO.getDisciplinaryList();
	}

	@Override
	public boolean insertDisciplinaryData(DisciplinaryActionBean objsBean) {
		// TODO Auto-generated method stub
		return disciplinaryDAO.insertDisciplinaryData(objsBean);
	}

	@Override
	public boolean updateDisciplinaryData(DisciplinaryActionBean objDiscipBean) throws Exception {
		return disciplinaryDAO.updateDisciplinaryData(objDiscipBean);
	}

	@Override
	public boolean deleteDisciplinaryData(int disciplinaryId) throws Exception {
		return disciplinaryDAO.deleteDisciplinaryData(disciplinaryId);
	}

	@Override
	public DisciplinaryActionBean getDisciplinaryDataEdit(int disciplinary_proceedings_sk) throws Exception {
		return disciplinaryDAO.getDisciplinaryDataEdit(disciplinary_proceedings_sk);
	}

	@Override
	public DisciplinaryActionBean getEmployeeList(DisciplinaryActionBean objDiscipBean) throws CustomException {
		return disciplinaryDAO.getEmployeeList(objDiscipBean);
	}

}
