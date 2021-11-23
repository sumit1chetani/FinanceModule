package com.dci.tenant.domain.repositoryimpl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.ContainerType;
import com.dci.tenant.domain.repository.ContainerTypeRepositoryCustom;

@Repository
@Transactional("tenantTransactionManager")
public class ContainerTypeCustomRepositoryImpl implements ContainerTypeRepositoryCustom {
//	private final static Logger LOGGER = LoggerFactory.getLogger(ContainerTypeController.class);
	
	@PersistenceContext(unitName = "tenantEntityManager")
	private EntityManager em;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;
	
//	@Override
//	public List<ContainerType> getContainerRequestList(int limit, int offset) {
//
//		List<ContainerType> lContainerRequest = new ArrayList<ContainerType>();
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		lContainerRequest = jdbcTemplate.query(ControllerTypeQueryUtil.GETCONTAINERREQUEST, new BeanPropertyRowMapper<ContainerType>(ContainerType.class));
//
//		return lContainerRequest;
//	}

//	@Override
//	public boolean addContainer(ContainerType objcontainerType) throws CustomException {
//		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		
//		boolean issucces = false;
//		int value = 0;
//		try {
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			int  contIdi = getcontId();
//			String contId = String.valueOf(contIdi);
//			int[] types = new int[] {Types.BIGINT, Types.VARCHAR, Types.BIGINT, Types.VARCHAR };
//			Object[] params = new Object[] {contId, objcontainerType.getContainer_type(), objcontainerType.getGroup_id(), objcontainerType.getDescription() };
//
//			value = jdbcTemplate.update(ControllerTypeQueryUtil.INSERTCONTAINERTYPE, params, types);
//			System.out.println("value +++++++++++++++++++++++++++++" + contId);
//					
//				UserLog userLog = userlogDao.userLogForInsert(objcontainerType, contId, userDetails.getUserId());
//				auditLogDao.auditLogForInsert(objcontainerType, userLog, null);
//				issucces = true;
//	
//
//		} catch (Exception ae) {
//			LOGGER.error("Error in addCodeStandard", ae);
//			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
//		}
//		return issucces;
//
//	}

//	private int getcontId() {
//		int prCode = 0;
//		try {
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			prCode = jdbcTemplate.queryForObject(ControllerTypeQueryUtil.getId, Integer.class);
//			System.out.println("prCode++++++++++++++++" +prCode);
//		} catch (DataAccessException e) {
//			LOGGER.error("Error in FY_CODE Generation", e);
//		}
//		return prCode;
//	}

//	@Override
//	public boolean updateContainer(ContainerType objcontainerType) throws CustomException {
//
//		boolean issucces = false;
//		int value = 0;
//		try {
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			int[] types = new int[] { Types.VARCHAR, Types.BIGINT, Types.VARCHAR, Types.BIGINT };
//			Object[] params = new Object[] { objcontainerType.getContainer_type(), objcontainerType.getGroup_id(), objcontainerType.getDescription(), objcontainerType.getContainer_type_id() };
//			int contTypeIdi = objcontainerType.getContainer_type_id();
//			String contTypeId = String.valueOf(contTypeIdi);
//			ContainerType oldData = getoldData(contTypeIdi);
//			value = jdbcTemplate.update(ControllerTypeQueryUtil.UPDATECONTAINERTYPE, params, types);
//
//			if (value != 0) {
//				issucces = true;
//				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//				UserLog userLog = userlogDao.userLogForUpdate(oldData, objcontainerType, contTypeId, userDetails.getUserId());
//				auditLogDao.auditLogForUpdate(oldData, objcontainerType, userLog, null);
//			}
//
//		} catch (Exception ae) {
//			LOGGER.error("Error in addCodeStandard", ae);
//			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
//		}
//		return issucces;
//
//	}

	
//	public ContainerType getoldData(int contTypeIdi) throws CustomException {
//		try {
//			System.out.println("contTypeIdi"+contTypeIdi);
//			ContainerType obj = jdbcTemplate.queryForObject(ControllerTypeQueryUtil.audit, new Object[] { contTypeIdi },
//					new BeanPropertyRowMapper<ContainerType>(ContainerType.class));
//			return obj;
//		} catch (DataAccessException e) {
//			LOGGER.error("Error in List", e);
//			throw new CustomException("Error in getting obj");
//		}
//	}

//	@Override
//	public boolean deleteContainer(String containerID) throws CustomException {
//
//		boolean issucces = false;
//		int value = 0;
//		try {
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			int container =  Integer.parseInt(containerID);
//			ContainerType objOld = getoldData(container);
//			value = jdbcTemplate.update(ControllerTypeQueryUtil.DELETECONTAINERTYP, container);
//			if (value != 0) {
//				issucces = true;
//				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//				UserLog userLog = userlogDao.userLogForDelete(objOld, containerID, userDetails.getUserId());
//				auditLogDao.auditLogForDelete(objOld, userLog, null);
//			}
//		} catch (DataAccessException e) {
//			LOGGER.error("Error in addCodeStandard", e);
//			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
//		}
//		return issucces;
//
//	}

	@Override
	public boolean checkContainer(ContainerType containerType)  {
		boolean issucces = false;
		int value;
		try {
			Query query = em.createNativeQuery("Select count(CONTAINER_TYPE_ID) from CONTAINER_TYPE where CONTAINER_TYPE =:containerType");
			query.setParameter("containerType", containerType.getContainerType());
			value = ((BigInteger) query.getSingleResult()).intValue();
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			value = jdbcTemplate.queryForInt(ControllerTypeQueryUtil.SELECTCONTAINERTYP, containerType.getContainerType(), containerType.getContainerType());
			if (value == 0) {
				System.out.println("a" + value);
				issucces = true;
			} else {
				issucces = false;
			}
		} catch (DataAccessException e) {
			 e.printStackTrace();
		}
		return issucces;
	}

	@Override
	public boolean checkContainerUpdate(ContainerType containerType)  {
		boolean issucces = false;
		int value;
		try {
			Query query = em.createNativeQuery("Select count(CONTAINER_TYPE_ID) from CONTAINER_TYPE where CONTAINER_TYPE =:containerType");
			query.setParameter("containerType", containerType.getContainerType());
			value = ((BigInteger) query.getSingleResult()).intValue();
			if(value>0){
				int value1 =0;
				query = em.createNativeQuery("Select count(*) from container_type where CONTAINER_TYPE =:containerType and CONTAINER_TYPE_ID= :containerTypeId ");
				query.setParameter("containerType", containerType.getContainerType());
				query.setParameter("containerTypeId", containerType.getContainerTypeId());
				value1 = ((BigInteger) query.getSingleResult()).intValue();
				if (value ==value1) {
					System.out.println("a" + value);
					issucces = true;
				} else  {
					issucces = false;
				}
			}else{
				issucces = true;
			}
			
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			value = jdbcTemplate.queryForInt(ControllerTypeQueryUtil.SELECTCONTAINERTYP, containerType.getContainerType(), containerType.getContainerType());
			
		} catch (DataAccessException e) {
			 e.printStackTrace();
		}
		return issucces;
	}

	@Override
	public Integer getcount(String userId, String password) {
		Integer count=0;
		try {
			
			Query	query = em.createNativeQuery("Select count(*) from user_master where user_name =:userId and user_password= :password ");
				query.setParameter("userId", userId);
				query.setParameter("password", password);
				count = Integer.parseInt((query.getSingleResult().toString()));
			
			
		}catch(NoResultException ex){
			
		}catch (DataAccessException e) {
			 e.printStackTrace();
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return count;
	}
}