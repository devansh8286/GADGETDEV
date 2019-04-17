package com.project.Frontend.Util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUplodeUtility {
	private static final String ABS_PATH = "E:\\ONLINE-SHOP\\Ecommerce\\Online-Shop\\Frontend\\src\\main\\webapp\\assets\\image\\";
	private static String REAL_PATH = "";
	private static final Logger logger = LoggerFactory.getLogger(FileUplodeUtility.class);

	public static void UploadFile(HttpServletRequest request, MultipartFile file, String code) {

		// get the realPath
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/image/");
		logger.info(REAL_PATH);
		
		//to make sure all the directory exist
		//create directory
		if(!new File(ABS_PATH).exists()) {
			//create new Directory
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()) {
			//create new Directory
			new File(REAL_PATH).mkdirs();
		}
		try {
			//server upload
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			//project directory file
			file.transferTo(new File(ABS_PATH+code+".jpg"));		
		}catch(IOException e) {
		
		
		}
		
		
	}

}
