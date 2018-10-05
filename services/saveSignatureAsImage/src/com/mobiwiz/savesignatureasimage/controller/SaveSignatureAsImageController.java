/**
 *This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.mobiwiz.savesignatureasimage.controller;

import com.mobiwiz.savesignatureasimage.SaveSignatureAsImage;
import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import java.lang.Exception;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/saveSignatureAsImage")
public class SaveSignatureAsImageController {

    @Autowired
    private SaveSignatureAsImage savesignatureAsImage;

    @RequestMapping(value = "/archivePath", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String getArchivePath(@RequestParam(value = "context", required = false) String context) {
        return savesignatureAsImage.getArchivePath(context);
    }

    @RequestMapping(value = "/sampleJavaOperation", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String sampleJavaOperation(@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
        return savesignatureAsImage.sampleJavaOperation(name, request);
    }

    @RequestMapping(value = "/saveSignature", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public void saveSignature(@RequestParam(value = "base64ImageUrl", required = false) String base64ImageUrl, @RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName, HttpServletRequest request) throws Exception {
        savesignatureAsImage.saveSignature(base64ImageUrl, firstName, lastName, request);
    }
}
