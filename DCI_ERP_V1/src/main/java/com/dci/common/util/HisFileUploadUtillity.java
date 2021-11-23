package com.dci.common.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

/**
 * 
 * Common For BackUp file Upload For Any Extension Type Eg(.jpg,.xlsx)
 * 
 */
public class HisFileUploadUtillity {

	/*
	 * Required Fields Uploaded File ,FileAbsolutePath, ServerPath WithOut File
	 * Name
	 */

	public static String uploadFileHandler(MultipartFile file, String fileAbsolutePath, String serverPath) {

		String url = "";
		try {
			File dirCreatory = new File(fileAbsolutePath);
			if (!dirCreatory.exists()) {
				dirCreatory.mkdir();
			}

			if (file.getSize() > 0) {
				String currentTimeStamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString() + "."
						+ FilenameUtils.getExtension(file.getOriginalFilename());
				String fileNameWithOutExt = FilenameUtils.removeExtension(file.getOriginalFilename());
				String destinationFileName = UUID.randomUUID().toString() + "_" + fileNameWithOutExt + "_" + currentTimeStamp;
				File destinationFile = new File(fileAbsolutePath + destinationFileName);
				Files.write(file.getBytes(), destinationFile);
				url = serverPath + File.separator + destinationFileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	public static String uploadFileHandler(MultipartFile file, String fileAbsolutePath, String serverPath, String fileName) {

		String url = "";
		try {
			File dirCreatory = new File(fileAbsolutePath);
			if (!dirCreatory.exists()) {
				dirCreatory.mkdir();
			}
			if (file.getSize() > 0) {
				String currentTimeStamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString() + "."
						+ FilenameUtils.getExtension(file.getOriginalFilename());
				String destinationFileName = UUID.randomUUID().toString() + "_" + fileName + "_" + currentTimeStamp;
				File destinationFile = new File(fileAbsolutePath + destinationFileName);
				Files.write(file.getBytes(), destinationFile);
				url = serverPath + File.separator + destinationFileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

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
				String destinationFileName = fileName + "_" + currentTimeStamp;
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

	public static String uploadImgFileHandler(MultipartFile file, String fileAbsolutePath, String serverPath, String fileName) {

		String url = "";
		try {
			File dirCreatory = new File(fileAbsolutePath);
			if (!dirCreatory.exists()) {
				dirCreatory.mkdir();
			}
			if (file.getSize() > 0) {
				String currentTimeStamp = FilenameUtils.getExtension(file.getOriginalFilename());
				String destinationFileName = fileName + "." + currentTimeStamp;
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
