package com.dci.tenant.container.containerstatussequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;




@Repository
@Transactional("tenantTransactionManager")
public class ContainerStatusSequenceDAOImpl implements ContainerStatusSequenceDAO{

	
	@Autowired
	DataSource dataSource;
	
	
	@Override
	public List<ContainerStatusSequenceBean> getList() throws Exception {
		List<ContainerStatusSequenceBean> bean = new ArrayList<ContainerStatusSequenceBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			bean = jdbcTemplate.query(ContainerStatusSequenceQueryUtil.containersequencestatus_list,
					new BeanPropertyRowMapper<ContainerStatusSequenceBean>(ContainerStatusSequenceBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public ContainerStatusSequenceBean save(ContainerStatusSequenceBean bean, String userId) throws Exception {
		boolean isSuccess = false;
		ContainerStatusSequenceBean leasebean = new ContainerStatusSequenceBean();

		try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		

		Integer leaseDtl = jdbcTemplate.update(ContainerStatusSequenceQueryUtil.containerstatussequence_hdr_insert, bean.getSequenceS(), userId);
		System.out.println(leaseDtl);
			for (ContainerStatusSequenceBean dtl : bean.getContainerstatussequenceDtl()) {
				int i = jdbcTemplate.update(ContainerStatusSequenceQueryUtil.containerstatussequence_dtl_insert, bean.getSequenceS(), dtl.getDirection(), dtl.getStatus());
			}
			isSuccess = true;
			leasebean.setIsSuccess(isSuccess);

		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			leasebean.setIsSuccess(isSuccess);
			leasebean.setMessage("Error in save :" + e.getMessage());

		}
		return leasebean;
	}

	

	@Override
	public ContainerStatusSequenceBean delete(String sequence) throws Exception {
		ContainerStatusSequenceBean bean = new ContainerStatusSequenceBean();

		boolean isSuccess = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			int j= jdbcTemplate.update(ContainerStatusSequenceQueryUtil.containerstatussequence_dtl_delete, sequence);

			int i= jdbcTemplate.update(ContainerStatusSequenceQueryUtil.containerstatussequence_hdr_delete, sequence);

			isSuccess = true;
			bean.setIsSuccess(isSuccess);

		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			bean.setIsSuccess(isSuccess);
			bean.setMessage("Error in save :" + e.getMessage());


		}
		return bean;
	}

	@Override
	public ContainerStatusSequenceBean edit(String sequence) throws Exception {
		ContainerStatusSequenceBean leasebean = new ContainerStatusSequenceBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			if (sequence!=null && !sequence.equals("undefined")) {


				leasebean = jdbcTemplate.queryForObject(ContainerStatusSequenceQueryUtil.containerstatussequence_hdr_edit,
					new Object[] { sequence },
					new BeanPropertyRowMapper<ContainerStatusSequenceBean>(ContainerStatusSequenceBean.class));

			List<ContainerStatusSequenceBean> listBean = jdbcTemplate.query(ContainerStatusSequenceQueryUtil.containerstatussequence_dtl_edit,new Object[] { sequence },
					new BeanPropertyRowMapper<ContainerStatusSequenceBean>(ContainerStatusSequenceBean.class));

			leasebean.setContainerstatussequenceDtl(listBean);
			}
			/* else {
					String agreementrefNo = "";
					agreementrefNo = jdbcTemplate.queryForObject(ContainerStatusSequenceQueryUtil.onHireRefNo,String.class);
					leasebean.setsequence(agreementrefNo);;					}*/
		} catch (DataAccessException e) {
			e.printStackTrace();

		}
		return leasebean;
	}
	
