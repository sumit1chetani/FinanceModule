package com.dci.payroll.payroll.Esi;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CustomException;


public interface EsiDAO {

	public List<EsiBean> getESIList(EsiBean esiBean) throws CustomException;

	public boolean insertEsiList(ArrayList<EsiBean> empLOPBean) throws CustomException;

}
