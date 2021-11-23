package com.dci.common.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

/**
 *
 * Common For BackUp file Upload For Any Extension Type Eg(.jpg,.xlsx)
 *
 */
public class FileUploadUtillity {

	/*
	 * Required Fields Uploaded File ,FileAbsolutePath, ServerPath WithOut File
	 * Name
	 */

	public static String uploadProfileImage(MultipartFile file, String fileAbsolutePath) {

		String destinationFileName = "";
		try {
			File dirCreatory = new File(fileAbsolutePath);
			if (!dirCreatory.exists()) {
				dirCreatory.mkdir();
			}

			if (file.getSize() > 0) {
				String currentTimeStamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString() + "."
						+ FilenameUtils.getExtension(file.getOriginalFilename());
				String fileNameWithOutExt = FilenameUtils.removeExtension(file.getOriginalFilename());
				destinationFileName = UUID.randomUUID().toString() + "_" + fileNameWithOutExt + "_" + currentTimeStamp;
				destinationFileName = destinationFileName.replace(CommonUtil.spaceChar, CommonUtil.underScoreChar)
						.replace(CommonUtil.hypenChar, CommonUtil.underScoreChar).replace(CommonUtil.colonChar, CommonUtil.underScoreChar);
				File destinationFile = new File(fileAbsolutePath + destinationFileName);
				BufferedImage img = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
				BufferedImage scaledImg = Scalr.resize(img, Method.QUALITY, 40, 40, Scalr.OP_ANTIALIAS);
				ImageIO.write(scaledImg, "jpg", destinationFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destinationFileName;
	}

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
				String destinationFileName = fileNameWithOutExt + "_" + currentTimeStamp;
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

	public static String uploadFileHandlerWithOutRandomNumber(MultipartFile file, String fileAbsolutePath, String serverPath, String fileName) {

		String url = "";
		try {
			File dirCreatory = new File(fileAbsolutePath);
			if (!dirCreatory.exists()) {
				dirCreatory.mkdir();
			}
			if (file.getSize() > 0) {
				String destinationFileName = fileName;
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
