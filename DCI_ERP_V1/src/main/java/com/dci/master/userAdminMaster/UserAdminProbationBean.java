package com.dci.master.userAdminMaster;

//
public class UserAdminProbationBean {
	private String empId;
	private String frmProbation;
	private int extend;
	private Boolean breakAny;
	private String toProbation;
	private int duration;
	private String frmBreakPro;
	private String toBreakPro;
	private int breakDuration;
	private String completion;
	private int empProbationId;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFrmProbation() {
		return frmProbation;
	}

	public void setFrmProbation(String frmProbation) {
		this.frmProbation = frmProbation;
	}

	public Boolean getBreakAny() {
		return breakAny;
	}

	public void setBreakAny(Boolean breakAny) {
		this.breakAny = breakAny;
	}

	public String getToProbation() {
		return toProbation;
	}

	public void setToProbation(String toProbation) {
		this.toProbation = toProbation;
	}

	public String getFrmBreakPro() {
		return frmBreakPro;
	}

	public void setFrmBreakPro(String frmBreakPro) {
		this.frmBreakPro = frmBreakPro;
	}

	public String getToBreakPro() {
		return toBreakPro;
	}

	public void setToBreakPro(String toBreakPro) {
		this.toBreakPro = toBreakPro;
	}

	public String getCompletion() {
		return completion;
	}

	public void setCompletion(String completion) {
		this.completion = completion;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getExtend() {
		return extend;
	}

	public void setExtend(int extend) {
		this.extend = extend;
	}

	public int getBreakDuration() {
		return breakDuration;
	}

	public void setBreakDuration(int breakDuration) {
		this.breakDuration = breakDuration;
	}

	public int getEmpProbationId() {
		return empProbationId;
	}

	public void setEmpProbationId(int empProbationId) {
		this.empProbationId = empProbationId;
	}

}
