package com.dci.hr.attendance.importattendance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;



@RestController
@RequestMapping(value = "hrms/hr/attendance")
public class ImportAttendanceController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ImportAttendanceController.class);

	@Autowired
	private ImportAttendanceService importAttendanceService;

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody ImportAttendanceResultBean uploadFile(MultipartFile file) throws CustomException {
		ImportAttendanceResultBean importAttendanceResultBean = new ImportAttendanceResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					importAttendanceService.uploadFile(file);
					importAttendanceResultBean.setSuccess(true);
				} else {
					importAttendanceResultBean.setSuccess(false);
				}

			} else {
				importAttendanceResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return importAttendanceResultBean;
	}
}
