package com.edsolstice.educationportal.utility;

import java.math.BigInteger;
import java.security.SecureRandom;

import com.edsolstice.educationportal.dbmodel.BaseObject;
import com.edsolstice.educationportal.dbmodel.Student;
import com.edsolstice.educationportal.dbmodel.Subscription;
import com.edsolstice.educationportal.exception.EDSExceptionErrorCode;
import com.edsolstice.educationportal.exception.EDSOperationException;

public class UidUtils {
    
    private static String getUid() {
        return new BigInteger(50, getRandom()).toString(32);
    }
    
    private static SecureRandom getRandom() {
        return new SecureRandom();
    }

	public static void setUID(Student user) {
		String email=user.getEmail();
		email = StringUtil.replace(email, ".", "-");
		email = StringUtil.replace(email, "@", "-");
		setUID( user , email);
	}

	private static void setUID(BaseObject baseObject , String... names) {
		String uid="";
		for(String name :names) uid=uid+name+"-";		
		uid=uid+baseObject.getId();
		baseObject.setUid(uid);
	}

	public static String getUid(String ... uids ) {
		String id = "" ;
		for(String uid : uids) {
			id = id + "-" +uid;
		}
		return id;
	}

    public static void setUID(String parentId, Subscription subscription) throws EDSOperationException {
      
        if(parentId == null) throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, "Student uid is not valid");  
        
        subscription.setParentId(parentId);
        setUID(subscription, parentId , getUid());
        
    }

}
