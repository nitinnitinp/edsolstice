package com.edsolstice.educationportal.restmodel;

import com.edsolstice.educationportal.dbmodel.EDSUser;



public class EDSUserCreate {

	private String userName;
	private String surName;
	private String password;
	private String cPassword;
	private String role;
	private String email;
	private int mobile;
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

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
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

	
public EDSUser covert() {
		EDSUser user = new EDSUser();
		user.setCollege(college);
		user.setEmail(email);
		user.setFieldOfInterest(fieldOfInterest);
		user.setFirstName(userName);
		user.setGender(gender);
		user.setName(userName);
		user.setMobile(mobile);
		user.setLastName(surName);
		user.setPassword(password);
		return user;
	}
}
