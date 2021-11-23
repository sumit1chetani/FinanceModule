package com.dci.master.template;

public interface TemplateDAO {

	TemplateResultBean getList();

	boolean getSave(TemplateBean bean);

	TemplateBean getTemplateDataEdit(int templateId);

	boolean update(TemplateBean bean);

	boolean delete(int templateId);

	TemplateBean sampleTemplate(String templateId);

	TemplateBean blTemplate(String subject, String emailBody, String blno, String userId);

}
