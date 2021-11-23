package com.dci.common.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Repository;

import sun.misc.BASE64Encoder;

@Repository
public class Base64 {

	public String base64(String localPath, String imageUrl) throws IOException {
		String file = imageUrl;
		String[] filePath = file.split("/");
		String[] ext = filePath[1].split("\\.");

		BufferedImage img = ImageIO.read(new File(localPath + filePath[1]));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(img, ext[ext.length - 1], bos);
		byte[] imageBytes = bos.toByteArray();

		BASE64Encoder encoder = new BASE64Encoder();
		return "data:image/" + ext[ext.length - 1] + ";base64," + encoder.encode(imageBytes);
	}

}
