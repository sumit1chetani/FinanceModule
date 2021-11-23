package com.dci.payroll.payroll.employeepaycomponent;

public class EmployeePayComponentBean {
	private int id;
	private String employeeId;
	private String arrears;
	private String arrearFlag;
	private boolean arrearExist;
	private String arrearsStartDate;
	private String employeeName;
	private String errorMessage;

	private String dept;
	public boolean isArrearExist() {
		return arrearExist;
	}

	public void setArrearExist(boolean arrearExist) {
		this.arrearExist = arrearExist;
	}

	private String fromdate;
	private String todate;
	private String companyId;
	private String branchId;
	private Integer departmentId;
	private String companyName;
	private String branchName;
	private String departmentName;
	private String dum1;
	private String dum2;
	private String dum3;
	private String dum4;
	private String dum5;
	private String dum6;
	private String dum7;
	private String dum8;
	private String dum9;
	private String dum10;
	private String dum11;
	private String dum12;
	private boolean check;

	public String getArrearFlag() {
		return arrearFlag;
	}

	public void setArrearFlag(String arrearFlag) {
		this.arrearFlag = arrearFlag;
	}

	public String getArrears() {
		return arrears;
	}

	public void setArrears(String arrears) {
		this.arrears = arrears;
	}

	public String getArrearsStartDate() {
		return arrearsStartDate;
	}

	public void setArrearsStartDate(String arrearsStartDate) {
		this.arrearsStartDate = arrearsStartDate;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	private String todaydate;
	private String payComponentId;
	private String payComponentName;
	private String percentageAppliedOn;
	private String select;
	private double amount;
	private double value;
	private boolean isValid; // Button Change While Adding and Updating
	private String otherrarnings;
	private String pfcom;
	private String conve;
	private String hra;
	private String grosspay;
	private String medic;
	private String nerpay;
	private String pfesl;
	private String da;
	private String otded;
	private String basic;
	private String spl;
	private String cons;

	public String getSpl() {
		return spl;
	}

	public void setSpl(String spl) {
		this.spl = spl;
	}

	public String getCons() {
		return cons;
	}

	public void setCons(String cons) {
		this.cons = cons;
	}

	public String getDum1() {
		return dum1;
	}

	public void setDum1(String dum1) {
		this.dum1 = dum1;
	}

	public String getDum2() {
		return dum2;
	}

	public void setDum2(String dum2) {
		this.dum2 = dum2;
	}

	public String getDum3() {
		return dum3;
	}

	public void setDum3(String dum3) {
		this.dum3 = dum3;
	}

	public String getDum4() {
		return dum4;
	}

	public void setDum4(String dum4) {
		this.dum4 = dum4;
	}

	public String getDum5() {
		return dum5;
	}

	public void setDum5(String dum5) {
		this.dum5 = dum5;
	}

	public String getDum6() {
		return dum6;
	}

	public void setDum6(String dum6) {
		this.dum6 = dum6;
	}

	public String getDum7() {
		return dum7;
	}

	public void setDum7(String dum7) {
		this.dum7 = dum7;
	}

	public String getDum8() {
		return dum8;
	}

	public void setDum8(String dum8) {
		this.dum8 = dum8;
	}

	public String getDum9() {
		return dum9;
	}

	public void setDum9(String dum9) {
		this.dum9 = dum9;
	}

	public String getDum10() {
		return dum10;
	}

	public void setDum10(String dum10) {
		this.dum10 = dum10;
	}

	public String getDum11() {
		return dum11;
	}

	public void setDum11(String dum11) {
		this.dum11 = dum11;
	}

	public String getDum12() {
		return dum12;
	}

	public void setDum12(String dum12) {
		this.dum12 = dum12;
	}

	public String getOtherrarnings() {
		return otherrarnings;
	}

	public void setOtherrarnings(String otherrarnings) {
		this.otherrarnings = otherrarnings;
	}

	public String getPfcom() {
		return pfcom;
	}

	public void setPfcom(String pfcom) {
		this.pfcom = pfcom;
	}

	public String getConve() {
		return conve;
	}

	public void setConve(String conve) {
		this.conve = conve;
	}

	public String getHra() {
		return hra;
	}

	public void setHra(String hra) {
		this.hra = hra;
	}

	public String getGrosspay() {
		return grosspay;
	}

	public void setGrosspay(String grosspay) {
		this.grosspay = grosspay;
	}

	public String getMedic() {
		return medic;
	}

	public void setMedic(String medic) {
		this.medic = medic;
	}

	public String getNerpay() {
		return nerpay;
	}

	public void setNerpay(String nerpay) {
		this.nerpay = nerpay;
	}

	public String getPfesl() {
		return pfesl;
	}

	public void setPfesl(String pfesl) {
		this.pfesl = pfesl;
	}

	public String getDa() {
		return da;
	}

	public void setDa(String da) {
		this.da = da;
	}

	public String getOtded() {
		return otded;
	}

	public void setOtded(String otded) {
		this.otded = otded;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean getisValid() {
		return isValid;
	}

	public void setisValid(boolean isValid) {
		this.isValid = isValid;
	}

	private int payComponentType;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getPayComponentId() {
		return payComponentId;
	}

	public void setPayComponentId(String payComponentId) {
		this.payComponentId = payComponentId;
	}

	public String getPayComponentName() {
		return payComponentName;
	}

	public void setPayComponentName(String payComponentName) {
		this.payComponentName = payComponentName;
	}

	public int getPayComponentType() {
		return payComponentType;
	}

	public void setPayComponentType(int payComponentType) {
		this.payComponentType = payComponentType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPercentageAppliedOn() {
		return percentageAppliedOn;
	}

	public void setPercentageAppliedOn(String percentageAppliedOn) {
		this.percentageAppliedOn = percentageAppliedOn;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getTodaydate() {
		return todaydate;
	}

	public void setTodaydate(String todaydate) {
		this.todaydate = todaydate;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	
	
}