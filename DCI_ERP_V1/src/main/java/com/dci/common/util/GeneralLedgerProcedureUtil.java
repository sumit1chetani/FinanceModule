package com.dci.common.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

public class GeneralLedgerProcedureUtil {
	private final static Logger LOGGER = LoggerFactory.getLogger(GeneralLedgerProcedureUtil.class);

	/**
	 * credit Entry in General Ledger for Header transaction tables
	 * 
	 * @param objGeneralLedgerProcedureBean
	 * @param conn
	 * @return
	 */
	public static boolean saveCreditEntryForHeaderProcedureCall(GeneralLedgerProcedureBean objGeneralLedgerProcedureBean, Connection conn) {
		// Get Connection instance from dataSource
		final String cbpHeaderProcedureCall = "{ call HEADER_GENERAL_LEDGER(?,?,?," + "?,?,?,?,?,?,?,to_date(?,'dd-mm-yy'),?,?,? )}";
		boolean isSuccess = false;
		try {

			CallableStatement cs = conn.prepareCall(cbpHeaderProcedureCall);
			cs.setString(1, objGeneralLedgerProcedureBean.getAccountHeadCode());
			cs.setString(2, objGeneralLedgerProcedureBean.getSubGroupCode());
			cs.setString(3, objGeneralLedgerProcedureBean.getTransactionNo());
			cs.setString(4, objGeneralLedgerProcedureBean.getCurrencyCode());
			cs.setDouble(5, objGeneralLedgerProcedureBean.getExchangeRate());
			cs.setDouble(6, 0);
			cs.setDouble(7, objGeneralLedgerProcedureBean.getTcAmount());
			cs.setDouble(8, 0);
			cs.setDouble(9, objGeneralLedgerProcedureBean.getBcAmount());
			cs.setString(10, "INSERT");
			cs.setString(11, objGeneralLedgerProcedureBean.getLedgerDate());
			cs.setInt(12, 0);
			cs.setString(13, objGeneralLedgerProcedureBean.getCompanyCode());
			cs.setString(14, objGeneralLedgerProcedureBean.getSubAccountCode());

			// Call Stored Procedure
			isSuccess = cs.execute();

		} catch (DataAccessException | SQLException e) {
			LOGGER.error("Error in save the Header Records in General Ledger!", e);
		}

		return isSuccess;
	}

	public static boolean saveCreditEntryForHeaderProcedureCallNEW(GeneralLedgerProcedureBean objGeneralLedgerProcedureBean, Connection conn) {
		// Get Connection instance from dataSource
		final String cbpHeaderProcedureCall = "{ call HEADER_GENERAL_LEDGER_NEW(?,?,?,"
				+ "?,?,?,?,?,?,?,to_date(?,'dd-mm-yy'),?,?,?,?,?,to_date(?,'dd-mm-yy'),? )}";
		boolean isSuccess = false;
		try {

			CallableStatement cs = conn.prepareCall(cbpHeaderProcedureCall);
			cs.setString(1, objGeneralLedgerProcedureBean.getAccountHeadCode());
			cs.setString(2, objGeneralLedgerProcedureBean.getSubGroupCode());
			cs.setString(3, objGeneralLedgerProcedureBean.getTransactionNo());
			cs.setString(4, objGeneralLedgerProcedureBean.getCurrencyCode());
			cs.setDouble(5, objGeneralLedgerProcedureBean.getExchangeRate());
			cs.setDouble(6, 0);
			cs.setDouble(7, objGeneralLedgerProcedureBean.getTcAmount());
			cs.setDouble(8, 0);
			cs.setDouble(9, objGeneralLedgerProcedureBean.getBcAmount());
			cs.setString(10, "INSERT");
			cs.setString(11, objGeneralLedgerProcedureBean.getLedgerDate());
			cs.setInt(12, 0);
			cs.setString(13, objGeneralLedgerProcedureBean.getCompanyCode());
			cs.setString(14, objGeneralLedgerProcedureBean.getSubAccountCode());
			cs.setString(15, objGeneralLedgerProcedureBean.getNarration());
			cs.setString(16, objGeneralLedgerProcedureBean.getPartyInvoiceNo());
			cs.setString(17, objGeneralLedgerProcedureBean.getPartyInvoiceDate());
			cs.setString(18, objGeneralLedgerProcedureBean.getRefNo());

			// Call Stored Procedure
			isSuccess = cs.execute();

		} catch (DataAccessException | SQLException e) {
			LOGGER.error("Error in save the Header Records in General Ledger!", e);
		}

		return isSuccess;
	}

