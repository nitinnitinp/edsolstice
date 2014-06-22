/*
 * (C) Copyright 2002-2013 Hewlett-Packard Development Company, L.P.
 */

package com.edsolstice.educationportal.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;


public abstract class WebUtil {
	public static final String SERIALIZE_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZ";
	private static final String REST_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";



	/**
	 * Parse a date string into Calendar
	 * 
	 * @param dateStr
	 * @return Calendar
	 */
	public static Calendar parseRESTCalendarStr(String dateStr) {
		if (dateStr == null) {
			return null;
		} else {
			try {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat(REST_DATE_FORMAT);
				cal.setTime(sdf.parse(dateStr));
				return cal;
			} catch (ParseException e) {
				return null;
			}
		}
	}

	private static ObjectMapper mapper = null;

	public static ObjectMapper initResolverObjectMapper() {
		if (mapper == null) {
			synchronized (WebUtil.class) {
				if (mapper == null) {
					mapper = new ObjectMapper();
					JacksonAnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
					// configure serialization
					SerializationConfig serialization = mapper.getSerializationConfig();
					serialization.withAnnotationIntrospector(introspector);
							
					
				}
			}		
		}
		return (mapper);
	}
}
