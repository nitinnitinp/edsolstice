package com.edsolstice.educationportal.app;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.reflections.Reflections;







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

	}

	public static Set<Object> getServices(String packageName) {

		Set<Object> services = new HashSet<Object>();

		Reflections reflections = new Reflections(packageName);
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(RegisterService.class);
		if(annotated == null || annotated.isEmpty()) {
			return services;
		}
		for (Class<?> cls : annotated) {
			try {
				Constructor<?> cons=cls.getConstructor();	
				Object object = cons.newInstance();
				services.add(object);
			} catch (InstantiationException e) {
				throw new RuntimeException("Error in loading " + cls.getName()+ " : " + e.getMessage());
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Error in loading " + cls.getName()+ " : " + e.getMessage());
			} catch (IllegalArgumentException e) {
				throw new RuntimeException("Error in loading " + cls.getName()+ " : " + e.getMessage());
			} catch (InvocationTargetException e) {
				throw new RuntimeException("Error in loading " + cls.getName()+ " : " + e.getMessage());
			} catch (NoSuchMethodException e) {
				throw new RuntimeException("Error in loading " + cls.getName()+ " : " + e.getMessage());
			} catch (SecurityException e) {
				throw new RuntimeException("Error in loading " + cls.getName()+ " : " + e.getMessage());
			}
		}

		return services;
	}

}
//public static Set<Object> getServices(String packageName, String baseRESTPath) {
//    Logger.getLogger(RegistrationHelper.class).debug("***Scanning for services to register in package: " + packageNameIn);
//
//    Collection<RegisteredServerItemV1> services = new ArrayList<RegisteredServerItemV1>();
//
//    String name;
//    Reflections reflections = new Reflections(packageNameIn);
//    Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(RegisterService.class);
//    if(annotated == null || annotated.isEmpty()) {
//        Logger.getLogger(RegistrationHelper.class).debug("***Did not find any classes annotated with @RegisterService in package: " + packageNameIn);
//    }
//    for (Class<?> cls : annotated) {
//
//        PathToClassMethod.index(cls, baseRESTPath);
//
//        name = cls.getName();
//        //
//        RegisterService regMe = (RegisterService) cls.getAnnotation(RegisterService.class);
//        Path pathA = (Path) cls.getAnnotation(Path.class);
//        String regPath = pathA.value();
//        regPath = regPath == null ? "/" : regPath;
//        String svcRegName = regMe.value();
//        
//
//        RegisteredServerItemWrapperV1 item = getRegisteredServiceItemWrapper(services, svcRegName, regPath);
//
//        Set<Method> listMethods = ReflectionUtils.getAllMethods(cls, ReflectionUtils.withAnnotation(RegisterLinkRelation.class));
//        listMethods.addAll(ReflectionUtils.getAllMethods(cls.getSuperclass(), ReflectionUtils.withAnnotation(RegisterLinkRelation.class)));
//        for (Method method : listMethods) {
//            RegisterLinkRelation relName = (RegisterLinkRelation) method.getAnnotation(RegisterLinkRelation.class);
//            Path path = method.getAnnotation(Path.class);
//            String template = (path == null) ? "/" : path.value();
//            if (servicePath.endsWith("/") && template.startsWith("/")) {
//                template = template.substring(1);
//            } else if (!servicePath.endsWith("/") && !template.startsWith("/")) {
//                template = "/" + template;
//            }
//            String hrefTemplate = servicePath + template;
//            Logger.getLogger(RegistrationHelper.class).debug("***Registering Link Rel Template" + relName + " = " + hrefTemplate);
//
//            //register relName to hrefTemplate
//            item.addLinkRelTemplate(relName.value(), hrefTemplate);
//        }
//    }
//    return services;
//}
//
//private static Object getRegisteredServiceItemWrapper(Collection<Object> services, String svcRegName, String servicePath) {
//    RegisteredServerItemWrapperV1 item = null;
//    for (RegisteredServerItemV1 service : services) {
//        if (service.getName().equals(svcRegName) && service.getApiBaseURI().equals(servicePath)) {
//            item = (RegisteredServerItemWrapperV1) service;
//            break;
//        }
//    }
//    if (item == null) {
//        item = new RegisteredServerItemWrapperV1(svcRegName, servicePath);
//        services.add(item);
//    }
//
//    return item;
//}

