package com.edsolstice.educationportal.logic;

import com.edsolstice.educationportal.dbmodel.EDSBaseObject;
import com.edsolstice.educationportal.dbmodel.EDSUser;

public class UidUtils {

	public static void setUID(EDSUser user) {
		String email=user.getEmail();
		String[] tokens=email.split("@");
		String domain = tokens[1];
		if(domain.contains("\\.")) {
			domain= domain.split("\\.")[0];
		}
		setUID( user , tokens[0] , domain);
	}

	private static void setUID(EDSBaseObject baseObject , String... names) {
		String uid="";
		for(String name :names) uid=uid+name+"-";		
		uid=uid+baseObject.getId();
		baseObject.setUid(uid);
	}

}
