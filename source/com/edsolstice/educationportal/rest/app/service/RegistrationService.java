package com.edsolstice.educationportal.rest.app.service;

import org.springframework.stereotype.Service;

import com.edsolstice.educationportal.auth.AuthorizedUserManager;
import com.edsolstice.educationportal.db.DBFactory;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.dbmodel.Subscription;
import com.edsolstice.educationportal.exception.EDSExceptionErrorCode;
import com.edsolstice.educationportal.exception.EDSExceptionMessage;
import com.edsolstice.educationportal.exception.EDSOperationException;
import com.edsolstice.educationportal.rest.operation.StudentCreateOperation;
import com.edsolstice.educationportal.utility.MailUtility;
import com.edsolstice.educationportal.utility.StringUtil;
import com.edsolstice.educationportal.utility.UidUtils;

@Service
public class RegistrationService {


    public void registerStudent(StudentCreateOperation createStudent) throws Exception {

        if(StringUtil.nullOrEmpty(createStudent.getEmail())) throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.INVALIDEMAIL);
        // Validate email ID
        MailUtility.isValidEmailAddress(createStudent.getEmail());

        Student student=DBFactory.getStudentDB().get("email", createStudent.getEmail());

        if(student != null) {
            throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.STUDENTALREADYEXIST);	
        }

        if(StringUtil.nullOrEmpty(createStudent.getPassword())) throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.NULLPASSWORD);

        student = new Student();
        student.setCollege(createStudent.getCollege());
        student.setEmail(createStudent.getEmail());
        student.setFieldOfInterest(createStudent.getFieldOfInterest());
        student.setFirstName(createStudent.getUserName());
        student.setGender(createStudent.getGender());
        student.setName(createStudent.getUserName());
        student.setMobile(createStudent.getMobile());
        student.setLastName(createStudent.getSurName());
        student.setPassword(createStudent.getPassword());
        student.setActive(false);
        student.setActivationCode(AuthorizedUserManager.getActivationToken());
        UidUtils.setUID(student);

        Subscription subscription = new Subscription();
        UidUtils.setUID(student.getUid() ,subscription);
        student.setSubscription(subscription);

        //add student in database
        DBFactory.getStudentDB().save(student);

    }

}