	/**
	 * debit Entry in General Ledger for Header transaction tables
	 * 
	 * @param objGeneralLedgerProcedureBean
	 * @return
	 */
	public static boolean saveDebitEntryForHeaderProcedureCall(GeneralLedgerProcedureBean objGeneralLedgerProcedureBean, Connection conn) {
		// Get Connection instance from dataSource
		final String cbpHeaderProcedureCall = "{ call HEADER_GENERAL_LEDGER(?,?,?," + "?,?,?,?,?,?,?,to_date(?,'dd-mm-yy'),?,?,? )}";
		boolean isSuccess = false;
		try {
			CallableStatement cs = conn.prepareCall(cbpHeaderProcedureCall);
			cs.setString(1, objGeneralLedgerProcedureBean.getAccountHeadCode());
			cs.setString(2, objGeneralLedgerProcedureBean.getSubGroupCode());
			cs.setString(3, objGeneralLedgerProcedureBean.getTransactionNo());
			cs.setString(4, objGeneralLedgerProcedureBean.getCurrencyCode());
			cs.setDouble(5, objGeneralLedgerProcedureBean.getExchangeRate());
			cs.setDouble(6, objGeneralLedgerProcedureBean.getTcAmount());
			cs.setDouble(7, 0);
			cs.setDouble(8, objGeneralLedgerProcedureBean.getBcAmount());
			cs.setDouble(9, 0);
			cs.setString(10, "INSERT");
			cs.setString(11, objGeneralLedgerProcedureBean.getLedgerDate());
			cs.setInt(12, 0);
			cs.setString(13, objGeneralLedgerProcedureBean.getCompanyCode());
			cs.setString(14, objGeneralLedgerProcedureBean.getSubAccountCode());

			// Call Stored Procedure
			isSuccess = cs.execute();

		} catch (DataAccessException | SQLException e) {
			LOGGER.error("Error in save the Header Records in General Ledger!", e);
		}

		return isSuccess;
	}

	public static boolean saveDebitEntryForHeaderProcedureCallNEW(GeneralLedgerProcedureBean objGeneralLedgerProcedureBean, Connection conn) {
		// Get Connection instance from dataSource
		final String cbpHeaderProcedureCall = "{ call HEADER_GENERAL_LEDGER_NEW(?,?,?,"
				+ "?,?,?,?,?,?,?,to_date(?,'dd-mm-yy'),?,?,?,?,?,to_date(?,'dd-mm-yy'),? )}";
		boolean isSuccess = false;
		try {
			CallableStatement cs = conn.prepareCall(cbpHeaderProcedureCall);
			cs.setString(1, objGeneralLedgerProcedureBean.getAccountHeadCode());
			cs.setString(2, objGeneralLedgerProcedureBean.getSubGroupCode());
			cs.setString(3, objGeneralLedgerProcedureBean.getTransactionNo());
			cs.setString(4, objGeneralLedgerProcedureBean.getCurrencyCode());
			cs.setDouble(5, objGeneralLedgerProcedureBean.getExchangeRate());
			cs.setDouble(6, objGeneralLedgerProcedureBean.getTcAmount());
			cs.setDouble(7, 0);
			cs.setDouble(8, objGeneralLedgerProcedureBean.getBcAmount());
			cs.setDouble(9, 0);
			cs.setString(10, "INSERT");
			cs.setString(11, objGeneralLedgerProcedureBean.getLedgerDate());
			cs.setInt(12, 0);
			cs.setString(13, objGeneralLedgerProcedureBean.getCompanyCode());
			cs.setString(14, objGeneralLedgerProcedureBean.getSubAccountCode());
			cs.setString(15, objGeneralLedgerProcedureBean.getNarration());
			cs.setString(16, objGeneralLedgerProcedureBean.getPartyInvoiceNo());
			cs.setString(17, objGeneralLedgerProcedureBean.getPartyInvoiceDate());
			cs.setString(18, objGeneralLedgerProcedureBean.getRefNo());
			// Call Stored Procedure
			isSuccess = cs.execute();

		} catch (DataAccessException | SQLException e) {
			LOGGER.error("Error in save the Header Records in General Ledger!", e);
		}

		return isSuccess;
	}

