package com.dci.payroll.payroll.Esi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CustomException;


public interface EsiService {

	public List<EsiBean> getESIList(EsiBean esiBean) throws Exception;

	boolean insertEsiList(ArrayList<EsiBean> esiBean) throws Exception;

	public void exportExcel(ArrayList<EsiBean> esiBean, String filePath) throws CustomException, IOException, Exception;

}
