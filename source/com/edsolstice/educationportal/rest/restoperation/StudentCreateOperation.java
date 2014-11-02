package com.edsolstice.educationportal.rest.restoperation;

import com.edsolstice.educationportal.auth.AuthorizedUserManager;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.logic.MailUtility;
import com.edsolstice.educationportal.logic.StringUtils;
import com.edsolstice.educationportal.logic.UidUtils;



public class StudentCreateOperation {

	private String userName;
	private String surName;
	private String password;
	private String cPassword;
	private String role;
	private String email;
	private long mobile;
	private String department;
	private String college;
	private String fieldOfInterest;
	private String gender;
	

	public String getFieldOfInterest() {
		return fieldOfInterest;
	}
	
	public void setFieldOfInterest(String fieldOfInterest) {
		this.fieldOfInterest = fieldOfInterest;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
public Student map() throws Exception {
		Student user = new Student();
		user.setCollege(college);
		if(StringUtils.nullOrEmpty(email)) throw new Exception (" email id is null or not valid");
		MailUtility.isValidEmailAddress(email);
		user.setEmail(email);
		user.setFieldOfInterest(fieldOfInterest);
		user.setFirstName(userName);
		user.setGender(gender);
		user.setName(userName);
		user.setMobile(mobile);
		user.setLastName(surName);
		user.setActive(false);
		user.setActivationCode(AuthorizedUserManager.getActivationToken());
		if(StringUtils.nullOrEmpty(password)) throw new Exception ("password is null");
		user.setPassword(password);
		UidUtils.setUID(user);
		return user;
	}
}
