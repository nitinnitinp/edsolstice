package com.edsolstice.educationportal.dbmodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.edsolstice.educationportal.rest.operation.LoginSessionOperation;

@Entity
@Table(name = "student")
public class Student extends BaseObject {
	
	private static final long serialVersionUID = 1L;

	String email;
	long mobile;
	String firstName;
	String lastName;
	String college;
	String stream;
	String fieldOfInterest;
	String gender;
	String password;
	String role;
	String activationCode;
	@Embedded
	List<String> studentRequestPending = new ArrayList<String> ();
	@Embedded
	List<String> studentRequestSent = new ArrayList<String> ();
	@Embedded
	List<String> registeredStudents=new ArrayList<String> ();

	boolean isActive;

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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getFieldOfInterest() {
		return fieldOfInterest;
	}
	public void setFieldOfInterest(String fieldOfInterest) {
		this.fieldOfInterest = fieldOfInterest;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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

	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	
	public List<String> getStudentRequestPending() {
		return studentRequestPending;
	}
	public void setStudentRequestPending(List<String> studentRequestPending) {
		this.studentRequestPending = studentRequestPending;
	}
	public List<String> getStudentRequestSent() {
		return studentRequestSent;
	}
	public void setStudentRequestSent(List<String> studentRequestSent) {
		this.studentRequestSent = studentRequestSent;
	}
	public List<String> getRegisteredStudents() {
		return registeredStudents;
	}
	public void setRegisteredStudents(List<String> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}

}























