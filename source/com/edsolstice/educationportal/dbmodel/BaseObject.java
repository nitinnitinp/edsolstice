package com.edsolstice.educationportal.dbmodel;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;
	@Id
	String uid;
	long id;
	String parentId;
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
