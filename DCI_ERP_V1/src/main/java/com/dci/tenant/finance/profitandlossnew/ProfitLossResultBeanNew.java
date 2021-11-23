package com.dci.tenant.finance.profitandlossnew;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.ReportHeaderBean;
import com.dci.common.util.BasicResultBean;

public class ProfitLossResultBeanNew extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ProfitAndLossBean> profitLossIncomeBean;
	private List<ProfitAndLossBean> profitLossExpensesBean;
	public ArrayList<ProfitAndLossBean> alResultTree;

	private double dSalesRevenueTotal;
	private double dCostOfSalesTotal;
	private double dOtherIncome;
	private double dAdminExpense;
	private double dOtherExpense;
	private double dFinanceCost;
	private double dRentCost;

	public double getDdisputedcost() {
		return ddisputedcost;
	}

	public void setDdisputedcost(double ddisputedcost) {
		this.ddisputedcost = ddisputedcost;
	}

	private double ddisputedcost;
	private double dTravellingCost;
	private double dSalesandBuss;
	private double dPersonalCost;
	private double dCommunctionExpense;
	private double dtravellingcost;
	private double dconveyencecost;

	private double dsalesCost;
	private double dpersonalCost;

	public double getDtravellingcost() {
		return dtravellingcost;
	}

	public void setDtravellingcost(double dtravellingcost) {
		this.dtravellingcost = dtravellingcost;
	}

	public double getDsalesCost() {
		return dsalesCost;
	}

	public void setDsalesCost(double dsalesCost) {
		this.dsalesCost = dsalesCost;
	}

	public double getDpersonalCost() {
		return dpersonalCost;
	}

	public void setDpersonalCost(double dpersonalCost) {
		this.dpersonalCost = dpersonalCost;
	}

	public double getDfinanceCost() {
		return dfinanceCost;
	}

	public void setDfinanceCost(double dfinanceCost) {
		this.dfinanceCost = dfinanceCost;
	}

	public double getDcommunicationCost() {
		return dcommunicationCost;
	}

	public void setDcommunicationCost(double dcommunicationCost) {
		this.dcommunicationCost = dcommunicationCost;
	}

	public double getDadministrativeCost() {
		return dadministrativeCost;
	}

	public void setDadministrativeCost(double dadministrativeCost) {
		this.dadministrativeCost = dadministrativeCost;
	}

	private double dfinanceCost;
	private double dcommunicationCost;
	private double dadministrativeCost;

	private List<ReportHeaderBean> getJobOrderReportHeaderList;
	private List<ProfitandLossJobOrderReport> ljobOrderReportlist;

	private List<ProfitAndLossBean> lSalesRevenue;
	private List<ProfitAndLossBean> lCostOfSales;
	private List<ProfitAndLossBean> lOtherIncome;
	private List<ProfitAndLossBean> lopeningstock;
	private List<ProfitAndLossBean> lindirectexpenses;

	public List<ProfitAndLossBean> getLindirectexpenses() {
		return lindirectexpenses;
	}

	public void setLindirectexpenses(List<ProfitAndLossBean> lindirectexpenses) {
		this.lindirectexpenses = lindirectexpenses;
	}

	private List<ProfitAndLossBean> lclosingstock;

	private List<ProfitAndLossBean> lpurchaseaccounts;

	public List<ProfitAndLossBean> getLopeningstock() {
		return lopeningstock;
	}

	public void setLopeningstock(List<ProfitAndLossBean> lopeningstock) {
		this.lopeningstock = lopeningstock;
	}

	public List<ProfitAndLossBean> getLclosingstock() {
		return lclosingstock;
	}

	public void setLclosingstock(List<ProfitAndLossBean> lclosingstock) {
		this.lclosingstock = lclosingstock;
	}

	public List<ProfitAndLossBean> getLpurchaseaccounts() {
		return lpurchaseaccounts;
	}

	public void setLpurchaseaccounts(List<ProfitAndLossBean> lpurchaseaccounts) {
		this.lpurchaseaccounts = lpurchaseaccounts;
	}

	public List<ProfitAndLossBean> getLsalesaccounts() {
		return lsalesaccounts;
	}

	public void setLsalesaccounts(List<ProfitAndLossBean> lsalesaccounts) {
		this.lsalesaccounts = lsalesaccounts;
	}

	private List<ProfitAndLossBean> lsalesaccounts;

	private List<ProfitAndLossBean> lAdminExpense;
	private List<ProfitAndLossBean> lOtherExpense;
	private List<ProfitAndLossBean> lFinanceCost;
	private List<ProfitAndLossBean> ldisputedCost;
	private List<ProfitAndLossBean> lTravellingCostList;
	private List<ProfitAndLossBean> lSalesandBusinessList;
	private List<ProfitAndLossBean> lPersonalCostList;
	private List<ProfitAndLossBean> lCommuncationCostList;
	private List<ProfitAndLossBean> lRentCostList;
	private List<ProfitAndLossBean> lIndirectExpensesList;
	private List<ProfitAndLossBean> lConveyenceCostList;
	private List<ProfitAndLossBean> lDisputedCostList;
	private ProfitAndLossBean companyDetails;

	public List<ProfitAndLossBean> getlDisputedCostList() {
		return lDisputedCostList;
	}

	public void setlDisputedCostList(List<ProfitAndLossBean> lDisputedCostList) {
		this.lDisputedCostList = lDisputedCostList;
	}

	private String excelExportPath;

	public List<ProfitAndLossBean> getLdisputedCost() {
		return ldisputedCost;
	}

	public void setLdisputedCost(List<ProfitAndLossBean> ldisputedCost) {
		this.ldisputedCost = ldisputedCost;
	}

	private boolean success;

	public List<ProfitAndLossBean> getProfitLossIncomeBean() {
		return profitLossIncomeBean;
	}

	public void setProfitLossIncomeBean(List<ProfitAndLossBean> profitLossIncomeBean) {
		this.profitLossIncomeBean = profitLossIncomeBean;
	}

	public List<ProfitAndLossBean> getProfitLossExpensesBean() {
		return profitLossExpensesBean;
	}

	public void setProfitLossExpensesBean(List<ProfitAndLossBean> profitLossExpensesBean) {
		this.profitLossExpensesBean = profitLossExpensesBean;
	}

	public ArrayList<ProfitAndLossBean> getAlResultTree() {
		return alResultTree;
	}

	public void setAlResultTree(ArrayList<ProfitAndLossBean> alResultTree) {
		this.alResultTree = alResultTree;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ProfitAndLossBean> getlSalesRevenue() {
		return lSalesRevenue;
	}

	public void setlSalesRevenue(List<ProfitAndLossBean> lSalesRevenue) {
		this.lSalesRevenue = lSalesRevenue;
	}

	public double getdSalesRevenueTotal() {
		return dSalesRevenueTotal;
	}

	public void setdSalesRevenueTotal(double dSalesRevenueTotal) {
		this.dSalesRevenueTotal = dSalesRevenueTotal;
	}

	public double getdCostOfSalesTotal() {
		return dCostOfSalesTotal;
	}

	public void setdCostOfSalesTotal(double dCostOfSalesTotal) {
		this.dCostOfSalesTotal = dCostOfSalesTotal;
	}

	public List<ProfitAndLossBean> getlCostOfSales() {
		return lCostOfSales;
	}

	public void setlCostOfSales(List<ProfitAndLossBean> lCostOfSales) {
		this.lCostOfSales = lCostOfSales;
	}

	public double getdOtherIncome() {
		return dOtherIncome;
	}

	public void setdOtherIncome(double dOtherIncome) {
		this.dOtherIncome = dOtherIncome;
	}

	public List<ProfitAndLossBean> getlOtherIncome() {
		return lOtherIncome;
	}

	public void setlOtherIncome(List<ProfitAndLossBean> lOtherIncome) {
		this.lOtherIncome = lOtherIncome;
	}

	public double getdAdminExpense() {
		return dAdminExpense;
	}

	public void setdAdminExpense(double dAdminExpense) {
		this.dAdminExpense = dAdminExpense;
	}

	public List<ProfitAndLossBean> getlAdminExpense() {
		return lAdminExpense;
	}

	public void setlAdminExpense(List<ProfitAndLossBean> lAdminExpense) {
		this.lAdminExpense = lAdminExpense;
	}

	public double getdOtherExpense() {
		return dOtherExpense;
	}

	public void setdOtherExpense(double dOtherExpense) {
		this.dOtherExpense = dOtherExpense;
	}

	public List<ProfitAndLossBean> getlOtherExpense() {
		return lOtherExpense;
	}

	public void setlOtherExpense(List<ProfitAndLossBean> lOtherExpense) {
		this.lOtherExpense = lOtherExpense;
	}

	public double getdFinanceCost() {
		return dFinanceCost;
	}

	public void setdFinanceCost(double dFinanceCost) {
		this.dFinanceCost = dFinanceCost;
	}

	public List<ProfitAndLossBean> getlFinanceCost() {
		return lFinanceCost;
	}

	public void setlFinanceCost(List<ProfitAndLossBean> lFinanceCost) {
		this.lFinanceCost = lFinanceCost;
	}

	public List<ReportHeaderBean> getGetJobOrderReportHeaderList() {
		return getJobOrderReportHeaderList;
	}

	public void setGetJobOrderReportHeaderList(List<ReportHeaderBean> getJobOrderReportHeaderList) {
		this.getJobOrderReportHeaderList = getJobOrderReportHeaderList;
	}

	public List<ProfitandLossJobOrderReport> getLjobOrderReportlist() {
		return ljobOrderReportlist;
	}

	public void setLjobOrderReportlist(List<ProfitandLossJobOrderReport> ljobOrderReportlist) {
		this.ljobOrderReportlist = ljobOrderReportlist;
	}

	public ProfitAndLossBean getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(ProfitAndLossBean companyDetails) {
		this.companyDetails = companyDetails;
	}

	public String getExcelExportPath() {
		return excelExportPath;
	}

	public void setExcelExportPath(String excelExportPath) {
		this.excelExportPath = excelExportPath;
	}

	@Override
	public boolean isSuccess() {
		return success;
	}

	@Override
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public double getdRentCost() {
		return dRentCost;
	}

	public double getdTravellingCost() {
		return dTravellingCost;
	}

	public double getdSalesandBuss() {
		return dSalesandBuss;
	}

	public double getdPersonalCost() {
		return dPersonalCost;
	}

	public void setdRentCost(double dRentCost) {
		this.dRentCost = dRentCost;
	}

	public void setdTravellingCost(double dTravellingCost) {
		this.dTravellingCost = dTravellingCost;
	}

	public void setdSalesandBuss(double dSalesandBuss) {
		this.dSalesandBuss = dSalesandBuss;
	}

	public void setdPersonalCost(double dPersonalCost) {
		this.dPersonalCost = dPersonalCost;
	}

	public double getdCommunctionExpense() {
		return dCommunctionExpense;
	}

	public void setdCommunctionExpense(double dCommunctionExpense) {
		this.dCommunctionExpense = dCommunctionExpense;
	}

	public List<ProfitAndLossBean> getlTravellingCostList() {
		return lTravellingCostList;
	}

	public List<ProfitAndLossBean> getlSalesandBusinessList() {
		return lSalesandBusinessList;
	}

	public List<ProfitAndLossBean> getlPersonalCostList() {
		return lPersonalCostList;
	}

	public List<ProfitAndLossBean> getlCommuncationCostList() {
		return lCommuncationCostList;
	}

	public List<ProfitAndLossBean> getlRentCostList() {
		return lRentCostList;
	}

	public List<ProfitAndLossBean> getlIndirectExpensesList() {
		return lIndirectExpensesList;
	}

	public void setlTravellingCostList(List<ProfitAndLossBean> lTravellingCostList) {
		this.lTravellingCostList = lTravellingCostList;
	}

	public void setlSalesandBusinessList(List<ProfitAndLossBean> lSalesandBusinessList) {
		this.lSalesandBusinessList = lSalesandBusinessList;
	}

	public void setlPersonalCostList(List<ProfitAndLossBean> lPersonalCostList) {
		this.lPersonalCostList = lPersonalCostList;
	}

	public void setlCommuncationCostList(List<ProfitAndLossBean> lCommuncationCostList) {
		this.lCommuncationCostList = lCommuncationCostList;
	}

	public void setlRentCostList(List<ProfitAndLossBean> lRentCostList) {
		this.lRentCostList = lRentCostList;
	}

	public void setlIndirectExpensesList(List<ProfitAndLossBean> lIndirectExpensesList) {
		this.lIndirectExpensesList = lIndirectExpensesList;
	}

	public double getDconveyencecost() {
		return dconveyencecost;
	}

	public void setDconveyencecost(double dconveyencecost) {
		this.dconveyencecost = dconveyencecost;
	}

	public List<ProfitAndLossBean> getlConveyenceCostList() {
		return lConveyenceCostList;
	}

	public void setlConveyenceCostList(List<ProfitAndLossBean> lConveyenceCostList) {
		this.lConveyenceCostList = lConveyenceCostList;
	}

}
