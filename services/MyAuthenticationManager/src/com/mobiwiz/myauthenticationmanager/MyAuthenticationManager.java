/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.mobiwiz.myauthenticationmanager;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

import java.util.Arrays;
import com.wavemaker.runtime.security.WMCustomAuthenticationManager;
import com.wavemaker.runtime.security.WMUser;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import com.wavemaker.runtime.security.AuthRequestContext;

//import com.mobiwiz.myauthenticationmanager.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 *
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 *
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 */
@ExposeToClient
public class MyAuthenticationManager implements WMCustomAuthenticationManager {
    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationManager.class);
    @Autowired
      private SecurityService securityService;
      private static final String GOOGLE = "google";
    @Override
     public WMUser authenticate(AuthRequestContext authRequestContext) {
        HttpServletRequest httpServletRequest = authRequestContext.getHttpServletRequest();
        boolean isSecurityUrl = httpServletRequest.getRequestURI().endsWith("j_spring_security_check");
        WMUser user = null;
        //String securityProvider = httpServletRequest.getParameter("j_username");
        String token = httpServletRequest.getParameter("j_password"); //getting the token from Prefab
        logger.info(" --------- Token is "+token);
        if (isSecurityUrl && token != null) {
               Google google = new GoogleTemplate(token); //passing the token to Google
               Person person = google.plusOperations().getGoogleProfile();
               logger.info("----------------- -- - ---   -----------"+ person.getDisplayName());
               user = new WMUser(token, person.getDisplayName(), Arrays.asList("user")); // returning the logged in user object    
        }
        return user;
    }
}