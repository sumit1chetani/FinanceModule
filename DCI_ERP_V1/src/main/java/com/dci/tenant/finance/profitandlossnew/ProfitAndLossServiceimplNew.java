package com.dci.tenant.finance.profitandlossnew;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dci.common.model.ReportHeaderBean;
import com.dci.common.model.SelectivityBean;
import com.dci.tenant.finance.trialBalance.TrialBalanceBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ProfitAndLossServiceimplNew implements ProfitAndLossServiceNew {

	@Autowired
	ProfitAndLossDAONew objProfitAndLossDao;

	@Value("${folder.path.localPath}")
	private String localPath;

	@Override
	public List<SelectivityBean> getCompanyList() {
		return objProfitAndLossDao.getCompanyList();
	}

	@Override
	public List<ProfitAndLossBean> generatePLReport(ProfitAndLossBean objProfitAndLossBean) {
		return objProfitAndLossDao.generatePLReport(objProfitAndLossBean);
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportDtl(ProfitAndLossBean objProfitAndLossBean) {
		return objProfitAndLossDao.generatePLReportDtl(objProfitAndLossBean);
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportAHDtl(ProfitAndLossBean objProfitAndLossBean) {
		return objProfitAndLossDao.generatePLReportAHDtl(objProfitAndLossBean);
	}

	@Override
	public ProfitLossResultBeanNew generatePLReportNew(ProfitAndLossBean objProfitAndLossBean) {
		Map<String, ProfitAndLossBean> hmProfitLossMap = objProfitAndLossDao.getProfitLossReportList(objProfitAndLossBean);

		ProfitLossResultBeanNew objProfitLossResultBean = new ProfitLossResultBeanNew();

		Iterator<Entry<String, ProfitAndLossBean>> it = hmProfitLossMap.entrySet().iterator();

		it = hmProfitLossMap.entrySet().iterator();
		double dSalesRevenueTotal = 0.0;
		double dOtherExpense = 0.0;
		double dFinanceCost = 0.0;
		double dOtherIncome = 0.0;
		double dCostOfSales = 0.0;
		double dAdminExpense = 0.0;
		double dRentCost = 0.0;
		double dTravellingCost = 0.0;
		double dSalesandBuss = 0.0;
		double dPersonalCost = 0.0;
		double dCommunctionExpense = 0.0;
		double dconveyencecost = 0.0;
		double ddisputedcost = 0.0;
		List<ProfitAndLossBean> lSalesRevenueList = new ArrayList<>();
		List<ProfitAndLossBean> dOtherIncomeList = new ArrayList<>();
		List<ProfitAndLossBean> lTravellingCostList = new ArrayList<>();
		List<ProfitAndLossBean> lSalesandBusinessList = new ArrayList<>();
		List<ProfitAndLossBean> lPersonalCostList = new ArrayList<>();
		List<ProfitAndLossBean> lCommuncationCostList = new ArrayList<>();
		List<ProfitAndLossBean> lRentCostList = new ArrayList<>();
		List<ProfitAndLossBean> lFinanceList = new ArrayList<>();
		List<ProfitAndLossBean> lCostOfSalesList = new ArrayList<>();
		List<ProfitAndLossBean> lAdministartiveExpensesList = new ArrayList<>();
		List<ProfitAndLossBean> lIndirectExpensesList = new ArrayList<>();
		List<ProfitAndLossBean> lOtherIncome = new ArrayList<>();
		List<ProfitAndLossBean> lConveyenceCostList = new ArrayList<>();

		while (it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
			System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

			if (((hmRow.getKey()).startsWith("400"))) {
				ProfitAndLossBean objSalesRevenue = hmRow.getValue();
				dSalesRevenueTotal += objSalesRevenue.getGroupAmount();

				List<ProfitAndLossBean> lAhlist = objSalesRevenue.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(objAhlist.getAmount());
					lSalesRevenueList.add(objProfitAndLossBeanTemp);
				}

			} else if (((hmRow.getKey()).startsWith("30"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dOtherIncome += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(objAhlist.getAmount());
					lOtherIncome.add(objProfitAndLossBeanTemp);
				}
			}

			else if (((hmRow.getKey()).startsWith("600"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dCostOfSales += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(-objAhlist.getAmount());
					lCostOfSalesList.add(objProfitAndLossBeanTemp);
				}
			} else if (((hmRow.getKey()).startsWith("5001"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dTravellingCost += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(-objAhlist.getAmount());
					lTravellingCostList.add(objProfitAndLossBeanTemp);

				}
				if (!lTravellingCostList.isEmpty()) {
					lIndirectExpensesList.addAll(lTravellingCostList);
				}
			} else if (((hmRow.getKey()).startsWith("5002"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dSalesandBuss += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(-objAhlist.getAmount());
					lSalesandBusinessList.add(objProfitAndLossBeanTemp);

				}
				if (!lSalesandBusinessList.isEmpty()) {
					lIndirectExpensesList.addAll(lSalesandBusinessList);
				}
			} else if (((hmRow.getKey()).startsWith("5003"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dPersonalCost += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(-objAhlist.getAmount());
					lPersonalCostList.add(objProfitAndLossBeanTemp);

				}
				if (!lPersonalCostList.isEmpty()) {
					lIndirectExpensesList.addAll(lPersonalCostList);
				}
			} else if (((hmRow.getKey()).startsWith("5004"))) {
				ProfitAndLossBean objCostOfSales = hmRow.getValue();
				dFinanceCost += objCostOfSales.getGroupAmount();

				List<ProfitAndLossBean> lAhlist = objCostOfSales.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					lFinanceList.add(objProfitAndLossBeanTemp);
				}
				if (!lFinanceList.isEmpty()) {

					lIndirectExpensesList.addAll(lFinanceList);
				}

			} else if (((hmRow.getKey()).startsWith("5005"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dCommunctionExpense += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(-objAhlist.getAmount());
					lCommuncationCostList.add(objProfitAndLossBeanTemp);

				}
				if (!lCommuncationCostList.isEmpty()) {
					lIndirectExpensesList.addAll(lCommuncationCostList);
				}
			} else {
				if (((hmRow.getKey()).startsWith("5006"))) {
					ProfitAndLossBean objCostOfSales = hmRow.getValue();
					dAdminExpense += objCostOfSales.getGroupAmount();

					List<ProfitAndLossBean> lAhlist = objCostOfSales.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
						String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

						objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
						objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
						objProfitAndLossBeanTemp.setAmount(-objAhlist.getAmount());
						lAdministartiveExpensesList.add(objProfitAndLossBeanTemp);

					}
					if (!lAdministartiveExpensesList.isEmpty()) {
						lIndirectExpensesList.addAll(lAdministartiveExpensesList);
					}
				} else if (((hmRow.getKey()).startsWith("5008"))) {
					ProfitAndLossBean objCostOfSales = hmRow.getValue();
					dRentCost += objCostOfSales.getGroupAmount();

					List<ProfitAndLossBean> lAhlist = objCostOfSales.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
						String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

						objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
						objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
						objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
						lRentCostList.add(objProfitAndLossBeanTemp);

					}
					if (!lRentCostList.isEmpty()) {
						lIndirectExpensesList.addAll(lRentCostList);
					}
				} else if (((hmRow.getKey()).startsWith("5007"))) {
					ProfitAndLossBean objCostOfSales = hmRow.getValue();
					dconveyencecost += objCostOfSales.getGroupAmount();

					List<ProfitAndLossBean> lAhlist = objCostOfSales.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
						String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

						objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
						objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
						objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
						lConveyenceCostList.add(objProfitAndLossBeanTemp);

					}
					if (!lConveyenceCostList.isEmpty()) {
						lIndirectExpensesList.addAll(lConveyenceCostList);
					}
				}

			}

		}

		Collections.sort(lSalesRevenueList, new Comparator<ProfitAndLossBean>() {
			@Override
			public int compare(final ProfitAndLossBean object1, final ProfitAndLossBean object2) {
				return object1.getAccountHead().toLowerCase().compareTo(object2.getAccountHead().toLowerCase());
			}
		});
		objProfitLossResultBean.setlSalesRevenue(lSalesRevenueList);
		objProfitLossResultBean.setlOtherIncome(dOtherIncomeList);
		objProfitLossResultBean.setdOtherIncome(dOtherIncome);
		objProfitLossResultBean.setdSalesRevenueTotal(dSalesRevenueTotal);
		objProfitLossResultBean.setdAdminExpense(dAdminExpense);
		objProfitLossResultBean.setlAdminExpense(lAdministartiveExpensesList);
		objProfitLossResultBean.setlFinanceCost(lFinanceList); // for 5004
		objProfitLossResultBean.setdFinanceCost(-dFinanceCost);
		List<ProfitAndLossBean> lCostOfSalesListNew = new ArrayList<>();
		Collections.sort(lCostOfSalesList, new Comparator<ProfitAndLossBean>() {
			@Override
			public int compare(final ProfitAndLossBean object1, final ProfitAndLossBean object2) {
				return object1.getAccountHead().toLowerCase().compareTo(object2.getAccountHead().toLowerCase());
			}
		});
		objProfitLossResultBean.setlCostOfSales(lCostOfSalesList);
		objProfitLossResultBean.setlTravellingCostList(lTravellingCostList); // for
		objProfitLossResultBean.setlOtherIncome(lOtherIncome); // 5001
		objProfitLossResultBean.setdTravellingCost(dTravellingCost);
		objProfitLossResultBean.setlSalesandBusinessList(lSalesandBusinessList); // for
																					// 5002
		objProfitLossResultBean.setdSalesandBuss(dSalesandBuss);
		objProfitLossResultBean.setlPersonalCostList(lPersonalCostList); // for
																			// 5003
		objProfitLossResultBean.setdPersonalCost(dPersonalCost);
		objProfitLossResultBean.setlCommuncationCostList(lCommuncationCostList); // for
																					// 5005
		objProfitLossResultBean.setdCommunctionExpense(dCommunctionExpense);
		objProfitLossResultBean.setdCostOfSalesTotal(-dCostOfSales);
		objProfitLossResultBean.setlRentCostList(lRentCostList); // for 5005
		objProfitLossResultBean.setdRentCost(dRentCost);
		objProfitLossResultBean.setdOtherExpense(-dOtherExpense);
		objProfitLossResultBean.setlIndirectExpensesList(lIndirectExpensesList);
		objProfitLossResultBean.setlConveyenceCostList(lConveyenceCostList);
		objProfitLossResultBean.setDconveyencecost(dconveyencecost);
		return objProfitLossResultBean;
	}

	@Override
	public boolean exportPLExcel(String sFilePath, ProfitAndLossBean objProfitAndLossBean) {

		boolean isSuccess =false;
		Map<String, ProfitAndLossBean> hmProfitLossMap = objProfitAndLossDao.getProfitLossReportList(objProfitAndLossBean);
		try {
			// Blank workbook
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCellStyle my_style = workbook.createCellStyle();
			my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			HSSFCellStyle my_style1 = workbook.createCellStyle();
			my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_LEFT);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			HSSFCellStyle my_style2 = workbook.createCellStyle();
			my_style2.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style2.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style2.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style2.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style2.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style2.setAlignment(my_style.ALIGN_RIGHT);
			my_style2.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style2.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font2 = workbook.createFont();
			font2.setFontHeight((short) 200);
			font2.setFontName("Arial");
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font2.setFontHeightInPoints((short) 10);
			my_style2.setFont(font2);

			HSSFCellStyle my_style3 = workbook.createCellStyle();
			my_style3.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style3.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style3.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style3.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style3.setAlignment(my_style.ALIGN_CENTER);
			my_style3.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style3.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font3 = workbook.createFont();
			font3.setFontHeight((short) 200);
			font3.setFontName("Arial");
			font3.setColor(HSSFColor.BLACK.index);
			font3.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font3.setFontHeightInPoints((short) 10);
			my_style3.setFont(font3);

			HSSFCellStyle my_style4 = workbook.createCellStyle();
			my_style4.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style4.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style4.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style4.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style4.setAlignment(my_style.ALIGN_LEFT);
			my_style4.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style4.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style4.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font4 = workbook.createFont();
			font4.setFontHeight((short) 200);
			font4.setFontName("Arial");
			font4.setColor(HSSFColor.BLACK.index);
			// font4.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font4.setFontHeightInPoints((short) 10);
			my_style4.setFont(font4);

			HSSFCellStyle my_style5 = workbook.createCellStyle();
			my_style5.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setAlignment(my_style.ALIGN_RIGHT);
			my_style5.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style5.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style5.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font5 = workbook.createFont();
			font5.setFontHeight((short) 200);
			font5.setFontName("Arial");
			font5.setColor(HSSFColor.BLACK.index);
			// font5.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font5.setFontHeightInPoints((short) 10);
			my_style5.setFont(font5);

			HSSFCellStyle my_style6 = workbook.createCellStyle();
			my_style6.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style6.setAlignment(my_style.ALIGN_RIGHT);
			my_style6.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style6.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style6.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font6 = workbook.createFont();
			font6.setFontHeight((short) 200);
			font6.setFontName("Arial");
			font6.setColor(HSSFColor.BLACK.index);
			font6.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font6.setFontHeightInPoints((short) 10);
			my_style6.setFont(font6);

			HSSFCellStyle my_style7 = workbook.createCellStyle();
			my_style7.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style7.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style7.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style7.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style7.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style7.setAlignment(my_style.ALIGN_LEFT);
			my_style7.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style7.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style7.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font7 = workbook.createFont();
			font7.setFontHeight((short) 200);
			font7.setFontName("Arial");
			font7.setColor(HSSFColor.BLACK.index);
			font7.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);

			font7.setFontHeightInPoints((short) 10);
			my_style7.setFont(font7);
			
		

			/*HSSFCellStyle my_style8 = workbook.createCellStyle();
			my_style6.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style6.setAlignment(my_style.ALIGN_LEFT);
			my_style6.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style6.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style6.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			Font font6 = workbook.createFont();
			font6.setFontHeight((short) 200);
			font6.setFontName("Arial");
			font6.setColor(HSSFColor.BLACK.index);
			font6.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font6.setFontHeightInPoints((short) 10);
			my_style6.setFont(font6);*/
			
			
			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Income and Expenditure");

			// set main header
			setExcelMainHeader(excelSheet, my_style, objProfitAndLossBean);

			// set header
			// setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, hmProfitLossMap, my_style, my_style1, my_style2, my_style3, my_style4, my_style5, my_style6, my_style7);

			for (int i = 0; i < 7; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);
			//String sFileUrl = writeExcelSubLedger(workbook, exportFilesPath);

			if (hmProfitLossMap.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return isSuccess;
	}

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style, ProfitAndLossBean objProfitAndLossBean) {
		
		
		
	/*	Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 3));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Income and Expenditure -" + objProfitAndLossBean.getCompanyName() + "");
		cell.setCellStyle(my_style);
		*/
		
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
		Cell cell1= row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		
		Row row2 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 3));
		Cell cell2= row2.createCell((short) 0);
		cell2.setCellValue(objProfitAndLossBean.getFromDate() + " TO " +objProfitAndLossBean.getToDate());   
		cell2.setCellStyle(my_style);
		
		Row row3 = excelSheet.createRow((short) 3);
		excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 3));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue("Income and Expenditure");
		cell3.setCellStyle(my_style);
	
		System.out.println("TEST"+objProfitAndLossBean.getFromDate());
		
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 3);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Group Head");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Sub Group Account");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Account head");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Debit");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Credit");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(HSSFSheet excelSheet, Map<String, ProfitAndLossBean> hmProfitLossMap, HSSFCellStyle my_style, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3, HSSFCellStyle my_style4, HSSFCellStyle my_style5, HSSFCellStyle my_style6, HSSFCellStyle my_style7) {
		int record = 4, sno = 1;
		int firstRow = 0, firstSgRow = 0, firstAhRow = 0;
		int lastRow = 0;
		try {

			Iterator<Entry<String, ProfitAndLossBean>> it = hmProfitLossMap.entrySet().iterator();

			// Row 2 Empty row
			Row row2 = excelSheet.createRow((short) 6);
			row2.setHeight((short) 350);

			// Row 3
			Row row3 = excelSheet.createRow((short) 7);
			row3.setHeight((short) 350);
			Cell cell30 = row3.createCell(0);
			cell30.setCellStyle(my_style);
			cell30.setCellValue("Particulars");
			Cell cell31 = row3.createCell(1);
			cell31.setCellStyle(my_style);
			cell31.setCellValue("Amount(INR)");
//			Cell cell32 = row3.createCell(2);
//			cell32.setCellStyle(my_style);
//			cell32.setCellValue("Particulars");
//			Cell cell33 = row3.createCell(3);
//			cell33.setCellStyle(my_style);
//			cell33.setCellValue("Amount(INR)");

			// Row 4 Empty row
			Row row4 = excelSheet.createRow((short) 8);
			row4.setHeight((short) 350);

			// Row for Sales (Revenue) - ( A )
			Row row5 = excelSheet.createRow((short) 9);
			row5.setHeight((short) 350);

			Cell cell50 = row5.createCell(0);
			cell50.setCellStyle(my_style3);
			cell50.setCellValue("INCOME ");

		/*	Cell cell51 = row5.createCell(1);
			cell51.setCellStyle(my_style2);
*/
			int counter = 10;

			it = hmProfitLossMap.entrySet().iterator();

			double dSalesRevenueTotal = 0.0, dCostOfSales = 0.0;
			List<ProfitAndLossBean> totalList1 = new ArrayList<>();
			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());
				if ((hmRow.getKey()).startsWith("3000")||(hmRow.getKey()).startsWith("3001")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dSalesRevenueTotal += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					totalList1.addAll(lAhlist);
					//System.out.println("3000 & 3001 " + totalList1.size());
				}
			}
			Collections.sort(totalList1, new Comparator<ProfitAndLossBean>() {
				@Override
				public int compare(final ProfitAndLossBean object1, final ProfitAndLossBean object2) {
					return object1.getAccountHeadName().toLowerCase().compareTo(object2.getAccountHeadName().toLowerCase());
				}
			});

			for (ProfitAndLossBean objAhlist : totalList1) {
				//System.out.println("counter :"+counter);
				Row rowAH = excelSheet.createRow((short) counter++);
				rowAH.setHeight((short) 350);
				String sAcctCodeName = objAhlist.getAccountHeadName();

				Cell cellAH0 = rowAH.createCell(0);
				cellAH0.setCellStyle(my_style4);
				cellAH0.setCellValue(sAcctCodeName);

				Cell cellAH1 = rowAH.createCell(1);
				cellAH1.setCellStyle(my_style5);
				cellAH1.setCellValue(objAhlist.getAmount());
			}
		//	cell51.setCellValue(dSalesRevenueTotal);

			// Row 6 Empty row
			/*
			 * Row row6 = excelSheet.createRow((short) counter++);
			 * row6.setHeight((short) 350);
			 */
			int conter = 9;
			// Row for Cost of Sales - ( B )
			/*
			 * Row row7 = excelSheet.createRow((short) conter++);
			 * row7.setHeight((short) 350);
			 */

			/*
			 * Row row7 = excelSheet.createRow((short) 5);
			 * row7.setHeight((short) 350);
			 */

		/*	Cell cell70 = row5.createCell(2);
			cell70.setCellStyle(my_style3);
			cell70.setCellValue("Direct Expenses - ( B )");

			Cell cell71 = row5.createCell(3);
			cell71.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();
			List<ProfitAndLossBean> totalList = new ArrayList<>();
			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());
				if ((hmRow.getKey()).startsWith("4000")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dCostOfSales += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					totalList.addAll(lAhlist);
					System.out.println("600 " + totalList.size());
				}
			}
			Collections.sort(totalList, new Comparator<ProfitAndLossBean>() {
				@Override
				public int compare(final ProfitAndLossBean object1, final ProfitAndLossBean object2) {
					return object1.getAccountHeadName().toLowerCase().compareTo(object2.getAccountHeadName().toLowerCase());
				}
			});
			for (ProfitAndLossBean objAhlist : totalList) {
				Row rowAH = excelSheet.getRow((short) conter++);

				if (rowAH == null) {
					rowAH = excelSheet.createRow((short) conter++);
				}
				rowAH.setHeight((short) 350);
				String sAcctCodeName = objAhlist.getAccountHeadName();

				Cell cellAH0 = rowAH.createCell(2);
				cellAH0.setCellStyle(my_style4);
				cellAH0.setCellValue(sAcctCodeName);

				Cell cellAH1 = rowAH.createCell(3);
				cellAH1.setCellStyle(my_style5);
				cellAH1.setCellValue(-objAhlist.getAmount());
			}

			// ///////
			cell71.setCellValue(dCostOfSales);*/

			// Row 8 Empty row
			
			Row row8 = excelSheet.createRow((short) counter++);
			row8.setHeight((short) 350);

			// Total row for non - current asset

			Row row9 = excelSheet.createRow((short) counter++);
			row9.setHeight((short) 350);

			Row row77 = excelSheet.getRow((short) counter - 2);
			// dCostOfSales= 390000000;

			if (dSalesRevenueTotal > dCostOfSales) {
				Cell cell90 = row9.createCell(0);
				cell90.setCellStyle(my_style1);
				cell90.setCellValue("Total(A)");

				Cell cell91 = row9.createCell(1);
				cell91.setCellStyle(my_style5);
				cell91.setCellValue(dSalesRevenueTotal);

				/*Cell cell92 = row77.createCell(2);
				cell92.setCellStyle(my_style);
				cell92.setCellValue("Gross Profit c/o");

				Cell cell93 = row77.createCell(3);
				cell93.setCellStyle(my_style);
				cell93.setCellValue(dSalesRevenueTotal + dCostOfSales);*/
			}

			else {

			/*	Row row79 = excelSheet.getRow((short) counter - 2);
				Cell cell92 = row79.createCell(0);
				cell92.setCellStyle(my_style);
				cell92.setCellValue("Gross Profit b/f ");

				Cell cell93 = row79.createCell(1);
				cell93.setCellStyle(my_style);
				cell93.setCellValue(dSalesRevenueTotal + dCostOfSales);*/

				Cell cell90 = row9.createCell(2);
				cell90.setCellStyle(my_style4);
				cell90.setCellValue("");

				Cell cell91 = row9.createCell(3);
				cell91.setCellStyle(my_style4);
				cell91.setCellValue(dCostOfSales);

			}

			Row row29 = excelSheet.createRow((short) counter++);
			row29.setHeight((short) 350);

			if (dSalesRevenueTotal > dCostOfSales) {/*
				Cell cell900 = row29.createCell(0);
				cell900.setCellStyle(my_style);
				cell900.setCellValue("Gross Profit b/f");

				Cell cell901 = row29.createCell(1);
				cell901.setCellStyle(my_style);
				cell901.setCellValue(dSalesRevenueTotal + dCostOfSales);

				Row row737 = excelSheet.getRow((short) counter - 2);

				double tot = dSalesRevenueTotal - dCostOfSales;
				Cell cell905 = row737.createCell(2);
				cell905.setCellStyle(my_style4);
				cell905.setCellValue("");

				Cell cell906 = row737.createCell(3);
				cell906.setCellStyle(my_style4);
				cell906.setCellValue(dSalesRevenueTotal);
			*/} else {/*

				Row row739 = excelSheet.getRow((short) counter - 2);
				double tot = dSalesRevenueTotal - dCostOfSales;
				Cell cell905 = row739.createCell(0);
				cell905.setCellStyle(my_style4);
				cell905.setCellValue("");

				Cell cell906 = row739.createCell(1);
				cell906.setCellStyle(my_style4);
				cell906.setCellValue(dCostOfSales);

				Cell cell900 = row29.createCell(2);
				cell900.setCellStyle(my_style);
				cell900.setCellValue("Gross Profit c/o");

				Cell cell901 = row29.createCell(3);
				cell901.setCellStyle(my_style);
				cell901.setCellValue(dSalesRevenueTotal + dCostOfSales);

			*/}

			/*
			 * Row roww10 = excelSheet.createRow((short) counter++);
			 * roww10.setHeight((short) 350); double greatestValue= 0;
			 * if(dSalesRevenueTotal>dCostOfSales){
			 * 
			 * greatestValue = dSalesRevenueTotal; } else{ greatestValue =
			 * dCostOfSales; }
			 * 
			 * 
			 * Cell cell988 = roww10.createCell(0);
			 * cell988.setCellStyle(my_style4); cell988.setCellValue("");
			 * 
			 * Cell cell98 = roww10.createCell(1);
			 * cell98.setCellStyle(my_style4);
			 * cell98.setCellValue(greatestValue);
			 * 
			 * Cell cell97 = roww10.createCell(2);
			 * cell97.setCellStyle(my_style4); cell97.setCellValue("");
			 * 
			 * Cell cell977 = roww10.createCell(3);
			 * cell977.setCellStyle(my_style4);
			 * cell977.setCellValue(greatestValue);
			 */

			// Row 10 Empty row
			Row row10 = excelSheet.createRow((short) counter++);
			row10.setHeight((short) 350);

			// Row for Other Income - D
			Row row11 = excelSheet.createRow((short) counter++);
			row11.setHeight((short) 350);

			Cell celll1 = row11.createCell(0);
			celll1.setCellStyle(my_style3);
			celll1.setCellValue("EXPENSES ");
