package com.dci.master.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

	/*
	 * @Value("${file.imgFiles.absolutePath}") private String
	 * getFilePropertyUrl;
	 * 
	 * @Value("${file.imgFiles.serverPath}") private String getFileServerPath;
	 */

	@Autowired
	TemplateDAO DAO;

	@Override
	public TemplateResultBean getList() {
		// TODO Auto-generated method stub
		return DAO.getList();
	}

	@Override
	public boolean getSave(TemplateBean bean) {
		// TODO Auto-generated method stub
		return DAO.getSave(bean);
	}

	@Override
	public TemplateBean getTemplateDataEdit(int templateId) {
		// TODO Auto-generated method stub
		return DAO.getTemplateDataEdit(templateId);
	}

	@Override
	public boolean update(TemplateBean bean) {
		// TODO Auto-generated method stub
		return DAO.update(bean);
	}

	@Override
	public boolean delete(int templateId) {
		// TODO Auto-generated method stub
		return DAO.delete(templateId);
	}

	@Override
	public TemplateBean sampleTemplate(String templateId) {
		// TODO Auto-generated method stub
		return DAO.sampleTemplate(templateId);

	}

}
