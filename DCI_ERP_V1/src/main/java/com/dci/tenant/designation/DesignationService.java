package com.dci.tenant.designation;



import java.util.List;

public interface DesignationService {

	List<DesignationBean> getDesignationList(int limit, int offset) throws Exception;

	public boolean addDesignation(DesignationBean objDesignationBean) throws Exception;

	public boolean updateDesignation(DesignationBean objDesignationBean) throws Exception;

	public boolean deleteDesignation(String dCode) throws Exception;

	public DesignationBean getdesignationValues(String desgnCode) throws Exception;

	public List getDesignation();

}