/*
			Cell cell111 = row11.createCell(1);
			cell111.setCellStyle(my_style2);*/

			/*Cell cell110 = row11.createCell(2);
			cell110.setCellStyle(my_style3);
			cell110.setCellValue("Indirect Expenses - ( D )");*/

//			Cell cell11 = row11.createCell(3);
//			cell11.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();
			double dOtherIncome = 0.0, dAdminExpense = 0.0, dotherExpense = 0.0, dFinanceCost = 0.0, dTravellingCost = 0.0, dsalesCost = 0.0, dCommunicationCost = 0.0, dRentCost = 0.0;

			double dconveyencecost = 0.0, ddisputedcost = 0.0;

			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("4000")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dOtherIncome += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			}
			
		
			
			//System.out.println("total b "+dOtherIncome);
			//cell111.setCellValue(dOtherIncome);
			
			Row rowtotalB = excelSheet.createRow((short) counter++);
			rowtotalB.setHeight((short) 350);
			
		

			// Total row for non - current asset

			Row rowtotalBb = excelSheet.createRow((short) counter++);
			rowtotalBb.setHeight((short) 350);

			Row rowsd = excelSheet.getRow((short) counter - 3);

			Cell cellTotalB = rowtotalBb.createCell(0);
			cellTotalB.setCellStyle(my_style1);
			cellTotalB.setCellValue("Total(B)");
			Cell cellTotalB1 = rowtotalBb.createCell(1);
			cellTotalB1.setCellStyle(my_style5);
			cellTotalB1.setCellValue(dOtherIncome);
			
