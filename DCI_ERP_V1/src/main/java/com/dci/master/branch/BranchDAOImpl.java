package com.dci.master.branch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.company.CompanyDetailsQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")

public class BranchDAOImpl implements BranchDAO {

	private final static Logger LOGGER = Logger.getLogger(BranchDAOImpl.class);
	
	@Autowired
	DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Override
	public List<Branch> getBranchList() throws Exception {
		List<Branch> BranchList = new ArrayList<Branch>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			BranchList = jdbcTemplate.query(BranchQueryUtil.GET_BRANCH_LIST,
					new BeanPropertyRowMapper<Branch>(Branch.class));

		} catch (Exception e) {
			LOGGER.error("Error in BranchList", e);
		}
		return BranchList;
	}

	@Override
	public BranchResultBean insertBranch(BranchResultBean branch1) {
		boolean isSuccess = false;
		BranchResultBean operationTheatreResultBean = new BranchResultBean();
		int branchId = 0;
		String result="";
		String subGroupCode ="1003";
		String acctHeadStatus = "Y";
		String accHead="A";
		try {
			Branch branch = new Branch();
			List<BranchBank> branchBank = new ArrayList<BranchBank>();
			branch=branch1.getBranch();
			branchBank=branch1.getBranchBank();
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			/*int i = jdbcTemplate.queryForObject(BranchQueryUtil.sCheckBranchCode,Integer.class, branch.getBranchCode().toUpperCase(), branch.getTenantId());
			if (i == 0) {
				int j = jdbcTemplate.queryForObject(BranchQueryUtil.sCheckBranchCode1,Integer.class, branch.getBranchName().toUpperCase(), branch.getTenantId());
				if (j == 0) {*/
					branch.setTableName("branch");
					branch.setFormCode("F0241");
					String active;
					String active1;

					String bankActive;
					if(branch.getIsActive()==true)
					{
						active="1";
						active1="Y";
					}
					else
					{
						active="0";
						active1="N";

					}
					String companyCode = jdbcTemplate.queryForObject(CompanyDetailsQueryUtil.SELEECT_COMPANY_CODE, String.class);

					jdbcTemplate.update(BranchQueryUtil.sAddCompanydetails, branch.getBranchName(),branch.getBranchCode(),branch.getCityId(),companyCode,branch.getAddress(),branch.getPhoneNumber(),branch.getFaxNo(),"N",userDetails.getUserId(),branch.getCurrencyId(),active1);

					jdbcTemplate.update(BranchQueryUtil.INSERT_Branch(active), branch.getBranchCode(),branch.getBranchName(),branch.getCompanyId(),branch.getCurrencyId(),branch.getAddress(),branch.getAddress1(),branch.getAddress2(),branch.getPinCode(),branch.getPhoneNumber(),branch.getFaxNo(),branch.getPanNo(),branch.getServiceTaxNo(),branch.getLicenceNo(),branch.getLogoPath(),branch.getUom(),branch.getGstnCode(),branch.getGstnNo(),userDetails.getUserId(),userDetails.getUserId(),companyCode,branch.getCountryId(),branch.getCityId(),branch.getEmail());
					
					branchId = jdbcTemplate.queryForObject(BranchQueryUtil.select_previous_id,Integer.class);

					 userlogDao.userLogForInsert(branch, branchId + "", userDetails.getUserId());
					 String currecny=jdbcTemplate.queryForObject(BranchQueryUtil.CURRENCY_VALUE,String.class,new Object[]{branch.getCurrencyId()} );
              for(BranchBank lbranchBank:branchBank)
               {
            	  if(lbranchBank.isBankActive())
					{
						bankActive="1";
					}
					else
					{
						bankActive="0";
	
					}
            	  
            	  jdbcTemplate.update(BranchQueryUtil.INSERT_Branch_BANK(bankActive),lbranchBank.getBankName(),lbranchBank.getBankAddress(),lbranchBank.getAccountNo(),lbranchBank.getIfscCode(),lbranchBank.getIbanNo(),lbranchBank.getShiftCard());
            	  List<Map<String, Object>> rows = jdbcTemplate.queryForList(BranchQueryUtil.AUTOGENERATE_OF_ACCT_HEAD_CODE,
        					new Object[] { subGroupCode });

        			if (rows.size() < 0) {
        				result = subGroupCode + "0000";
        			} else {
        				for (Map row : rows) {
        					result = (String) row.get("ACCT_CODE");
        				}
        			}

        			if(result == "null" || "null".equalsIgnoreCase(result) || result ==null)
        				result = subGroupCode + "0000";
        			
        			int iLastAccountCode = Integer.parseInt(result);
        			int iNewAccountCode = iLastAccountCode + 1;
        			String convResult = String.valueOf(iNewAccountCode);
        			String AcctHeadCode = convResult;
        			
        			
        			jdbcTemplate.update(BranchQueryUtil.INSERT_ACC_HEAD,AcctHeadCode,subGroupCode,lbranchBank.getBankName(),currecny,accHead,acctHeadStatus,userDetails.getUserId());
               }
             /* List<Map<String, Object>> rows = jdbcTemplate.queryForList(BranchQueryUtil.AUTOGENERATE_OF_ACCT_HEAD_CODE,
  					new Object[] { subGroupCode });

  			if (rows.size() < 0) {
  				result = subGroupCode + "0000";
  			} else {
  				for (Map row : rows) {
  					result = (String) row.get("ACCT_CODE");
  				}
  			}

  			if(result == "null" || "null".equalsIgnoreCase(result) || result ==null)
  				result = subGroupCode + "0000";
  			
  			int iLastAccountCode = Integer.parseInt(result);
  			int iNewAccountCode = iLastAccountCode + 1;
  			String convResult = String.valueOf(iNewAccountCode);
  			String AcctHeadCode = convResult;*/
  			
  			//jdbcTemplate.update(BranchQueryUtil.INSERT_ACC_HEAD,AcctHeadCode,subGroupCode,lbranchBank.getBankName(),branch.getCurrencyId(),accHead,acctHeadStatus);
            
  			
					operationTheatreResultBean.setSuccess(true);
				  
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Operation Theatre", e);
		}
		return operationTheatreResultBean;
	}

	@Override
	public BranchResultBean getBranchById(int custId) {
		BranchResultBean branch = new BranchResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			branch.setBranch(jdbcTemplate.queryForObject(
					BranchQueryUtil.SELECT_BRANCH_BY_ID,
					new BeanPropertyRowMapper<Branch>(Branch.class), custId));
			branch.setBranchBank(jdbcTemplate.query(
					BranchQueryUtil.SELECT_BRANCH_BANK_BY_ID,
					new BeanPropertyRowMapper<BranchBank>(BranchBank.class), custId));
			branch.setSuccess(true);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in BranchById", e);
		}
		return branch;
	}
	
	@Override
	public BranchResultBean getview(int custId) {
		BranchResultBean branch = new BranchResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			branch.setBranch(jdbcTemplate.queryForObject(
					BranchQueryUtil.SELECT_BRANCH_BY_ID_view,
					new BeanPropertyRowMapper<Branch>(Branch.class), custId));
			branch.setBranchBank(jdbcTemplate.query(
					BranchQueryUtil.SELECT_BRANCH_BANK_BY_ID_view,
					new BeanPropertyRowMapper<BranchBank>(BranchBank.class), custId));
			branch.setSuccess(true);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in view", e);
		}
		return branch;
	}

	@Override
	public boolean deleteBranch(int custId) {
		boolean isDeleted = false;
		int val = 1;
		UserDetail userDetails = (UserDetail) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		BranchResultBean BranchResultBean = new BranchResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String companyCode = jdbcTemplate.queryForObject(BranchQueryUtil.GET_COMPANY,String.class,custId);
			

			val = jdbcTemplate.update(BranchQueryUtil.DELETE_Branch, custId);
			
			jdbcTemplate.update(BranchQueryUtil.DELETEBRANCHBANK, custId);
			jdbcTemplate.update(BranchQueryUtil.DELETE_COMPANY, companyCode);
			/*userlogDao.userLogForDelete(branch, custId + "",
					userDetails.getUserId());
*/
			isDeleted = true;
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in view", e);
		}
		return isDeleted;
	}

	@Override
	public BranchResultBean updateBranch(BranchResultBean branch1) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		BranchResultBean branchResultBean = new BranchResultBean();
		Branch branch = new Branch();
		List<BranchBank> branchBank = new ArrayList<BranchBank>();
		branch=branch1.getBranch();
		branchBank=branch1.getBranchBank();
		//Branch brancholdbean = getBranchById(branch.getBranchId());
		UserDetail userDetails = (UserDetail) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String result="";
		String subGroupCode ="1003";
		String acctHeadStatus = "Y";
		String accHead="A";

		try {
		
				int i = jdbcTemplate.queryForObject(
						BranchQueryUtil.sCheckBranchCode3, Integer.class,
						branch.getBranchCode().toUpperCase(),
						branch.getTenantId(), branch.getBranchId());
				branch.setTableName("branch");
				branch.setFormCode("F5036");
				String active;
				String active1;

				String bankActive;
				if(branch.getIsActive()==true)
				{
					active="1";
					active1="Y";
				}
				else
				{
					active="0";
					active1="N";


				}
				jdbcTemplate.update(BranchQueryUtil.sUpdateCompanyDetail, branch.getBranchName(),branch.getBranchCode(),branch.getCityId(),branch.getAddress(),branch.getPhoneNumber(),branch.getFaxNo(),"N",userDetails.getUserId(),branch.getCurrencyId(),active1,branch.getCompanyCode());

				jdbcTemplate.update(BranchQueryUtil.UPDATE_Branch(active), branch.getBranchCode(),branch.getBranchName(),branch.getCompanyId(),branch.getCurrencyId(),branch.getAddress(),branch.getAddress1(),branch.getAddress2(),branch.getPinCode(),branch.getPhoneNumber(),branch.getFaxNo(),branch.getPanNo(),branch.getServiceTaxNo(),branch.getLicenceNo(),branch.getLogoPath(),branch.getUom(),branch.getGstnCode(),branch.getGstnNo(),userDetails.getUserId(),branch.getCountryId(),branch.getCityId(),branch.getEmail(),branch.getBranchId());
				
						branch.setTableName("branch");
						branch.setFormCode("F5118");
					/*	userlogDao.userLogForUpdate(brancholdbean, branch,
								branch.getBranchId() + "",
								userDetails.getUserId());*/
						/*jdbcTemplate.update(BranchQueryUtil.DELETEBRANCHBANK,branch.getBranchId());*/
						  jdbcTemplate.update(BranchQueryUtil.DELETE_ACC,branch.getBranchId());
						  String currecny=jdbcTemplate.queryForObject(BranchQueryUtil.CURRENCY_VALUE,String.class,new Object[]{branch.getCurrencyId()} );
			  				 jdbcTemplate.update(BranchQueryUtil.DELETE_BRANCHBANK_DETAIL, branch.getBranchId());

						  for(BranchBank lbranchBank:branchBank)
			               {
			            	  if(lbranchBank.isBankActive())
								{
									bankActive="1";
								}
								else
								{
									bankActive="0";
				
								}

			            	  jdbcTemplate.update(BranchQueryUtil.INSERT_Branch_BANK1(bankActive),lbranchBank.getBankName(),lbranchBank.getBankAddress(),lbranchBank.getAccountNo(),lbranchBank.getIfscCode(),lbranchBank.getIbanNo(),lbranchBank.getShiftCard(),branch.getBranchId());
			            	
			            	  List<Map<String, Object>> rows = jdbcTemplate.queryForList(BranchQueryUtil.AUTOGENERATE_OF_ACCT_HEAD_CODE,
			        					new Object[] { subGroupCode });

			        			if (rows.size() < 0) {
			        				result = subGroupCode + "0000";
			        			} else {
			        				for (Map row : rows) {
			        					result = (String) row.get("ACCT_CODE");
			        				}
			        			}

			        			if(result == "null" || "null".equalsIgnoreCase(result) || result ==null)
			        				result = subGroupCode + "0000";
			        			
			        			int iLastAccountCode = Integer.parseInt(result);
			        			int iNewAccountCode = iLastAccountCode + 1;
			        			String convResult = String.valueOf(iNewAccountCode);
			        			String AcctHeadCode = convResult;
			        			
			        			jdbcTemplate.update(BranchQueryUtil.INSERT_ACC_HEAD,AcctHeadCode,subGroupCode,lbranchBank.getBankName(),currecny,accHead,acctHeadStatus,userDetails.getUserId(),branch.getBranchId());
			               }
						branchResultBean.setSuccess(true);
					
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in Update Branch", e);
		}

		return branchResultBean;
	}

	@Override
	public List<Branch> getTemplateById(int templateId) throws Exception {
		List<Branch> templateList = new ArrayList<Branch>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			// templateList =
			// jdbcTemplate.query(BranchQueryUtil.SELECT_TENENT_BY_ID, new
			// BeanPropertyRowMapper<Branch>(Branch.class), templateId);

		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in TemplateById", e);
		}
		return templateList;
	}

	@Override
	public boolean deletebranchBank(List<BranchBank> lBranchBank)
			throws Exception {
		boolean isDeleted = false;
		int val = 1;
		UserDetail userDetails = (UserDetail) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		BranchResultBean BranchResultBean = new BranchResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
			for(BranchBank BranchBank:lBranchBank)
			{
				jdbcTemplate.update(BranchQueryUtil.DELETEBRANCHBANKDETAIL, BranchBank.getBranchBankDetailId());

			}
			/*userlogDao.userLogForDelete(branch, custId + "",
					userDetails.getUserId());
*/
			isDeleted = true;
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in DeleteBranchBank", e);
		}
		return isDeleted;
	}

	
	@Override
	public BranchResultBean getDropDownList(int cityId) {
		// TODO Auto-generated method stub
		BranchResultBean branchResultBean = new BranchResultBean();
		
		List<SelectivityBean> countryList = new ArrayList<SelectivityBean>();
		
		
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int stateId = jdbcTemplate.queryForObject(BranchQueryUtil.GET_STATE_ID,int.class,cityId);
			
			countryList = jdbcTemplate.query(BranchQueryUtil.GETCOUNTRYLIST,new Object[] { stateId },new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			
			
			branchResultBean.setCountryList(countryList);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in DropDownList", e);
		}
		return branchResultBean;
	}
	@Override
	public BranchResultBean deleteKeyDetail(List<BranchNewKeyBean> lServicePartnerKeyBean) {
		// TODO Auto-generated method stub
		BranchResultBean servicePartnerResultBean = new BranchResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			for(BranchNewKeyBean servicePartnerKeyBean:lServicePartnerKeyBean)
			{
				jdbcTemplate.update(BranchQueryUtil.DELETEBRANCHBANKDETAIL,
						servicePartnerKeyBean.getBranchBankDetailId());
				servicePartnerResultBean.setSuccess(true);
			}
			
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in Delete Key Details", e);
		}
		return servicePartnerResultBean;
	}
}
