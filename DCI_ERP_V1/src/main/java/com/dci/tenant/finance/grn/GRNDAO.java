package com.dci.tenant.finance.grn;

import java.util.List;

import com.dci.common.util.CustomException;

public interface GRNDAO {

	GRNResultBean getLocationList();

	GRNResultBean getVendorList();

	GRNResultBean getPOList();

	GRNResultBean getPODtlList(int poId);

	List<GRNPurchaseOrderBean> getBatchList(String grnCode);

	boolean saveGrn(GRNBean bean) throws Exception;

	String grnAutoIncrementNo();

	GRNResultBean getRequisition(int poId);

	GRNResultBean getVendorAddress(int vendorId);

	GRNResultBean getGrnEditData(String grnCode);

	boolean updateGRN(GRNBean bean) throws Exception;

	boolean deleteGRN(String grnNo);

	GRNPurchaseOrderBean getGrnOldBatchValue(GRNPurchaseOrderBean bean);

	GRNResultBean getDeliverySchedule(int poDtlId);

	List<GRNBean> getGRNMasterList(int limit, int offset, String formName) throws CustomException;

	boolean updateGRNwithQC(GRNBean bean);

	GRNPurchaseOrderBean getItemAttributes(int itemId);

	List<GRNBean> getGRNExportMasterList() throws CustomException;

	GRNResultBean getPOEditList() throws CustomException;

	GRNResultBean getPOListbasedonCompany(String companyId, int vendorId);

	GRNResultBean getGrnPrintData(String grnCode);

}
