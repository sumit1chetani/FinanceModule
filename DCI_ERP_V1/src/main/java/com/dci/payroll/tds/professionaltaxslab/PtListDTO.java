package com.dci.payroll.tds.professionaltaxslab;

import java.util.ArrayList;
import java.util.List;

public class PtListDTO {

	private List<PtSlabDTO> emplList = new ArrayList<PtSlabDTO>();

	public List<PtSlabDTO> getEmplList() {
		return emplList;
	}

	public void setEmplList(List<PtSlabDTO> emplList) {
		this.emplList = emplList;
	}

}
