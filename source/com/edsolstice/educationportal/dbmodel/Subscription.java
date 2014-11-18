package com.edsolstice.educationportal.dbmodel;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription extends BaseObject {

    private static final long serialVersionUID = 1L;


    @OneToMany( fetch = FetchType.LAZY )  
   // @JoinColumn(name = "uid",nullable=false)
  
    Map<String , Student> studentSubscriptionSent  = new HashMap<String , Student> ();

    @OneToMany( fetch = FetchType.LAZY  )  
  //  @JoinColumn(name = "uid",nullable=false)
   
    Map<String , Student> studentSubscriptionPending  = new HashMap<String , Student> ();

    @OneToMany( fetch = FetchType.LAZY)  
  //  @JoinColumn(name = "uid",nullable=false)
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
}
