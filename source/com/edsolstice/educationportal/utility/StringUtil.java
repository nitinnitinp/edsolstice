package com.edsolstice.educationportal.utility;

import org.apache.commons.lang3.StringUtils;

public class StringUtil extends StringUtils {
	
	public static boolean nullOrEmpty(String a) {
		return (a ==null || a.isEmpty()) ;	
	}
	
	

}
