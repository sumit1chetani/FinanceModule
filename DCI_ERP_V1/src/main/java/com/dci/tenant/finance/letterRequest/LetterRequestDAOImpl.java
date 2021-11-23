package com.dci.tenant.finance.letterRequest;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")


public class LetterRequestDAOImpl implements LetterRequestDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LetterRequestDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	AuditLogDAO auditLogDao;

	@Override
	public List<LetterRequestBean> getLetterTypeList() throws Exception {
	
		 List<LetterRequestBean> List = new ArrayList<>();
		 try {
			 List = jdbcTemplate.query(LetterRequestQueryUtil.LEETERREQTYPELIST, new BeanPropertyRowMapper<LetterRequestBean>(LetterRequestBean.class));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return List;
		
	}

	@Override
	public boolean insertLetterRequestType(LetterRequestBean bean) throws Exception {
		boolean success = false;

		try {
			int i = jdbcTemplate.update(LetterRequestQueryUtil.INSERT_LEETTER_TYPE,new Object[] {bean.getLetterReqTypeName(),
					bean.getCompanyCode(),
					bean.getDescripiton()});
			if(i>0) {
				success = true;
			}
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		return success;
		
	}

	@Override
	public boolean updateLetterRequestType(LetterRequestBean bean) throws Exception {
		boolean success = false;

		try {
			int i = jdbcTemplate.update(LetterRequestQueryUtil.UPDATE_LEETTER_TYPE,new Object[] {bean.getLetterReqTypeName(),
					bean.getDescripiton(),
					bean.getLetterReqTypeId()});
			if(i>0) {
				success = true;
			}
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		return success;
		
	}

	@Override
	public LetterRequestBean editLetterRequestType(Integer id) throws Exception {
		LetterRequestBean LetterRequestBean = new LetterRequestBean();
		List<LetterRequestBean> bean = new ArrayList<>();
		 try {
			 bean = jdbcTemplate.query(LetterRequestQueryUtil.SELECT_EDIT_LIST, new BeanPropertyRowMapper<LetterRequestBean>(LetterRequestBean.class),id);
			 LetterRequestBean = bean.get(0);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return LetterRequestBean;
		
	}

	@Override
	public boolean delete(LetterRequestBean bean) throws Exception {
		boolean success = false;

		try {
			int i = jdbcTemplate.update(LetterRequestQueryUtil.DELETE_LEETTER_TYPE,new Object[] {bean.getLetterReqTypeId()});
			if(i>0) {
				success = true;
			}
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		return success;
		
	}

	@Override
	public List<LetterRequestBean> letterReqList() throws Exception {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		 List<LetterRequestBean> List = new ArrayList<>();
		 try {
		/*	 if(user.getDesignationId().equalsIgnoreCase("DS005")) {
			 List = jdbcTemplate.query(LetterRequestQueryUtil.GET_LETTER_REUEST_LIST1, new BeanPropertyRowMapper<LetterRequestBean>(LetterRequestBean.class));
			 } else if(user.getDesignationId().equalsIgnoreCase("DS037")) {
				 
				 List = jdbcTemplate.query(LetterRequestQueryUtil.GET_LETTER_REUEST_LIST2, new BeanPropertyRowMapper<LetterRequestBean>(LetterRequestBean.class));
				 }else*/ {
				 List = jdbcTemplate.query(LetterRequestQueryUtil.GET_LETTER_REUEST_LIST, new BeanPropertyRowMapper<LetterRequestBean>(LetterRequestBean.class),user.getUserId());
					
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return List;
		
	}

	@Override
	public boolean save(LetterRequestBean bean) throws Exception {
		boolean success = false;
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			int i = jdbcTemplate.update(LetterRequestQueryUtil.INSERT_LETTER_REQUEST,new Object[] {
					bean.getLetterReqTypeId(),
					user.getUserId(),
					bean.getAddress(),
					bean.getPurpose(),
					"Pending",
					user.getUserId()});
			if(i>0) {
				success = true;
			}
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		return success;
		
	}

	@Override
	public boolean update(LetterRequestBean bean) throws Exception {
		boolean success = false;
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			int i = jdbcTemplate.update(LetterRequestQueryUtil.UPDATE_LETTER_REQUEST,new Object[] {
					bean.getLetterReqTypeId(),
					user.getUserId(),
					bean.getAddress(),
					bean.getPurpose(),
					"Pending",
					user.getUserId(),
					bean.getLetterReqId()});
			if(i>0) {
				success = true;
			}
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		return success;
		
	}

	@Override
	public LetterRequestBean edit(Integer id) throws Exception {
		LetterRequestBean LetterRequestBean = new LetterRequestBean();
		List<LetterRequestBean> bean = new ArrayList<>();
		 try {
			 bean = jdbcTemplate.query(LetterRequestQueryUtil.EDIT_LETTER_REQUEST, new BeanPropertyRowMapper<LetterRequestBean>(LetterRequestBean.class),id);
			 LetterRequestBean = bean.get(0);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return LetterRequestBean;
		
	}

	@Override
	public boolean deleteLR(LetterRequestBean bean) throws Exception {
		boolean success = false;

		try {
			int i = jdbcTemplate.update(LetterRequestQueryUtil.DELETE_LETTER_REQUEST,new Object[] {bean.getLetterReqId()});
			if(i>0) {
				success = true;
			}
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		return success;
		
	}

	@Override
	public List<SelectivityBean> getLetterReqTypeList() throws Exception {
		List<SelectivityBean> bean = new ArrayList<>();
		 try {
			 bean = jdbcTemplate.query(LetterRequestQueryUtil.GET_LETTER_TYPE_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return bean;
		
	}

	@Override
	public boolean approve(LetterRequestBean bean) throws Exception {
		boolean success = false;
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			int i = jdbcTemplate.update(LetterRequestQueryUtil.APPROVE_LETTER_REQUEST,new Object[] {user.getUserId(),bean.getIssuedDate(), bean.getLetterReqId()});
			if(i>0) {
				success = true;
			}
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		return success;
		
	}

	@Override
	public boolean issueVal(LetterRequestBean bean) throws Exception {
		boolean success = false;
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			int i = jdbcTemplate.update(LetterRequestQueryUtil.ISSUE_LETTER_REQUEST,new Object[] { bean.getLetterReqId()});
			if(i>0) {
				success = true;
			}
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		return success;
		
	}

}