package com.dci.hr.attendance.importattendance;

import org.springframework.web.multipart.MultipartFile;

public interface ImportAttendanceService {
	public void uploadFile(MultipartFile file);
}
