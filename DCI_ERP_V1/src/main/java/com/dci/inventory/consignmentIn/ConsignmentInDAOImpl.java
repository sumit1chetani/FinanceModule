package com.dci.inventory.consignmentIn;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.util.CommonUtil;
import com.dci.inventory.stocktransfer.StockTransferQueryUtil;
import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;
import com.dci.tenant.finance.grn.GRNQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class ConsignmentInDAOImpl implements ConsignmentInDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ConsignmentInDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;



	

	
	@Override
	public List<Object> getDropdownValues() {

		List<Object> list = new ArrayList<Object>();

		list.add(getLocation());
		list.add(getQuotation());
		List<ConsignmentInBean> lTransportationType = getDefaultCode(57);

		list.add(lTransportationType);
		return list;

	}

	@Override
	public List<Object> getDropdownValues1() {

		List<Object> list = new ArrayList<Object>();

		list.add(getLocation());
		list.add(getQuotation1());
		List<ConsignmentInBean> lTransportationType = getDefaultCode(57);

		list.add(lTransportationType);
		return list;

	}

	public List<ConsignmentInBean> getDefaultCode(int formFieldId) {
		List<ConsignmentInBean> list = new ArrayList<ConsignmentInBean>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(ConsignmentInQueryUtil.GET_DEFAULT_VALUE, new Object[] { formFieldId });
			for (Map row : location) {
				ConsignmentInBean bean = new ConsignmentInBean();
				bean.setId(CommonUtil.convertNullToInteger(String.valueOf(row.get("def_table_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("value"))));
				list.add(bean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ConsignmentInBean> getLocation() {
		List<ConsignmentInBean> list = new ArrayList<ConsignmentInBean>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(ConsignmentInQueryUtil.GET_LOACATION);
			for (Map row : location) {
				ConsignmentInBean bean = new ConsignmentInBean();
				bean.setId(CommonUtil.convertNullToInteger(String.valueOf(row.get("location_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("location_name"))));
				list.add(bean);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<ConsignmentInBean> getQuotation1() {

		List<ConsignmentInBean> list = new ArrayList<ConsignmentInBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(ConsignmentInQueryUtil.GET_QUOTATION1, userDetails.getCompanyCode());
			for (Map row : location) {
				ConsignmentInBean bean = new ConsignmentInBean();
				bean.setId(CommonUtil.convertNullToInteger(String.valueOf(row.get("purchase_quote_id"))));
				bean.setText(CommonUtil.checkEmptyString(String.valueOf(row.get("purchase_quote_no"))));
				bean.setVendor(CommonUtil.convertNullToInteger(String.valueOf(row.get("entity_id"))));
				bean.setVendorName(CommonUtil.checkEmptyString(String.valueOf(row.get("entity_name"))));

				list.add(bean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<ConsignmentInBean> getQuotation() {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ConsignmentInBean> list = new ArrayList<ConsignmentInBean>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(ConsignmentInQueryUtil.GET_QUOTATION, userDetails.getCompanyCode());
			for (Map row : location) {
				ConsignmentInBean bean = new ConsignmentInBean();
				bean.setId(CommonUtil.convertNullToInteger(String.valueOf(row.get("purchase_quote_id"))));
				bean.setText(CommonUtil.checkEmptyString(String.valueOf(row.get("purchase_quote_no"))));
				bean.setVendor(CommonUtil.convertNullToInteger(String.valueOf(row.get("entity_id"))));
				bean.setVendorName(CommonUtil.checkEmptyString(String.valueOf(row.get("entity_name"))));

				list.add(bean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	private String covertNullToEmpty(String value) {
		return (value == null || value.equals("null")) ? null : value;
	}

	@Override
	public List<ConsignmentInBean> saveConsignmentInData(ConsignmentInBean objConsignmentInBean, String consignmentInNo) {
		List<ConsignmentInBean> alConsignmentInList = new ArrayList<ConsignmentInBean>();
		ConsignmentInBean bean = null;
		boolean isSuccess = false;
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);

			Object[] params = new Object[] { consignmentInNo, CommonUtil.convertSqlDateFormat(objConsignmentInBean.getConsignmentInDate()), objConsignmentInBean.getTransportType(), objConsignmentInBean.getServiceName(), objConsignmentInBean.getPersonName(), objConsignmentInBean.getDeliveryMet(), objConsignmentInBean.getStatus(), objConsignmentInBean.getStockReason(), objConsignmentInBean.getQuotation() };
			int iSIHdr = jdbcTemplate.queryForObject(ConsignmentInQueryUtil.saveConsignmentInData, params, Integer.class);
			if (iSIHdr > 0) {
				objConsignmentInBean.setConsignmentInNo(consignmentInNo);
				objConsignmentInBean.setConsignmentInId(iSIHdr);
				isSuccess = saveConsignmentInDetail(objConsignmentInBean, consignmentInNo, jdbcTemplate);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Consignment In Records!", e);
		}

		alConsignmentInList.add(objConsignmentInBean);

		return alConsignmentInList;
	}

	private boolean saveConsignmentInDetail(ConsignmentInBean objConsignmentInBean, String consignmentInNo, JdbcTemplate jdbcTemplate2) {

		boolean flag = false;
		try {
			List<ConsignmentInDetailBean> consignmentInTableData = objConsignmentInBean.getConsignmentIntables();
			for (int i = 0; i < consignmentInTableData.size(); i++) {
				ConsignmentInDetailBean objConsignmentInDetailBean = consignmentInTableData.get(i);

				int iSInDtl = jdbcTemplate.update(ConsignmentInQueryUtil.saveConsignmentInDetailData, new Object[] { objConsignmentInDetailBean.getItemId(), objConsignmentInDetailBean.getItemQuantity(), objConsignmentInBean.getConsignmentInId() });
				if (iSInDtl > 0) {
					flag = true;
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Consignment In Detail Records!", e);
		}

		return flag;
	}

	@Override
	public String generateConsignmentInNumber() {

		String consignmentInNoValue = "";
		String sSINoLike = "", sDefaultSINo = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

			sCurrentYear = sCurrentYear.substring(2);
			sSINoLike = "CNI%";
			sDefaultSINo = "CNI" + "0001";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ConsignmentInQueryUtil.autoGenConsignmentInNo, new Object[] { sDefaultSINo, sSINoLike });
			for (Map row : rows) {
				consignmentInNoValue = (String) row.get("stock_in_number");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Stock Number", e);
		}
		return consignmentInNoValue;
	}

	@Override
	public ConsignmentInResultBean getConsignmentInList() {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ConsignmentInResultBean resultBean = new ConsignmentInResultBean();
		List<ConsignmentInBean> quotationList = null;

		try {
			quotationList = jdbcTemplate.query(ConsignmentInQueryUtil.SELECT_CONSIGNMENT_IN_HEADER_LIST, new Object[] { 121, userDetails.getCompanyCode() }, new BeanPropertyRowMapper<ConsignmentInBean>(ConsignmentInBean.class));
			resultBean.setlConsignmentInBean(quotationList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPurchaseQuotationList", e);
		}
		return resultBean;
	}

	@Override
	public List<ConsignmentInDetailBean> getItemrequisition(String id) {
		List<ConsignmentInDetailBean> list = new ArrayList<ConsignmentInDetailBean>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(ConsignmentInQueryUtil.GET_ITEM_CODE, new Object[] { Integer.parseInt(id) });
			for (Map row : location) {
				ConsignmentInDetailBean bean = new ConsignmentInDetailBean();
				bean.setId(CommonUtil.convertNullToInteger(String.valueOf(row.get("itemId"))));
				bean.setItemId(CommonUtil.convertNullToInteger(String.valueOf(row.get("itemId"))));
				bean.setText(CommonUtil.checkEmptyString(String.valueOf(row.get("itemName"))));
				bean.setItemQuantity(CommonUtil.convertNullToInteger(String.valueOf(row.get("itemQuantity"))));
				bean.setConsignmentInDetId(CommonUtil.convertNullToInteger(String.valueOf(row.get("consignmentInDetId"))));
				bean.setPurchaseQuantity(CommonUtil.convertNullToInteger(String.valueOf(row.get("purchaseQuantity"))));
				bean.setBatchNoExist((Boolean) row.get("isBatchNoExist"));
				list.add(bean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ConsignmentInBean getConsignmentInDataOnEdit(Integer consignmentInId) {
		ArrayList<ConsignmentInDetailBean> consignmentInDetailList = new ArrayList<ConsignmentInDetailBean>();
		ConsignmentInBean objConsignmentInBean = new ConsignmentInBean();
		try {
			objConsignmentInBean = jdbcTemplate.queryForObject(ConsignmentInQueryUtil.GET_CONSIGNMENT_IN_HDR_LIST_ON_EDIT, new Object[] { consignmentInId }, new BeanPropertyRowMapper<ConsignmentInBean>(ConsignmentInBean.class));

			consignmentInDetailList = (ArrayList<ConsignmentInDetailBean>) jdbcTemplate.query(ConsignmentInQueryUtil.GET_CONSIGNMENT_IN_DTL_LIST_ON_EDIT, new Object[] { consignmentInId }, new BeanPropertyRowMapper<ConsignmentInDetailBean>(ConsignmentInDetailBean.class));

			for (int i = 0; i < consignmentInDetailList.size(); i++) {
				int stockInDetId = consignmentInDetailList.get(i).getConsignmentInDetId();
				List<GRNPurchaseOrderBean> batchDtlsList = jdbcTemplate.query(StockTransferQueryUtil.GET_CONSIGNMENT_IN_BATCH_DTLS, new BeanPropertyRowMapper<GRNPurchaseOrderBean>(GRNPurchaseOrderBean.class), new Object[] { stockInDetId });
				consignmentInDetailList.get(i).setStockTransferBatchList(batchDtlsList);

				if (batchDtlsList.size() > 0) {
					consignmentInDetailList.get(i).setBatchNoExist(true);
				} else {
					consignmentInDetailList.get(i).setBatchNoExist(false);
				}

			}

			objConsignmentInBean.setRowCollection(consignmentInDetailList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPurchaseQuotationList", e);
		}
		return objConsignmentInBean;
	}

	@Override
	public int checkBatchNumber(String manageName) throws Exception {
		int batchNumberId = 0;
		try {

			batchNumberId = jdbcTemplate.queryForObject(ConsignmentInQueryUtil.sCheckBatchName, Integer.class,  manageName );

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check Store Name", e);
		}

		return batchNumberId;

	}

	

	
}
