package com.dci.tenant.finance.reports.financials.corg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.template.SimpleExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@Service
public class CorgServiceImpl implements CorgService {

	@Autowired
	CorgDao objCorgDao;
	
	@Override
	public List<CorgBean> viewCorgReport(CorgBean objCorgBean) {
		return objCorgDao.viewCorgReport(objCorgBean);
	}

	@Override
	public boolean exportCorgReport(String exportFilesPath, CorgBean objCorgBean) {
		List<CorgBean> lCorgList = objCorgDao.viewCorgReport(objCorgBean);
		try {

			if (lCorgList.size() > 0) {
				String fName = "/CORG.xls";
				String fileName = exportFilesPath + fName;
				WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(fileName));
				workbook.createSheet("Sheet1", 0);
				workbook.write();
				workbook.close();
				try (OutputStream os = new FileOutputStream(fileName)) {
					List<String> headers = Arrays.asList("YEAR","WEEK","TOTAL AMT","BLW 30 AMT",
							"BLW 30 PER","30-45 AMT","30-45 PER","45-60 AMT","45-60 PER","60+ AMT","60+ PER");
					Context context = new Context();
					context.putVar("subLedger", lCorgList);
					SimpleExporter exporter = new SimpleExporter();
					exporter.gridExport(headers, lCorgList, "year, week, totalAmount, CO30, CO30Per, "
							+ "CO30to45, CO30to45Per, CO45to60, CO45to60Per, CO60Plus, CO60PlusPer", os);
				} catch (Exception e) {
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}

		return true;
	}

	@Override
	public List<CorgBean> viewCorgReportAsOnDate(CorgBean objCorgBean) {
		return objCorgDao.viewCorgReportAsOnDate(objCorgBean);
	}

	@Override
	public boolean exportCorgReportAsOnDate(String exportFilesPath, CorgBean objCorgBean) {
		List<CorgBean> lCorgList = objCorgDao.viewCorgReportAsOnDate(objCorgBean);
		try {

			if (lCorgList.size() > 0) {
				String fName = "/CORG.xls";
				String fileName = exportFilesPath + fName;
				WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(fileName));
				workbook.createSheet("Sheet1", 0);
				workbook.write();
				workbook.close();
				try (OutputStream os = new FileOutputStream(fileName)) {
					List<String> headers = Arrays.asList("YEAR","WEEK","TOTAL AMT","BLW 30 AMT",
							"BLW 30 PER","30-45 AMT","30-45 PER","45-60 AMT","45-60 PER","60+ AMT","60+ PER");
					Context context = new Context();
					context.putVar("subLedger", lCorgList);
					SimpleExporter exporter = new SimpleExporter();
					exporter.gridExport(headers, lCorgList, "year, week, totalAmount, CO30, CO30Per, "
							+ "CO30to45, CO30to45Per, CO45to60, CO45to60Per, CO60Plus, CO60PlusPer", os);
				} catch (Exception e) {
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}

		return true;
	}

	@Override
	public String getweekenddate(CorgBean objCorgBean) {
		return objCorgDao.getweekenddate(objCorgBean);
	}

}
