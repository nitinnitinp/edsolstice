package com.edsolstice.educationportal.rest.app.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edsolstice.educationportal.rest.app.service.FileUploadService;


@Controller
@RequestMapping("/uploadservice")
public class FileUploadRest {
	@Autowired
	FileUploadService fileUploadService;
	
	 @RequestMapping(value="/upload", method=RequestMethod.POST, consumes = "multipart/form-data")
	    public @ResponseBody String upload(
	            @RequestParam("file") MultipartFile file){
	        if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();
	                String name=  file.getOriginalFilename();
	                fileUploadService.upload(name , bytes);
	                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
	            } catch (Exception e) {
	                return "You failed to upload " + e.getMessage();
	            }
	        } else {
	            return "You failed to upload  because the file was empty.";
	        }
	    }
	 
	 
	 @RequestMapping(value="/profilepic/{uid}", method=RequestMethod.POST, consumes = "multipart/form-data")
	    public @ResponseBody String uploadProfilePic(
	    		@PathVariable ("uid") String uid, @RequestParam("file") MultipartFile file){
	        if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();
	                String name=  file.getOriginalFilename();
	                fileUploadService.uploadProfilePic(uid, name , bytes);
	                
	                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
	            } catch (Exception e) {
	                return "You failed to upload " + e.getMessage();
	            }
	        } else {
	            return "You failed to upload  because the file was empty.";
	        }
	    }


	}


