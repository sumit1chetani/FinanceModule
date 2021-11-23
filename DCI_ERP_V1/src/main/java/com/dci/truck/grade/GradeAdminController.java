package com.dci.truck.grade;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "{tenantid}/hrms/master/gradeadmin")
public class GradeAdminController {

	private final static Logger LOGGER = LoggerFactory.getLogger(GradeAdminController.class);

	@Autowired
	private GradeAdminService gradeService;

	@RequestMapping(value = "/list")
	public GradeAdminResultBean getGradeList() {
		GradeAdminResultBean gradeResultBean = new GradeAdminResultBean();
		try {

			gradeResultBean.setGradeList(gradeService.getGradeList());
			gradeResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return gradeResultBean;

	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody GradeAdmin grade) {
		GradeAdminResultBean gradeResultBean = new GradeAdminResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = gradeService.insertGrade(grade);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody GradeAdmin grade) {
		GradeAdminResultBean gradeResultBean = new GradeAdminResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = gradeService.updateGrade(grade);
		} catch (CustomException e) {
			gradeResultBean.setSuccess(false);
			gradeResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody GradeAdminResultBean deleteGrade(@RequestBody Integer gradeId) {
		GradeAdminResultBean gradeResultBean = new GradeAdminResultBean();
		try {
			gradeService.deleteGrade(gradeId);
			gradeResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gradeResultBean;
	}

	@RequestMapping(value = "/edit")
	public GradeAdminResultBean getGradeById(@RequestBody Integer gradeId) {
		GradeAdminResultBean gradeResultBean = new GradeAdminResultBean();
		try {
			GradeAdmin grade = gradeService.getGradeById(gradeId);
			gradeResultBean.setGrade(grade);
			gradeResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gradeResultBean;
	}

	@RequestMapping(value = "/companyList")
	public GradeAdminResultBean getCompanyList() {
		GradeAdminResultBean gradeResultBean = new GradeAdminResultBean();
		try {
			gradeResultBean = gradeService.getCompanyList();
			gradeResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gradeResultBean;
	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody GradeAdminResultBean uploadFile(MultipartFile file) throws CustomException {
		GradeAdminResultBean gradeResultBean = new GradeAdminResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					gradeService.uploadFile(file);
					gradeResultBean.setSuccess(true);
				} else {
					gradeResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				gradeResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gradeResultBean;
	}

}

