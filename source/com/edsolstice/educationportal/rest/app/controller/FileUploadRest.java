package com.edsolstice.educationportal.rest.app.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/uploadservice")
public class FileUploadRest {
	
	 @RequestMapping(value="/upload", method=RequestMethod.POST, consumes = "multipart/form-data")
	    public @ResponseBody String handleFileUpload(
	            @RequestParam("file") MultipartFile file){
	        if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();
	                String name=  file.getOriginalFilename();
	                System.out.println("file name : " +name);
	                BufferedOutputStream stream =
	                        new BufferedOutputStream(new FileOutputStream(new File(name)));
	                stream.write(bytes);
	                stream.close();
	                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
	            } catch (Exception e) {
	                return "You failed to upload " + e.getMessage();
	            }
	        } else {
	            return "You failed to upload  because the file was empty.";
	        }
	    }

	}


