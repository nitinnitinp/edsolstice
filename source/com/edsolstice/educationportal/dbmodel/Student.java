package com.edsolstice.educationportal.dbmodel;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
   
    @ManyToMany(
        targetEntity=com.edsolstice.educationportal.dbmodel.Student.class,
        cascade={CascadeType.PERSIST, CascadeType.MERGE} , fetch =FetchType.EAGER
    )
    @JoinTable(
        name="STUDENTSUBSCRIPTION_SENT",
        joinColumns=@JoinColumn(name="studentSubscriptionSent"),
        inverseJoinColumns=@JoinColumn(name="uid")
    )
    Map<String , Student> studentSubscriptionSent  = new HashMap<String , Student> ();

    @ManyToMany(
        targetEntity=com.edsolstice.educationportal.dbmodel.Student.class,
        cascade={CascadeType.PERSIST, CascadeType.MERGE} ,fetch =FetchType.EAGER
    )
    @JoinTable(
        name="STUDENTSUBSCRIPTION_PENDING",
        joinColumns=@JoinColumn(name="studentSubscriptionPending"),
        inverseJoinColumns=@JoinColumn(name="uid")
    )
    Map<String , Student> studentSubscriptionPending  = new HashMap<String , Student> ();

    @ManyToMany(
        targetEntity=com.edsolstice.educationportal.dbmodel.Student.class,
        cascade={CascadeType.PERSIST, CascadeType.MERGE} ,fetch =FetchType.EAGER
    )
    @JoinTable(
        name="SUBSCRIBEDSTUDENT",
        joinColumns=@JoinColumn(name="subscribedStudent"),
        inverseJoinColumns=@JoinColumn(name="uid")
    )
    Map<String , Student> subscribedStudent  = new HashMap<String , Student> ();


    public Map<String, Student> getStudentSubscriptionSent() {
        return studentSubscriptionSent;
    }
    public void setStudentSubscriptionSent(Map<String, Student> studentSubscriptionSent) {
        this.studentSubscriptionSent = studentSubscriptionSent;
    }
    public Map<String, Student> getStudentSubscriptionPending() {
        return studentSubscriptionPending;
    }
    public void setStudentSubscriptionPending(Map<String, Student> studentSubscriptionPending) {
        this.studentSubscriptionPending = studentSubscriptionPending;
    }

    public Map<String, Student> getSubscribedStudent() {
        return subscribedStudent;
    }
    public void setSubscribedStudent(Map<String, Student> subscribedStudent) {
        this.subscribedStudent = subscribedStudent;
    }
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


}