	@Override
	public ContainerStatusSequenceBean update(ContainerStatusSequenceBean bean) throws Exception {
		boolean isSuccess = false;
		ContainerStatusSequenceBean leasebean = new ContainerStatusSequenceBean();

		try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		/*String dummy = bean.getContainerstatussequenceDate();
		
		String sub[]= dummy.split("/");
		
		String one = sub[0] ;
		String two = sub[1];
		String three = sub[2];
		
		String dt= three + "-" + two + "-" + one ;*/

		//int i = jdbcTemplate.update(ContainerStatusSequenceQueryUtil.containerstatussequence_hdr_update, bean.getSequence());
		
		//if(i>0) {
			int  dtl1 = jdbcTemplate.update(ContainerStatusSequenceQueryUtil.containerstatussequence_dtl_delete,bean.getSequence());

			if( dtl1 >0) {
				
				for (ContainerStatusSequenceBean dtl : bean.getContainerstatussequenceDtl()) {
					int j = jdbcTemplate.update(ContainerStatusSequenceQueryUtil.containerstatussequence_dtl_insert, bean.getSequence(), dtl.getDirection(), dtl.getStatus());
				}
				
				
				}
					
				//}
		
			isSuccess = true;
			leasebean.setIsSuccess(isSuccess);

		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			leasebean.setIsSuccess(isSuccess);
			leasebean.setMessage("Error in save :" + e.getMessage());

		}
		return leasebean;
	}

	/*@Override
	public List<ContainerStatusSequenceBean> getAgreementPartyList() {
		List <ContainerStatusSequenceBean> agreementPartyList = new ArrayList();
		ContainerStatusSequenceBean ddbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ContainerStatusSequenceQueryUtil.getAgreementPartyList);

			for (Map<String, Object> row : rows) {
				ddbean = new ContainerStatusSequenceBean();
				ddbean.setId(row.get("id").toString());
				ddbean.setText(row.get("text").toString());
				agreementPartyList.add(ddbean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return agreementPartyList;
	}

	@Override
	public List<ContainerStatusSequenceBean> getContainerTypeList() {
		List <ContainerStatusSequenceBean> agreementTypeList = new ArrayList();
		ContainerStatusSequenceBean ddbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ContainerStatusSequenceQueryUtil.ContainerTypeList);

			for (Map<String, Object> row : rows) {
				ddbean = new ContainerStatusSequenceBean();
				ddbean.setId(row.get("id").toString());
				ddbean.setText(row.get("text").toString());
				agreementTypeList.add(ddbean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return agreementTypeList;
	}
	
	@Override
	public List<ContainerStatusSequenceBean> getsequenceList() {
		List <ContainerStatusSequenceBean> sequenceList = new ArrayList();
		ContainerStatusSequenceBean ddbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ContainerStatusSequenceQueryUtil.sequenceList);

			for (Map<String, Object> row : rows) {
				ddbean = new ContainerStatusSequenceBean();
				ddbean.setId(row.get("id").toString());
				ddbean.setText(row.get("text").toString());
				sequenceList.add(ddbean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return sequenceList;
	}

	@Override
	public List<ContainerStatusSequenceBean> getLocationList() {
		List <ContainerStatusSequenceBean> locationList = new ArrayList();
		ContainerStatusSequenceBean ddbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ContainerStatusSequenceQueryUtil.getLocationList);

			for (Map<String, Object> row : rows) {
				ddbean = new ContainerStatusSequenceBean();
				ddbean.setId(row.get("id").toString());
				ddbean.setText(row.get("location").toString());
				locationList.add(ddbean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return locationList;
	}

	@Override
	public List<ContainerStatusSequenceBean> getContainerStatusSequenceList() {
		List <ContainerStatusSequenceBean> damageCodeList = new ArrayList();
		ContainerStatusSequenceBean ddbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ContainerStatusSequenceQueryUtil.getContainerStatusSequenceList);

			for (Map<String, Object> row : rows) {
				ddbean = new ContainerStatusSequenceBean();
				ddbean.setId(row.get("id").toString());
				ddbean.setText(row.get("text").toString());
				damageCodeList.add(ddbean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return damageCodeList;
	}

	@Override
	public List<ContainerStatusSequenceBean> getRepairProcessList() {
		List <ContainerStatusSequenceBean> repairProcessList = new ArrayList();
		ContainerStatusSequenceBean ddbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ContainerStatusSequenceQueryUtil.getRepairProcessList);

			for (Map<String, Object> row : rows) {
				ddbean = new ContainerStatusSequenceBean();
				ddbean.setId(row.get("id").toString());
				ddbean.setText(row.get("text").toString());
				repairProcessList.add(ddbean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return repairProcessList;
	}*/
	
	
	@Override
	public List<ContainerStatusSequenceBean> getStatusList() {
		List <ContainerStatusSequenceBean> damageCodeList = new ArrayList();
		ContainerStatusSequenceBean ddbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ContainerStatusSequenceQueryUtil.getStatusList);

			for (Map<String, Object> row : rows) {
				ddbean = new ContainerStatusSequenceBean();
				ddbean.setId(row.get("id").toString());
				ddbean.setText(row.get("text").toString());
				damageCodeList.add(ddbean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return damageCodeList;
	}

	@Override 
	public String getSequence() {
		String sequence = "";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			sequence = jdbcTemplate.queryForObject(ContainerStatusSequenceQueryUtil.generateSequence, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sequence;
	}

	@Override
	public List<SelectivityBean> getcontainerStatus() {
		
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();   

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(ContainerStatusSequenceQueryUtil.get_container_status, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return list;
	}

	@Override
	public ContainerStatusSequenceBean saveContainer(
			ContainerStatusSequenceBean bean, String userId) throws Exception {
		boolean isSuccess = false;
		ContainerStatusSequenceBean leasebean = new ContainerStatusSequenceBean();

		try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<String> arra = new ArrayList<String>();
				
				for(int i=0;i<bean.getSequenceM().size();i++){
					arra.add(bean.getSequenceM().get(i).id);				
					
				}
				
		
		Integer leaseDtl = jdbcTemplate.update(ContainerStatusSequenceQueryUtil.save, bean.getSequenceS(), String.join(",",arra),userId);
		
		for(int i=0;i<bean.getSequenceM().size();i++){
			System.out.println(bean.getSequenceM());
			jdbcTemplate.update(ContainerStatusSequenceQueryUtil.save_dtl, bean.getSequenceS(), bean.getSequenceM().get(i).id,bean.getSequenceM().get(i).text);
			
		}
		leasebean.setIsSuccess(true);
		
		/*Integer leaseDtl = jdbcTemplate.update(ContainerStatusSequenceQueryUtil.containerstatussequence_hdr_insert, bean.getSequence(), userId);
		System.out.println(leaseDtl);
			for (ContainerStatusSequenceBean dtl : bean.getContainerstatussequenceDtl()) {
				int i = jdbcTemplate.update(ContainerStatusSequenceQueryUtil.containerstatussequence_dtl_insert, bean.getSequence(), dtl.getDirection(), dtl.getStatus());
			}
			isSuccess = true;
			leasebean.setIsSuccess(isSuccess);*/

		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			leasebean.setIsSuccess(isSuccess);
			leasebean.setMessage("Error in save :" + e.getMessage());

		}
		return leasebean;
	}

	/*@Override
	public List<ContainerStatusSequenceBean> getAgreementTypeList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ContainerStatusSequenceBean> getDamageStatusList() {
		List <ContainerStatusSequenceBean> damageStatusList = new ArrayList();
		ContainerStatusSequenceBean ddbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ContainerStatusSequenceQueryUtil.getDamageStatusList);

			for (Map<String, Object> row : rows) {
				ddbean = new ContainerStatusSequenceBean();
				ddbean.setId(row.get("id").toString());
				ddbean.setText(row.get("text").toString());
				damageStatusList.add(ddbean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return damageStatusList;
	}*/
	
	
	
	

}
