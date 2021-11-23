package com.dci.master.template;

public class TemplateQueryUtil {

	public static final String GET_TEMPLATELIST = "";
	public static final String GET_TEMPLATELIST_User = "";
	public static final String INSERT_TEMPLATEDATA = "INSERT INTO template_hdr"
			+ "(template_name ,description,subject, html_version ,status,ccmail,bccmail,created_by,created_dt,tomail)"
			+ " VALUES (:template_name,:description,:subjct,:html_version,:status,:ccmail,:bccmail,:createdBy,now(),:tomail)";
	public static final String UPDATE_TEMPLATEDATA = " UPDATE template_hdr  SET  template_name=:template_name,description=:description,html_version=:html_version,status=:status,subject=:subject,ccmail=:ccmail,bccmail=:bccmail,modified_by=:modifiedBy,modified_dt=now(),tomail=:tomail WHERE id=:id ";
	public static final String EDIT_TEMPLATEHDRDATA = " select id as id,template_name as templateName,subject as subject,description as description,html_version as html_version,ccmail as ccmail,bccmail as bccmail,tomail as tomail from template_hdr where id =? ";
	public static final String GET_LIST = "select id as id,template_name as templateName,subject as subject,description as description,ccmail as ccmail,bccmail as bccmail from template_hdr";
	public static final String DELETE = "delete from template_hdr where id =? ";
	public static final String GET_TEMPLATE_DATE = " select template_name as templateName,subject as subject, description as description,ccmail as ccmail,bccmail as bccmail,html_version as content,tomail as tomail from template_hdr where  template_name =? ";
	public static final String GET_DISCHARGENOTICE_TEMPLATE = " select template_name as templateName,subject as subject, description as description,ccmail as ccmail,bccmail as bccmail,html_version as content  from template_hdr where  template_name =? ";

}
