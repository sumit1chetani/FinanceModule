package com.dci.tenant.finance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;

@Repository
@Transactional("tenantTransactionManager")
public class RebateFreightRefundDAOImpl implements RebateFreightRefundDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(RebateFreightRefundDAOImpl.class);

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Resource
	private DataSource dataSource;

	@Override
	public List<RebateFreightRefundBean> getRebateFreightRefundList() {
		List<RebateFreightRefundBean> rebateFreightRefundBeanList = new ArrayList<RebateFreightRefundBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 

			rebateFreightRefundBeanList = jdbcTemplate.query(RebateFreightRefundQueryUtil.getRebateList, new BeanPropertyRowMapper<RebateFreightRefundBean>(RebateFreightRefundBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in vessel", e);
		}
		return rebateFreightRefundBeanList;
	}

	@Override
	public RebateFreightRefundResultBean getDropDownList(RebateFreightRefundBean rebateFreightRefundBean) {
		RebateFreightRefundResultBean rebateFreightRefundResultBeanList = new RebateFreightRefundResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 

			List<SelectivityBean> customerList = new ArrayList<SelectivityBean>();
			List<SelectivityBean> invoiceList = new ArrayList<SelectivityBean>();
			List<SelectivityBean> voyageList = new ArrayList<SelectivityBean>();
			List<SelectivityBean> quotationList = new ArrayList<SelectivityBean>();
			List<SelectivityBean> portList = new ArrayList<SelectivityBean>();
			customerList = jdbcTemplate.query(RebateFreightRefundQueryUtil.selectCustomerList, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			invoiceList = jdbcTemplate.query(RebateFreightRefundQueryUtil.getInvoiceNo, new Object[] { rebateFreightRefundBean.getCustomerCode() }, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			voyageList = jdbcTemplate.query(RebateFreightRefundQueryUtil.selectVslVoyage, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			quotationList = jdbcTemplate.query(RebateFreightRefundQueryUtil.getRateList, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			portList = jdbcTemplate.query(RebateFreightRefundQueryUtil.selectPorts, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			rebateFreightRefundResultBeanList.setCustomerList(customerList);
			rebateFreightRefundResultBeanList.setInvoiceList(invoiceList);
			rebateFreightRefundResultBeanList.setVoyageList(voyageList);
			rebateFreightRefundResultBeanList.setQuotationList(quotationList);
			rebateFreightRefundResultBeanList.setPortList(portList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get drop down List", e);
		}
		return rebateFreightRefundResultBeanList;
	}

	@Override
	public boolean saveRebateRefund(RebateFreightRefundBean rebateBean, String userId) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 

			String rebateCode = jdbcTemplate.queryForObject(RebateFreightRefundQueryUtil.generateRebateId, String.class);
			System.out.println("tds Code-" + rebateCode);
			jdbcTemplate.update(RebateFreightRefundQueryUtil.insertIntoHdr, new Object[] { rebateCode, rebateBean.getCustomerCode(), rebateBean.getFromDate(), rebateBean.getToDate(), rebateBean.getSlabVolume(), rebateBean.getSlabRevenue(), rebateBean.getSlabPeriod(), rebateBean.getExceptionPortsExcluded(), rebateBean.getExceptionInvoicesExcluded(), rebateBean.getExceptionOthers(), rebateBean.getPortsExcluded(), rebateBean.getInvoicesExcluded(), rebateBean.getOneOffRate(), rebateBean.getOneOffSailings(), rebateBean.getRebateApproved(), rebateBean.getRemarks() });
			if (rebateBean.getSlabVolume().equals("Y") || rebateBean.getSlabRevenue().equals("Y")) {
				Iterator itr = rebateBean.getSlabsVolumeBasedList().iterator();
				while (itr.hasNext()) {
					RebateFreightRefundDtlBean rebateDtlObj = (RebateFreightRefundDtlBean) itr.next();
					jdbcTemplate.update(RebateFreightRefundQueryUtil.insertSlabsDtl, new Object[] { rebateCode, rebateDtlObj.getFrom(), rebateDtlObj.getTo(), rebateDtlObj.getValue(), rebateDtlObj.getCurrencyCode(), rebateDtlObj.getPercentage() });

				}
			}
			if (rebateBean.getSlabPeriod().equals("Y")) {
				Iterator itr = rebateBean.getSlabsBasedPeriodList().iterator();
				while (itr.hasNext()) {
					RebateFreightRefundDtlBean rebateDtlObj = (RebateFreightRefundDtlBean) itr.next();
					jdbcTemplate.update(RebateFreightRefundQueryUtil.insertExcepDtl, new Object[] { rebateCode, rebateDtlObj.getFrom(), rebateDtlObj.getTo(), rebateDtlObj.getValue(), rebateDtlObj.getCurrencyCode(), rebateDtlObj.getPercentage() });

				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in rebate save error ", e);
		}
		return false;
	}

	/*@Override
	public List<VesselInformationDtlBean> saveVesselInformaiton(VesselInformationBean vesselInformationBean, String userId) {
		savevesselInformationDtl(vesselInformationBean.getCredittables(), vesselInformationBean.getVesselCode(), "Sea Consumption", userId);
		savevesselInformationDtl(vesselInformationBean.getCredittables1(), vesselInformationBean.getVesselCode(), "Port Consumption", userId);
		return null;
	}

	public void savevesselInformationDtl(ArrayList vesselInfoList, String vesselCode, String consumptionType, String userId) {
		System.out.println("vessel info details=" + vesselInfoList);
		int vessselInfoId = jdbcTemplate.queryForInt(VesselInformationQueryUtil.GET_VESSEL_INFO_ID);
		Iterator itr = vesselInfoList.iterator();
		while (itr.hasNext()) {
			VesselInformationDtlBean vesselObj = (VesselInformationDtlBean) itr.next();
			if (vessselInfoId > 0 && vesselCode != null && !vesselCode.isEmpty() && (vesselObj.getTcpSpeed() > 0 || vesselObj.getNoOfReefer() > 0 || vesselObj.getNoOfReeferPercentage() > 0)) {
				jdbcTemplate.update(VesselInformationQueryUtil.SAVE_VESSEL_INFO_LIST, new Object[] { vessselInfoId, vesselCode, vesselObj.getTcpSpeed(), vesselObj.getNoOfReefer(), vesselObj.getNoOfReeferPercentage(), consumptionType, userId });
				vessselInfoId++;
			}

		}
	}

	@Override
	public List<VesselInformationDtlBean> updateVesselInformaiton(VesselInformationBean vesselInformationBean, String userId) {
		if (vesselInformationBean.getCredittables().size() > 0 && vesselInformationBean.getCredittables().get(0).getVesselInfoId() > 0) {
			updatevesselInformationDtl(vesselInformationBean.getCredittables(), vesselInformationBean.getVesselCode(), "Sea Consumption", userId);
		}
		if (vesselInformationBean.getCredittables1().size() > 0 && vesselInformationBean.getCredittables1().get(0).getVesselInfoId() > 0) {
			updatevesselInformationDtl(vesselInformationBean.getCredittables1(), vesselInformationBean.getVesselCode(), "Port Consumption", userId);
		}

		return null;
	}

	public void updatevesselInformationDtl(ArrayList vesselInfoList, String vesselCode, String consumptionType, String userId) {
		System.out.println("vessel info details=" + vesselInfoList);
		// int vessselInfoId =
		// jdbcTemplate.queryForInt(VesselInformationQueryUtil.GET_VESSEL_INFO_ID);
		Iterator itr = vesselInfoList.iterator();
		while (itr.hasNext()) {
			VesselInformationDtlBean vesselObj = (VesselInformationDtlBean) itr.next();
			if (vesselObj.getVesselInfoId() > 0 && vesselCode != null && !vesselCode.isEmpty() && (vesselObj.getTcpSpeed() > 0 || vesselObj.getNoOfReefer() > 0 || vesselObj.getNoOfReeferPercentage() > 0)) {
				jdbcTemplate.update(VesselInformationQueryUtil.UPDATE_VESSEL_INFO, new Object[] { vesselCode, vesselObj.getTcpSpeed(), vesselObj.getNoOfReefer(), vesselObj.getNoOfReeferPercentage(), consumptionType, userId, vesselObj.getVesselInfoId() });

			}

		}
	}

	@Override
	public VesselInformationBean editVesselInformaiton(int vesselInfoId, String userId) {
		ArrayList<VesselInformationDtlBean> vesselInforDtBeanList = new ArrayList<VesselInformationDtlBean>();
		ArrayList<VesselInformationDtlBean> vesselInforDtBeanList1 = new ArrayList<VesselInformationDtlBean>();
		VesselInformationBean vesselInformationBean = new VesselInformationBean();

		try {
			String vesselCode = "", consumptionType = "";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(VesselInformationQueryUtil.GET_VESSEL_INFO, new Object[] { vesselInfoId });
			for (Map row : rows) {
				VesselInformationDtlBean vesselInformationDtlBean = new VesselInformationDtlBean();
				vesselInformationDtlBean.setVesselInfoId(Integer.parseInt(row.get("vessel_info_id").toString()));
				vesselCode = ((String) row.get("vessel_id"));
				vesselInformationDtlBean.setVesselCode(vesselCode);
				vesselInformationDtlBean.setTcpSpeed(Double.parseDouble(row.get("tcp_speed").toString()));
				vesselInformationDtlBean.setNoOfReefer(Double.parseDouble(row.get("no_of_reefer").toString()));
				vesselInformationDtlBean.setNoOfReeferPercentage(Double.parseDouble(row.get("no_of_reefer").toString()));
				consumptionType = (String) row.get("consumption_type");
				vesselInformationDtlBean.setConsumptionType(consumptionType);
				vesselInforDtBeanList.add(vesselInformationDtlBean);
			}
			vesselInformationBean.setVesselCode(vesselCode);
			if (consumptionType.equals("Sea Consumption")) {
				vesselInformationBean.setCredittables(vesselInforDtBeanList);
				vesselInformationBean.setCredittables1(vesselInforDtBeanList1);
			} else {
				vesselInformationBean.setCredittables1(vesselInforDtBeanList);
				vesselInformationBean.setCredittables(vesselInforDtBeanList1);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in disbursement account list page", e);
		}
		return vesselInformationBean;
	}*/

	@Override
	public List<SelectivityBean> getInvoiceList(String customerCode) {
		List<SelectivityBean> invoiceList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 

			invoiceList = jdbcTemplate.query(RebateFreightRefundQueryUtil.getInvoiceNo, new Object[] { customerCode }, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get drop down List", e);
		}
		return invoiceList;
	}

}
