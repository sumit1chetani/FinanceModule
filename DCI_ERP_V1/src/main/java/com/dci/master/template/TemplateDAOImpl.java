package com.dci.master.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")
public class TemplateDAOImpl implements TemplateDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(TemplateDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public TemplateResultBean getList() {
		TemplateResultBean resultBean = new TemplateResultBean();
		List<TemplateBean> templateList = new ArrayList<TemplateBean>();
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			userDetails.getUserId();
			/*
			 * String customerId = userDetails.getUserId(); if
			 * (userId.equalsIgnoreCase("Admin")) { templateList =
			 * jdbcTemplate.query(TemplateQueryUtil.GET_TEMPLATELIST, new
			 * BeanPropertyRowMapper<TemplateBean>(TemplateBean.class)); } else
			 * { templateList =
			 * jdbcTemplate.query(TemplateQueryUtil.GET_TEMPLATELIST_User, new
			 * BeanPropertyRowMapper<TemplateBean>(TemplateBean.class)); }
			 */
			templateList = jdbcTemplate.query(TemplateQueryUtil.GET_LIST,
					new BeanPropertyRowMapper<TemplateBean>(TemplateBean.class));
			resultBean.setList(templateList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public boolean getSave(TemplateBean bean) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSuccess = false;
		int ret = 0;
		try {
			HashMap<String, Object> template = new HashMap<String, Object>();

			template.put("description", bean.getDescription());
			template.put("subjct", bean.getSubject());
			template.put("html_version", bean.getHtml_version());
			template.put("status", true);
			template.put("template_name", bean.getTemplateName());
			template.put("ccmail", bean.getCcmail());
			template.put("bccmail", bean.getBccmail());
			template.put("createdBy", userDetails.getUserId());
			template.put("tomail", bean.getTomail());

			ret = namedParameterJdbcTemplate.update(TemplateQueryUtil.INSERT_TEMPLATEDATA, template);
			userlogDao.userLogForInsert(bean, bean.getTemplateName() + "", userDetails.getUserId());
			if (ret > 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return isSuccess;
	}

	@Override
	public TemplateBean getTemplateDataEdit(int templateId) {

		TemplateBean obTemplateDataBean = new TemplateBean();

		try {
			// List<TemplateBean> templateAttachmentFileList = new
			// ArrayList<TemplateBean>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(TemplateQueryUtil.EDIT_TEMPLATEHDRDATA,
					new Object[] { templateId });
			for (Map row : rows) {
				obTemplateDataBean.setId((int) row.get("id"));
				obTemplateDataBean.setDescription((String) row.get("description"));
				obTemplateDataBean.setSubject((String) row.get("subject"));
				obTemplateDataBean.setHtml_version((String) row.get("html_version"));
				obTemplateDataBean.setStatus((Boolean) row.get("status"));
				obTemplateDataBean.setTemplateName((String) row.get("templateName"));
				obTemplateDataBean.setCcmail((String) row.get("ccmail"));
				obTemplateDataBean.setBccmail((String) row.get("bccmail"));
				obTemplateDataBean.setTomail((String) row.get("tomail"));

			}

		} catch (Exception e) {
			LOGGER.error("Error in Get Question Edit List", e);
			e.printStackTrace();
		}

		return obTemplateDataBean;
	}

	@Override
	public boolean update(TemplateBean bean) {
		boolean isSuccess = false;
		int ret = 0;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			new JdbcTemplate(dataSource);

			TemplateBean oldData = getTemplateDataEdit(bean.getId());
			HashMap<String, Object> template = new HashMap<String, Object>();

			template.put("description", bean.getDescription());
			template.put("subject", bean.getSubject());
			template.put("html_version", bean.getHtml_version());
			template.put("template_name", bean.getTemplateName());
			template.put("status", true);
			template.put("ccmail", bean.getCcmail());
			template.put("bccmail", bean.getBccmail());
			template.put("modifiedBy", userDetails.getUserId());
			template.put("id", bean.getId());
			template.put("tomail", bean.getTomail());
			ret = namedParameterJdbcTemplate.update(TemplateQueryUtil.UPDATE_TEMPLATEDATA, template);
			userlogDao.userLogForUpdate(oldData, bean, bean.getTemplateName() + "", userDetails.getUserId());
			if (ret > 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public boolean delete(int templateId) {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			TemplateBean bean = new TemplateBean();
			// bean.setTableName("employee_master");
			// bean.setFormCode("F6249");
			jdbcTemplate.update(TemplateQueryUtil.DELETE, new Object[] { templateId });
			userlogDao.userLogForDelete(bean, templateId + "", userDetails.getUserId());
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = true;

		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public TemplateBean sampleTemplate(String templateId) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		TemplateBean resultBean = new TemplateBean();
		try {

			TemplateBean bean = new TemplateBean();
			bean = jdbcTemplate.queryForObject(TemplateQueryUtil.GET_TEMPLATE_DATE, new Object[] { templateId },
					new BeanPropertyRowMapper<TemplateBean>(TemplateBean.class));
			Email email = new Email();
			StringBuffer sb = new StringBuffer();
			String path = "";
			email.setFromEmailAddress("support@cordelialine.com");
			// String toMailAddress = objEmployee.getEmailId();
			// String[] toEmailIds = { "vigneshvijaycs18@gmail.com" };
			// email.setToEmailAddress(toEmailIds);

			String[] bccEmailIds = { "sgopes@gmail.com", "nandakumar@cordelialine.com" };

			if (!bean.getCcmail().equals(null) && !bean.getCcmail().equals("")) {
				String[] cc = bean.getCcmail().split(",");
				email.setCcEmailAddress(cc);
			}
			if (bean.getBccmail() != null && bean.getBccmail() != "") {
				String[] bcc = bean.getBccmail().split(",");
				email.setBccEmailAddress(bcc);
			}
			String companyName = "<b>Cordelia Container Shipping Line <b> <br>Cordelia Container Shipping Line LLC <br> Regal Tower, Business Bay";
/*
			bean = CommonUtil.dischargeNotice(bean.getSubject(), bean.getContent(), companyName, "Dubai",
					"CSX20MUNJEA000029", "Mundra", "06/06/2020", "");
*/
			email.setSubject(bean.getSubject());
			email.setBodyHtml(bean.getContent());

			MailUtility.sendMailCordelia(email, path);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return resultBean;
	}

	@Override
	public TemplateBean blTemplate(String subject, String emailBody, String blno, String userId) {
		TemplateBean bean = new TemplateBean();
		try {
			String subjectvalues = "";
			String content = "";
			if (subject.contains("<BLNo>")) {
				subjectvalues = subject.replace("<BLNo>", blno);

			}

			if (emailBody.contains("&lt;user&gt;")) {
				content = emailBody.replaceAll("&lt;user&gt;", userId);
			}

			bean.setSubject(subjectvalues);
			bean.setContent(content);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;

	}

}
