package com.dci.master.employeeAdminMaster;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;


@Repository

@Transactional("tenantTransactionManager")
public class EmployeeSchedule {
	@Autowired
	DataSource dataSource;
	

	
	public void sendingDojList() {
		
		List<String> dbList = getTenantDb();
		
		try {
			
			

				List<EmployeeAdminMasterBean> dojList = getDojList();
//				dojList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.GETDATEOFJOIN, new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
				StringBuffer sb = null;
				Email email = null;
				for (EmployeeAdminMasterBean objBean : dojList) {
					sb = null;
					email = null;
					email = new Email();
					String fromEmailId = "feedertech@simatech.com";

					String[] toMailAddress = {"viniba93@gmail.com"};
					email.setFromEmailAddress(fromEmailId);

					String[] bccEmailAddress = getMailIdSeparate("meenavalli.v@gmail.com");
					email.setBccEmailAddress(bccEmailAddress);

					sb = new StringBuffer();
					sb.append("<html><head><style> #bWord {font-size: 50px;}</style></head><body>");

					sb.append("<p style=\"text-align: left; font-size:30px; margin-bottom:0px;\"><strong id='bWord'>N</strong>EW HIRE REPORT</p>");
					sb.append("<p style=\"text-align: left; margin-top:5px; margin-bottom:5px;\"><b>Inter-Africa Haulage Services LTD</b></p>");
					//sb.append("<p style=\"text-align: left;margin-top:0px;\">1-Aug-2017 TO 31-Aug-2017</p>");
					sb.append("<table style=\"height: 43px;\" width=\"100%\"><thead><tr><th style=\"width: 30%; text-align: left;\">NAME&nbsp;</th><th style=\"width: 15%; text-align: left;\">CODE&nbsp;</th><th style=\"width: 15%; text-align: left;\">HIRE DATE&nbsp;</th><th style=\"width: 40%; text-align: left;\">POSITION&nbsp;</th></tr></thead></table>");
					sb.append("<hr style=\"border: solid 2px grey;\" /><h5 style=\"text-align: left; color: red;\">ADMINISTRATION</h5><table style=\"height: auto;\" width=\"100%\"><tbody>");
					
					for (int i = 0; i < dojList.size(); i++) {
						sb.append("<tr>");
						sb.append("<td style=\"width: 30%;\">");
						sb.append(dojList.get(i).getFirstName());
						sb.append("</td>");
						sb.append("<td style=\"width: 15%;\">");
						sb.append(dojList.get(i).getEmpId());
						sb.append("</td>");
						sb.append("<td style=\"width: 15%;\">");
						sb.append(dojList.get(i).getDoj());
						sb.append("</td>");
						sb.append("<td style=\"width: 40%;\">");
						sb.append(dojList.get(i).getDesignationName());
						sb.append("</td>");
						sb.append("</tr>");
					}
					sb.append("</tbody></table></body></html>");
					email.setBodyHtml(sb.toString());
					email.setSubject("");
					email.setFromEmailAddress(fromEmailId);
					email.setToEmailAddress(toMailAddress);
					email.setBodyText(sb.toString());
					try {
						MailUtility.sendMail(email, "");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  @Scheduled(cron="0 0 10 * * *")
  public void sendingReleivingList() {
	List<String> dbList = getTenantDb();
		
		try {
			
			
				

				List<EmployeeAdminMasterBean> dojList = getRelievingList();
//				dojList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.GETDATEOFJOIN, new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
				StringBuffer sb = null;
				Email email = null;
				for (EmployeeAdminMasterBean objBean : dojList) {
					sb = null;
					email = null;
					email = new Email();
					String fromEmailId = "feedertech@simatech.com";

					String[] toMailAddress = {"viniba93@gmail.com"};
					email.setFromEmailAddress(fromEmailId);

					String[] bccEmailAddress = getMailIdSeparate("meenavalli.v@gmail.com");
					email.setBccEmailAddress(bccEmailAddress);

					sb = new StringBuffer();
					sb.append("<html><head><style> #bWord {font-size: 50px;}</style></head><body>");

					sb.append("<p style=\"text-align: left; font-size:30px; margin-bottom:0px;\"><strong id='bWord'>N</strong>EW HIRE REPORT</p>");
					sb.append("<p style=\"text-align: left; margin-top:5px; margin-bottom:5px;\"><b>Inter-Africa Haulage Services LTD</b></p>");
					//sb.append("<p style=\"text-align: left;margin-top:0px;\">1-Aug-2017 TO 31-Aug-2017</p>");
					sb.append("<table style=\"height: 43px;\" width=\"100%\"><thead><tr><th style=\"width: 30%; text-align: left;\">NAME&nbsp;</th><th style=\"width: 15%; text-align: left;\">CODE&nbsp;</th><th style=\"width: 15%; text-align: left;\">HIRE DATE&nbsp;</th><th style=\"width: 15%; text-align: left;\">Relieving DATE&nbsp;<th style=\"width: 40%; text-align: left;\">POSITION&nbsp;</th></tr></thead></table>");
					sb.append("<hr style=\"border: solid 2px grey;\" /><h5 style=\"text-align: left; color: red;\">ADMINISTRATION</h5><table style=\"height: auto;\" width=\"100%\"><tbody>");
					
					for (int i = 0; i < dojList.size(); i++) {
						sb.append("<tr>");
						sb.append("<td style=\"width: 30%;\">");
						sb.append(dojList.get(i).getFirstName());
						sb.append("</td>");
						sb.append("<td style=\"width: 15%;\">");
						sb.append(dojList.get(i).getEmpId());
						sb.append("</td>");
						sb.append("<td style=\"width: 15%;\">");
						sb.append(dojList.get(i).getDoj());
						sb.append("</td>");
						sb.append("<td style=\"width: 15%;\">");
						sb.append(dojList.get(i).getRelieveDate());
						sb.append("<td style=\"width: 40%;\">");
						sb.append(dojList.get(i).getDesignationName());
						sb.append("</td>");
						sb.append("</tr>");
					}
					sb.append("</tbody></table></body></html>");
					email.setBodyHtml(sb.toString());
					email.setSubject("");
					email.setFromEmailAddress(fromEmailId);
					email.setToEmailAddress(toMailAddress);
					email.setBodyText(sb.toString());
					try {
						MailUtility.sendMail(email, "");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String[] getMailIdSeparate(String emailids1) {
		String[] toIds = emailids1.split(",");
		return toIds;
	}
	
	public List<String> getTenantDb() {
		List<String> tenantDb = new ArrayList<String>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			tenantDb = jdbcTemplate.queryForList(EmployeeAdminMasterQueryUtil.getTenantDb, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tenantDb;
	}
	
/*	public Connection getConn(String tenantId)
			throws ClassNotFoundException, SQLException {
		String dbConfigName = "org.postgresql.Driver/jdbc:postgresql";
		String[] urlArr = dbUrl.split("/");
		String[] serverArr = urlArr[2].split(":");
		String serverIp =serverArr[0];
		String portNo=serverArr[1];
		String dbName = tenantId;
		Connection connection = null;
		String[] dbAry = dbConfigName.split("/");
		Class.forName(dbAry[0]);
		String url = dbAry[1] + "://" + serverIp.trim()
				+ ":" + portNo.trim() + "/"
				+ dbName.trim() + "?useSSL=false";
		connection = DriverManager.getConnection(url, userName.trim(), password.trim());
		return connection;
	}*/
	
	public List<EmployeeAdminMasterBean> getDojList()
			throws SQLException {
		List<EmployeeAdminMasterBean> dojList = new ArrayList<EmployeeAdminMasterBean>();
		Connection con = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			dojList=jdbcTemplate.query(EmployeeAdminMasterQueryUtil.GET_JOINING_LIST,new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
 
			

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return dojList;
	}
	
	public List<EmployeeAdminMasterBean> getRelievingList()
			throws SQLException {
		List<EmployeeAdminMasterBean> dojList = new ArrayList<EmployeeAdminMasterBean>();
		Connection con = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			dojList=jdbcTemplate.query(EmployeeAdminMasterQueryUtil.GET_RELEIVING_LIST,new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
 
		/*	ResultSet rs = stmt.executeQuery("select emp_name as firstName,emp_id as empId,to_char(dt_of_join,'dd/mm/yyyy')as doj,to_char(relieving_date,'dd/mm/yyyy')as relievingDate,dm.desgn_name as designationName from employee_master emp inner join designation_master dm on dm.desgn_code=emp.designation where relieving_date =current_date");
			while (rs.next()) {
				EmployeeAdminMasterBean employeeAdminMasterBean = new EmployeeAdminMasterBean();
				employeeAdminMasterBean.setFirstName(rs.getString(1));
				employeeAdminMasterBean.setEmpId(rs.getString(2));
				employeeAdminMasterBean.setDoj(rs.getString(3));
				employeeAdminMasterBean.setRelieveDate(rs.getString(4));

				employeeAdminMasterBean.setDesignationName(rs.getString(5));
				dojList.add(employeeAdminMasterBean);
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return dojList;
	}
}
