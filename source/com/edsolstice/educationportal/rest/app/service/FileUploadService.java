package com.edsolstice.educationportal.rest.app.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.exception.EDSExceptionErrorCode;
import com.edsolstice.educationportal.exception.EDSExceptionMessage;
import com.edsolstice.educationportal.exception.EDSOperationException;

@Service
public class FileUploadService {

	public void upload(String name, byte[] bytes) throws IOException {
		 BufferedOutputStream stream =
                 new BufferedOutputStream(new FileOutputStream(new File(name)));
         stream.write(bytes);
         stream.close();
		
	}

	public void uploadProfilePic(String uid, String name, byte[] bytes) throws IOException {
		
//		Student student=DBFactory.getStudentDB().get("uid" , uid);
//	
//		if(student == null) {
//			throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.STUDENTDOESNOTEXIST + " "+uid);	
//		}
	
		upload("./images/profile.jpg", bytes);
		
	}

}
