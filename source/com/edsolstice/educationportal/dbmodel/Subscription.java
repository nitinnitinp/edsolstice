package com.edsolstice.educationportal.dbmodel;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription extends BaseObject {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.MERGE )  
    @JoinColumn(name = "uid")
    Map<String , Student> studentSubscriptionSent  = new HashMap<String , Student> ();
    
    @OneToMany(mappedBy = "subscription", cascade = CascadeType.MERGE )  
    @JoinColumn(name = "uid")
    Map<String , Student> studentSubscriptionPending  = new HashMap<String , Student> ();
    
    @OneToMany(mappedBy = "subscription", cascade = CascadeType.MERGE )  
    @JoinColumn(name = "uid")
    Map<String , Student> studentSubscriptionApproved  = new HashMap<String , Student> ();

   
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
    public Map<String, Student> getStudentSubscriptionApproved() {
        return studentSubscriptionApproved;
    }
    public void setStudentSubscriptionApproved(Map<String, Student> studentSubscriptionApproved) {
        this.studentSubscriptionApproved = studentSubscriptionApproved;
    }


}
