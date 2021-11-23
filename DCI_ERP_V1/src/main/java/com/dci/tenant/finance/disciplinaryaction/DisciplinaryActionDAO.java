package com.dci.tenant.finance.disciplinaryaction;

import java.util.List;

import com.dci.common.util.CustomException;


public interface DisciplinaryActionDAO {
	List<DisciplinaryActionBean> getDisciplinaryList() throws Exception;

	public boolean insertDisciplinaryData(DisciplinaryActionBean objsBean);

	public boolean updateDisciplinaryData(DisciplinaryActionBean objDiscipBean) throws Exception;

	public DisciplinaryActionBean getDisciplinaryDataEdit(int disciplinary_proceedings_sk) throws Exception;

	public boolean deleteDisciplinaryData(int disciplinaryId) throws Exception;

	public DisciplinaryActionBean getEmployeeList(DisciplinaryActionBean objDiscipBean) throws CustomException;

}
