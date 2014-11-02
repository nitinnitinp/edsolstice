package com.edsolstice.educationportal.utility;

import com.edsolstice.educationportal.dbmodel.BaseObject;
import com.edsolstice.educationportal.dbmodel.Student;

public class UidUtils {

	public static void setUID(Student user) {
		String email=user.getEmail();
		String[] tokens=email.split("@");
		String domain = tokens[1];
		if(domain.contains("\\.")) {
			domain= domain.split("\\.")[0];
		}
		setUID( user , tokens[0] , domain);
	}

	private static void setUID(BaseObject baseObject , String... names) {
		String uid="";
		for(String name :names) uid=uid+name+"-";		
		uid=uid+baseObject.getId();
		baseObject.setUid(uid);
	}

}
