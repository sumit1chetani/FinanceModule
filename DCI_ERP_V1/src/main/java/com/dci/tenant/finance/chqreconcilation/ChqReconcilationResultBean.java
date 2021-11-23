package com.dci.tenant.finance.chqreconcilation;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ChqReconcilationResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private ChqReconcilationBook objBankReconcilationBook = new ChqReconcilationBook();

	private List<ChqReconcilationBook> lBankReconcilationBook;

	public ChqReconcilationBook getObjBankReconcilationBook() {
		return objBankReconcilationBook;
	}

	public void setObjBankReconcilationBook(ChqReconcilationBook objBankReconcilationBook) {
		this.objBankReconcilationBook = objBankReconcilationBook;
	}

	public List<ChqReconcilationBook> getlBankReconcilationBook() {
		return lBankReconcilationBook;
	}

	public void setlBankReconcilationBook(List<ChqReconcilationBook> lBankReconcilationBook) {
		this.lBankReconcilationBook = lBankReconcilationBook;
	}

}