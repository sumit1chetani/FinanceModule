package com.dci.tenant.finance.profitandlossnew;

import java.util.List;

public class ProfitandLossJobOrderReport {

	public Integer jb_bin;
	public Integer jb_md_id;
	public Integer assgnd_by;
	public Integer shppr_bin;
	public Integer cnsgn_bin;
	public String jb_no_tcd;
	public String branch;
	public String term;

	public String getCnsgnName() {
		return cnsgnName;
	}

	public void setCnsgnName(String cnsgnName) {
		this.cnsgnName = cnsgnName;
	}

	public String getPolName() {
		return polName;
	}

	public void setPolName(String polName) {
		this.polName = polName;
	}

	public String getPodName() {
		return podName;
	}

	public void setPodName(String podName) {
		this.podName = podName;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getDstnName() {
		return dstnName;
	}

	public void setDstnName(String dstnName) {
		this.dstnName = dstnName;
	}

	public String cnsgnName;
	public String polName;
	public String podName;
	public String originName;
	public String dstnName;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String sales;

	public String service;

	public String status;

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String aol;
	public String aod;
	public String pol;
	public String pod;
	public String sls_prsn_nam;
	public String statusi;

	public String getStatusi() {
		return statusi;
	}

	public void setStatusi(String statusi) {
		this.statusi = statusi;
	}

	public Integer sls_typ_id;
	public Integer jb_stts_id;

	public String branchName;
	public String cmmdty_nam;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String jobName;

	public String getAol() {
		return aol;
	}

	public void setAol(String aol) {
		this.aol = aol;
	}

	public String getAod() {
		return aod;
	}

	public void setAod(String aod) {
		this.aod = aod;
	}

	public String getPol() {
		return pol;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String fromDate;
	public String toDate;
	public List lCustomerType;

	public String customerType;

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public List getlCustomerType() {
		return lCustomerType;
	}

	public void setlCustomerType(List lCustomerType) {
		this.lCustomerType = lCustomerType;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String brnch_id;
	public String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String jb_dt;
	public String vssl_vyg_tcd;
	public Integer orgn_id;
	public Integer dstntn_id;
	public String flght_no_nam;
	public String arrvl_dt;
	public Integer pod_id;
	public Integer pol_id;
	public String igm_no;
	public String to_nam;
	public Integer ntfy_prty_bin;
	public String crtd_by;
	public String mode;

	public Integer cstmr_bin;

	public Integer getJb_md_id() {
		return jb_md_id;
	}

	public void setJb_md_id(Integer jb_md_id) {
		this.jb_md_id = jb_md_id;
	}

	public Integer getAssgnd_by() {
		return assgnd_by;
	}

	public void setAssgnd_by(Integer assgnd_by) {
		this.assgnd_by = assgnd_by;
	}

	public Integer getShppr_bin() {
		return shppr_bin;
	}

	public void setShppr_bin(Integer shppr_bin) {
		this.shppr_bin = shppr_bin;
	}

	public String getJb_no_tcd() {
		return jb_no_tcd;
	}

	public void setJb_no_tcd(String jb_no_tcd) {
		this.jb_no_tcd = jb_no_tcd;
	}

	public String getSls_prsn_nam() {
		return sls_prsn_nam;
	}

	public void setSls_prsn_nam(String sls_prsn_nam) {
		this.sls_prsn_nam = sls_prsn_nam;
	}

	public Integer getSls_typ_id() {
		return sls_typ_id;
	}

	public void setSls_typ_id(Integer sls_typ_id) {
		this.sls_typ_id = sls_typ_id;
	}

	public Integer getJb_stts_id() {
		return jb_stts_id;
	}

	public void setJb_stts_id(Integer jb_stts_id) {
		this.jb_stts_id = jb_stts_id;
	}

	public String getCmmdty_nam() {
		return cmmdty_nam;
	}

	public void setCmmdty_nam(String cmmdty_nam) {
		this.cmmdty_nam = cmmdty_nam;
	}

	public String getBrnch_id() {
		return brnch_id;
	}

	public void setBrnch_id(String brnch_id) {
		this.brnch_id = brnch_id;
	}

	public String getJb_dt() {
		return jb_dt;
	}

	public void setJb_dt(String jb_dt) {
		this.jb_dt = jb_dt;
	}

	public Integer getJb_bin() {
		return jb_bin;
	}

	public void setJb_bin(Integer jb_bin) {
		this.jb_bin = jb_bin;
	}

	public String getVssl_vyg_tcd() {
		return vssl_vyg_tcd;
	}

	public void setVssl_vyg_tcd(String vssl_vyg_tcd) {
		this.vssl_vyg_tcd = vssl_vyg_tcd;
	}

	public Integer getOrgn_id() {
		return orgn_id;
	}

	public void setOrgn_id(Integer orgn_id) {
		this.orgn_id = orgn_id;
	}

	public Integer getDstntn_id() {
		return dstntn_id;
	}

	public void setDstntn_id(Integer dstntn_id) {
		this.dstntn_id = dstntn_id;
	}

	public String getFlght_no_nam() {
		return flght_no_nam;
	}

	public void setFlght_no_nam(String flght_no_nam) {
		this.flght_no_nam = flght_no_nam;
	}

	public String getArrvl_dt() {
		return arrvl_dt;
	}

	public void setArrvl_dt(String arrvl_dt) {
		this.arrvl_dt = arrvl_dt;
	}

	public Integer getPod_id() {
		return pod_id;
	}

	public void setPod_id(Integer pod_id) {
		this.pod_id = pod_id;
	}

	public Integer getPol_id() {
		return pol_id;
	}

	public void setPol_id(Integer pol_id) {
		this.pol_id = pol_id;
	}

	public String getIgm_no() {
		return igm_no;
	}

	public void setIgm_no(String igm_no) {
		this.igm_no = igm_no;
	}

	public Integer getCnsgn_bin() {
		return cnsgn_bin;
	}

	public void setCnsgn_bin(Integer cnsgn_bin) {
		this.cnsgn_bin = cnsgn_bin;
	}

	public String getTo_nam() {
		return to_nam;
	}

	public void setTo_nam(String to_nam) {
		this.to_nam = to_nam;
	}

	public Integer getCstmr_bin() {
		return cstmr_bin;
	}

	public void setCstmr_bin(Integer cstmr_bin) {
		this.cstmr_bin = cstmr_bin;
	}

	public Integer getNtfy_prty_bin() {
		return ntfy_prty_bin;
	}

	public void setNtfy_prty_bin(Integer ntfy_prty_bin) {
		this.ntfy_prty_bin = ntfy_prty_bin;
	}

	public String getCrtd_by() {
		return crtd_by;
	}

	public void setCrtd_by(String crtd_by) {
		this.crtd_by = crtd_by;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCrtd_dt() {
		return crtd_dt;
	}

	public void setCrtd_dt(String crtd_dt) {
		this.crtd_dt = crtd_dt;
	}

	public String getMdfd_by() {
		return mdfd_by;
	}

	public void setMdfd_by(String mdfd_by) {
		this.mdfd_by = mdfd_by;
	}

	public String getMdfd_dt() {
		return mdfd_dt;
	}

	public void setMdfd_dt(String mdfd_dt) {
		this.mdfd_dt = mdfd_dt;
	}

	public String getIgm_dt() {
		return igm_dt;
	}

	public void setIgm_dt(String igm_dt) {
		this.igm_dt = igm_dt;
	}

	public String getItm_no() {
		return itm_no;
	}

	public void setItm_no(String itm_no) {
		this.itm_no = itm_no;
	}

	public Integer getJb_srvc_id() {
		return jb_srvc_id;
	}

	public void setJb_srvc_id(Integer jb_srvc_id) {
		this.jb_srvc_id = jb_srvc_id;
	}

	public String getCan_rmrks_vcr() {
		return can_rmrks_vcr;
	}

	public void setCan_rmrks_vcr(String can_rmrks_vcr) {
		this.can_rmrks_vcr = can_rmrks_vcr;
	}

	public String crtd_dt;
	public String mdfd_by;
	public String mdfd_dt;
	public String igm_dt;
	public String itm_no;
	public Integer jb_srvc_id;
	public String can_rmrks_vcr;

	public List lcreditCategory;
	public List lcategory;

	public List getLcreditCategory() {
		return lcreditCategory;
	}

	public void setLcreditCategory(List lcreditCategory) {
		this.lcreditCategory = lcreditCategory;
	}

	public List getLcategory() {
		return lcategory;
	}

	public void setLcategory(List lcategory) {
		this.lcategory = lcategory;
	}

}
