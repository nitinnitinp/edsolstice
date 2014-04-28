package com.edsolstice.educationportal.app;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Set;

import org.apache.log4j.Logger;


public class RestAppUtility {

	protected static Logger LOG = Logger.getLogger(RestAppUtility.class);

	public static void rgisterRestServices(String packageName, Set<Object> singletons) {

		String packageNameSlashed =  packageName.replace(".", "/");
		// Get a File object for the package
		URL directoryURL = Thread.currentThread().getContextClassLoader().getResource(packageNameSlashed);
		if (directoryURL == null) {
			LOG.info("Could not retrieve URL resource: " + packageNameSlashed);
			throw new RuntimeException("Could not retrieve URL resource: " + packageNameSlashed);
		}
		
		String directoryString = directoryURL.getFile();
		if (directoryString == null) {
			LOG.info("Could not find directory for URL resource: " + packageNameSlashed);
			throw new RuntimeException("Could not find directory for URL resource: " + packageNameSlashed);
		}
		File directory = new File(directoryString);
		if (directory.exists()) {
			// Get the list of the files contained in the package
			String[] files = directory.list();
			for (String fileName : files) {
				// We are only interested in .class files
				if (fileName.endsWith(".class")) {
					// Remove the .class extension
					fileName = fileName.substring(0, fileName.length() - 6);
					try {
						String classname=packageName + "." + fileName;
						LOG.info("registering service : " +classname);
						Class<?> restClass=Class.forName(classname);
						Constructor<?> cons=restClass.getConstructor();
						Object object=cons.newInstance();
						
						singletons.add(object);
					} 
					catch (ClassNotFoundException e) {
						LOG.info(packageName + "." + fileName + " does not appear to be a valid class.");
						throw new RuntimeException("ClassNotFoundException loading " + fileName);

					} catch (Exception e) {
						throw new RuntimeException("Could not find directory for URL resource: " + e.getMessage());
					}

				} else {
					LOG.info(packageName + " does not appear to exist as a valid package on the file system.");
				}


			}
		}   	    

	}}


