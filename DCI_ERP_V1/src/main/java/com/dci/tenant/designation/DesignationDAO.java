package com.dci.tenant.designation;



import java.util.List;

public interface DesignationDAO {

	List<DesignationBean> getDesignationList(int limit, int offset) throws Exception;

	public boolean addDesignation(DesignationBean objDesignationBean) throws Exception;

	public boolean updateDesignation(DesignationBean objDesignationBean) throws Exception;

	public boolean deleteDesignation(String dCode) throws Exception;

	public List getDesignation();

	public DesignationBean getdesignationValues(String desgnCode) throws Exception;

}
