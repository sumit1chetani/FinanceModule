package com.dci.tenant.finance.disciplinaryaction;

import java.util.List;

import com.dci.common.util.CustomException;


public interface DisciplinaryActionService {

	List<DisciplinaryActionBean> getDisciplinaryActionList() throws Exception;

	public boolean insertDisciplinaryData(DisciplinaryActionBean objsBean);

	public boolean deleteDisciplinaryData(int disciplinaryId) throws Exception;

	public boolean updateDisciplinaryData(DisciplinaryActionBean objDiscipBean) throws Exception;

	public DisciplinaryActionBean getDisciplinaryDataEdit(int disciplinary_proceedings_sk) throws Exception;

	public DisciplinaryActionBean getEmployeeList(DisciplinaryActionBean objsBean) throws CustomException;

}
