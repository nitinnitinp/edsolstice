package com.edsolstice.educationportal.dbmodel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessage {

    String message;
    String uid;
    String name;
    String colorSelected;
    String msgTime;

    public ChatMessage() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        msgTime = dateFormat.format(date);

    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColorSelected() {
        return colorSelected;
    }
    public void setColorSelected(String colorSelected) {
        this.colorSelected = colorSelected;
    }
    public String getMsgTime() {
        return msgTime;
    }
    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }




}