	/**
	 * Delete Credit Entry in General Ledger for Header transaction tables
	 * 
	 * @param objGeneralLedgerProcedureBean
	 * @return
	 */
	public static boolean deleteCreditEntryHeaderProcedure(GeneralLedgerProcedureBean objGeneralLedgerProcedureBean, Connection conn) {
		final String cbpHeaderProcedureCall = "{ call HEADER_GENERAL_LEDGER(?,?,?," + "?,?,?,?,?,?,?,to_date(?,'dd-mm-yy'),?,?,? )}";
		boolean isSuccess = false;
		try {
			CallableStatement deleteCs = conn.prepareCall(cbpHeaderProcedureCall);

			deleteCs.setString(1, objGeneralLedgerProcedureBean.getAccountHeadCode());
			deleteCs.setString(2, objGeneralLedgerProcedureBean.getSubGroupCode());
			deleteCs.setString(3, objGeneralLedgerProcedureBean.getTransactionNo());
			deleteCs.setString(4, objGeneralLedgerProcedureBean.getCurrencyCode());
			deleteCs.setDouble(5, objGeneralLedgerProcedureBean.getExchangeRate());
			deleteCs.setDouble(6, 0);
			deleteCs.setDouble(7, objGeneralLedgerProcedureBean.getBcAmount());
			deleteCs.setDouble(8, 0);
			deleteCs.setDouble(9, objGeneralLedgerProcedureBean.getTcAmount());
			deleteCs.setString(10, "DELETE");
			deleteCs.setString(11, objGeneralLedgerProcedureBean.getLedgerDate());
			deleteCs.setInt(12, 0);
			deleteCs.setString(13, objGeneralLedgerProcedureBean.getCompanyCode());
			deleteCs.setString(14, objGeneralLedgerProcedureBean.getSubAccountCode());
			isSuccess = deleteCs.execute();

		} catch (DataAccessException | SQLException e) {
			LOGGER.error("Error in delete the Header Records in General Ledger!", e);
		}
		return isSuccess;
	}

	/**
	 * Delete Debit Entry in General Ledger for Header transaction tables
	 * 
	 * @param objGeneralLedgerProcedureBean
	 * @return
	 */
	public static boolean deleteDebitEntryHeaderProcedure(GeneralLedgerProcedureBean objGeneralLedgerProcedureBean, Connection conn) {
		final String cbpHeaderProcedureCall = "{ call HEADER_GENERAL_LEDGER(?,?,?," + "?,?,?,?,?,?,?,to_date(?,'dd-mm-yy'),?,?,? )}";
		boolean isSuccess = false;
		try {
			CallableStatement deleteCs = conn.prepareCall(cbpHeaderProcedureCall);

			deleteCs.setString(1, objGeneralLedgerProcedureBean.getAccountHeadCode());
			deleteCs.setString(2, objGeneralLedgerProcedureBean.getSubGroupCode());
			deleteCs.setString(3, objGeneralLedgerProcedureBean.getTransactionNo());
			deleteCs.setString(4, objGeneralLedgerProcedureBean.getCurrencyCode());
			deleteCs.setDouble(5, objGeneralLedgerProcedureBean.getExchangeRate());
			deleteCs.setDouble(6, objGeneralLedgerProcedureBean.getTcAmount());
			deleteCs.setDouble(7, 0);
			deleteCs.setDouble(8, objGeneralLedgerProcedureBean.getBcAmount());
			deleteCs.setDouble(9, 0);
			deleteCs.setString(10, "DELETE");
			deleteCs.setString(11, objGeneralLedgerProcedureBean.getLedgerDate());
			deleteCs.setInt(12, 0);
			deleteCs.setString(13, objGeneralLedgerProcedureBean.getCompanyCode());
			deleteCs.setString(14, objGeneralLedgerProcedureBean.getSubAccountCode());

			isSuccess = deleteCs.execute();

		} catch (DataAccessException | SQLException e) {
			LOGGER.error("Error in delete the Header Records in General Ledger!", e);
		}
		return isSuccess;
	}
}
