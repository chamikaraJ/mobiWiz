/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.mobiwiz.savesignatureasimage;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;


//import com.mobiwiz.savesignatureasimage.model.*;

@ExposeToClient
public class SaveSignatureAsImage {

    private static final Logger logger = LoggerFactory.getLogger(SaveSignatureAsImage.class);

    @Autowired
    private SecurityService securityService;
    
    private File uploadDirectory = null;
    private String filename = null;

    public String sampleJavaOperation(String name, HttpServletRequest request) {
        logger.debug("Starting sample operation with request url " + request.getRequestURL().toString());
        
        String result = null;
        if (securityService.isAuthenticated()) {
            result = "Hello " + name + ", You are logged in as "+  securityService.getLoggedInUser().getUserName();
        } else {
            result = "Hello " + name + ", You are not authenticated yet!";
        }
        logger.debug("Returning {}", result);
        return result;
    }
    
    public void saveSignature(String base64ImageUrl, String firstName, String lastName, HttpServletRequest request) throws Exception{
        
        String uploadDir = getArchivePath(request.getServletContext().getServletContextName());
        
         Decoder decoder = Base64.getDecoder();
        byte[] decodedByte = decoder.decode(base64ImageUrl.split(",")[1]);
        FileOutputStream fos = new FileOutputStream("MyAudio.webm");
        fos.write(decodedByte);
        fos.close();
    }
    
        private String generateFileName(String firstname, String surname) {
	
	    DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

		StringBuilder sb = new StringBuilder();
	    sb.append(df.format(new Date()));

		if (firstname != null && firstname.length() > 0) {
			sb.append("_").append(firstname.trim().replaceAll("[^\\w]",""));
		}

		if (surname != null && surname.length() > 0) {
		    sb.append("_").append(surname.trim().replaceAll("[^\\w]",""));
	    }

		return sb.toString();
    }
    
    public String getArchivePath(String context){
        
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.home"));
        if(context!=null && context !=""){
            sb.append("/"+context);
        }
        sb.append("/csv");

         String uploadDir = sb.toString();
         
        try{
            File f = new File(uploadDir);
            uploadDirectory = f;
            boolean created = f.mkdirs();
            if(created) {
                logger.info("ARCHIVE FOLDER CREAED :"+ uploadDir);
            }else{
                logger.error("ARCHIVE FOLDER CREATION FAILED");
            }
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return uploadDir;
    }
    

}