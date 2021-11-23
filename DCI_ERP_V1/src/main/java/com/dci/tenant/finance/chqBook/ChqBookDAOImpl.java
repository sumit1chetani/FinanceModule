package com.dci.tenant.finance.chqBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;

@Repository
public class ChqBookDAOImpl implements ChqBookDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ChqBookDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ChqBookBean> getStatusList() throws Exception {
		List<ChqBookBean> statusList = new ArrayList<ChqBookBean>();

		try {
			statusList = jdbcTemplate.query(ChqBookQueryUtil.GET_STATUS_LIST, new BeanPropertyRowMapper<ChqBookBean>(ChqBookBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return statusList;
	}

	@Override
	public List<ChqBookBean> getChqBookList() throws Exception {

		List<ChqBookBean> chqBookList = new ArrayList<ChqBookBean>();
		try {
			chqBookList = jdbcTemplate.query(ChqBookQueryUtil.GET_CHQ_BOOK_LIST, new BeanPropertyRowMapper<ChqBookBean>(ChqBookBean.class));
			return chqBookList;

		} catch (Exception e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<ChqBookBean> getChqBookListdummy() throws Exception {

		List<ChqBookBean> chqBookList = new ArrayList<ChqBookBean>();
		try {
			chqBookList = jdbcTemplate.query(ChqBookQueryUtil.GET_CHQ_BOOK, new BeanPropertyRowMapper<ChqBookBean>(ChqBookBean.class));
			return chqBookList;

		} catch (Exception e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean saveChqBook(ChqBookBean objChqBookBean) throws Exception {

		boolean isSuccess = false;
		int chqBookCount = 0;
		int chequeNumber = 0;

		try {

			int noOfLeaves = objChqBookBean.getNoOfLeaves();

			for (int i = 0; i < noOfLeaves; i++) {
				/*
				 * if (i == 0) { chequeNumber =
				 * objChqBookBean.getStartingLeaves(); } else { chequeNumber =
				 * chequeNumber + 1; }
				 */

				String chequeNumbers = "";

				chequeNumbers = jdbcTemplate.queryForObject(ChqBookQueryUtil.GENERATE_CODE, new Object[] { "", "" }, String.class);
				chequeNumbers = "" + chequeNumbers;

				// String chequeNumberString = String.format("%06d",
				// chequeNumber);

				HashMap<String, Object> chqBookMap = new HashMap<String, Object>();
				chqBookMap.put("bankAccountId", objChqBookBean.getBankAccountId());
				chqBookMap.put("validFrom", objChqBookBean.getValidFrom());
				chqBookMap.put("validTo", objChqBookBean.getValidTo());
				chqBookMap.put("statusId", objChqBookBean.getStatusId());
				chqBookMap.put("chequeNumber", chequeNumbers);
				chqBookMap.put("chequeDate", objChqBookBean.getChequeDate());

				chqBookCount = namedParameterJdbcTemplate.update(ChqBookQueryUtil.INSERT_CHQ_BOOK, chqBookMap);

				if (chqBookCount != 0) {
					isSuccess = true;
				}

			}

		} catch (Exception e) {
			LOGGER.error("Error in Insert Cheque Book");
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public boolean updateChqBook(ChqBookBean objChqBookBean) throws Exception {

		boolean isSuccess = false;
		int chqBookCount = 0;

		try {

			HashMap<String, Object> chqBookMap = new HashMap<String, Object>();
			chqBookMap.put("bankAccountId", objChqBookBean.getBankAccountId());
			chqBookMap.put("validFrom", objChqBookBean.getValidFrom());
			chqBookMap.put("validTo", objChqBookBean.getValidTo());
			chqBookMap.put("statusId", objChqBookBean.getStatusId());
			chqBookMap.put("chqNo", objChqBookBean.getChqNo());
			chqBookMap.put("chequeDate", objChqBookBean.getChequeDate());
			chqBookMap.put("chqBookId", objChqBookBean.getChqBookId());

			chqBookCount = namedParameterJdbcTemplate.update(ChqBookQueryUtil.UPDATE_CHQ_BOOK, chqBookMap);

			if (chqBookCount != 0) {
				isSuccess = true;
			}

		} catch (Exception e) {
			LOGGER.error("Error in Insert Cheque Book");
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public ChqBookResultBean editChqBook(int chqBookId) throws Exception {

		ChqBookBean objChqBookBean = new ChqBookBean();
		ChqBookResultBean bean = new ChqBookResultBean();
		List<ChqBookBean> beans = new ArrayList<ChqBookBean>();

		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ChqBookQueryUtil.getEditList, new Object[] { chqBookId });

			for (Map row : rows) {

				objChqBookBean.setChqBookId((int) row.get("chqBookId"));
				objChqBookBean.setBankAccountId((String) row.get("bankAccountId"));
				objChqBookBean.setBankAccountName((String) row.get("bankAccountName"));
				objChqBookBean.setValidFrom((String) row.get("validFrom"));
				objChqBookBean.setValidTo((String) row.get("validTo"));
				objChqBookBean.setChqNo((String) row.get("chqNo"));
				objChqBookBean.setChequeDate((String) row.get("chequeDate"));
				objChqBookBean.setStatusName((String) row.get("statusName"));
				objChqBookBean.setStatusId((int) row.get("statusId"));

			}

			beans.add(objChqBookBean);
			bean.setEditList(beans);

		} catch (Exception e) {
			LOGGER.error("Error in Get Manage Location Edit List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return bean;

	}

	@Override
	public boolean deleteChqBook(int chqBookId) throws Exception {
		boolean isSuccess = false;
		int count = 0;

		try {
			count = jdbcTemplate.update(ChqBookQueryUtil.DELETE_CHQ_BOOK, new Object[] { chqBookId });

			if (count != 0) {
				isSuccess = true;
			}

		} catch (Exception e) {
			LOGGER.error("Error in Deleting Manage Cheque Book", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}

		return isSuccess;
	}

	@Override
	public List<ChqBookBean> searchList(ChqBookBean objChqBookBean) throws Exception {
		List<ChqBookBean> chqBookList = new ArrayList<ChqBookBean>();
		String query = "";

		try {

			query = "select cd.chq_book_id as chqBookId,ahm.acct_head_code as bankAccountId,ahm.acct_head_name as bankAccountName,TO_CHAR(cd.valid_from,'dd/mm/yyyy') as validFrom,TO_CHAR(cd.valid_to,'dd/mm/yyyy') as validTo, cd.cheque_number as chqNo,TO_CHAR(cd.cheque_date,'dd/mm/yyyy') as chequeDate,df.value as statusName from cheque_details cd left join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code = cd.bank_account inner join def_table df on df.def_table_id = cd.cheque_status where cd.cheque_status = " + objChqBookBean.getStatusId();

			if (!objChqBookBean.getBankAccountId().isEmpty()) {
				query = query + " and cd.bank_account = '" + objChqBookBean.getBankAccountId() + "'";
			}
			if (!objChqBookBean.getValidFrom().isEmpty()) {
				query = query + " and cd.valid_from >= to_date('" + objChqBookBean.getValidFrom() + "','dd/mm/yyyy')";
			}
			if (!objChqBookBean.getValidTo().isEmpty()) {
				query = query + " and cd.valid_to <= to_date('" + objChqBookBean.getValidTo() + "','dd/mm/yyyy')";
			}

			chqBookList = jdbcTemplate.query(query, new BeanPropertyRowMapper<ChqBookBean>(ChqBookBean.class));

		} catch (Exception e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return chqBookList;
	}
}
