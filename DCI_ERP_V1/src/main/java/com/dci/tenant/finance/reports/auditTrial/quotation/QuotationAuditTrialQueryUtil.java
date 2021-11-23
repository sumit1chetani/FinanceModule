package com.dci.tenant.finance.reports.auditTrial.quotation;

public class QuotationAuditTrialQueryUtil {

	public static final String SELECT_EMPLOYEE_LIST = "select EMP_ID as id, EMP_NAME as text from EMPLOYEE_MASTER where status='Y' and login_flag='E'";

	public static String SELECT_QUOTATION_LIST_BY_CUST(QuotationAuditTrialBean bean) {
		System.out.println(bean.getCustomerCode());
		String str = "";
		String sql = "select * from ( SELECT QUOTATION.QUOTATION_NO quotationNo, "
				+ "to_char(QUOTATION.QUOTATION_DT,'dd/mm/yyyy hh24:mm') quotationDate,to_char(QUOTATION.CREATED_DT,'dd/mm/yyyy hh24:mm') createdDate, "
				+ "to_char(QUOTATION.MODIFIED_DT,'dd/mm/yyyy hh24:mm')  modifiedDate, EMPLOYEE_MASTER.EMP_NAME empName, "
				+ " QUOTATION.MODIFIED_BY modifiedBy,GET_EMPNAME(QUOTATION.MODIFIED_BY) modifiedName, GET_EMPNAME(QUOTATION.CREATED_BY) createdName,QUOTATION.CREATED_BY createdBy, "
				+ "QUOTATION_PORT_PAIR.POL pol, QUOTATION_PORT_PAIR.POD pod,"
				+ " MLO_MASTER.MLO_SHORT_NAME customerName "
				+ "FROM   "
				+ "(QUOTATION_PORT_PAIR QUOTATION_PORT_PAIR "
				+ "INNER JOIN (MLO_MASTER MLO_MASTER INNER JOIN QUOTATION QUOTATION ON MLO_MASTER.MLO_CODE=QUOTATION.MLO_ID) ON QUOTATION_PORT_PAIR.QUOTATION_NO=QUOTATION.QUOTATION_NO) INNER JOIN EMPLOYEE_MASTER EMPLOYEE_MASTER ON QUOTATION.CREATED_BY=EMPLOYEE_MASTER.EMP_ID ";
		/*
		 * if (bean.getCustomerCode() != null &&
		 * !bean.getCustomerCode().isEmpty()) {
		 */
		if (bean.getType() != null && !bean.getType().isEmpty() && !bean.getType().equalsIgnoreCase("B")) {
			if (bean.getType().equalsIgnoreCase("C")) {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " QUOTATION.CREATED_BY in ('" + bean.getCustomerCode() + "') ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (QUOTATION.created_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + "  (QUOTATION.created_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			} else {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " QUOTATION.MODIFIED_BY in ('" + bean.getCustomerCode() + "' )";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where ";
					} else {
						str = " and ";
					}
					sql += str + " (QUOTATION.modified_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (QUOTATION.modified_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			}
		} else {
			if (bean.getFromDate() != null && !bean.getFromDate().isEmpty() && bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " where ((QUOTATION.created_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (QUOTATION.created_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " or ((QUOTATION.modified_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (QUOTATION.modified_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				
			} else if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
				sql += " where ((QUOTATION.created_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";
				sql += " or ((QUOTATION.modified_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";

			} else if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				sql += " where ((QUOTATION.created_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				sql += " or((QUOTATION.modified_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
			}
		}
		/* } */
		sql += " ) temp ";
		if (bean.getType().equalsIgnoreCase("B") && bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty())
			sql += " where (createdBy in ('" + bean.getCustomerCode() + "') OR modifiedBy in ('" + bean.getCustomerCode() + "')) ";
		sql += " ORDER BY createdDate DESC";
		return sql;
	}
	public static String SELECT_JVTARIFF_LIST_BY_CUST(QuotationAuditTrialBean bean) {

		System.out.println(bean.getCustomerCode());
		String str = "";
		String sql = "select * from ( SELECT jv_tariff.jv_tariff_NO quotationNo, "
				+ "				to_char(jv_tariff.jv_tariff_DT,'dd/mm/yyyy hh24:mm') quotationDate,to_char(jv_tariff.CREATED_DT,'dd/mm/yyyy hh24:mm') createdDate, "
				+ "				to_char(jv_tariff.MODIFIED_DT,'dd/mm/yyyy hh24:mm')  modifiedDate, EMPLOYEE_MASTER.EMP_NAME empName, "
				+ "				 jv_tariff.MODIFIED_BY modifiedBy,GET_EMPNAME(jv_tariff.MODIFIED_BY) modifiedName, GET_EMPNAME(jv_tariff.CREATED_BY) createdName,jv_tariff.CREATED_BY createdBy, "
				+ "				jv_tariff_port_pair.POL pol, jv_tariff_port_pair.POD pod, "
				+ "				null_or_empty(get_company(customer),customer) customerName "
				+ "				FROM "
				+ "				(jv_tariff_port_pair "
				+ "				 INNER JOIN jv_tariff  ON jv_tariff.jv_tariff_NO=jv_tariff_port_pair.jv_tariff_NO) INNER JOIN EMPLOYEE_MASTER EMPLOYEE_MASTER ON jv_tariff.CREATED_BY=EMPLOYEE_MASTER.EMP_ID";
		/*
		 * if (bean.getCustomerCode() != null &&
		 * !bean.getCustomerCode().isEmpty()) {
		 */
		if (bean.getType() != null && !bean.getType().isEmpty() && !bean.getType().equalsIgnoreCase("B")) {
			if (bean.getType().equalsIgnoreCase("C")) {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " jv_tariff.CREATED_BY in ('" + bean.getCustomerCode() + "') ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (jv_tariff.created_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + "  (jv_tariff.created_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			} else {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " jv_tariff.MODIFIED_BY in ('" + bean.getCustomerCode() + "' )";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where ";
					} else {
						str = " and ";
					}
					sql += str + " (jv_tariff.modified_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (jv_tariff.modified_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			}
		} else {
			if (bean.getFromDate() != null && !bean.getFromDate().isEmpty() && bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " where ((jv_tariff.created_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (jv_tariff.created_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " or ((jv_tariff.modified_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (jv_tariff.modified_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				
			} else if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
				sql += " where ((jv_tariff.created_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";
				sql += " or ((jv_tariff.modified_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";

			} else if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				sql += " where ((jv_tariff.created_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				sql += " or((jv_tariff.modified_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
			}
		}
		/* } */
		sql += " ) temp ";
		if (bean.getType().equalsIgnoreCase("B") && bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty())
			sql += " where (createdBy in ('" + bean.getCustomerCode() + "') OR modifiedBy in ('" + bean.getCustomerCode() + "')) ";
		sql += " ORDER BY createdDate DESC";
		return sql;
	
	}
	
	
	public static String SELECT_PURCHASEQUOT_LIST_BY_CUST(QuotationAuditTrialBean bean) {

		System.out.println(bean.getCustomerCode());
		String str = "";
		String sql ="select * from ( SELECT purchase_quotation.quotation_no quotationNo, "
				+ "								to_char(purchase_quotation.quotation_DT,'dd/mm/yyyy hh24:mm') quotationDate,to_char(purchase_quotation.CREATED_DT,'dd/mm/yyyy hh24:mm') createdDate, "
				+ "								to_char(purchase_quotation.MODIFIED_DT,'dd/mm/yyyy hh24:mm')  modifiedDate, EMPLOYEE_MASTER.EMP_NAME empName, "
				+ "								 purchase_quotation.MODIFIED_BY modifiedBy,GET_EMPNAME(purchase_quotation.MODIFIED_BY) modifiedName, GET_EMPNAME(purchase_quotation.CREATED_BY) createdName,purchase_quotation.CREATED_BY createdBy, "
				+ "								purchase_quotation_port_pair.POL pol, purchase_quotation_port_pair.POD pod, "
				+ "								get_vendor_short_name(vendor_id) customerName "
				+ "								FROM "
				+ "								(purchase_quotation_port_pair "
				+ "								 INNER JOIN purchase_quotation  ON purchase_quotation.quotation_no=purchase_quotation_port_pair.quotation_no) INNER JOIN EMPLOYEE_MASTER EMPLOYEE_MASTER ON purchase_quotation.CREATED_BY=EMPLOYEE_MASTER.EMP_ID";
		/*
		 * if (bean.getCustomerCode() != null &&
		 * !bean.getCustomerCode().isEmpty()) {
		 */
		if (bean.getType() != null && !bean.getType().isEmpty() && !bean.getType().equalsIgnoreCase("B")) {
			if (bean.getType().equalsIgnoreCase("C")) {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " purchase_quotation.CREATED_BY in ('" + bean.getCustomerCode() + "') ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (purchase_quotation.created_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + "  (purchase_quotation.created_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			} else {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " purchase_quotation.MODIFIED_BY in ('" + bean.getCustomerCode() + "' )";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where ";
					} else {
						str = " and ";
					}
					sql += str + " (purchase_quotation.modified_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (purchase_quotation.modified_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			}
		} else {
			if (bean.getFromDate() != null && !bean.getFromDate().isEmpty() && bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " where ((purchase_quotation.created_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (purchase_quotation.created_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " or ((purchase_quotation.modified_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (purchase_quotation.modified_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				
			} else if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
				sql += " where ((purchase_quotation.created_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";
				sql += " or ((purchase_quotation.modified_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";

			} else if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				sql += " where ((purchase_quotation.created_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				sql += " or((purchase_quotation.modified_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
			}
		}
		/* } */
		sql += " ) temp ";
		if (bean.getType().equalsIgnoreCase("B") && bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty())
			sql += " where (createdBy in ('" + bean.getCustomerCode() + "') OR modifiedBy in ('" + bean.getCustomerCode() + "')) ";
		sql += " ORDER BY createdDate DESC";
		return sql;
	
	}
	
	public static String SELECT_QUOTATION_LIST_BY_CUST_SEA(QuotationAuditTrialBean bean) {
		System.out.println(bean.getCustomerCode());
		String str = "";
		String sql = " select s.qttn_no_tcd quotationNo, to_char(s.qttn_dt,'dd/mm/yyyy') quotationDate, to_char(s.crtd_dt,'dd/mm/yyyy hh24:mm') createdDate, GET_EMPNAME(s.crtd_by) createdName, GET_EMPNAME(s.mdfd_by) modifiedName, to_char(s.mdfd_dt,'dd/mm/yyyy hh24:mm') modifiedDate, p.prt_icd_nam pol, p1.prt_icd_nam pod, sp.srvc_prtnr_nam customerName from sea_quotation s inner join port_icd p on p.prt_icd_id = s.pol_id inner join port_icd p1 on p1.prt_icd_id = s.pod_id inner join service_partner sp on sp.srvc_prtnr_bin = s.cstmr_bin ";

		if (bean.getType() != null && !bean.getType().isEmpty() && !bean.getType().equalsIgnoreCase("B")) {
			if (bean.getType().equalsIgnoreCase("C")) {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " s.crtd_by in ('" + bean.getCustomerCode() + "') ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (s.crtd_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + "  (s.crtd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			} else {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " s.mdfd_by in ('" + bean.getCustomerCode() + "' )";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where ";
					} else {
						str = " and ";
					}
					sql += str + " (s.mdfd_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (s.mdfd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			}
		} else {
			if (bean.getFromDate() != null && !bean.getFromDate().isEmpty() && bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " where ((s.crtd_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (s.crtd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " or ((s.mdfd_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (s.mdfd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				
			} else if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
				sql += " where ((s.crtd_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";
				sql += " or ((s.mdfd_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";

			} else if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				sql += " where ((s.crtd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				sql += " or((s.mdfd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
			}
		}
	
		if (bean.getType().equalsIgnoreCase("B") && bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty())
			if (!sql.contains("where")) {
			sql += " where (s.crtd_by in ('" + bean.getCustomerCode() + "') OR s.mdfd_by in ('" + bean.getCustomerCode() + "')) ";
			}else{
			sql += " and (s.crtd_by in ('" + bean.getCustomerCode() + "') OR s.mdfd_by in ('" + bean.getCustomerCode() + "')) ";
			}
		sql += " ORDER BY createdDate DESC";
		return sql;
	}
	
	public static String SELECT_QUOTATION_LIST_BY_CUST_AIR(QuotationAuditTrialBean bean) {
		System.out.println(bean.getCustomerCode());
		String str = "";
		String sql = " select s.qttn_no_tcd quotationNo, to_char(s.qttn_dt,'dd/mm/yyyy') quotationDate, to_char(s.crtd_dt,'dd/mm/yyyy hh24:mm') createdDate, GET_EMPNAME(s.crtd_by) createdName, GET_EMPNAME(s.mdfd_by) modifiedName, to_char(s.mdfd_dt,'dd/mm/yyyy hh24:mm') modifiedDate, p.iata_nam pol, p1.iata_nam pod, sp.srvc_prtnr_nam customerName from air_quotation s inner join iata p on p.iata_id = s.pol_id inner join iata p1 on p1.iata_id = s.pod_id inner join service_partner sp on sp.srvc_prtnr_bin = s.cstmr_bin ";

		if (bean.getType() != null && !bean.getType().isEmpty() && !bean.getType().equalsIgnoreCase("B")) {
			if (bean.getType().equalsIgnoreCase("C")) {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " s.crtd_by in ('" + bean.getCustomerCode() + "') ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (s.crtd_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + "  (s.crtd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			} else {
				if (bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()) {
					str = " where ";
					sql += str + " s.mdfd_by in ('" + bean.getCustomerCode() + "' )";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where ";
					} else {
						str = " and ";
					}
					sql += str + " (s.mdfd_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					if (str.isEmpty()) {
						str = " where";
					} else {
						str = " and ";
					}
					sql += str + " (s.mdfd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
				}
			}
		} else {
			if (bean.getFromDate() != null && !bean.getFromDate().isEmpty() && bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " where ((s.crtd_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (s.crtd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
					sql += " or ((s.mdfd_dt)::date >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
				}
				if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
					sql += " and (s.mdfd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				}
				
			} else if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
				sql += " where ((s.crtd_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";
				sql += " or ((s.mdfd_dt) >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy')) ";

			} else if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				sql += " where ((s.crtd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
				sql += " or((s.mdfd_dt)::date <= to_date('" + bean.getToDate() + "','dd/mm/yyyy')) ";
			}
		}
	
		if (bean.getType().equalsIgnoreCase("B") && bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty())
			if (!sql.contains("where")) {
			sql += " where (s.crtd_by in ('" + bean.getCustomerCode() + "') OR s.mdfd_by in ('" + bean.getCustomerCode() + "')) ";
			}else{
			sql += " and (s.crtd_by in ('" + bean.getCustomerCode() + "') OR s.mdfd_by in ('" + bean.getCustomerCode() + "')) ";
			}
		sql += " ORDER BY createdDate DESC";
		return sql;
	}
}
