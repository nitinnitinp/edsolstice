package com.edsolstice.educationportal.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class EdsolsticeApplication  extends Application {

	private Set<Object> singletons = new HashSet<Object>();


	public EdsolsticeApplication() {
//		//RestAppUtility.rgisterRestServices("com.edsolstice.educationportal.rest",singletons);
//		singletons.addAll(RestAppUtility.getServices("com.edsolstice.educationportal.rest"));
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
//	@Override
//	public  Set<Class<?>> getClasses(){
//		Set<Class<?>> clsses = new HashSet<Class<?>>();
//		clsses.add(EDSUserCreate.class);
//		return clsses;
//		
//	}

}
