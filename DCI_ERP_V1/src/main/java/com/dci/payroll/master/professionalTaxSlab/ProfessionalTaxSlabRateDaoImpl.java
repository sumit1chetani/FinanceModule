package com.dci.payroll.master.professionalTaxSlab;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.tenant.user.UserDetail;


@Repository
public class ProfessionalTaxSlabRateDaoImpl implements ProfessionalTaxSlabRateDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// SAVE
	@Override
	public ProfessionalTaxSlabRateBean insertTax(ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean) {
		ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateResultBean = new ProfessionalTaxSlabRateBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			objProfessionalTaxSlabRateBean.getFromDate();
			objProfessionalTaxSlabRateBean.getToDate();

			Integer dateValidation = jdbcTemplate.queryForObject(ProfessionalTaxSlabRateQueryUtil.DUPLICATE_COUNT, Integer.class, objProfessionalTaxSlabRateBean.getFromDate(), objProfessionalTaxSlabRateBean.getToDate());
			if (dateValidation == 0) {
				int hdrId = jdbcTemplate.queryForObject(ProfessionalTaxSlabRateQueryUtil.SAVE_SLAB_RATE_HDR, Integer.class, objProfessionalTaxSlabRateBean.getFromDate(), objProfessionalTaxSlabRateBean.getToDate(), userDetail.getUserId());
				for (ProfessionalTaxSlabRateDetailBean iterate : objProfessionalTaxSlabRateBean.getRateTable()) {
					iterate.getSlabName();
					iterate.getRangeFromAmount();
					iterate.getRangeToAmount();
					iterate.getProfessionaltax();
					jdbcTemplate.update(ProfessionalTaxSlabRateQueryUtil.SAVE_SLAB_RATE_DTL, iterate.getSlabName(), iterate.getRangeFromAmount(), iterate.getRangeToAmount(), iterate.getProfessionaltax(), userDetail.getUserId(), hdrId);

				}
				objProfessionalTaxSlabRateResultBean.setSavedSuccess(true);
			} else {
				objProfessionalTaxSlabRateResultBean.setMessage("Professional Tax Period Already Exist !");
				objProfessionalTaxSlabRateResultBean.setSavedSuccess(false);

			}

		} catch (Exception e) {
			// objProfessionalTaxSlabRateBean.setSavedSuccess(false);
			e.printStackTrace();
		}

		return objProfessionalTaxSlabRateResultBean;
	}

	// GRID LIST
	@Override
	public List<ProfessionalTaxSlabRateBean> getList() {
		List<ProfessionalTaxSlabRateBean> list = new ArrayList<>();

		try {
			list = jdbcTemplate.query(ProfessionalTaxSlabRateQueryUtil.SLAB_LIST, new BeanPropertyRowMapper<>(ProfessionalTaxSlabRateBean.class));

		} catch (Exception e) {

			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	// EDIT
	@Override
	public ProfessionalTaxSlabRateResultBean getListEdit(int slabHdrId) {
		List<ProfessionalTaxSlabRateDetailBean> editist = new ArrayList<>();
		List<ProfessionalTaxSlabRateResultBean> objProfessionalTaxSlabRateResultBeanArray = new ArrayList<>();
		List<ProfessionalTaxSlabRateBean> ObjProfessionalTaxSlabRateBean = new ArrayList<>();
		ProfessionalTaxSlabRateResultBean objProfessionalTaxSlabRateResultBean = new ProfessionalTaxSlabRateResultBean();
		try {

			ObjProfessionalTaxSlabRateBean = jdbcTemplate.query(ProfessionalTaxSlabRateQueryUtil.SLAB_LIST_EDIT, new BeanPropertyRowMapper<>(ProfessionalTaxSlabRateBean.class), slabHdrId);

			editist = jdbcTemplate.query(ProfessionalTaxSlabRateQueryUtil.SLAB_LIST_EDIT_DTL, new BeanPropertyRowMapper<>(ProfessionalTaxSlabRateDetailBean.class), slabHdrId);
			objProfessionalTaxSlabRateResultBean.setEditListDtl(ObjProfessionalTaxSlabRateBean);
			objProfessionalTaxSlabRateResultBean.setEditList(editist);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return objProfessionalTaxSlabRateResultBean;
	}

	/*
	 * @Override public ProfessionalTaxSlabRateBean
	 * updateTax(ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean) {
	 * ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateResultBean = new
	 * ProfessionalTaxSlabRateBean(); UserDetail userDetail = (UserDetail)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * 
	 * try { objProfessionalTaxSlabRateBean.getFromDate();
	 * objProfessionalTaxSlabRateBean.getToDate();
	 * objProfessionalTaxSlabRateBean.getSlabHdrId();
	 * objProfessionalTaxSlabRateBean.getRateTable();
	 * 
	 * jdbcTemplate.update(ProfessionalTaxSlabRateQueryUtil.
	 * UPDATE_SLAB_RATE_HDR, objProfessionalTaxSlabRateBean.getFromDate(),
	 * objProfessionalTaxSlabRateBean.getToDate(), userDetail.getUserId(),
	 * objProfessionalTaxSlabRateBean.getSlabHdrId()); for
	 * (ProfessionalTaxSlabRateDetailBean iterate :
	 * objProfessionalTaxSlabRateBean.getRateTable()) { iterate.getSlabHdrId();
	 * iterate.getSlabName(); iterate.getRangeFromAmount();
	 * iterate.getRangeToAmount(); iterate.getProfessionaltax();
	 * jdbcTemplate.update(ProfessionalTaxSlabRateQueryUtil.
	 * UPDATE_SLAB_RATE_DTL, iterate.getSlabName(),
	 * iterate.getRangeFromAmount(), iterate.getRangeToAmount(),
	 * iterate.getProfessionaltax(), userDetail.getUserId(),
	 * iterate.getSlabHdrId());
	 * 
	 * }
	 * 
	 * } catch (Exception e) { //
	 * objProfessionalTaxSlabRateBean.setSavedSuccess(false);
	 * e.printStackTrace(); }
	 * 
	 * return objProfessionalTaxSlabRateResultBean; }
	 */

	@Override
	public ProfessionalTaxSlabRateBean updateTax(ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean) {
		ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateResultBean = new ProfessionalTaxSlabRateBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {

			jdbcTemplate.update(ProfessionalTaxSlabRateQueryUtil.UPDATE_SLAB_RATE_HDR, objProfessionalTaxSlabRateBean.getFromDate(), objProfessionalTaxSlabRateBean.getToDate(), userDetail.getUserId(), objProfessionalTaxSlabRateBean.getSlabHdrId());
			jdbcTemplate.update(ProfessionalTaxSlabRateQueryUtil.DELETE_DETAIL, objProfessionalTaxSlabRateBean.getSlabHdrId());
			for (ProfessionalTaxSlabRateDetailBean iterate : objProfessionalTaxSlabRateBean.getRateTable()) {
				iterate.getSlabHdrId();
				iterate.getSlabName();
				iterate.getRangeFromAmount();
				iterate.getRangeToAmount();
				iterate.getProfessionaltax();

				jdbcTemplate.update(ProfessionalTaxSlabRateQueryUtil.SAVE_SLAB_RATE_DTL, iterate.getSlabName(), iterate.getRangeFromAmount(), iterate.getRangeToAmount(), iterate.getProfessionaltax(), userDetail.getUserId(), objProfessionalTaxSlabRateBean.getSlabHdrId());

			}

		} catch (Exception e) {
			// objProfessionalTaxSlabRateBean.setSavedSuccess(false);
			e.printStackTrace();
		}

		return objProfessionalTaxSlabRateResultBean;
	}

	@Override
	public ProfessionalTaxSlabRateBean deleteTax(int slabHdrId) {
		ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateResultBean = new ProfessionalTaxSlabRateBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {

			jdbcTemplate.update(ProfessionalTaxSlabRateQueryUtil.DELETE_DETAIL, slabHdrId);

			jdbcTemplate.update(ProfessionalTaxSlabRateQueryUtil.DELETE_HEADER, slabHdrId);

		} catch (Exception e) {
			// objProfessionalTaxSlabRateBean.setSavedSuccess(false);
			e.printStackTrace();
		}

		return objProfessionalTaxSlabRateResultBean;
	}

	@Override
	public boolean validateFromToDate(ProfessionalTaxSlabRateBean objBean) throws Exception {

		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSuccess = false;
		int count = 0;
		try {
			if (!objBean.isEdit())
				count = jdbcTemplate.queryForObject(ProfessionalTaxSlabRateQueryUtil.getValidate, Integer.class, new Object[] { userDetail.getUserId(), objBean.getFromDate(), objBean.getToDate() });
			else
				count = jdbcTemplate.queryForObject(ProfessionalTaxSlabRateQueryUtil.getEditValidate, Integer.class, new Object[] { userDetail.getUserId(), objBean.getSlabHdrId(), objBean.getFromDate(), objBean.getToDate() });

			if (count == 0) {
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			// LOGGER.error("Error in Validate Academic Year", e.getMessage());
			e.printStackTrace();
		}
		return isSuccess;
	}

}
