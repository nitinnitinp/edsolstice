/*
 * (C) Copyright 2002-2013 Hewlett-Packard Development Company, L.P.
 */
package com.edsolstice.educationportal.logic;

import java.util.Hashtable;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;






/**
 * @author JohnEri
 *
 * This abstract class forms the base for creating classes that
 * convert the name/value pairs from POST requests into
 * specific class representations.
 * It is designed to allow the use of specific marshaller/unmarshallers
 * frameworks, such as Jackson, to convert the name/value pairs
 * into a Java class.
 * 
 * Typically, the web interface layer (REST, SOAP, etc) would provide
 * the logic layer a concrete implementation of this class so that the
 * logic layer is isolated from the mechanics of the framework used by 
 * the web layer.
 */

public abstract class ActionParameters<T> {
	protected Map<String,Object> parameters = null;
	
	protected ActionParameters() {
		this.parameters = new Hashtable<String,Object>();
	}
	
	
	@JsonAnyGetter()
	public void setParameters(String name, Object value) {
		if (value != null)
			parameters.put(name, value);
	}
	
	public Object getValue(String name) {
		return parameters.get(name);
	}
	
	public abstract T convert(Class<? extends T> clazz) throws Exception ;
}
