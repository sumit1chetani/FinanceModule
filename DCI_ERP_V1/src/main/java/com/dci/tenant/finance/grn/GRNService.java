package com.dci.tenant.finance.grn;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public interface GRNService {

	GRNResultBean getLocationList();

	GRNResultBean getVendorList();

	GRNResultBean getPOList();

	GRNResultBean getPODtlList(int poId);

	boolean saveGrn(GRNBean bean) throws Exception;

	String grnAutoIncrementNo();

	GRNResultBean getRequisition(int poId);

	GRNResultBean getVendorAddress(int vendorId);

	GRNResultBean getGrnEditData(String grnCode);

	GRNResultBean getGrnPrintData(String grnCode);

	List<GRNPurchaseOrderBean> getBatchList(String grnCode);

	boolean updateGRN(GRNBean bean) throws Exception;

	boolean deleteGRN(String grnNo);

	GRNResultBean getDeliverySchedule(int poDtlId);

	GRNPurchaseOrderBean getGrnOldBatchValue(GRNPurchaseOrderBean bean);

	List<GRNBean> getGRNMasterList(int limit, int offset, String formName) throws Exception;

	boolean updateGRNwithQC(GRNBean bean);

	GRNPurchaseOrderBean getItemAttributes(int itemId);

	void exportExcel(String filePath) throws CustomException;

	GRNResultBean getPOEditList() throws CustomException;

	GRNResultBean getPOListbasedonCompany(String companyId, int vendorId);

	List<GRNBean> getGRNExportMasterList() throws Exception;

	public boolean exportExcelnew(String sFilePath, List<GRNBean> rsList);

}
