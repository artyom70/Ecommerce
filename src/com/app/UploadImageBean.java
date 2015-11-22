package com.app;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public class UploadImageBean {
	public String uploadImage(String path, String resaizePath,Part part, ServletContext context) throws IOException {
		OutputStream out = null;
		InputStream in = null;
		String fileName = getFileName(part);
		String mimeType = context.getMimeType(fileName);
		if (!mimeType.startsWith("image/")) {
		    return null;
		}
        String fileType = fileName.substring(fileName.length()-3);
        int rand = (int) (Math.random()*10000000);
    	String fileGenName = rand + "_" + rand + "." + fileType;
		out = new FileOutputStream(new File(path + File.separator + fileGenName));
		in = part.getInputStream();
		int read = 0;
		
		byte[] bytes = new byte[1024];
		
		while((read = in.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
        BufferedImage originalImage = ImageIO.read(new File(path + File.separator + fileGenName));//change path to where file is located
        int resizeWidth = 150;
        int resizeHeight = 210;
        int height = originalImage.getHeight(null);
        int width = originalImage.getWidth(null);
        if(width > resizeWidth && height > resizeHeight) {
        	width = width * resizeHeight / height;
        }
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        BufferedImage resizeImageJpg = resizeImage(originalImage, type, width, resizeHeight);
        ImageIO.write(resizeImageJpg, fileType, new File(resaizePath + File.separator + fileGenName)); //change path where you want it saved
		out.close();
		return fileGenName;

	}
	private BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
	    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	    Graphics2D g = resizedImage.createGraphics();
	    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	    g.dispose();
 
	    return resizedImage;
	}
	private String getFileName(final Part part) {
		String header = part.getHeader("content-disposition");
		for(String element : header.split(";")) {
			if(element.trim().startsWith("filename")) {
				return element.substring(element.indexOf("=")+1).trim().replace("\"", ""); 
			}
		}
		return null;
	}
}