//			 Balance Block 
			

			Row rowtotBalanceBlock = excelSheet.createRow((short) counter++);
			rowtotBalanceBlock.setHeight((short) 350);

			Cell cellbal1 = rowtotBalanceBlock.createCell(0);
			cellbal1.setCellStyle(my_style4);
			cellbal1.setCellValue("BELANCE BEING EXCESS  OF INCOME OVER EXPENDITURE(A-B)");
			Cell cellbal2 = rowtotBalanceBlock.createCell(1);
			cellbal2.setCellStyle(my_style5);
			cellbal2.setCellValue(dSalesRevenueTotal - dOtherIncome);

			Row rowtotBalanceBlock1 = excelSheet.createRow((short) counter++);
			rowtotBalanceBlock1.setHeight((short) 350);
			Cell cellbal_1 = rowtotBalanceBlock1.createCell(0);
			cellbal_1.setCellStyle(my_style4);
			cellbal_1.setCellValue("BALANCE TRANSFERRED TO/FROM CAPITAL FUND/RESERVES SURPLUS");
			Cell cellbal_2 = rowtotBalanceBlock1.createCell(1);
			cellbal_2.setCellStyle(my_style5);
			cellbal_2.setCellValue(dSalesRevenueTotal - dOtherIncome);
			
//			END
			
			
			
			
			
			
			// cell161.setCellValue(dFinanceCost);
			/*Row rowCountTotalB = excelSheet.createRow((short) (counter++)+2);
			rowCountTotalB.setHeight((short) 350);
			
			Cell cell90 = rowCountTotalB.createCell(0);
			cell90.setCellStyle(my_style4);
			cell90.setCellValue("Total(B)");

			Cell cell91 = rowCountTotalB.createCell(1);
			cell91.setCellStyle(my_style4);
			cell91.setCellValue(dOtherIncome);*/
			
			// Travelling Cost
			Row row20 = excelSheet.createRow((short) counter++);
			row20.setHeight((short) 350);
			/*
			 * Cell cell163 = row20.createCell(0);
			 * cell163.setCellStyle(my_style3);
			 * cell163.setCellValue("Travelling Cost - H");
			 * 
			 * Cell cell164 = row20.createCell(1);
			 * cell164.setCellStyle(my_style2);
			 */
			it = hmProfitLossMap.entrySet().iterator();

			//while (it.hasNext()) {
				/*
			}
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5001")) {
					counter = counter - 1;
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dTravellingCost += objVesselEquipBean.getGroupAmount();
					Row rowAH1 = excelSheet.createRow((short) counter++);
					rowAH1.setHeight((short) 350);

					Cell cellAH01 = rowAH1.createCell(2);
					cellAH01.setCellStyle(my_style7);
					cellAH01.setCellValue("Travelling Cost");

					Cell cellAH12 = rowAH1.createCell(3);
					cellAH12.setCellStyle(my_style6);
					cellAH12.setCellValue(dTravellingCost);
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(2);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(3);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			*/
				//}

			// cell131.setCellValue(dAdminExpense);

			// Sales & Buisness Cost
			Row row21 = excelSheet.createRow((short) counter++);
			row21.setHeight((short) 350);

			/*
			 * Cell cell165 = row21.createCell(0);
			 * cell165.setCellStyle(my_style3);
			 * cell165.setCellValue("Sales & Buisness Cost - I");
			 * 
			 * Cell cell166 = row21.createCell(1);
			 * cell166.setCellStyle(my_style2);
			 */
			it = hmProfitLossMap.entrySet().iterator();

			//while (it.hasNext()) {
				/*
			}
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5002")) {
					counter = counter - 1;
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dsalesCost += objVesselEquipBean.getGroupAmount();
					Row rowAH1 = excelSheet.createRow((short) counter++);
					rowAH1.setHeight((short) 350);

					Cell cellAH01 = rowAH1.createCell(2);
					cellAH01.setCellStyle(my_style7);
					cellAH01.setCellValue("Sales & Business Cost");

					Cell cellAH12 = rowAH1.createCell(3);
					cellAH12.setCellStyle(my_style6);
					cellAH12.setCellValue(dsalesCost);
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(2);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(3);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			*/
				//}
			// cell166.setCellValue(dsalesCost);
			// Empty row
			Row row14 = excelSheet.createRow((short) counter++);
			row14.setHeight((short) 350);

			Row row15 = excelSheet.createRow((short) counter++);
			row15.setHeight((short) 350);

			/*
			 * Cell cell150 = row15.createCell(0);
			 * cell150.setCellStyle(my_style3);
			 * cell150.setCellValue("Personal Cost - F");
			 * 
			 * Cell cell151 = row15.createCell(1);
			 * cell151.setCellStyle(my_style2);
			 */

			it = hmProfitLossMap.entrySet().iterator();

		//	while (it.hasNext()) {
				
				/*
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5003")) {
					counter = counter - 2;
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dotherExpense += objVesselEquipBean.getGroupAmount();
					Row rowAH1 = excelSheet.createRow((short) counter++);
					rowAH1.setHeight((short) 350);

					Cell cellAH01 = rowAH1.createCell(2);
					cellAH01.setCellStyle(my_style7);
					cellAH01.setCellValue("Personal Cost");

					Cell cellAH12 = rowAH1.createCell(3);
					cellAH12.setCellStyle(my_style6);
					cellAH12.setCellValue(dotherExpense);
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(2);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(3);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}
				}

			*/
			//}

			// cell151.setCellValue(dotherExpense);

			Row rowempty = excelSheet.createRow((short) counter++);
			rowempty.setHeight((short) 350);

			// Finance Costs - G

			Row row16 = excelSheet.createRow((short) counter++);
			row16.setHeight((short) 350);

			/*
			 * Cell cell160 = row16.createCell(0);
			 * cell160.setCellStyle(my_style3);
			 * cell160.setCellValue("Finance Costs - G");
			 * 
			 * Cell cell161 = row16.createCell(1);
			 * cell161.setCellStyle(my_style2);
			 */

			it = hmProfitLossMap.entrySet().iterator();

			//while (it.hasNext()) {
				/*
			}
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5004")) {
					counter = counter - 2;
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dFinanceCost += objVesselEquipBean.getGroupAmount();
					Row rowAH1 = excelSheet.createRow((short) counter++);
					rowAH1.setHeight((short) 350);

					Cell cellAH01 = rowAH1.createCell(2);
					cellAH01.setCellStyle(my_style7);
					cellAH01.setCellValue("Finance Costs");

					Cell cellAH12 = rowAH1.createCell(3);
					cellAH12.setCellStyle(my_style6);
					cellAH12.setCellValue(dFinanceCost);
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(2);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(3);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			*/
				//}

			// cell164.setCellValue(dTravellingCost);

			// Communication Cost
			Row row22 = excelSheet.createRow((short) counter++);
			row22.setHeight((short) 350);
			/*
			 * Cell cell167 = row22.createCell(0);
			 * cell167.setCellStyle(my_style3);
			 * cell167.setCellValue("Communication Cost - J");
			 * 
			 * Cell cell168 = row22.createCell(1);
			 * cell168.setCellStyle(my_style2);
			 */

			it = hmProfitLossMap.entrySet().iterator();

			//while (it.hasNext()) {
				
				/*
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5005")) {
					counter = counter - 1;
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dCommunicationCost += objVesselEquipBean.getGroupAmount();
					Row rowAH1 = excelSheet.createRow((short) counter++);
					rowAH1.setHeight((short) 350);

					Cell cellAH01 = rowAH1.createCell(2);
					cellAH01.setCellStyle(my_style7);
					cellAH01.setCellValue("Communication Cost");

					Cell cellAH12 = rowAH1.createCell(3);
					cellAH12.setCellStyle(my_style6);
					cellAH12.setCellValue(dCommunicationCost);
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(2);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(3);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			*/
			//}

			// Row 12 Empty row
			Row row12 = excelSheet.createRow((short) counter++);
			row12.setHeight((short) 350);

			// Row for Administrative Expenses - E
			Row row13 = excelSheet.createRow((short) counter++);
			row13.setHeight((short) 350);

			/*
			 * Cell cell130 = row13.createCell(0);
			 * cell130.setCellStyle(my_style3);
			 * cell130.setCellValue("Administrative Cost - E");
			 * 
			 * Cell cell131 = row13.createCell(1);
			 * cell131.setCellStyle(my_style2);
			 */
			it = hmProfitLossMap.entrySet().iterator();

			//while (it.hasNext()) {
				
				/*
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5006")) {
					counter = counter - 2;
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dAdminExpense += objVesselEquipBean.getGroupAmount();
					Row rowAH1 = excelSheet.createRow((short) counter++);
					rowAH1.setHeight((short) 350);

					Cell cellAH01 = rowAH1.createCell(2);
					cellAH01.setCellStyle(my_style7);
					cellAH01.setCellValue("Administrative Cost");

					Cell cellAH12 = rowAH1.createCell(3);
					cellAH12.setCellStyle(my_style6);
					cellAH12.setCellValue(dAdminExpense);
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(2);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(3);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			*/
			//}
			// cell168.setCellValue(dCommunicationCost);

			// Rent Cost
			Row row23 = excelSheet.createRow((short) counter++);
			row23.setHeight((short) 350);

			/*
			 * Cell cell169 = row23.createCell(0);
			 * cell169.setCellStyle(my_style3);
			 * cell169.setCellValue("Rent Cost - K");
			 * 
			 * Cell cell170 = row23.createCell(1);
			 * cell170.setCellStyle(my_style2);
			 */

			it = hmProfitLossMap.entrySet().iterator();

			//while (it.hasNext()) {
				/*
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5007")) {
					counter = counter - 1;
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dconveyencecost += objVesselEquipBean.getGroupAmount();
					Row rowAH1 = excelSheet.createRow((short) counter++);
					rowAH1.setHeight((short) 350);

					Cell cellAH01 = rowAH1.createCell(2);
					cellAH01.setCellStyle(my_style7);
					cellAH01.setCellValue("Conveyance Cost");

					Cell cellAH12 = rowAH1.createCell(3);
					cellAH12.setCellStyle(my_style6);
					cellAH12.setCellValue(dconveyencecost);
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(2);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(3);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			*/
			//}

			Row row24 = excelSheet.createRow((short) counter++);
			row23.setHeight((short) 350);

			/*
			 * Cell cell169 = row23.createCell(0);
			 * cell169.setCellStyle(my_style3);
			 * cell169.setCellValue("Rent Cost - K");
			 * 
			 * Cell cell170 = row23.createCell(1);
			 * cell170.setCellStyle(my_style2);
			 */

			it = hmProfitLossMap.entrySet().iterator();

			//while (it.hasNext()) {
				/*
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5008")) {
					counter = counter - 1;
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dRentCost += objVesselEquipBean.getGroupAmount();
					Row rowAH1 = excelSheet.createRow((short) counter++);
					rowAH1.setHeight((short) 350);

					Cell cellAH01 = rowAH1.createCell(2);
					cellAH01.setCellStyle(my_style7);
					cellAH01.setCellValue("Rent Cost");

					Cell cellAH12 = rowAH1.createCell(3);
					cellAH12.setCellStyle(my_style6);
					cellAH12.setCellValue(dRentCost);
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(2);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(3);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			*///}
			it = hmProfitLossMap.entrySet().iterator();
			/*
			 * while (it.hasNext()) {
			 * 
			 * @SuppressWarnings("unchecked") Map.Entry<String,
			 * ProfitAndLossBean> hmRow = it.next();
			 * System.out.println(hmRow.getKey() + " = " + hmRow.getValue());
			 * 
			 * if ((hmRow.getKey()).startsWith("2002")) { counter = counter - 1;
			 * ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
			 * ddisputedcost += objVesselEquipBean.getGroupAmount(); Row rowAH1
			 * = excelSheet.createRow((short) counter++);
			 * rowAH1.setHeight((short) 350);
			 * 
			 * Cell cellAH01 = rowAH1.createCell(2);
			 * cellAH01.setCellStyle(my_style7);
			 * cellAH01.setCellValue("Disputed Revenue Cost");
			 * 
			 * Cell cellAH12 = rowAH1.createCell(3);
			 * cellAH12.setCellStyle(my_style6);
			 * cellAH12.setCellValue(ddisputedcost); List<ProfitAndLossBean>
			 * lAhlist = objVesselEquipBean.getlAccountHeadLevelList(); for
			 * (ProfitAndLossBean objAhlist : lAhlist) { Row rowAH =
			 * excelSheet.createRow((short) counter++); rowAH.setHeight((short)
			 * 350); String sAcctCodeName = objAhlist.getAccountHeadName();
			 * 
			 * Cell cellAH0 = rowAH.createCell(2);
			 * cellAH0.setCellStyle(my_style4);
			 * cellAH0.setCellValue(sAcctCodeName);
			 * 
			 * Cell cellAH1 = rowAH.createCell(3);
			 * cellAH1.setCellStyle(my_style5);
			 * cellAH1.setCellValue(objAhlist.getAmount()); }
			 * 
			 * }
			 * 
			 * }
			 */
			// cell170.setCellValue(dRentCost);

			Row row177 = excelSheet.createRow((short) counter++);
			row177 = excelSheet.createRow((short) counter++);
			row177.setHeight((short) 350);
			Double amoount = dAdminExpense + dotherExpense + dTravellingCost + dCommunicationCost + dRentCost + dconveyencecost + dsalesCost + dFinanceCost + ddisputedcost;
			double ntloss = 0.00;
			double totl = 0.00;
			double ntprof = 0.00;
			double amount = Math.abs(amoount);
			totl = dOtherIncome + dSalesRevenueTotal + dCostOfSales;
			double totlAmt = Math.abs(totl);
			// dOtherIncome = 390000000;
			if (totlAmt > amount) {
				/*totl = dSalesRevenueTotal + dCostOfSales;

				Cell cell180 = row177.createCell(0);
				cell180.setCellStyle(my_style4);
//				cell180.setCellValue("Excess of income over expenditure");

				Cell cell181 = row177.createCell(1);
				cell181.setCellStyle(my_style4);
				double val = Math.abs(amount - (totl + dOtherIncome));
				cell181.setCellValue(val);
				ntloss = amount - (totl + dOtherIncome);*/

			} else {/*

				totl = dSalesRevenueTotal + dCostOfSales;

				Cell cell180 = row177.createCell(0);
				cell180.setCellStyle(my_style4);
				cell180.setCellValue("Excess of expenditure over income");

				Cell cell181 = row177.createCell(1);
				cell181.setCellStyle(my_style4);
				double val = Math.abs(amount - (totl + dOtherIncome));
				cell181.setCellValue(val);
				ntloss = amount - (totl + dOtherIncome);
			*/}

			// Empty row
			Row row17 = excelSheet.createRow((short) counter++);
			row17.setHeight((short) 350);
			Double amoountt = dAdminExpense + dotherExpense + dTravellingCost + dCommunicationCost + dRentCost + dconveyencecost + dsalesCost + dFinanceCost + ddisputedcost;
			double amountt = Math.abs(amoountt);
			if (amount > dOtherIncome) {/*
				Row row18 = excelSheet.createRow((short) counter++);
				int val = counter - 1;
				row18.setHeight((short) 350);
				// excelSheet.addMergedRegion(new CellRangeAddress(val,val, 0,
				// 2));
				Cell cell180 = row18.createCell(0);
				cell180.setCellStyle(my_style);
				cell180.setCellValue("Total ");

				
				 * Row row = excelSheet.createRow((short) 0);
				 * excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 3));
				 * Cell cell = row.createCell((short) 0);
				 * cell.setCellValue("Income and Expenditure");
				 * cell.setCellStyle(my_style);
				 

				amoountt = dAdminExpense + dotherExpense + dTravellingCost + dCommunicationCost + dRentCost + dconveyencecost + dsalesCost + dFinanceCost + ddisputedcost;

//				System.out.println(amoountt);
//				amountt = Math.abs(amoountt);
//				cell11.setCellValue(amountt);

				Cell cell181 = row18.createCell(1);
				cell181.setCellStyle(my_style);
				cell181.setCellValue(amountt);

				Cell cell182 = row18.createCell(2);
				cell182.setCellStyle(my_style);
				cell182.setCellValue("Total ");

				Cell cell183 = row18.createCell(3);
				amoountt = dAdminExpense + dotherExpense + dTravellingCost + dCommunicationCost + dRentCost + dconveyencecost + dsalesCost + dFinanceCost + ddisputedcost;

				System.out.println(amoountt);
				amountt = Math.abs(amoountt);
				cell183.setCellStyle(my_style);
				cell183.setCellValue(amountt);
			*/}

			else {/*

				Row row18 = excelSheet.createRow((short) counter++);
				int val = counter - 1;
				row18.setHeight((short) 350);
				// excelSheet.addMergedRegion(new CellRangeAddress(val,val, 0,
				// 2));
				Cell cell180 = row18.createCell(0);
				cell180.setCellStyle(my_style);
				cell180.setCellValue("Total ");

				
				 * Row row = excelSheet.createRow((short) 0);
				 * excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 3));
				 * Cell cell = row.createCell((short) 0);
				 * cell.setCellValue("Income and Expenditure");
				 * cell.setCellStyle(my_style);
				 

				amoountt = dAdminExpense + dotherExpense + dTravellingCost + dCommunicationCost + dRentCost + dconveyencecost + dsalesCost + dFinanceCost + ddisputedcost;

//				System.out.println(amoountt);
//				amountt = Math.abs(amoountt);
//				cell11.setCellValue(amountt);

				Cell cell181 = row18.createCell(1);
				cell181.setCellStyle(my_style);
				cell181.setCellValue(dOtherIncome);

				Cell cell182 = row18.createCell(2);
				cell182.setCellStyle(my_style);
				cell182.setCellValue("Total ");

				Cell cell183 = row18.createCell(3);
				cell183.setCellStyle(my_style);
				cell183.setCellValue(dOtherIncome);

			*/}
			// ////
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/Income and Expenditure.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filepath" + sOutFile);
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/Income and Expenditure.xls";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return url;
	}

	private String checkNullValue(String value) {

		String t = "";
		try {
			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			}
		} catch (Exception e) {
			return t;
		}

		return value;
	}

	@Override
	public ProfitLossResultBeanNew generatePLReportNewHor(ProfitAndLossBean objProfitAndLossBean) {
		Map<String, ProfitAndLossBean> hmProfitLossMap = objProfitAndLossDao.getProfitLossReportList(objProfitAndLossBean);

		ProfitLossResultBeanNew objProfitLossResultBean = new ProfitLossResultBeanNew();

		Iterator<Entry<String, ProfitAndLossBean>> it = hmProfitLossMap.entrySet().iterator();

		it = hmProfitLossMap.entrySet().iterator();
		double dSalesRevenueTotal = 0.0;
		double dOtherExpense = 0.0;
		double dFinanceCost = 0.0;
		double dOtherIncome = 0.0;
		double dCostOfSales = 0.0;
		double dAdminExpense = 0.0;
		double dtravellingcost = 0.0;
		double dsalesCost = 0.0;

		double dpersonalCost = 0.0;

		double dfinanceCost = 0.0;

		double dcommunicationCost = 0.0;

		double dadministrativeCost = 0.0;

		double dRentCost = 0.0;

		double dconveyencecost = 0.0;
		double ddisputedcost = 0.0;
		List<ProfitAndLossBean> lSalesRevenueList = new ArrayList<>();
		List<ProfitAndLossBean> dOtherIncomeList = new ArrayList<>();
		List<ProfitAndLossBean> dOtherExpensesList = new ArrayList<>();
		List<ProfitAndLossBean> lFinanceList = new ArrayList<>();
		List<ProfitAndLossBean> lCostOfSalesList = new ArrayList<>();
		List<ProfitAndLossBean> lTravellingCostList = new ArrayList<>();
		List<ProfitAndLossBean> lSalesandBusinessList = new ArrayList<>();
		List<ProfitAndLossBean> lPersonalCostList = new ArrayList<>();
		List<ProfitAndLossBean> lCommuncationCostList = new ArrayList<>();
		List<ProfitAndLossBean> lRentCostList = new ArrayList<>();
		List<ProfitAndLossBean> lAdministartiveExpensesList = new ArrayList<>();
		List<ProfitAndLossBean> lIndirectExpensesList = new ArrayList<>();
		List<ProfitAndLossBean> lOtherIncome = new ArrayList<>();
		List<ProfitAndLossBean> lopeningstock = new ArrayList<>();

		List<ProfitAndLossBean> lclosingstock = new ArrayList<>();

		List<ProfitAndLossBean> purchaseaccounts = new ArrayList<>();

		List<ProfitAndLossBean> salesaccounts = new ArrayList<>();

		List<ProfitAndLossBean> lConveyenceCostList = new ArrayList<>();
		List<ProfitAndLossBean> lDisputedrevenue = new ArrayList<>();
		List<ProfitAndLossBean> lindirectExpense = new ArrayList<>();

		while (it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
			System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

			if (((hmRow.getKey()).startsWith("3000"))) {
				ProfitAndLossBean objSalesRevenue = hmRow.getValue();
				dSalesRevenueTotal += objSalesRevenue.getGroupAmount();

				List<ProfitAndLossBean> lAhlist = objSalesRevenue.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(objAhlist.getAmount());
					lSalesRevenueList.add(objProfitAndLossBeanTemp);
				}

			} else if (((hmRow.getKey()).startsWith("3001"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dOtherIncome += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(objAhlist.getAmount());
					lOtherIncome.add(objProfitAndLossBeanTemp);
				}
			} else if (((hmRow.getKey()).startsWith("30"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dOtherIncome += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(objAhlist.getAmount());
					lopeningstock.add(objProfitAndLossBeanTemp);
				}
			}

			else if (((hmRow.getKey()).startsWith("30"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dOtherIncome += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(objAhlist.getAmount());
					lclosingstock.add(objProfitAndLossBeanTemp);
				}
			}

			else if (((hmRow.getKey()).startsWith("30"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dOtherIncome += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(objAhlist.getAmount());
					purchaseaccounts.add(objProfitAndLossBeanTemp);
				}
			}

			else if (((hmRow.getKey()).startsWith("30"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dOtherIncome += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadName(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmount(objAhlist.getAmount());
					salesaccounts.add(objProfitAndLossBeanTemp);
				}
			}

			else if (((hmRow.getKey()).startsWith("4000"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dCostOfSales += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					dOtherExpensesList.add(objProfitAndLossBeanTemp);
				}
			} else if (((hmRow.getKey()).startsWith("4001"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dtravellingcost += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();
					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					lindirectExpense.add(objProfitAndLossBeanTemp);
				}

			} else if (((hmRow.getKey()).startsWith("5002"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dsalesCost += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					lSalesandBusinessList.add(objProfitAndLossBeanTemp);
				}
			} else if (((hmRow.getKey()).startsWith("5003"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dpersonalCost += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					lPersonalCostList.add(objProfitAndLossBeanTemp);
				}
			} else if (((hmRow.getKey()).startsWith("5004"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dfinanceCost += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					lFinanceList.add(objProfitAndLossBeanTemp);
				}
			} else if (((hmRow.getKey()).startsWith("5005"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dcommunicationCost += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					lCommuncationCostList.add(objProfitAndLossBeanTemp);
				}
			} else if (((hmRow.getKey()).startsWith("5006"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dAdminExpense += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					lAdministartiveExpensesList.add(objProfitAndLossBeanTemp);
				}
			}

			else if (((hmRow.getKey()).startsWith("5008"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dRentCost += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					lRentCostList.add(objProfitAndLossBeanTemp);
				}
			} else if (((hmRow.getKey()).startsWith("5007"))) {
				ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				dconveyencecost += objVesselEquipBean.getGroupAmount();
				List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
				for (ProfitAndLossBean objAhlist : lAhlist) {
					ProfitAndLossBean objProfitAndLossBeanTemp = new ProfitAndLossBean();
					String sAcctCodeName = objAhlist.getAccountHeadCode() + " - " + objAhlist.getAccountHeadName();

					objProfitAndLossBeanTemp.setAccountHead(objAhlist.getAccountHeadName());
					objProfitAndLossBeanTemp.setAccountHeadNameAdmin(sAcctCodeName);
					objProfitAndLossBeanTemp.setAmountAdmin(objAhlist.getAmount());
					lConveyenceCostList.add(objProfitAndLossBeanTemp);
				}
			} /*
				 * else if (((hmRow.getKey()).startsWith("50060044"))) {
				 * ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
				 * ddisputedcost += objVesselEquipBean.getGroupAmount();
				 * List<ProfitAndLossBean> lAhlist = objVesselEquipBean
				 * .getlAccountHeadLevelList(); for (ProfitAndLossBean objAhlist
				 * : lAhlist) { ProfitAndLossBean objProfitAndLossBeanTemp = new
				 * ProfitAndLossBean(); String sAcctCodeName =
				 * objAhlist.getAccountHeadCode() + " - " +
				 * objAhlist.getAccountHeadName();
				 * 
				 * objProfitAndLossBeanTemp.setAccountHead(objAhlist.
				 * getAccountHeadName()); objProfitAndLossBeanTemp
				 * .setAccountHeadNameAdmin(sAcctCodeName);
				 * objProfitAndLossBeanTemp.setAmountAdmin(objAhlist
				 * .getAmount());
				 * lDisputedrevenue.add(objProfitAndLossBeanTemp); } }
				 */

		}

		Collections.sort(lSalesRevenueList, new Comparator<ProfitAndLossBean>() {
			@Override
			public int compare(final ProfitAndLossBean object1, final ProfitAndLossBean object2) {
				return object1.getAccountHead().toLowerCase().compareTo(object2.getAccountHead().toLowerCase());
			}
		});
		objProfitLossResultBean.setlSalesRevenue(lSalesRevenueList);
		objProfitLossResultBean.setdSalesRevenueTotal(dSalesRevenueTotal);
		objProfitLossResultBean.setdOtherExpense(dOtherExpense);
		objProfitLossResultBean.setdCostOfSalesTotal(-dCostOfSales);
		// objProfitLossResultBean.setdCostOfSalesTotal(-390000000);

		objProfitLossResultBean.setDtravellingcost(-dtravellingcost);
		objProfitLossResultBean.setDsalesCost(dsalesCost);
		objProfitLossResultBean.setDpersonalCost(dpersonalCost);
		objProfitLossResultBean.setDfinanceCost(dfinanceCost);
		objProfitLossResultBean.setDcommunicationCost(dcommunicationCost);
		objProfitLossResultBean.setDadministrativeCost(dadministrativeCost);
		objProfitLossResultBean.setdRentCost(dRentCost);
		objProfitLossResultBean.setdAdminExpense(dAdminExpense);
		objProfitLossResultBean.setlFinanceCost(lFinanceList);
		Collections.sort(dOtherExpensesList, new Comparator<ProfitAndLossBean>() {
			@Override
			public int compare(final ProfitAndLossBean object1, final ProfitAndLossBean object2) {
				return object1.getAccountHead().toLowerCase().compareTo(object2.getAccountHead().toLowerCase());
			}
		});
		objProfitLossResultBean.setlCostOfSales(lCostOfSalesList);
		objProfitLossResultBean.setlOtherExpense(dOtherExpensesList);
		objProfitLossResultBean.setlOtherIncome(lOtherIncome);

		// objProfitLossResultBean.setlOtherIncome(lOtherIncome);
		objProfitLossResultBean.setdOtherIncome(dOtherIncome);
		objProfitLossResultBean.setLopeningstock(lopeningstock);
		objProfitLossResultBean.setLclosingstock(lclosingstock);

		objProfitLossResultBean.setLindirectexpenses(lindirectExpense);

		objProfitLossResultBean.setLpurchaseaccounts(purchaseaccounts);

		objProfitLossResultBean.setLsalesaccounts(salesaccounts);

		objProfitLossResultBean.setdOtherIncome(dOtherIncome);

		objProfitLossResultBean.setdOtherIncome(dOtherIncome);

		objProfitLossResultBean.setdOtherIncome(dOtherIncome);

		// objProfitLossResultBean.setdOtherIncome(-390000000);

		objProfitLossResultBean.setdAdminExpense(dAdminExpense);
		objProfitLossResultBean.setlAdminExpense(lAdministartiveExpensesList);
		objProfitLossResultBean.setlFinanceCost(lFinanceList); // for 5004
		objProfitLossResultBean.setdFinanceCost(dFinanceCost);
		objProfitLossResultBean.setlCostOfSales(lCostOfSalesList);
		objProfitLossResultBean.setlTravellingCostList(lTravellingCostList); // for
																				// 5001
		objProfitLossResultBean.setlSalesandBusinessList(lSalesandBusinessList); // for
																					// 5002
		objProfitLossResultBean.setlPersonalCostList(lPersonalCostList); // for
																			// 5003
		objProfitLossResultBean.setlCommuncationCostList(lCommuncationCostList); // for
																					// 5005
		objProfitLossResultBean.setlRentCostList(lRentCostList); // for 5005
		objProfitLossResultBean.setdRentCost(dRentCost);
		objProfitLossResultBean.setlConveyenceCostList(lConveyenceCostList); // for
		objProfitLossResultBean.setlDisputedCostList(lDisputedrevenue);
		objProfitLossResultBean.setDdisputedcost(ddisputedcost); // 5005
		objProfitLossResultBean.setDconveyencecost(dconveyencecost);
		objProfitLossResultBean.setlIndirectExpensesList(lIndirectExpensesList);

		return objProfitLossResultBean;

	}

	@Override
	public boolean exportPLExcelHor(String sFilePath, ProfitAndLossBean objProfitAndLossBean) {

		Map<String, ProfitAndLossBean> hmProfitLossMap = objProfitAndLossDao.getProfitLossReportList(objProfitAndLossBean);
		try {
			// Blank workbook
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCellStyle my_style = workbook.createCellStyle();
			my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			HSSFCellStyle my_style1 = workbook.createCellStyle();
			my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_LEFT);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			HSSFCellStyle my_style2 = workbook.createCellStyle();
			my_style2.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style2.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style2.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style2.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style2.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style2.setAlignment(my_style.ALIGN_RIGHT);
			my_style2.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style2.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font2 = workbook.createFont();
			font2.setFontHeight((short) 200);
			font2.setFontName("Arial");
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font2.setFontHeightInPoints((short) 10);
			my_style2.setFont(font2);

			HSSFCellStyle my_style3 = workbook.createCellStyle();
			my_style3.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style3.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style3.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style3.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style3.setAlignment(my_style.ALIGN_CENTER);
			my_style3.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style3.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font3 = workbook.createFont();
			font3.setFontHeight((short) 200);
			font3.setFontName("Arial");
			font3.setColor(HSSFColor.BLACK.index);
			font3.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font3.setFontHeightInPoints((short) 10);
			my_style3.setFont(font3);

			HSSFCellStyle my_style4 = workbook.createCellStyle();
			my_style4.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style4.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style4.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style4.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style4.setAlignment(my_style.ALIGN_LEFT);
			my_style4.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style4.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style4.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font4 = workbook.createFont();
			font4.setFontHeight((short) 200);
			font4.setFontName("Arial");
			font4.setColor(HSSFColor.BLACK.index);
			font4.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font4.setFontHeightInPoints((short) 10);
			my_style4.setFont(font4);

			HSSFCellStyle my_style5 = workbook.createCellStyle();
			my_style5.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setAlignment(my_style.ALIGN_RIGHT);
			my_style5.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style5.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style5.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font5 = workbook.createFont();
			font5.setFontHeight((short) 200);
			font5.setFontName("Arial");
			font5.setColor(HSSFColor.BLACK.index);
			font5.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font5.setFontHeightInPoints((short) 10);
			my_style5.setFont(font5);
			
			
			HSSFCellStyle my_style6 = workbook.createCellStyle();
			my_style6.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style6.setAlignment(my_style.ALIGN_LEFT);
			my_style6.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style6.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style6.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font6 = workbook.createFont();
			font6.setFontHeight((short) 200);
			font6.setFontName("Arial");
			font6.setColor(HSSFColor.BLACK.index);
			font6.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font6.setFontHeightInPoints((short) 10);
			my_style6.setFont(font6);
			

			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Income and Expenditure");

			// set main header
			setExcelMainHeaderHor(excelSheet, my_style, objProfitAndLossBean);

			// set header
			// setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRowsHor(excelSheet, hmProfitLossMap, my_style, my_style1, my_style2, my_style3, my_style4, my_style5,my_style6);

			for (int i = 0; i < 7; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	public void setExcelMainHeaderHor(HSSFSheet excelSheet, HSSFCellStyle my_style, ProfitAndLossBean objProfitAndLossBean) {
		/*Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Income and Expenditure -" + objProfitAndLossBean.getCompanyName() + "");
		cell.setCellStyle(my_style);*/
		
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeaderHor(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 3);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Group Head");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Sub Group Account");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Account head");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Debit");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Credit");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRowsHor(HSSFSheet excelSheet, Map<String, ProfitAndLossBean> hmProfitLossMap, HSSFCellStyle my_style, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3, HSSFCellStyle my_style4, HSSFCellStyle my_style5, HSSFCellStyle my_style6) {
		int record = 4, sno = 1;
		int firstRow = 0, firstSgRow = 0, firstAhRow = 0;
		int lastRow = 0;
		try {

			Iterator<Entry<String, ProfitAndLossBean>> it = hmProfitLossMap.entrySet().iterator();

			// Row 2 Empty row
			Row row2 = excelSheet.createRow((short) 5);
			row2.setHeight((short) 350);

			// Row 3
			Row row3 = excelSheet.createRow((short) 6);
			row3.setHeight((short) 350);
			Cell cell30 = row3.createCell(0);
			cell30.setCellStyle(my_style);
			cell30.setCellValue("Particulars");
			Cell cell31 = row3.createCell(1);
			cell31.setCellStyle(my_style);
			cell31.setCellValue("Amount(INR)");

			// Row 4 Empty row
			Row row4 = excelSheet.createRow((short) 7);
			row4.setHeight((short) 350);

			// Row for Sales (Revenue) - ( A )
			Row row5 = excelSheet.createRow((short) 8);
			row5.setHeight((short) 350);

			Cell cell50 = row5.createCell(0);
			cell50.setCellStyle(my_style3);
			cell50.setCellValue("Direct Incomes(A)");

			Cell cell51 = row5.createCell(1);
			cell51.setCellStyle(my_style2);

			int counter = 9;
			it = hmProfitLossMap.entrySet().iterator();
			double dSalesRevenueTotal = 0.0, dCostOfSales = 0.0;
			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("3000")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dSalesRevenueTotal += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			}
			cell51.setCellValue(dSalesRevenueTotal);

			// Row 6 Empty row
			Row row6 = excelSheet.createRow((short) counter++);
			row6.setHeight((short) 350);

			// Row for Cost of Sales - ( B )
			Row row7 = excelSheet.createRow((short) counter++);
			row7.setHeight((short) 350);

			Cell cell70 = row7.createCell(0);
			cell70.setCellStyle(my_style3);
			cell70.setCellValue("Direct Expenses - ( B )");

			Cell cell71 = row7.createCell(1);
			cell71.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();

			List<ProfitAndLossBean> totalList = new ArrayList<>();
			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());
				if ((hmRow.getKey()).startsWith("600")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dCostOfSales += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					totalList.addAll(lAhlist);
					System.out.println("600 " + totalList.size());
				}
			}
			Collections.sort(totalList, new Comparator<ProfitAndLossBean>() {
				@Override
				public int compare(final ProfitAndLossBean object1, final ProfitAndLossBean object2) {
					return object1.getAccountHeadName().toLowerCase().compareTo(object2.getAccountHeadName().toLowerCase());
				}
			});

			for (ProfitAndLossBean objAhlist : totalList) {

				Row rowAH = excelSheet.createRow((short) counter++);
				rowAH.setHeight((short) 350);
				String sAcctCodeName = objAhlist.getAccountHeadName();

				Cell cellAH0 = rowAH.createCell(0);
				cellAH0.setCellStyle(my_style4);
				cellAH0.setCellValue(sAcctCodeName);

				Cell cellAH1 = rowAH.createCell(1);
				cellAH1.setCellStyle(my_style5);
				cellAH1.setCellValue(-objAhlist.getAmount());
			}
			cell71.setCellValue(-dCostOfSales);

			// Row 8 Empty row
			Row row8 = excelSheet.createRow((short) counter++);
			row8.setHeight((short) 350);

			// Total row for non - current asset

			Row row9 = excelSheet.createRow((short) counter++);
			row9.setHeight((short) 350);
			Cell cell90 = row9.createCell(0);
			cell90.setCellStyle(my_style);
			cell90.setCellValue("Gross Profit : C = ( A - B )");

			Cell cell91 = row9.createCell(1);
			cell91.setCellStyle(my_style);
			cell91.setCellValue(dSalesRevenueTotal + dCostOfSales);

			// Row 10 Empty row
			Row row10 = excelSheet.createRow((short) counter++);
			row10.setHeight((short) 350);

			// Row for Other Income - D
			Row row11 = excelSheet.createRow((short) counter++);
			row11.setHeight((short) 350);

			Cell cell110 = row11.createCell(0);
			cell110.setCellStyle(my_style3);
			cell110.setCellValue("Other Income - D");

			Cell cell111 = row11.createCell(1);
			cell111.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();
			double dOtherIncome = 0.0, dAdminExpense = 0.0, dotherExpense = 0.0, dFinanceCost = 0.0, dTravellingCost = 0.0, dsalesCost = 0.0, dCommunicationCost = 0.0, dRentCost = 0.0;
			double dConveyanceCost = 0.0;
			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("30")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dOtherIncome += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(objAhlist.getAmount());
					}

				}

			}
			cell111.setCellValue(dOtherIncome);

			// Row 12 Empty row
			Row row12 = excelSheet.createRow((short) counter++);
			row12.setHeight((short) 350);

			// Row for Administrative Expenses - E
			Row row13 = excelSheet.createRow((short) counter++);
			row13.setHeight((short) 350);

			Cell cell130 = row13.createCell(0);
			cell130.setCellStyle(my_style3);
			cell130.setCellValue("Administrative Cost - E");

			Cell cell131 = row13.createCell(1);
			cell131.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();

			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5006")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dAdminExpense += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(-objAhlist.getAmount());
					}

				}

			}
			cell131.setCellValue(-dAdminExpense);

			// Empty row
			Row row14 = excelSheet.createRow((short) counter++);
			row14.setHeight((short) 350);

			Row row15 = excelSheet.createRow((short) counter++);
			row15.setHeight((short) 350);

			Cell cell150 = row15.createCell(0);
			cell150.setCellStyle(my_style3);
			cell150.setCellValue("Personal Cost - F");

			Cell cell151 = row15.createCell(1);
			cell151.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();

			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5003")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dotherExpense += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(-objAhlist.getAmount());
					}
				}

			}

			cell151.setCellValue(-dotherExpense);

			Row rowempty = excelSheet.createRow((short) counter++);
			rowempty.setHeight((short) 350);

			// Finance Costs - G

			Row row16 = excelSheet.createRow((short) counter++);
			row16.setHeight((short) 350);

			Cell cell160 = row16.createCell(0);
			cell160.setCellStyle(my_style3);
			cell160.setCellValue("Finance Costs - G");

			Cell cell161 = row16.createCell(1);
			cell161.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();

			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5004")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dFinanceCost += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(-objAhlist.getAmount());
					}

				}

			}
			cell161.setCellValue(-dFinanceCost);

			// Travelling Cost
			Row row20 = excelSheet.createRow((short) counter++);
			row20.setHeight((short) 350);

			Cell cell163 = row20.createCell(0);
			cell163.setCellStyle(my_style3);
			cell163.setCellValue("Travelling Cost - H");

			Cell cell164 = row20.createCell(1);
			cell164.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();

			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5001")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dTravellingCost += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(-objAhlist.getAmount());
					}

				}

			}
			cell164.setCellValue(-dTravellingCost);

			// Sales & Buisness Cost
			Row row21 = excelSheet.createRow((short) counter++);
			row21.setHeight((short) 350);

			Cell cell165 = row21.createCell(0);
			cell165.setCellStyle(my_style3);
			cell165.setCellValue("Sales & Business Cost - I");

			Cell cell166 = row21.createCell(1);
			cell166.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();

			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5002")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dsalesCost += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(-objAhlist.getAmount());
					}

				}

			}
			cell166.setCellValue(-dsalesCost);

			// Communication Cost
			Row row22 = excelSheet.createRow((short) counter++);
			row22.setHeight((short) 350);

			Cell cell167 = row22.createCell(0);
			cell167.setCellStyle(my_style3);
			cell167.setCellValue("Communication Cost - J");

			Cell cell168 = row22.createCell(1);
			cell168.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();

			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5005")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dCommunicationCost += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(-objAhlist.getAmount());
					}

				}

			}
			cell168.setCellValue(-dCommunicationCost);

			// Conveyance Cost
			Row row23 = excelSheet.createRow((short) counter++);
			row23.setHeight((short) 350);

			Cell cell169 = row23.createCell(0);
			cell169.setCellStyle(my_style3);
			cell169.setCellValue("Conveyance Cost  - K");

			Cell cell170 = row23.createCell(1);
			cell170.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();

			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5007")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dConveyanceCost += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(-objAhlist.getAmount());
					}

				}

			}
			cell170.setCellValue(-dConveyanceCost);

			// Rent Cost

			Row row233 = excelSheet.createRow((short) counter++);
			row233.setHeight((short) 350);

			Cell cell1699 = row233.createCell(0);
			cell1699.setCellStyle(my_style3);
			cell1699.setCellValue("Rent Cost  - L");

			Cell cell1700 = row233.createCell(1);
			cell1700.setCellStyle(my_style2);

			it = hmProfitLossMap.entrySet().iterator();

			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
				System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

				if ((hmRow.getKey()).startsWith("5008")) {
					ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
					dRentCost += objVesselEquipBean.getGroupAmount();
					List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
					for (ProfitAndLossBean objAhlist : lAhlist) {
						Row rowAH = excelSheet.createRow((short) counter++);
						rowAH.setHeight((short) 350);
						String sAcctCodeName = objAhlist.getAccountHeadName();

						Cell cellAH0 = rowAH.createCell(0);
						cellAH0.setCellStyle(my_style4);
						cellAH0.setCellValue(sAcctCodeName);

						Cell cellAH1 = rowAH.createCell(1);
						cellAH1.setCellStyle(my_style5);
						cellAH1.setCellValue(-objAhlist.getAmount());
					}

				}

			}
			cell1700.setCellValue(-dRentCost);

			// Empty row
			Row row17 = excelSheet.createRow((short) counter++);
			row17.setHeight((short) 350);

			Row row18 = excelSheet.createRow((short) counter++);
			row18.setHeight((short) 350);
			Cell cell180 = row18.createCell(0);
			cell180.setCellStyle(my_style);
			cell180.setCellValue("Net Loss/Profit");

			Double amoount = dAdminExpense + dotherExpense + dTravellingCost + dCommunicationCost + dRentCost + dsalesCost + dFinanceCost + dConveyanceCost;

			System.out.println(amoount);

			Cell cell181 = row18.createCell(1);
			cell181.setCellStyle(my_style);
			double val = Math.abs((dSalesRevenueTotal + dCostOfSales) + amoount + dOtherIncome);
			cell181.setCellValue(val);

			/*
			 * double val=Math.abs(amount - (totl + dOtherIncome));
			 * 
			 * 
			 * cell181.setCellValue(((dSalesRevenueTotal + dCostOfSales)+ +
			 * dOtherIncome) (-amoount));
			 */

			/*
			 * // Empty row Row row19 = excelSheet.createRow((short) counter++);
			 * row19.setHeight((short) 350);
			 * 
			 * 
			 * double totl = dSalesRevenueTotal + dCostOfSales; double amountt =
			 * Math.abs(amoount); if (amountt > dOtherIncome) {
			 * 
			 * 
			 * Row row200 = excelSheet.createRow((short) counter++);
			 * row200.setHeight((short) 350); Cell cell20 =
			 * row200.createCell(0); cell20.setCellStyle(my_style);
			 * cell20.setCellValue("Total");
			 * 
			 * Cell cell201 = row200.createCell(1);
			 * cell201.setCellStyle(my_style);
			 * 
			 * 
			 * 
			 * cell201.setCellValue(val + dOtherIncome + totl); }
			 * 
			 * else {
			 * 
			 * 
			 * Row row200 = excelSheet.createRow((short) counter++);
			 * row200.setHeight((short) 350); Cell cell20 =
			 * row200.createCell(0); cell20.setCellStyle(my_style);
			 * cell20.setCellValue("Total");
			 * 
			 * Cell cell201 = row200.createCell(1);
			 * cell201.setCellStyle(my_style);
			 * 
			 * 
			 * 
			 * cell201.setCellValue(val + amountt + totl);
			 * 
			 * 
			 * 
			 * }
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcelHor(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/Income and Expenditure.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filepath" + sOutFile);
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/Income and Expenditure.xls";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return url;
	}

	@Override
	public ProfitAndLossBean getCompanyDetails(String companyCode) {
		// TODO Auto-generated method stub
		return objProfitAndLossDao.getCompanyDetails(companyCode);
	}

	private void setExcelMainHeader1(HSSFSheet excelSheet, HSSFCellStyle my_style1, Integer size, String header) {

		Row row = excelSheet.createRow((short) 3);
		row.setHeight((short) 100);
		excelSheet.addMergedRegion(new CellRangeAddress(3, 5, 0, 10));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue(header);
		cell.setCellStyle(my_style1);

	}

	private void setExcelHeader2(HSSFSheet excelSheet, HSSFCellStyle my_style1, List<ReportHeaderBean> reportHeader) {
		try {

			Row row = excelSheet.createRow((short) 8);
			row.setHeight((short) 350);

			for (int i = 0; i < 20; i++) {
				excelSheet.autoSizeColumn(i);
			}

			for (int j = 0; j < reportHeader.size(); j++) {
				Cell cell = row.createCell(j);
				cell.setCellStyle(my_style1);
				cell.setCellValue(reportHeader.get(j).getTitle());
				excelSheet.autoSizeColumn(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel1(HSSFWorkbook myWorkBook, String path, String fileName) {

		Date currentDate = new Date();
		String sOutFile = path + fileName + "_" + currentDate.getDate() + "_" + currentDate.getHours() + "_" + currentDate.getMinutes() + "_" + currentDate.getSeconds() + ".xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = sOutFile;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return url;
	}

	@Override
	public ProfitAndLossBean pdfExportNew(ProfitAndLossBean profitreport, String exportFilesPath) {
		try {
			// ServletContext context1 = request.getServletContext();
			Document document = new Document(PageSize.A4, 2, 2, 2, 2);

			//PdfWriter writer = null;

			PdfWriter	writer = PdfWriter.getInstance(document,
					new FileOutputStream(exportFilesPath + "/Income and Expenditure.pdf"));
			document.addAuthor("tg");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("tg");
			document.addTitle("Income and Expenditure");
			document.setPageSize(PageSize.A4);
			document.setMargins(50, 50, 50, 50);

			
			document.open();

			Map<String, ProfitAndLossBean> hmProfitLossMap = objProfitAndLossDao.getProfitLossReportList(profitreport);

			   BaseColor color = BaseColor.BLACK;

			 Font bfBold123 = new Font(FontFamily.HELVETICA, 12,  Font.BOLD, new BaseColor(0, 0, 0)); 
				Paragraph paragraph = new Paragraph();
			Paragraph paragraphmain = new Paragraph();
			Paragraph paragraphmain1 = new Paragraph();
			Paragraph paragraphmain3 = new Paragraph();
			paragraphmain3 = new Paragraph("\n",bfBold123);
			paragraphmain = new Paragraph(" Income and Expenditure	\n",bfBold123);
			paragraphmain1 = new Paragraph("\n",bfBold123);
			paragraphmain.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraphmain3);
			document.add(paragraphmain);
			document.add(paragraphmain1);
//			
		//	Iterator<Entry<String, ProfitAndLossBean>> it = Listbean.entrySet().iterator();

			//it = Listbean.entrySet().iterator();

			PdfPTable table = new PdfPTable(1);
			table.getDefaultCell().setBorder(0);
			Font bfBold12 = new Font(FontFamily.HELVETICA, 8,  Font.NORMAL, new BaseColor(0, 0, 0)); 
			Font bfBold13 = new Font(FontFamily.HELVETICA, 8,  Font.BOLD, new BaseColor(0, 0, 0)); 

			Font bf12 = new Font(FontFamily.HELVETICA, 8); 
			 
			   table = new PdfPTable(2);
			   table.getDefaultCell().setBorder(0);
			    table.setWidthPercentage(100);
				Font tableFont = FontFactory.getFont("Helvetica", 10, Font.NORMAL);

			

				table.addCell("\n");
				table.addCell("\n");
				table.addCell("\n");
			    
			    

				  DecimalFormat df = new DecimalFormat("0.00");

				   document.add(table);
			    

				   //specify column widths
				   float[] columnWidths = {20f, 20f};
				   //create PDF table with the given widths
				   PdfPTable table1 = new PdfPTable(columnWidths);
				   // set table width a percentage of the page width
				   table1.setWidthPercentage(100f);
				 
				   //insert column headings
				   insertCell(table1, "PARTICULARS", Element.ALIGN_LEFT, 1, bfBold13);
				   insertCell(table1, "Amount(INR)", Element.ALIGN_LEFT, 1, bfBold13);
			

				   table1.setHeaderRows(1);
				 
				
							Iterator<Entry<String, ProfitAndLossBean>> it = hmProfitLossMap.entrySet().iterator();

							int counter = 10;

							it = hmProfitLossMap.entrySet().iterator();

							double dSalesRevenueTotal = 0.0, dCostOfSales = 0.0;
							double amt=0, amt1=0,total=0, amt2=0, amt3=0;
							List<ProfitAndLossBean> totalList1 = new ArrayList<>();
							


							while (it.hasNext()) {
								@SuppressWarnings("unchecked")
								Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
								System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

								if ((hmRow.getKey()).startsWith("3000")) {
									
									   insertCell(table1, "DIRECT INCOMES", Element.ALIGN_CENTER, 1, bfBold13);
									   insertCell(table1, "", Element.ALIGN_LEFT, 1, bfBold13);
									
									ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
									List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
									for (ProfitAndLossBean objAhlist : lAhlist) {
										
										   insertCell(table1, "" +objAhlist.getAccountHeadName() , Element.ALIGN_LEFT,color, 1, bf12);
										   insertCell(table1, "" +df.format(objAhlist.getAmount()), Element.ALIGN_RIGHT,color, 1, bf12);
										   amt = amt + objAhlist.getAmount();

									}
									 
								}

							}
							insertCell(table1, "TOTAL-(A)", Element.ALIGN_RIGHT, 1, bfBold13);
							   insertCell(table1, df.format(amt), Element.ALIGN_RIGHT, 1, bfBold13);
						
							it = hmProfitLossMap.entrySet().iterator();

							
							while (it.hasNext()) {
								@SuppressWarnings("unchecked")
								Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
								System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

								if ((hmRow.getKey()).startsWith("3001")) {
									
									   insertCell(table1, " INDIRECT INCOMES", Element.ALIGN_CENTER, 1, bfBold13);
									   insertCell(table1, "", Element.ALIGN_LEFT, 1, bfBold13);
									
									ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
									List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
									for (ProfitAndLossBean objAhlist : lAhlist) {
										
										   insertCell(table1, "" +objAhlist.getAccountHeadName() , Element.ALIGN_LEFT,color, 1, bf12);
										   insertCell(table1, "" +df.format(objAhlist.getAmount()), Element.ALIGN_RIGHT,color, 1, bf12);
										   amt1 = amt1 + objAhlist.getAmount();
										   total = amt + amt1;
									}

								}

							}
							insertCell(table1, "TOTAL-(B)", Element.ALIGN_RIGHT, 1, bfBold13);
							   insertCell(table1, df.format(amt1), Element.ALIGN_RIGHT, 1, bfBold13);
							   insertCell(table1, "TOTAL-(A+B)", Element.ALIGN_RIGHT, 1, bfBold13);
							   insertCell(table1, df.format(total), Element.ALIGN_RIGHT, 1, bfBold13);
						
							it = hmProfitLossMap.entrySet().iterator();

							
							while (it.hasNext()) {
								@SuppressWarnings("unchecked")
								Map.Entry<String, ProfitAndLossBean> hmRow = it.next();
								System.out.println(hmRow.getKey() + " = " + hmRow.getValue());

								if ((hmRow.getKey()).startsWith("4000")) {
									
									   insertCell(table1, "DIRECT EXPENSES", Element.ALIGN_CENTER, 1, bfBold13);
									   insertCell(table1, "", Element.ALIGN_LEFT, 1, bfBold13);
									
									ProfitAndLossBean objVesselEquipBean = hmRow.getValue();
									List<ProfitAndLossBean> lAhlist = objVesselEquipBean.getlAccountHeadLevelList();
									for (ProfitAndLossBean objAhlist : lAhlist) {
										
										   insertCell(table1, "" +objAhlist.getAccountHeadName() , Element.ALIGN_LEFT,color, 1, bf12);
										   insertCell(table1, "" +df.format(objAhlist.getAmount()), Element.ALIGN_RIGHT,color, 1, bf12);
										   amt2 = amt2 + objAhlist.getAmount();
									}

								}

							}
							
							insertCell(table1, "TOTAL-(C)", Element.ALIGN_RIGHT, 1, bfBold13);
							   insertCell(table1, df.format(amt2), Element.ALIGN_RIGHT, 1, bfBold13);
							
						
							   insertCell(table1, "INDIRECT EXPENSES", Element.ALIGN_CENTER, 1, bfBold13);
							   insertCell(table1, "", Element.ALIGN_LEFT, 1, bfBold13);
							   insertCell(table1, "", Element.ALIGN_LEFT, 2, bfBold12);
							   insertCell(table1, "TOTAL-(D)", Element.ALIGN_RIGHT, 1, bfBold13);
							   insertCell(table1, df.format(amt3), Element.ALIGN_RIGHT, 1, bfBold13);
							   
							   insertCell(table1, "TOTAL EXPENDITURE-(C+D)", Element.ALIGN_RIGHT, 1, bfBold13);
							   insertCell(table1, df.format(amt2+amt3), Element.ALIGN_RIGHT, 1, bfBold13);
							   
							   insertCell(table1, "EXCESS OF INCOME OVER EXPENDITURE", Element.ALIGN_RIGHT, 1, bfBold13);
							   insertCell(table1, df.format(amt2-total), Element.ALIGN_RIGHT, 1, bfBold13);
							   
							   
							   
						
							
							
							
							
							
						
					
				   paragraph.add(table1);
				   // add the paragraph to the document
				   document.add(paragraph);
				 
			

			
			document.close();
	         writer.close();


	         profitreport.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profitreport;
	
	}
	
	private void insertCell(PdfPTable table, String text, int align,BaseColor color, int colspan, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), (com.itextpdf.text.Font) font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  cell.setBorderColor(color);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(10f);
		  }
		  //add the call to the table
		  table.addCell(cell);
		   
		 }
	
	 private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(10f);
		  }
		  //add the call to the table
		  table.addCell(cell);
		   
		 }
	

}