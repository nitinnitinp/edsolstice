/*
 * (C) Copyright 2002-2013 Hewlett-Packard Development Company, L.P.
 */
package com.edsolstice.educationportal.utility;

import org.codehaus.jackson.map.ObjectMapper;





/**
 * @author JohnEri
 *
 * This class uses the Jackson Json framework to convert
 * the name/value pairs sent in a POST request into a concrete 
 * Java class.
 */

public class JsonActionParameters<T> extends ActionParameters<T> {

	@Override
	public T convert(Class<? extends T> clazz) throws Exception  {
		try {
			
			ObjectMapper mapper = WebUtil.initResolverObjectMapper();
			String json = mapper.writeValueAsString(parameters);
			System.out.println("json" +json);
			T wrapper =  (T)mapper.readValue(json, clazz);
			return wrapper;
		} catch (Exception e) {
			
			throw e;
            //The ObjectMapper is going to wrap whatever exception was thrown during the deserialization
            //process into an IOException.  If the cause was actually a ConversionException or a BaseException,
            //throw that instead.
           
		}

	}

}
