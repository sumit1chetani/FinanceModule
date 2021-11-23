package com.dci.hr.attendance.importattendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImportAttendanceServiceImpl implements ImportAttendanceService {
	@Autowired
	ImportAttendanceDAO importAttendanceDAO;

	@Override
	public void uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		importAttendanceDAO.uploadFile(file);

	}/* refer Purchase---->Rate Contract form */
}
