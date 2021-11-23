package com.dci.tenant.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

@RestController
@RequestMapping(value = "app/common")
public class FileUploadUtill {

	// Without Random number

	public static String uploadFileHandlerWithOutRandom(MultipartFile file, String fileAbsolutePath, String serverPath, String fileName) {

		String url = "";
		try {
			File dirCreatory = new File(fileAbsolutePath);
			if (!dirCreatory.exists()) {
				dirCreatory.mkdir();
			}
			if (file.getSize() > 0) {
				String currentTimeStamp = "." + FilenameUtils.getExtension(file.getOriginalFilename());
				//String destinationFileName = fileName + "_" + currentTimeStamp;
				String destinationFileName = file.getOriginalFilename();
				File destinationFile = new File(fileAbsolutePath + destinationFileName);
				Files.write(file.getBytes(), destinationFile);
				url = serverPath + File.separator + destinationFileName;
				System.out.println("serverpath is" + serverPath);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}
